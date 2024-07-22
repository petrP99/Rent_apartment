package com.example.rent_module.service.services;

import com.example.rent_module.dto.UserAuthDto;
import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.dto.UserReadDto;

import java.util.Optional;

public interface AuthService {

    UserReadDto createUser(UserCreateDto userCreateDto);
    String findByLogin(UserAuthDto userAuthDto);


}
