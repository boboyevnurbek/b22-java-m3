package uz.b22.tasks;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

public class Task1 {
    public static void main(String[] args) {
        int monthNumber = 9;
//        Shu oyning oxirgi shanbasini topish

        LocalDate localDate =
                LocalDate.of(2022, monthNumber+1, 1)
                        .minusDays(1);

        // find first saturday
        while (!localDate.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
            localDate = localDate.minusDays(1);
        }

        System.out.println(localDate);

    }
}
