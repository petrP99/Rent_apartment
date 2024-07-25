package com.example.product.controller;

import com.example.product.dto.TestObjectDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PostMapping("/product")
    public String getProduct(@RequestHeader String token,  @RequestBody TestObjectDto testObjectDto) {
        return testObjectDto.toString();
    }
}
