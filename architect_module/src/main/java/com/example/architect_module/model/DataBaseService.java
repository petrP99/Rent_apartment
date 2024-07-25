package com.example.architect_module.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DataBaseService {

    private final static String SQL = ".sql";
    private final static String DIRECTORY_PATH = "rent_module/src/main/resources/db/migration/";

    public  void addFlywayScript(String tableName, String operation, Map<String, String> map) {

        int currentVersion = readVersionFile(operation, tableName);// тут должен быть парсер
        int newVersion = currentVersion++;
        String fileName = String.format("V%s__%s_%s%s", currentVersion
                , operation, tableName, SQL);
        Map.Entry<String, String> lastEntry = map.entrySet().stream().reduce((one, two) -> two).get();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DIRECTORY_PATH + fileName))) {
            if (operation.equals("create")) {
                writer.write(String.format("%s table %s if not exists \n(\n", operation, tableName));
            } else
                writer.write(String.format("%s table %s \n(", operation, tableName));
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue());
                if (entry != lastEntry) {
                    writer.write(",\n");
                }
            }
            writer.write(")");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    public static int readVersionFile(String operation, String tableName) {
        File directory = new File(DIRECTORY_PATH);
        File[] files = directory.listFiles();

        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());

        String file = getString(files, operation, tableName);
        return Integer.parseInt(file.replaceAll("[^0-9]+", ""));
    }

    private static String getString(File[] files, String operation, String tableName) {
        for (File file : files) {
            if (file.getName().contains(operation) && file.getName().contains(tableName)) {
                return file.getName();
            }
        }
        return "нет файла для обновления";
    }
}