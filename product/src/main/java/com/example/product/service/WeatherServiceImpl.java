package com.example.product.service;

import com.example.product.service.services.WeatherService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Service

public class WeatherServiceImpl implements WeatherService {

    private final static String PRODUCT_URL = "https://api.weather.yandex.ru/v2/forecast?lat=52.443&lon=4.866";

    @Override
    public String getWeather(String key) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(PRODUCT_URL,
                HttpMethod.GET,
                new HttpEntity<>(prepareHeaders(key)),
                String.class).getBody();
    }

    private HttpHeaders prepareHeaders(String key) {
        HashMap<String, String> map = new HashMap<>();
        map.put("X-Yandex-Weather-Key", key);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAll(map);
        return httpHeaders;
    }
}
