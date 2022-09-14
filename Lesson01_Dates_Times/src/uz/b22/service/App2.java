package uz.b22.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class App2 {
    public static void main(String[] args) {
//        date, time

        // Tashkent : 15.00
        // duration: 4 hours
        // Istanbul: 17.00

        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar = " + calendar);

        // month: 0-11
        // sunday=1, monday=2, tuesday=3

        for (String availableCalendarType : Calendar.getAvailableCalendarTypes()) {
            System.out.println("availableCalendarType = " + availableCalendarType);
        }

        Date date = calendar.getTime();
        System.out.println("date = " + date.toString());

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        String format = dateFormat.format(date);
        System.out.println("format = " + format);

        format = new SimpleDateFormat("dd MMMM yyyy").format(date);
        System.out.println("format = " + format);

        format = new SimpleDateFormat("dd MMMM yyyy EEEE").format(date);
        System.out.println("format = " + format);

        calendar.set(2004, Calendar.DECEMBER, 4);
        System.out.println("calendar.getTime() = " + calendar.getTime());

        calendar.add(Calendar.DAY_OF_YEAR, 10000);
        System.out.println("calendar.getTime() = " + calendar.getTime());


        System.out.println();

        calendar.set(2022, 1, 15);
        System.out.println("calendar.getTime() = " + calendar.getTime());

        System.out.println("calendar.getMaximum(Calendar.DAY_OF_MONTH) = " +
                calendar.getMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("calendar.getActualMaximum(Calendar.DAY_OF_MONTH) = " +
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        System.out.println("calendar.getMaximum(Calendar.DAY_OF_YEAR) = " +
                calendar.getMaximum(Calendar.DAY_OF_YEAR));
        System.out.println("calendar.getActualMaximum(Calendar.DAY_OF_YEAR) = " +
                calendar.getActualMaximum(Calendar.DAY_OF_YEAR));


        System.out.println("calendar.getCalendarType() = " +
                calendar.getCalendarType());

        System.out.println("calendar.getTime() = " + calendar.getTime());

        calendar.add(Calendar.MONTH, 5);
        System.out.println("calendar.getTime() = " + calendar.getTime());

        calendar.add(Calendar.HOUR_OF_DAY, -55);
        System.out.println("calendar.getTime() = " + calendar.getTime());
    }
}
