package com.example.rent_module.repository;

import com.example.rent_module.module.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

    UserInfoEntity findByNickName(String nickName);
}
