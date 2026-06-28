package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateUtil {

    private DateUtil() {
    }

    public static String getCurrentDate() {

        return LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

    }

    public static String getCurrentDateTime() {

        return LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

    }

}