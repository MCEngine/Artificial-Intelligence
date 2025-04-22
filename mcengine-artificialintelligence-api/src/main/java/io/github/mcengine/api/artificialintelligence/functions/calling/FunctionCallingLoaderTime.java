package io.github.mcengine.api.artificialintelligence.functions.calling;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.jar.JarFile;

public class FunctionCallingLoaderTime {

    public static final Map<String, String> namedZones = new HashMap<>();

    static {
        try {
            Enumeration<URL> urls = FunctionCallingLoaderTime.class.getClassLoader().getResources("timezones");
            while (urls.hasMoreElements()) {
                URL dirUrl = urls.nextElement();
                String protocol = dirUrl.getProtocol();

                if (protocol.equals("jar")) {
                    String path = dirUrl.getPath();
                    String jarPath = path.substring(5, path.indexOf("!"));
                    try (JarFile jar = new JarFile(jarPath)) {
                        jar.stream()
                            .filter(e -> e.getName().startsWith("timezones/") && e.getName().endsWith(".json"))
                            .forEach(e -> loadTimezoneFile(e.getName()));
                    }
                } else if (protocol.equals("file")) {
                    File folder = new File(dirUrl.toURI());
                    File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
                    if (files != null) {
                        for (File file : files) {
                            loadTimezoneFile("timezones/" + file.getName());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadTimezoneFile(String path) {
        try (InputStream stream = FunctionCallingLoaderTime.class.getClassLoader().getResourceAsStream(path)) {
            if (stream == null) return;

            InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            Map<String, String> raw = new Gson().fromJson(reader, new TypeToken<Map<String, String>>() {}.getType());

            for (Map.Entry<String, String> entry : raw.entrySet()) {
                namedZones.put(entry.getKey(), getFormattedTime(entry.getValue()));
            }
        } catch (Exception e) {
            System.err.println("Failed to load timezone file: " + path);
            e.printStackTrace();
        }
    }

    public static String applyTimePlaceholders(String response) {
        response = response
                .replace("{time_server}", getFormattedTime(TimeZone.getDefault()))
                .replace("{time_utc}", getFormattedTime(TimeZone.getTimeZone("UTC")))
                .replace("{time_gmt}", getFormattedTime(TimeZone.getTimeZone("GMT")));

        for (Map.Entry<String, String> entry : namedZones.entrySet()) {
            response = response.replace(entry.getKey(), entry.getValue());
        }

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
        return getFormattedTime(TimeZone.getTimeZone(zoneId));
    }

    public static String getZoneLabel(String prefix, int hour, int minute) {
        String sign = hour >= 0 ? "plus" : "minus";
        int absHour = Math.abs(hour);
        return String.format("{time_%s_%s_%02d_%02d}", prefix, sign, absHour, minute);
    }
}
