package com.example.rent_module.service;

import com.example.rent_module.dto.RentReadDto;
import com.example.rent_module.entity.IntegrationInfo;
import com.example.rent_module.repository.IntegrationInfoRepository;
import com.example.rent_module.service.services.GeoCoderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GeoCoderServiceImpl implements GeoCoderService {

    private final IntegrationInfoRepository integrationInfoRepository;
    private final String ID = "GEO";

    @Override
    public List<RentReadDto> getLocation(String lat, String lon) {
        getIntegrationWithGeoCoder(lat, lon);

        return null;
    }

    private String getIntegrationWithGeoCoder(String lat, String lon) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(prepareUrl(lat, lon),
                HttpMethod.GET,
                new HttpEntity<>(null, null),
                String.class).getBody();
    }

    public String prepareUrl(String lat, String lon) {
        IntegrationInfo integrationInfo = integrationInfoRepository.findById(ID).get();
        return String.format(integrationInfo.getPathInfo(), lat, lon, Base64EncoderDecoder.decode(integrationInfo.getToken()));
    }

}

