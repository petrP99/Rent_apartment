package com.example.rent_module.service;

import com.example.rent_module.dto.RentReadDto;
import com.example.rent_module.entity.Address;
import com.example.rent_module.entity.IntegrationInfo;
import com.example.rent_module.mapper.AddressMapper;
import com.example.rent_module.repository.AddressRepository;
import com.example.rent_module.repository.IntegrationInfoRepository;
import com.example.rent_module.service.services.GeoCoderService;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GeoCoderServiceImpl implements GeoCoderService {

    private final IntegrationInfoRepository integrationInfoRepository;
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    private final String ID = "GEO";

    @Override
    public List<RentReadDto> getApartamentsByLocation(String lat, String lon) {
        String city = findCityFromResponse(getResponseFromGeoCoder(lat, lon));
        List<Address> listAddress = addressRepository.findByCity(city);
        var x = listAddress.stream()
                .map(Address::getApartment)
                .collect(Collectors.toList()).stream()
                .map(AddressMapper::toDto).collect(Collectors.toList());

        return null;
    }


    public String findCityFromResponse(String response) {
        return JsonParser.parseString(response)
                .getAsJsonObject().get("results")
                .getAsJsonArray().get(0)
                .getAsJsonObject().get("components")
                .getAsJsonObject().get("city")
                .toString();
    }

    private String getResponseFromGeoCoder(String lat, String lon) {
        return RestClient.create()
                .method(HttpMethod.GET)
                .uri(prepareUrl(lat, lon))
                .retrieve()
                .toEntity(String.class)
                .getBody();

//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.exchange(prepareUrl(lat, lon),
//                HttpMethod.GET,
//                new HttpEntity<>(null, null),
//                String.class).getBody();
    }

    public String prepareUrl(String lat, String lon) {
        IntegrationInfo integrationInfo = integrationInfoRepository.findById(ID).get();
        return String.format(integrationInfo.getPathInfo(), lat, lon, Base64EncoderDecoder.decode(integrationInfo.getToken()));
    }

}
