package uz.b22.time_api;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class App1 {
    public static void main(String[] args) {
//        java.time
//        JAVA TIME API

        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        System.out.println("LocalDate.MIN = " + LocalDate.MIN);
        System.out.println("LocalDate.MAX = " + LocalDate.MAX);

        LocalDate date = LocalDate.of(2004, 12, 4);

        System.out.println("date = " + date);

        System.out.println("***************");
        localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);

        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);

        int dayWeek = localDate.get(ChronoField.DAY_OF_WEEK);
        System.out.println("dayWeek = " + dayWeek);

        //int hour = localDate.get(ChronoField.HOUR_OF_DAY);
        //System.out.println("hour = " + hour);

        System.out.println( localDate.isSupported(ChronoField.DAY_OF_WEEK) );
        System.out.println( localDate.isSupported(ChronoField.HOUR_OF_DAY) );

        localDate = localDate.plusDays(10);
        System.out.println("localDate.plusDays(10) = " + localDate.plusDays(10));
        System.out.println("localDate = " + localDate);

        System.out.println();

        LocalDate localDate1 = LocalDate.parse("2022-09-13");
        System.out.println("localDate1 = " + localDate1);

        localDate1 = LocalDate.parse("13."+"09.2022", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("localDate1 = " + localDate1.format(DateTimeFormatter.ofPattern("M/d/y")));

        LocalDate localDate2 = LocalDate.ofYearDay(2022, 300);
        System.out.println("localDate2 = " + localDate2);

        LocalDate localDate3 = LocalDate.ofEpochDay(10000);
        System.out.println("localDate3 = " + localDate3);


    }
}
