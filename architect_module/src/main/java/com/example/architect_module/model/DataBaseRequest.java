package com.example.architect_module.model;

import com.example.rent_module.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
public class DataBaseRequest {

    private final static String SQL = ".sql";
    private final UserInfoRepository userInfoRepository;
    private String operationType;
    private String tableName;
    private Map<String, String> map;


    public static void addFlywayScript(String tableName, String operation, Map<String, String> map) {
        int version = 1;// тут должен быть парсер
        String fileName = String.format("V%s__%s_%s%s", version
                , operation, tableName, SQL);
        var lastEntry = map.entrySet().stream().reduce((one, two) -> two).get();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            if (operation.equals("create")) {
                writer.write(String.format("%s table %s if not exists \n(\n", operation, tableName));
            } else
                writer.write(String.format("%s table %s \n(", operation, tableName)); //использовать подставления из входных параметров(create/insert/drop) или делалть статичные разные методы
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + "\n");
                if (entry != lastEntry) {
                    writer.write(",");
                }
            }
            writer.write(")");
            version = version++;
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

}
