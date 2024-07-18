package com.example.rent_module.service;

import com.example.rent_module.dto.UserAuthDto;
import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.dto.UserReadDto;
import com.example.rent_module.entity.UserInfoEntity;

import static com.example.rent_module.exception.ExceptionConstants.INCORRECT_PASS;
import static com.example.rent_module.exception.ExceptionConstants.USER_NOT_FOUND;

import com.example.rent_module.exception.UserException;
import com.example.rent_module.mapper.UserMapper;
import com.example.rent_module.repository.UserInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;

import static java.util.Objects.isNull;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final EntityManager entityManager;

    private final UserInfoRepository userInfoRepository;
    private final UserMapper userMapper;


    @Override
    public UserReadDto createUser(@Valid UserCreateDto userCreateDto) {
        UserInfoEntity mayBeUser = userInfoRepository.findByLogin(userCreateDto.login());
        if (!isNull(mayBeUser)) throw new RuntimeException("Пользователь с таким ником уже существует");
        UserInfoEntity newUser = userMapper.toEntity(userCreateDto);
        UserInfoEntity savedUSer = userInfoRepository.save(newUser);
        return userMapper.toDto(savedUSer);
    }

    @Override
    public String findByLogin(@Valid UserAuthDto userAuthDto) {
        UserInfoEntity mayBeUser = userInfoRepository.findUserByLoginWithJPQL(userAuthDto.getLogin())
                .orElseThrow(() -> new UserException(USER_NOT_FOUND, 1));
        if (!mayBeUser.getPassword().equals(userAuthDto.getPassword())) {
            throw new UserException(INCORRECT_PASS, 2);
        }
        String token = generateToken();
        mayBeUser.setToken(token);
        userInfoRepository.save(mayBeUser);
        return token;
    }

    private String generateToken() {
        String x = "5be1ed74-4a62-4c38-b663-462a6d7ebe97|2024-07-19T14:40:13.500885900";
        LocalDateTime.parse(x);
        return UUID.randomUUID() + "|" + LocalDateTime.now().plusDays(1L);

    }

}

