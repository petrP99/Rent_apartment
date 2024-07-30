package com.example.rent_module.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class IntegrationInfo {

    @Id
    private String id;

    @Column(name = "path_info")
    private String pathInfo;

    @Column(name = "token")
    private String token;

}
