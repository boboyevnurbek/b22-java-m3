package uz.b22.tasks;

import java.util.Calendar;

public class Task2_v2 {
    public static void main(String[] args) {
        Calendar today = Calendar.getInstance();

        Calendar birthDay = Calendar.getInstance();
        birthDay.set(2004, Calendar.DECEMBER, 4);

        int counter = 0;

        while (birthDay.before(today)){
            counter++;
            birthDay.add(Calendar.DAY_OF_MONTH, 1);
        }

        System.out.println("counter = " + counter);
    }
}
