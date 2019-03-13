package pl.gregrad.isslocator;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeFormat {

    public static void timeConverter(long timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        long unixTime = timestamp;
        String format = Instant.ofEpochSecond(unixTime)
                .atZone(ZoneId.of("CET"))
                .format(formatter);
        System.out.println(format);
    }
}
