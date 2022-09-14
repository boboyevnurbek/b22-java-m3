package uz.b22.tasks;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task3 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, 2020);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 29);

        System.out.println("calendar.getTime() = " + calendar.getTime());

        if(calendar.get(Calendar.MONTH) == 1){
            System.out.println("Leap year");
        }else{
            System.out.println("Not leap year");
        }

        boolean leapYear = new GregorianCalendar().isLeapYear(2020);
        System.out.println("leapYear = " + leapYear);
    }
}
