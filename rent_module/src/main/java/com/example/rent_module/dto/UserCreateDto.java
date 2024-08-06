package com.example.rent_module.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UserCreateDto {

    private static final String PASS_LENGTH = "Пароль не должен быть короче 3-х символов";
    private static final String NICK_LENGTH = "Ник не должен быть короче 3-х символов";
    private static final String INVALID_EMAIL = "Email должен быть в формате ***@**.ru";

    private String nickname;
    @NotBlank
    @Email(message = INVALID_EMAIL)
    private String login;
    @NotBlank
    @Size(min = 3, max = 20, message = PASS_LENGTH)
    private String password;
}

