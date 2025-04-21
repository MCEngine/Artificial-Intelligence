package io.github.mcengine.api.artificialintelligence.functions.calling;

import org.bukkit.Material;

import java.util.HashMap;
import java.util.Map;

public class FunctionCallingLoaderMCItem {
    public static final Map<String, Material> MATERIAL_ALIASES = new HashMap<>();

    static {
        MATERIAL_ALIASES.put("diamond", Material.DIAMOND);
        MATERIAL_ALIASES.put("gold ingot", Material.GOLD_INGOT);
        MATERIAL_ALIASES.put("iron sword", Material.IRON_SWORD);
        MATERIAL_ALIASES.put("golden apple", Material.GOLDEN_APPLE);
        MATERIAL_ALIASES.put("emerald", Material.EMERALD);
        MATERIAL_ALIASES.put("stone pickaxe", Material.STONE_PICKAXE);
        MATERIAL_ALIASES.put("torch", Material.TORCH);
        MATERIAL_ALIASES.put("bread", Material.BREAD);
        MATERIAL_ALIASES.put("steak", Material.COOKED_BEEF);
        MATERIAL_ALIASES.put("carrot", Material.CARROT);
        MATERIAL_ALIASES.put("potato", Material.POTATO);
        MATERIAL_ALIASES.put("obsidian", Material.OBSIDIAN);
        MATERIAL_ALIASES.put("netherite ingot", Material.NETHERITE_INGOT);
        MATERIAL_ALIASES.put("book", Material.BOOK);
        MATERIAL_ALIASES.put("chest", Material.CHEST);
        MATERIAL_ALIASES.put("bow", Material.BOW);
        MATERIAL_ALIASES.put("arrow", Material.ARROW);
        MATERIAL_ALIASES.put("shield", Material.SHIELD);
    }
}
