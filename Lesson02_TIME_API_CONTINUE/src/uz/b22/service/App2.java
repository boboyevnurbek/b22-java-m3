package uz.b22.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class App2 {
    public static void main(String[] args) {

        Duration duration = Duration.between(
                LocalTime.of(4, 30),
                LocalTime.now()
        );
        System.out.println("duration = " + duration);

        System.out.println("duration.getSeconds() = " +
                duration.getSeconds());

        System.out.println("duration.toHours() = " + duration.toHours());

        long hours = ChronoUnit.HOURS.between(
                LocalTime.of(4, 30),
                LocalTime.now()
        );

        System.out.println("hours = " + hours);
    }
}
