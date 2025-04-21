package io.github.mcengine.api.artificialintelligence.functions.calling;

import org.bukkit.Material;
import java.util.Map;

public class FunctionCallingLoaderMCItem {

    public static final Map<String, Material> MATERIAL_ALIASES = Map.ofEntries(
        Map.entry("air", Material.AIR), // 0
        Map.entry("stone", Material.STONE), // 1
        Map.entry("granite", Material.GRANITE), // 1:1
        Map.entry("polished granite", Material.POLISHED_GRANITE), // 1:2
        Map.entry("diorite", Material.DIORITE), // 1:3
        Map.entry("polished diorite", Material.POLISHED_DIORITE), // 1:4
        Map.entry("andesite", Material.ANDESITE), // 1:5
        Map.entry("polished andesite", Material.POLISHED_ANDESITE), // 1:6
        Map.entry("grass", Material.GRASS), // 2
        Map.entry("dirt", Material.DIRT), // 3
        Map.entry("coarse dirt", Material.COARSE_DIRT), // 3:1
        Map.entry("podzol", Material.PODZOL), // 3:2
        Map.entry("cobblestone", Material.COBBLESTONE), // 4
        Map.entry("gold ore", Material.GOLD_ORE), // 14
        Map.entry("iron ore", Material.IRON_ORE), // 15
        Map.entry("coal ore", Material.COAL_ORE), // 16
        Map.entry("white wool", Material.WHITE_WOOL), // 35
        Map.entry("orange wool", Material.ORANGE_WOOL), // 35:1
        Map.entry("magenta wool", Material.MAGENTA_WOOL), // 35:2
        Map.entry("light blue wool", Material.LIGHT_BLUE_WOOL), // 35:3
        Map.entry("yellow wool", Material.YELLOW_WOOL), // 35:4
        Map.entry("lime wool", Material.LIME_WOOL), // 35:5
        Map.entry("pink wool", Material.PINK_WOOL), // 35:6
        Map.entry("gray wool", Material.GRAY_WOOL), // 35:7
        Map.entry("light gray wool", Material.LIGHT_GRAY_WOOL), // 35:8
        Map.entry("cyan wool", Material.CYAN_WOOL), // 35:9
        Map.entry("purple wool", Material.PURPLE_WOOL), // 35:10
        Map.entry("blue wool", Material.BLUE_WOOL), // 35:11
        Map.entry("brown wool", Material.BROWN_WOOL), // 35:12
        Map.entry("green wool", Material.GREEN_WOOL), // 35:13
        Map.entry("red wool", Material.RED_WOOL), // 35:15
        Map.entry("black wool", Material.BLACK_WOOL), // 35:15
        Map.entry("iron block", Material.IRON_BLOCK), // 42
        Map.entry("torch", Material.TORCH), // 50
        Map.entry("diamond ore", Material.DIAMOND_ORE), // 56
        Map.entry("diamond block", Material.DIAMOND_BLOCK), // 57
        Map.entry("crafting table", Material.CRAFTING_TABLE), // 58
        Map.entry("wheat", Material.WHEAT), // 59
        Map.entry("furnace", Material.FURNACE), // 60
        Map.entry("bed", Material.BED) // 355
    );

    public static String applyMaterialPlaceholders(String input) {
        for (Map.Entry<String, Material> entry : MATERIAL_ALIASES.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue().name());
        }
        return input;
    }
}
