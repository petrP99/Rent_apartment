package com.example.rent_module.service;

import com.example.rent_module.entity.UserInfoEntity;

public interface ValidTokenService {

    UserInfoEntity checkValidToken(String token);
}
