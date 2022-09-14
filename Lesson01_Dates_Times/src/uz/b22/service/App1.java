package uz.b22.service;

import java.time.DayOfWeek;
import java.util.EnumSet;

public class App1 {
    public static void main(String[] args) {
        DayOfWeek[] dayOfWeeks = DayOfWeek.values();
        // name(), ordinal()

        for (DayOfWeek dayOfWeek : dayOfWeeks) {
            System.out.println("dayOfWeek = " + dayOfWeek);
        }

        EnumSet<DayOfWeek> set = EnumSet.allOf(DayOfWeek.class);
        System.out.println("set = " + set);

        EnumSet<DayOfWeek> workDays = EnumSet.range(DayOfWeek.MONDAY, DayOfWeek.FRIDAY);
        System.out.println("workDays = " + workDays);

    }
}
