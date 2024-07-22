package com.example.architect_module;

import com.example.architect_module.model.DataBaseRequest;
import static com.example.architect_module.model.DataBaseRequest.addFlywayScript;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
public class ArchitectModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArchitectModuleApplication.class, args);


        addFlywayScript("address", "create", Map.of(
                "id", "serial",
                "login", "varchar",
                "age", "int",
                "card", "serial",
                "password", "varchar"));

    }

}
