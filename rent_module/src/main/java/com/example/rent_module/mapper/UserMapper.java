package com.example.rent_module.mapper;

import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.dto.UserReadDto;
import com.example.rent_module.entity.UserInfoEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserReadDto toDto(UserInfoEntity user);

    @Mapping(target = "nickName", source = "nickname")
    @Mapping(target = "password", ignore = true)
    UserInfoEntity toEntity(UserCreateDto dto);

    @AfterMapping
    default void afterMappingToEntity(@MappingTarget UserInfoEntity userInfoEntity, UserCreateDto userCreateDto) {
        String password = userCreateDto.password();
        userInfoEntity.setPassword(password + "test");
    }


}
