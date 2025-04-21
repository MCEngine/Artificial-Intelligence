package io.github.mcengine.api.artificialintelligence.functions.calling;

import java.text.SimpleDateFormat;
import java.util.*;

public class FunctionCallingLoaderTime {

    public static final Map<String, String> namedZones = Map.ofEntries(
            Map.entry("{time_new_york}", getFormattedTime("America/New_York")),
            Map.entry("{time_london}", getFormattedTime("Europe/London")),
            Map.entry("{time_tokyo}", getFormattedTime("Asia/Tokyo")),
            Map.entry("{time_bangkok}", getFormattedTime("Asia/Bangkok")),
            Map.entry("{time_sydney}", getFormattedTime("Australia/Sydney")),
            Map.entry("{time_paris}", getFormattedTime("Europe/Paris")),
            Map.entry("{time_berlin}", getFormattedTime("Europe/Berlin")),
            Map.entry("{time_singapore}", getFormattedTime("Asia/Singapore")),
            Map.entry("{time_los_angeles}", getFormattedTime("America/Los_Angeles")),
            Map.entry("{time_toronto}", getFormattedTime("America/Toronto"))
    );

    public static String applyTimePlaceholders(String response) {
        // Standard time zones
        response = response
                .replace("{time_server}", getFormattedTime(TimeZone.getDefault()))
                .replace("{time_utc}", getFormattedTime(TimeZone.getTimeZone("UTC")))
                .replace("{time_gmt}", getFormattedTime(TimeZone.getTimeZone("GMT")));

        // Named zones
        for (Map.Entry<String, String> entry : namedZones.entrySet()) {
            response = response.replace(entry.getKey(), entry.getValue());
        }

        // Offset time zones
        for (int hour = -12; hour <= 14; hour++) {
            for (int min : new int[]{0, 30, 45}) {
                String utcLabel = getZoneLabel("utc", hour, min);
                String gmtLabel = getZoneLabel("gmt", hour, min);
                TimeZone tz = TimeZone.getTimeZone(String.format("GMT%+03d:%02d", hour, min));
                String time = getFormattedTime(tz);
                response = response.replace(utcLabel, time);
                response = response.replace(gmtLabel, time);
            }
        }

        return response;
    }

    public static String getFormattedTime(TimeZone timeZone) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date());
    }

    public static String getFormattedTime(String zoneId) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone(zoneId));
        return sdf.format(new Date());
    }

    public static String getZoneLabel(String prefix, int hour, int minute) {
        String sign = hour >= 0 ? "plus" : "minus";
        int absHour = Math.abs(hour);
        return String.format("{time_%s_%s_%02d_%02d}", prefix, sign, absHour, minute);
    }
}
