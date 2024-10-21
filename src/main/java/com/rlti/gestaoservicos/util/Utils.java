package com.rlti.gestaoservicos.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    public static String formatarData(LocalDate data) {
        if (data == null) {
            return "";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return data.format(formatter);
    }
}
