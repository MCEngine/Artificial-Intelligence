package io.github.mcengine.api.artificialintelligence.functions.calling;

import org.bukkit.Material;

import java.util.Map;

public class FunctionCallingLoaderMCItem {

    public static final Map<String, Material> MATERIAL_ALIASES = Map.ofEntries(
        Map.entry("diamond", Material.DIAMOND),
        Map.entry("gold ingot", Material.GOLD_INGOT),
        Map.entry("iron sword", Material.IRON_SWORD),
        Map.entry("golden apple", Material.GOLDEN_APPLE),
        Map.entry("emerald", Material.EMERALD),
        Map.entry("stone pickaxe", Material.STONE_PICKAXE),
        Map.entry("torch", Material.TORCH),
        Map.entry("bread", Material.BREAD),
        Map.entry("steak", Material.COOKED_BEEF),
        Map.entry("carrot", Material.CARROT),
        Map.entry("potato", Material.POTATO),
        Map.entry("obsidian", Material.OBSIDIAN),
        Map.entry("netherite ingot", Material.NETHERITE_INGOT),
        Map.entry("book", Material.BOOK),
        Map.entry("chest", Material.CHEST),
        Map.entry("bow", Material.BOW),
        Map.entry("arrow", Material.ARROW),
        Map.entry("shield", Material.SHIELD)
    );

    public static String applyMaterialPlaceholders(String input) {
        for (Map.Entry<String, Material> entry : MATERIAL_ALIASES.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue().name());
        }
        return input;
    }
}
