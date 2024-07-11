package com.example.rent_module.controller;

import com.example.rent_module.module.entity.UserInfoEntity;
import static com.example.rent_module.controller.PathConstants.REGISTRATION;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping(REGISTRATION)
    public String registrationUser(UserInfoEntity userInfoEntity) {

    }
}
