package com.example.rent_module.repository;

import com.example.rent_module.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long> {

    UserInfoEntity findByLogin(String login);

    @Query(value = "select u from UserInfoEntity u where u.token = :token")
    Optional<UserInfoEntity> findByToken(String token);


    @Query(value = "select u from UserInfoEntity u where u.login = :login")
    Optional<UserInfoEntity> findUserByLoginWithJPQL(String login);


}
