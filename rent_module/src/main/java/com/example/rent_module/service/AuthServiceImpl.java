package com.example.rent_module.service;

import com.example.rent_module.module.entity.UserInfoEntity;
import com.example.rent_module.repository.UserInfoRepository;

import static java.util.Objects.isNull;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public String registrationUser(UserInfoEntity userInfoEntity) {
        UserInfoEntity byNickName = userInfoRepository.findByNickName(userInfoEntity.getNickName());
        if (!isNull(byNickName)) throw new RuntimeException("Пользователь с таким никнеймом уже существует");
        return "redirect:/auth";
    }
}
/**
 * проверка на логин, если нету / регистрация иначе ошибка
 * <p>
 * запрос чрз апигейтвейв
 * сделать дто
 * опционально генерация токена
 */