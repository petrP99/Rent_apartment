package com.example.rent_module.controller;

import static com.example.rent_module.controller.PathConstants.AUTH;
import static com.example.rent_module.controller.PathConstants.BASE_PATH_AUTH;
import static com.example.rent_module.controller.PathConstants.REGISTRATION;
import com.example.rent_module.dto.UserAuthDto;
import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.service.AuthService;
import jakarta.validation.Valid;
import static java.util.Objects.isNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        return "redirect:" + BASE_PATH_AUTH;
    }

}
