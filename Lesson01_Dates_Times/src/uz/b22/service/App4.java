package uz.b22.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class App4 {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.US);
        System.out.println(dateFormat.format(date));

        dateFormat = new SimpleDateFormat("'Date: 'dd.MM.yyyy 'Time: 'HH:mm:ss", Locale.US);
        System.out.println(dateFormat.format(date));

        System.out.println();
        dateFormat = new SimpleDateFormat("h:m a\nM/d/y", Locale.US);
        System.out.println(dateFormat.format(date));

//        default ISO DATE FORMAT "yyyy-MM-dd"

    }
}
