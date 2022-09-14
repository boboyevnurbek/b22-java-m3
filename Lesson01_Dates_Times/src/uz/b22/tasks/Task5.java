package uz.b22.tasks;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Task5 {
    public static void main(String[] args) {
        // 2022-yilning 33-jumasi qaysi sana ekanligini toping.
        LocalDate localDate = LocalDate.of(2022, 1, 1);

        // find first FRIDAY
        while (!localDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
            localDate = localDate.plusDays(1);
        }

        localDate = localDate.plusWeeks(32);

        System.out.println("localDate = " + localDate);
    }
}
