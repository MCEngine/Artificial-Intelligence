package io.github.mcengine.api.artificialintelligence.functions.calling;

import org.bukkit.Material;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.jar.JarFile;

public class FunctionCallingLoaderMCItem {

    public static final Map<String, Material> MATERIAL_ALIASES = new HashMap<>();

    static {
        try {
            Enumeration<URL> urls = FunctionCallingLoaderMCItem.class.getClassLoader().getResources("materials");
            while (urls.hasMoreElements()) {
                URL dirUrl = urls.nextElement();
                String protocol = dirUrl.getProtocol();

                if (protocol.equals("jar")) {
                    String path = dirUrl.getPath();
                    String jarPath = path.substring(5, path.indexOf("!"));
                    try (JarFile jar = new JarFile(jarPath)) {
                        jar.stream()
                            .filter(e -> e.getName().startsWith("materials/") && e.getName().endsWith(".json"))
                            .forEach(e -> loadMaterialFile(e.getName()));
                    }
                } else if (protocol.equals("file")) {
                    File folder = new File(dirUrl.toURI());
                    File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));
                    if (files != null) {
                        for (File file : files) {
                            loadMaterialFile("materials/" + file.getName());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadMaterialFile(String path) {
        try (InputStream stream = FunctionCallingLoaderMCItem.class.getClassLoader().getResourceAsStream(path)) {
            if (stream == null) return;

            InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            Map<String, String> raw = new Gson().fromJson(reader, new TypeToken<Map<String, String>>() {}.getType());

            for (Map.Entry<String, String> entry : raw.entrySet()) {
                try {
                    MATERIAL_ALIASES.put(entry.getKey(), Material.valueOf(entry.getValue()));
                } catch (IllegalArgumentException ignored) {}
            }
        } catch (Exception e) {
            System.err.println("Failed to load: " + path);
            e.printStackTrace();
        }
    }

    public static String applyMaterialPlaceholders(String input) {
        for (Map.Entry<String, Material> entry : MATERIAL_ALIASES.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue().name());
        }
        return input;
    }
}
