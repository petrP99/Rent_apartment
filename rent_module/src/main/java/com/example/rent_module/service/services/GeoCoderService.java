package com.example.rent_module.service.services;

import com.example.rent_module.dto.RentReadDto;

import java.util.List;

public interface GeoCoderService {

    List<RentReadDto> getApartamentsByLocation(String lat, String lon);
}
