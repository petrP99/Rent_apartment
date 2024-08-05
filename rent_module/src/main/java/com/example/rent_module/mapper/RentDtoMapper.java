package com.example.rent_module.mapper;

import com.example.rent_module.dto.RentReadDto;
import com.example.rent_module.entity.Address;
import com.example.rent_module.entity.Apartment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RentDtoMapper {

    @Mapping(target = "addressId", source = "address.id")
    @Mapping(target = "addressCity", source = "address.city")
    @Mapping(target = "addressStreet", source = "address.street")
    @Mapping(target = "addressHouse", source = "address.house")
    @Mapping(target = "number", source = "apartment.number")
    @Mapping(target = "status", source = "apartment.status")
    @Mapping(target = "price", source = "apartment.price")
    RentReadDto toDto(Address address, Apartment apartment);


}
