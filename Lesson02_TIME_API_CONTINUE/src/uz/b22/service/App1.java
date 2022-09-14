package uz.b22.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class App1 {
    public static void main(String[] args) {
        // Calendar, LocalDateTime, DateFormat, DateTimeFormatter,
        // DayOfWeek, SimpleDateFormat, DateFormat, Date,
        // LocalDate, LocalTime, ZoneId, ZonedDateTime,
        // Period, Duration, ZonedDateTime, Year, YearMonth, TimeZone,
        // OffsetDateTime, GregorianCalendar, TemporalField, TemporalUnit

        Period period = Period.between(
                LocalDate.of(2004, 12, 4),
                LocalDate.now());

        System.out.println("period = " + period);

        System.out.println("period.getYears() = " + period.getYears());
        System.out.println("period.getMonths() = " + period.getMonths());
        System.out.println("period.getDays() = " + period.getDays());


        long days = ChronoUnit.DAYS.between(
                LocalDate.of(2004, 12, 4),
                LocalDate.now());

        System.out.println("days = " + days);
    }
}
