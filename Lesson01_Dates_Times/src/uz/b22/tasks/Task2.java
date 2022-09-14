package uz.b22.tasks;

import java.util.Calendar;

public class Task2 {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();

        Calendar birthDay = Calendar.getInstance();
        birthDay.set(2004, Calendar.DECEMBER, 4);

        double days = (today.getTimeInMillis() - birthDay.getTimeInMillis()) / 1000. / 60 / 60 / 24;

        System.out.println("days = " + days);

        //birthDay.add(Calendar.DAY_OF_YEAR, 6492);
        //System.out.println("birthDay.getTime() = " + birthDay.getTime());
    }
}
