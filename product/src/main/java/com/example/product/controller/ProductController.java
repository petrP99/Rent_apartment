package com.example.product.controller;

import com.example.product.dto.TestObjectDto;
import com.example.product.service.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {


    private final WeatherService weatherService;

    @PostMapping("/product")
    public String getProduct(@RequestHeader String token, @RequestBody TestObjectDto testObjectDto) {
        return testObjectDto.toString();
    }

    @PostMapping("/weather")
    public String getWeatherInCity(@RequestHeader String key) {
        return weatherService.getWeather(key);
    }

}
