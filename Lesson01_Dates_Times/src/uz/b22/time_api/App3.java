package uz.b22.time_api;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class App3 {
    public static void main(String[] args) {

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();

        System.out.println("availableZoneIds.size() = " +
                availableZoneIds.size());

        for (String availableZoneId : availableZoneIds) {
            LocalTime now = LocalTime.now(ZoneId.of(availableZoneId));
            System.out.println(availableZoneId+" -> "+now);
        }

    }
}
