package com.example.rent_module.service;

import com.example.rent_module.entity.Apartment;
import com.example.rent_module.entity.Address;
import com.example.rent_module.entity.UserInfoEntity;
import com.example.rent_module.repository.ApartmentRepository;
import com.example.rent_module.repository.HotelRepository;
import com.example.rent_module.service.services.ApartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {

    private final UserServiceImpl userService;
    private final HotelRepository hotelRepository;
    private final ApartmentRepository apartmentRepository;

    @Override
    public String registerApartment(String token, String hotelName) {
        Optional<UserInfoEntity> user = userService.findByToken(token);
        if (user.isEmpty()) {
            throw new RuntimeException("Пользователь не найден");
        }
        Optional<Address> hotel = hotelRepository.findByName(hotelName);
        if (hotel.isEmpty()) {
            throw new RuntimeException("Отель с таким названием не найден");
        }
        Long apartmentId = hotel.map(Address::getApartment)
                .map(apartments -> apartments.stream().filter(Apartment::getStatus)).get()
                .findAny()
                .get().getId();
        Optional<Apartment> apartment = apartmentRepository.findById(apartmentId);
        apartment.get().setUserInfo(user.get());
        apartmentRepository.save(apartment.get());
        return String.format("Апартаменты №%d в отеле %s забронированы пользователем %s ", apartment.get().getNumber(),
                hotelName, user.get().getNickName());
        return null;
    }

}


