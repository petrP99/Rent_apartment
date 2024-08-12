package com.example.rent_module.dto;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record BookingCreateDto(
        LocalDate startTime,
        LocalDate endTime,
        Integer days,
        Integer cost,
        Long userId,
        Long apartmentId,
        Long productId
) {
}



