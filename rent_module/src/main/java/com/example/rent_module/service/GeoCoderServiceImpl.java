package com.example.rent_module.service;

import com.example.rent_module.dto.RentReadDto;
import com.example.rent_module.entity.IntegrationInfo;
import com.example.rent_module.mapper.RentDtoMapper;
import com.example.rent_module.repository.ApartmentRepository;
import com.example.rent_module.repository.IntegrationInfoRepository;
import com.example.rent_module.service.services.GeoCoderService;
import com.google.gson.JsonParser;
import static java.util.stream.Collectors.toList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeoCoderServiceImpl implements GeoCoderService {

    private final static String ID = "GEO";
    private final IntegrationInfoRepository integrationInfoRepository;
    private final ApartmentRepository apartmentRepository;
    private final RentDtoMapper rentDtoMapper;

    @Override
    public List<RentReadDto> getApartmentsByLocation(String lat, String lon) {
        String city = findCityFromResponse(getResponseFromGeoCoder(lat, lon));
        return apartmentRepository.findAllByAddressCityOrderByPrice(city).stream()
                .map(rentDtoMapper::toDto)
                .collect(toList());
    }

    public String findCityFromResponse(String response) {
        return JsonParser.parseString(response)
                .getAsJsonObject().get("results")
                .getAsJsonArray().get(0)
                .getAsJsonObject().get("components")
                .getAsJsonObject().get("city")
                .getAsString();
    }

    private String getResponseFromGeoCoder(String lat, String lon) {
        return RestClient.create()
                .method(HttpMethod.GET)
                .uri(prepareUrl(lat, lon))
                .retrieve()
                .toEntity(String.class)
                .getBody();
    }

    public String prepareUrl(String lat, String lon) {
        IntegrationInfo integrationInfo = integrationInfoRepository.findById(ID).get();
        return String.format(integrationInfo.getPathInfo(), lat, lon, Base64EncoderDecoder.decode(integrationInfo.getToken()));
    }

}

