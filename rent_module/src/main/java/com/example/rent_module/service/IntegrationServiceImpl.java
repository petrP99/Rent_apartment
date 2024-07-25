package com.example.rent_module.service;

import com.example.rent_module.dto.TestObjectDto;
import com.example.rent_module.service.services.IntegrationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service
public class IntegrationServiceImpl implements IntegrationService {

    private final static String PRODUCT_URL = "http://localhost:7777/product";

    @Override
    public String productIntegration() {
        TestObjectDto testObjectDto = new TestObjectDto("Передаваемая строка");
        RestTemplate restTemplate = new RestTemplate();
        String token = "testToken";
        String body = restTemplate.exchange(PRODUCT_URL,
                HttpMethod.POST,
                new HttpEntity<>(testObjectDto, prepareHeaders(token)),
                String.class).getBody();
        return body;
    }

    private HttpHeaders prepareHeaders(String token) {
        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAll(map);
        return httpHeaders;
    }

}
