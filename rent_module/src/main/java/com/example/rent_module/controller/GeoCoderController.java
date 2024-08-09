package com.example.rent_module.controller;

import com.example.rent_module.dto.RentReadDto;
import com.example.rent_module.service.services.GeoCoderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.rent_module.controller.PathConstants.GEOCODER;

@RequiredArgsConstructor
@RestController
public class GeoCoderController {

    private final GeoCoderService geoCoderService;

    @GetMapping(GEOCODER)
    public List<RentReadDto> getLocation(@RequestParam String lat, @RequestParam String lon) {
        return geoCoderService.getApartmentsByLocation(lat, lon);

    }
}
