package com.example.rent_module.dto;

public record UserReadDto(
        Long id,
        String nickName,
        String login,
        String password,
        String token
) {
}
