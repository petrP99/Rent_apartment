package com.example.rent_module.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record UserCreateDto(
        @NotBlank
        @Size(min = 3, message = "Ник должен быть не короче 3-х символов")
        String nickname,
        @NotBlank
        @Email(message = "формат почты ***@***.ru")
        String login,
        @NotBlank
        @Size(min = 3, max = 20, message = "Пароль не короче 3х символов")
        String password
        //создать константы стринговых ошибок
) {
}
