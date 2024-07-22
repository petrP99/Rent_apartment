package com.example.rent_module.service;

import com.example.rent_module.dto.UserAuthDto;
import com.example.rent_module.dto.UserCreateDto;
import com.example.rent_module.dto.UserReadDto;
import com.example.rent_module.entity.UserInfoEntity;
import static com.example.rent_module.exception.ExceptionConstants.INVALID_PASS;
import static com.example.rent_module.exception.ExceptionConstants.USER_NOT_FOUND;
import com.example.rent_module.exception.UserException;
import com.example.rent_module.mapper.UserMapper;
import com.example.rent_module.repository.UserInfoRepository;
import com.example.rent_module.service.services.AuthService;
import com.example.rent_module.util.DateParserUtil;
import jakarta.validation.Valid;
import static java.util.Objects.isNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class UserServiceImpl implements AuthService {

    private final UserInfoRepository userInfoRepository;
    private final UserMapper userMapper;

    public UserReadDto createUser(@Valid UserCreateDto userCreateDto) {
        UserInfoEntity mayBeUser = userInfoRepository.findByLogin(userCreateDto.getLogin());
        if (!isNull(mayBeUser)) throw new RuntimeException("Пользователь с таким ником уже существует");
        userCreateDto.setPassword(Base64EncoderDecoder.encode(userCreateDto.getPassword()));
        UserInfoEntity newUser = userMapper.toEntity(userCreateDto);
        UserInfoEntity savedUSer = userInfoRepository.save(newUser);
        return userMapper.toDto(savedUSer);
    }

    @Override
    public String findByLogin(@Valid UserAuthDto userAuthDto) {
        UserInfoEntity mayBeUser = userInfoRepository.findUserByLoginWithJPQL(userAuthDto.getLogin())
                .orElseThrow(() -> new UserException(USER_NOT_FOUND, 1));
        if (!mayBeUser.getPassword().equals(userAuthDto.getPassword())) {
            throw new UserException(INVALID_PASS, 2);
        }
        String token = generateToken();
        mayBeUser.setToken(token);
        userInfoRepository.save(mayBeUser);
        return token;
    }

    public Optional<UserInfoEntity> findByToken(String token) {
        return userInfoRepository.findByToken(token);
    }

    private String generateToken() {
        return UUID.randomUUID() + "|" + LocalDateTime.now().plusDays(1L);
    }

}
