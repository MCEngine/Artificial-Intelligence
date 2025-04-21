package io.github.mcengine.api.artificialintelligence;

import io.github.mcengine.api.artificialintelligence.functions.calling.FunctionRule;
import io.github.mcengine.api.artificialintelligence.functions.calling.IFunctionCallingLoader;
import io.github.mcengine.api.artificialintelligence.functions.calling.json.FunctionCallingJson;
import io.github.mcengine.api.artificialintelligence.functions.calling.FunctionCallingLoaderTime;
import io.github.mcengine.api.artificialintelligence.functions.calling.FunctionCallingLoaderMCItem;
import io.github.mcengine.api.artificialintelligence.shop.IShopHandler;
import io.github.mcengine.api.artificialintelligence.shop.economyshopgui.EconomyShopGUIHandler;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.*;

public class FunctionCallingLoader {

    private final List<FunctionRule> mergedRules = new ArrayList<>();
    private final IShopHandler shopHandler;

    public FunctionCallingLoader(Plugin plugin) {
        String dbType = plugin.getConfig().getString("db.type", "json").toLowerCase();

        File jsonFolder = null;
        if (dbType.equals("json")) {
            jsonFolder = new File(plugin.getDataFolder(), plugin.getConfig().getString("db.json.path", "json"));
        }

        IFunctionCallingLoader orm = switch (dbType) {
            case "json" -> new FunctionCallingJson(jsonFolder);
            default -> new FunctionCallingJson(jsonFolder);
        };

        List<FunctionRule> rules = orm.loadFunctionRules();
        if (rules != null) mergedRules.addAll(rules);

        IShopHandler handler = null;
        if (plugin.getConfig().getBoolean("shop.enable", true)) {
            String shopType = plugin.getConfig().getString("shop.type", "EconomyShopGUI");
            switch (shopType.toLowerCase()) {
                case "economyshopgui" -> handler = new EconomyShopGUIHandler();
                // case "quickshop" -> handler = new QuickShopReremakeHandler();
                default -> handler = new EconomyShopGUIHandler();
            }
        }
        this.shopHandler = handler;
    }

    public List<String> match(Player player, String input) {
        List<String> results = new ArrayList<>();
        String lowerInput = input.toLowerCase().trim();

        // Try to handle flexible buy commands like "buy 5 diamond" or "buy diamond 5"
        if (lowerInput.contains("buy")) {
            String[] words = lowerInput.replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
            int amount = 1;
            String itemName = null;

            for (String word : words) {
                if (word.matches("\\d+")) {
                    amount = Integer.parseInt(word);
                } else {
                    String matchedAlias = matchAlias(word);
                    if (matchedAlias != null) {
                        itemName = matchedAlias;
                    }
                }
            }

            if (itemName != null) {
                Material material = FunctionCallingLoaderMCItem.MATERIAL_ALIASES.get(itemName);
                if (material != null && shopHandler != null) {
                    boolean success = shopHandler.buy(player, material.name(), amount);
                    if (success) {
                        results.add("✅ Bought " + amount + " " + material.name().toLowerCase().replace("_", " "));
                    } else {
                        results.add("❌ Failed to buy " + amount + " " + material.name().toLowerCase().replace("_", " "));
                    }
                    return results;
                }
            }
        }

        // Fallback: simple contains match
        for (FunctionRule rule : mergedRules) {
            for (String pattern : rule.match) {
                if (lowerInput.contains(pattern.toLowerCase())) {
                    String resolved = applyPlaceholders(rule.response, player);
                    results.add(resolved);
                    break;
                }
            }
        }

        return results;
    }

    private String matchAlias(String word) {
        for (String alias : FunctionCallingLoaderMCItem.MATERIAL_ALIASES.keySet()) {
            if (alias.contains(word) || word.contains(alias)) {
                return alias;
            }
        }
        return null;
    }

    private String applyPlaceholders(String response, Player player) {
        response = response
                .replace("{player_name}", player.getName())
                .replace("{player_uuid}", player.getUniqueId().toString());

        response = FunctionCallingLoaderTime.applyTimePlaceholders(response);
        response = FunctionCallingLoaderMCItem.applyMaterialPlaceholders(response);

        return response;
    }
}
