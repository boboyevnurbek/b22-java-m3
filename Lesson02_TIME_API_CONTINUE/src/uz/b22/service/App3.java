package uz.b22.service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class App3 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        System.out.println();
        System.out.println(new SimpleDateFormat("EEEE").format(date));
        System.out.println(String.format("%tA", date));

        System.out.println();
        System.out.println(new SimpleDateFormat("EEE").format(date));
        System.out.println(String.format("%ta", date));

    }
}
