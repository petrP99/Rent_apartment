package com.example.rent_module.controller;

import static com.example.rent_module.controller.PathConstants.REGISTRATION_APARTMENT;
import com.example.rent_module.dto.BookingApartmentRequest;
import com.example.rent_module.dto.RentCreateDto;
import com.example.rent_module.service.ValidTokenServiceImpl;
import com.example.rent_module.service.services.ApartmentService;
import static java.util.Objects.isNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class RentApartmentController {

    private final ValidTokenServiceImpl validTokenService;
    private final ApartmentService apartmentService;

    @PostMapping(REGISTRATION_APARTMENT)
    public String registration(@RequestHeader String token, @RequestBody RentCreateDto createDto) {
        validTokenService.checkValidToken(token);
        return apartmentService.registerApartment(token, createDto.getCity(), createDto.getStreet(), createDto.getNumber(), createDto.getPrice());
    }

    @GetMapping("/integration/product")
    public BookingApartmentRequest getBookingApartment(@RequestParam(required = false) LocalDateTime startTime,
                                                       @RequestParam(required = false) LocalDateTime endTime,
                                                       @RequestParam Long apartmentId,
                                                       @RequestHeader(required = false) String token) {
        if (isNull(startTime) && isNull(endTime)) {
            return apartmentService.findById(apartmentId);
        }
        /*метод проверки токена(не налл и соотвенствие в бд) - находим юзера
        нов таблица букинг апартмент (начало/конце бронив  ссылка на юзера,  сылка на апартамента, ссылка на таблица продукты(придумать их, страовка/питание и тд,) цена за все дни,, количество дней)
        * после бронирования статус фолсе + сообщение пользователю + заглушку под отправку имейла на будущее
        после бронирования передать на клиент с продуктами

        вынести все константы


        */
        return null;
    }

}
