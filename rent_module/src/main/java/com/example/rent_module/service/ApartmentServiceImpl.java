package com.example.rent_module.service;

import com.example.rent_module.dto.BookingApartmentRequest;
import com.example.rent_module.dto.RentReadDto;
import com.example.rent_module.entity.Address;
import com.example.rent_module.entity.Apartment;
import com.example.rent_module.entity.UserInfoEntity;
import com.example.rent_module.exception.ApartmentException;
import static com.example.rent_module.exception.ExceptionConstants.ADDRESS_NOT_FOUND;
import static com.example.rent_module.exception.ExceptionConstants.NOT_FREE_APARTMENT;
import static com.example.rent_module.exception.ExceptionConstants.USER_NOT_FOUND;
import com.example.rent_module.exception.UserException;
import com.example.rent_module.mapper.RentDtoMapper;
import com.example.rent_module.repository.AddressRepository;
import com.example.rent_module.repository.ApartmentRepository;
import com.example.rent_module.service.services.ApartmentService;
import com.example.rent_module.service.services.IntegrationService;
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
    private final RentDtoMapper rentDtoMapper;

    @Override
    public String registerApartment(String token, String city, String street, Integer number, Integer price) {
        UserInfoEntity user = userService.findByToken(token).orElseThrow(() -> new UserException(USER_NOT_FOUND, 1));
        Address address = addressRepository.findByCityAndStreet(city, street)
                .orElseThrow(() -> new ApartmentException((String.format(ADDRESS_NOT_FOUND, street, city)), 3));

        // проверить, будет ли ошибка если по такому айди нулл
        Optional<Apartment> apartment = apartmentRepository.findById(address.getId());

        if (apartment.isPresent()) {
            apartment.get().setUserInfo(user);
            apartment.get().setStatus(false);
            apartment.get().setNumber(number);
            apartment.get().setPrice(price);
            apartmentRepository.save(apartment.get());
            return String.format("Апартаменты №%d в г. %s по улице %s забронированы пользователем %s", apartment.get().getNumber(),
                    city, street, user.getNickName());
        }
        return NOT_FREE_APARTMENT;
    }

    @Override
    public String getIntegration() {
        return integrationService.productIntegration();
    }

    @Override
    public BookingApartmentRequest findById(Long id) {
        Apartment apartment = apartmentRepository.findById(id).orElseThrow(() -> new ApartmentException("Апартаментов не обнаружено", 10));
        Address address = addressRepository.findById(apartment.getAddress().getId()).get();
        RentReadDto dto = rentDtoMapper.toDto(address, apartment);
        return new BookingApartmentRequest("Апартаменты доступны для брониварвания", dto);
    }
}


