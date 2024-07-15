package com.example.rent_module.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;


public record UserReadDto(
        Long id,
        String nickName,
        String login,
        String password
) {
}
