package com.example.rent_module.service.services;


public interface ApartmentService {

     //по токену будет находить юзера, тк передавать токен в сам контроллер невозможно(сам юзер его не знает)
     String registerApartment(String token, String city, String street, Integer number, Integer price);
}
