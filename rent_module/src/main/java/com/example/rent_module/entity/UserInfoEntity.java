package com.example.rent_module.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_info")
@Data
public class UserInfoEntity {

    @Id
    @SequenceGenerator(name = "user_infoSequence", sequenceName = "user_info_sequence", allocationSize = 1, initialValue = 2)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_infoSequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "login_value", nullable = false)
    private String login;

    @Column(name = "pass")
    private String password;

    @Column(name = "token")
    private String token;

}
