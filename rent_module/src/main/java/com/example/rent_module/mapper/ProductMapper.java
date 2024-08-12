package com.example.rent_module.mapper;

import com.example.rent_module.dto.BookingCreateDto;
import com.example.rent_module.dto.ProductCreateDto;
import com.example.rent_module.entity.Booking;
import com.example.rent_module.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    Product toEntity(ProductCreateDto dto);

}
