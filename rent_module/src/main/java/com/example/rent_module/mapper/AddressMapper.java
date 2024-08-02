package com.example.rent_module.mapper;

import com.example.rent_module.dto.RentReadDto;
import com.example.rent_module.entity.Address;
import com.example.rent_module.entity.Apartment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public class AddressMapper {


    public RentReadDto toDto(Address address, Apartment apartment) {
        RentReadDto rentReadDto = new RentReadDto();
        rentReadDto.setId((address.getId()));
        rentReadDto.setCity(address.getCity());
        rentReadDto.setStreet(address.getStreet());
        rentReadDto.setHouse(address.getHouse());
        rentReadDto.setNumber(apartment.getNumber());
        rentReadDto.setStatus(apartment.getStatus());
        rentReadDto.setPrice(apartment.getPrice());
        return rentReadDto;
    }

}
