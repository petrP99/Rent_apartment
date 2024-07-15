package com.example.rent_module.service;

import com.example.rent_module.dto.UserAuthDto;
import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.dto.UserReadDto;

public interface AuthService {

    UserReadDto registrationUser(UserCreateDto userCreateDto);

    UserReadDto findByLogin(UserAuthDto userAuthDto);

}
