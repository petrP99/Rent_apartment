package com.example.rent_module.dto;

import lombok.Data;

@Data
public class ProductReadDto {

    private Long id;
    private Boolean cleaning;
    private Boolean breakfast;
    private Boolean dinner;
    private Boolean bar;
    private Boolean transfer;
    private Boolean insurance;

}
