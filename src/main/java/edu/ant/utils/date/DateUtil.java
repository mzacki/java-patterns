package edu.ant.utils.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static LocalDate localDateNow() {
        return LocalDate.now();
    }

    public static LocalDate localDateOf(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    public static LocalTime localTimeOf(int hrs, int min) {
        return LocalTime.of(hrs, min);
    }

    public static LocalDateTime localDateTimeOfBoth(LocalDate localDate, LocalTime localTime) {
        return LocalDateTime.of(localDate, localTime);
    }

    public static String formatDate(LocalDate localDate, String pattern) {
        return localDate.format(DateTimeFormatter.ofPattern(pattern));
    }

    public static LocalDate parseDate(String dateAsString, String pattern) {
        return LocalDate.parse(dateAsString, DateTimeFormatter.ofPattern(pattern));
    }

}
