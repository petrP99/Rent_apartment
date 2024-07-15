package com.example.rent_module.controller;

import static com.example.rent_module.controller.PathConstants.AUTH;
import static com.example.rent_module.controller.PathConstants.BASE_PATH;
import static com.example.rent_module.controller.PathConstants.MAIN;
import static com.example.rent_module.controller.PathConstants.REGISTRATION;

import com.example.rent_module.dto.UserAuthDto;
import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.dto.UserReadDto;
import com.example.rent_module.exception.UserException;
import com.example.rent_module.service.AuthService;

import static com.example.rent_module.exception.ExceptionConstants.INCORRECT_PASS;
import static java.util.Objects.isNull;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService AuthService;

    @PostMapping(AUTH)
    public String authUser(@RequestBody UserAuthDto userAuthDto) {
        Optional<UserReadDto> mayBeUser = AuthService.findByLogin(userAuthDto);
        if (mayBeUser.isPresent()) {
            if (mayBeUser.get().password().equals(userAuthDto.getPassword())) {
                return "redirect:" + MAIN;
            } else throw new UserException(INCORRECT_PASS, 2);
        }
        return "redirect: " + REGISTRATION;
    }

    @PostMapping(REGISTRATION)
    public String registrationUser(@RequestBody UserCreateDto userCreateDto) {
        if (isNull((AuthService.registrationUser(userCreateDto)))) return REGISTRATION;
        return "redirect:" + BASE_PATH;
    }
}
