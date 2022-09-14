package uz.b22.tasks;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task4 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(2022, Calendar.JANUARY, 1);

        int counter = 0;

        while (calendar.get(Calendar.YEAR) == 2022) {
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY &&
                    calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) counter++;

            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        System.out.println("counter = " + counter);
    }
}
