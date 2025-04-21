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

        // Replace item placeholders like {diamond} → DIAMOND
        lowerInput = FunctionCallingLoaderMCItem.applyMaterialPlaceholders(lowerInput);

        for (FunctionRule rule : mergedRules) {
            for (String pattern : rule.match) {
                String lowerPattern = FunctionCallingLoaderMCItem.applyMaterialPlaceholders(pattern.toLowerCase());

                if (lowerInput.contains(lowerPattern) || lowerPattern.contains(lowerInput)) {
                    // Check for auto-buy format
                    if (lowerInput.startsWith("buy ")) {
                        String[] parts = lowerInput.split("\\s+");
                        if (parts.length >= 2) {
                            String item = parts[1];
                            int amount = 1;

                            if (parts.length >= 3) {
                                try {
                                    amount = Integer.parseInt(parts[2]);
                                } catch (NumberFormatException e) {
                                    amount = 1;
                                }
                            }

                            // Try to resolve input using alias map (even if already uppercased)
                            Material mat = Material.matchMaterial(item.toUpperCase());
                            String resolvedName = mat != null ? mat.name() : item;

                            if (shopHandler != null && shopHandler.buy(player, resolvedName, amount)) {
                                results.add("✅ Bought " + amount + " " + resolvedName.toLowerCase().replace("_", " "));
                            } else {
                                results.add("❌ Failed to buy " + amount + " " + resolvedName.toLowerCase().replace("_", " "));
                            }
                            return results;
                        }
                    }

                    // Regular pattern match (not "buy" command)
                    String resolved = applyPlaceholders(rule.response, player);
                    results.add(resolved);
                    break;
                }
            }
        }

        return results;
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
