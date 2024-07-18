package com.example.rent_module.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record UserCreateDto(
        @NotBlank
        @Size(min = 3, message = NICK_LENGTH)
        String nickname,
        @NotBlank
        @Email(message = EMAIL_FORMAT)
        String login,
        @NotBlank
        @Size(min = 3, max = 20, message = PASS_LENGTH)
        String password
) {
    private static final String PASS_LENGTH = "Пароль не должен быть короче 3-х символов";
    private static final String NICK_LENGTH = "Ник не должен быть короче 3-х символов";
    private static final String EMAIL_FORMAT = "Email должен быть в формате ***@**.ru";

}
