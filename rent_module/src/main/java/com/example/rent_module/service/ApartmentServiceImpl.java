package com.example.rent_module.service;

import com.example.rent_module.entity.Address;
import com.example.rent_module.entity.Apartment;
import com.example.rent_module.entity.UserInfoEntity;
import com.example.rent_module.repository.AddressRepository;
import com.example.rent_module.repository.ApartmentRepository;
import com.example.rent_module.service.services.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {

    private final UserServiceImpl userService;
    private final AddressRepository addressRepository;
    private final ApartmentRepository apartmentRepository;
    private final IntegrationService integrationService;

    @Override
    public String registerApartment(String token, String city, String street, Integer number, Integer price) {
        UserInfoEntity user = userService.findByToken(token).orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        Address address = addressRepository.findByCityAndStreet(city, street)
                .orElseThrow(() -> new RuntimeException(String.format("Отель по адресу %s  в городе %s не найден", street, city)));


        if (address.getApartment().getStatus()) {
            Optional<Apartment> apartment = apartmentRepository.findById(address.getApartment().getId());
            apartment.get().setUserInfo(user);
            apartment.get().setStatus(false);
            apartment.get().setNumber(number);
            apartment.get().setPrice(price);
            apartmentRepository.save(apartment.get());
            return String.format("Апартаменты №%d в г. %s по улице %s забронированы пользователем %s", apartment.get().getNumber(),
                    city, street, user.getNickName());
        }
        return "Нет свободных апартаментов";
    }

    @Override
    public String getIntegration() {
        return integrationService.productIntegration();
    }
}


