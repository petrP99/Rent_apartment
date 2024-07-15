package com.example.rent_module.service;

import com.example.rent_module.dto.UserAuthDto;
import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.dto.UserReadDto;

import java.util.Optional;

public interface AuthService {

    UserReadDto registrationUser(UserCreateDto userCreateDto);

    Optional<UserReadDto> findByLogin(UserAuthDto userAuthDto);

}
