package com.example.architect_module.controller;

import com.example.architect_module.model.DataBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ArchitectController {

    private final DataBaseService dataBaseService;

//    private final static String SQL_VERSION = """select version from flyway_schema_history order by version DESC limit 1""";


    @GetMapping("/script")
    public String createScript() {


        dataBaseService.addFlywayScript("address", "create", Map.of(
                "id", "serial",
                "login", "varchar",
                "age", "int",
                "card", "serial",
                "password", "varchar"));
        return "success";
    }


    @GetMapping("/test")
    public int getTest() {

//        return jdbcTemplate.queryForObject(SQL_VERSION, Integer.class);
        return 0;
    }
}
