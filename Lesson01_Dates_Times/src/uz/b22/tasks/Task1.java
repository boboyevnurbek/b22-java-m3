package uz.b22.tasks;

import java.util.Calendar;

public class Task1 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        System.out.println("calendar.get(Calendar.YEAR) = " +
                calendar.get(Calendar.YEAR));

        System.out.println("calendar.get(Calendar.MONTH) = " +
                calendar.get(Calendar.MONTH));


    }
}
