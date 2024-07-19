package com.example.rent_module.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;

@UtilityClass
public class DateParserUtil {

    private static char DELIMITER = '|';
    public static boolean parseAndCheckDate(String token) {
        int index = token.indexOf(DELIMITER);
        LocalDateTime dateAndTimeCurrentToken = LocalDateTime.parse(token.substring(index + 1));
        return LocalDateTime.now().isAfter(dateAndTimeCurrentToken);
    }

}
