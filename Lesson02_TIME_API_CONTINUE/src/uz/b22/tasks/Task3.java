package uz.b22.tasks;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Task3 {
    public static void main(String[] args) {

        // 2022-yilning 33-jumasini aniqlash

        LocalDate localDate =
                LocalDate.of(2022, 1, 1)
                        .with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY))
                        .plusWeeks(32);

        System.out.println("localDate = " + localDate);

        LocalDate localDate1 = LocalDate.of(2022, 1, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(33, DayOfWeek.FRIDAY));

        System.out.println("localDate1 = " + localDate1);

        LocalDate nextWednesday = LocalDate
                .now()
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.WEDNESDAY));

        System.out.println("nextWednesday = " + nextWednesday);
    }
}
