package com.example.rent_module.controller;

import static com.example.rent_module.controller.PathConstants.REGISTRATION_APARTMENT;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentApartmentController {

    @PostMapping(REGISTRATION_APARTMENT)
//    public String registration(@RequestBody @Valid ApartDto apartDto){
    public String registration(@RequestHeader String token) {
        return "test";
    }
}
//каким юхером зареганы апартаменты
//проверка токена
