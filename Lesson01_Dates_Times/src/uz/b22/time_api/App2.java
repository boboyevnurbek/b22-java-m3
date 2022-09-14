package uz.b22.time_api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class App2 {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime);

        System.out.println("LocalTime.MIN = " + LocalTime.MIN);
        System.out.println("LocalTime.MIDNIGHT = " + LocalTime.MIDNIGHT);
        System.out.println("LocalTime.NOON = " + LocalTime.NOON);
        System.out.println("LocalTime.MAX = " + LocalTime.MAX);

        LocalTime startLesson = LocalTime.of(14, 30);
        System.out.println("startLesson = " + startLesson);

        LocalTime finishLesson = LocalTime.parse("18:03");
        System.out.println("finishLesson = " + finishLesson);

        finishLesson = LocalTime.parse("18:3", DateTimeFormatter.ofPattern("HH:m"));
        System.out.println("finishLesson = " + finishLesson);

        LocalTime localTime1 = LocalTime.ofSecondOfDay(10000);
        System.out.println("localTime1 = " + localTime1);

        System.out.println();

//        ZoneId zoneId = ZoneId.of("Asia/Tashkent");
//        LocalTime now = LocalTime.now(zoneId);
//        System.out.println("now = " + now);

        ZoneId zoneId = ZoneId.of("Asia/Istanbul");
        LocalTime now = LocalTime.now(zoneId);
        System.out.println("now = " + now);
    }
}
