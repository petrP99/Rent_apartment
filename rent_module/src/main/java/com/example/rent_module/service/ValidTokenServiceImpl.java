package com.example.rent_module.service;

import com.example.rent_module.entity.UserInfoEntity;
import com.example.rent_module.repository.UserInfoRepository;
import com.example.rent_module.util.DateParserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValidTokenServiceImpl implements ValidTokenService {

    private final UserInfoRepository userInfoRepository;

    @Override
    public void checkValidToken(String token) {
        userInfoRepository.findByToken(token).orElseThrow(() -> new RuntimeException("Необходима авторизация"));
    }

    public void removeToken(UserInfoEntity userInfoEntity) {
        userInfoEntity.setToken(null);
        userInfoRepository.saveAndFlush(userInfoEntity);
    }

    @Scheduled(cron = "0 18 21 * * *")
    public void checkAndRemoveToken() {
        List<UserInfoEntity> users = userInfoRepository.findAll();
        users.stream()
                .filter(user -> user.getToken() != null)
                .filter(user -> DateParserUtil.parseAndCheckDate(user.getToken()))
                .forEach(this::removeToken);
    }
}
