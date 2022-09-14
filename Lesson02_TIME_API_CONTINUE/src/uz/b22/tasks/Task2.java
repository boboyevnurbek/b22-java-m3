package uz.b22.tasks;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Task2 {
    public static void main(String[] args) {
        int monthNumber = 9;

        LocalDate localDate = LocalDate.of(2022, monthNumber, 1);

        LocalDate result = localDate.with(
                TemporalAdjusters.lastInMonth(DayOfWeek.SATURDAY));

        System.out.println(result);

        // 2022-yilning 33-jumasini aniqlash
    }
}
