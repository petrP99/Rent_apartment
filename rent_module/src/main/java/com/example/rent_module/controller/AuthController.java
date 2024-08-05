package com.example.rent_module.controller;

import com.example.rent_module.dto.UserAuthDto;
import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.service.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.rent_module.controller.PathConstants.AUTH;
import static com.example.rent_module.controller.PathConstants.REGISTRATION;
import static java.util.Objects.isNull;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(AUTH)
    public String authUser(@RequestBody UserAuthDto userAuthDto) {
        return authService.findByLogin(userAuthDto);
    }

    @PostMapping(REGISTRATION)
    public String registrationUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        if (isNull((authService.createUser(userCreateDto)))) return REGISTRATION;
        return String.format("пользователь %s успешно создан", userCreateDto.getLogin());
    }
}
