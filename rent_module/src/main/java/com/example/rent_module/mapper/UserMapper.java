package com.example.rent_module.mapper;

import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.dto.UserReadDto;
import com.example.rent_module.entity.UserInfoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserReadDto toDto(UserInfoEntity user);

    @Mapping(target = "nickName", source = "nickname")
    UserInfoEntity toEntity(UserCreateDto dto);

}
