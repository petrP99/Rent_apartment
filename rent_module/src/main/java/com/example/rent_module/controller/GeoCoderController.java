package com.example.rent_module.controller;

import com.example.rent_module.dto.RentReadDto;
import com.example.rent_module.service.services.GeoCoderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GeoCoderController {

    private final GeoCoderService geoCoderService;

    @GetMapping("/geocoder")
    public List<RentReadDto> getLocation(@RequestParam String lat, @RequestParam String lon) {
        return geoCoderService.getApartmentsByLocation(lat, lon);

    }
}
