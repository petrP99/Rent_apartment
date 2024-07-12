package com.example.rent_module.controller;

import static com.example.rent_module.controller.PathConstants.REGISTRATION;

import com.example.rent_module.module.entity.UserInfoEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping(REGISTRATION)
    public String registrationUser(UserInfoEntity userInfoEntity) {
        return null;
    }

    @GetMapping(BASE_PATH)
    public String authUser(UserInfoEntity userInfoEntity) {
        return null;
    }
}
