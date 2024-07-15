package com.example.rent_module.controller;

import static com.example.rent_module.controller.PathConstants.AUTH;
import static com.example.rent_module.controller.PathConstants.BASE_PATH;
import static com.example.rent_module.controller.PathConstants.MAIN;
import static com.example.rent_module.controller.PathConstants.REGISTRATION;
import com.example.rent_module.dto.UserAuthDto;
import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.dto.UserReadDto;
import com.example.rent_module.service.AuthService;
import static java.util.Objects.isNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService AuthService;

    @PostMapping(AUTH)
    public String authUser(@RequestBody UserAuthDto userAuthDto) {
        UserReadDto mayBeUser = AuthService.findByLogin(userAuthDto);
        if (isNull(mayBeUser)) return "redirect: " + REGISTRATION;
        else return "redirect:" + MAIN;
    }

    @PostMapping(REGISTRATION)
    public String registrationUser(@RequestBody UserCreateDto userCreateDto) {
        if (isNull((AuthService.registrationUser(userCreateDto)))) return REGISTRATION;
        else return "redirect:" + BASE_PATH;
    }
}
