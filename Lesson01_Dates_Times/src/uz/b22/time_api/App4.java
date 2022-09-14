package uz.b22.time_api;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class App4 {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);


        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();

        System.out.println("availableZoneIds.size() = " +
                availableZoneIds.size());

        for (String availableZoneId : availableZoneIds) {
            LocalDateTime now = LocalDateTime.now(ZoneId.of(availableZoneId));
            System.out.println(availableZoneId + " -> " +
                    now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        }

    }
}
