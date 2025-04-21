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
        Map.entry("brick block", Material.BRICKS), // 45
        Map.entry("bookshelf", Material.BOOKSHELF), // 47
        Map.entry("mossy cobblestone", Material.MOSSY_COBBLESTONE), // 48
        Map.entry("obsidian", Material.OBSIDIAN), // 49
        Map.entry("torch", Material.TORCH), // 50
        Map.entry("diamond ore", Material.DIAMOND_ORE), // 56
        Map.entry("diamond block", Material.DIAMOND_BLOCK), // 57
        Map.entry("crafting table", Material.CRAFTING_TABLE), // 58
        Map.entry("wheat", Material.WHEAT), // 59
        Map.entry("furnace", Material.FURNACE), // 60
        Map.entry("wooden pressure plate", Material.OAK_PRESSURE_PLATE), // 72
        Map.entry("redstone ore", Material.REDSTONE_ORE), // 73
        Map.entry("redstone torch", Material.REDSTONE_TORCH), // 76
        Map.entry("stone button", Material.STONE_BUTTON), // 77
        Map.entry("snow", Material.SNOW), // 78
        Map.entry("ice", Material.ICE), // 79
        Map.entry("snow block", Material.SNOW_BLOCK), // 80
        Map.entry("cactus", Material.CACTUS), // 81
        Map.entry("clay", Material.CLAY), // 82
        Map.entry("jukebox", Material.JUKEBOX), // 84
        Map.entry("oak fence", Material.OAK_FENCE), // 85
        Map.entry("pumpkin", Material.PUMPKIN), // 86
        Map.entry("netherrack", Material.NETHERRACK), // 87
        Map.entry("soul sand", Material.SOUL_SAND), // 88
        Map.entry("glowstone", Material.GLOWSTONE), // 89
        Map.entry("jack o lantern", Material.JACK_O_LANTERN), // 91
        Map.entry("oak trapdoor", Material.OAK_TRAPDOOR), // 96
        Map.entry("infested stone", Material.INFESTED_STONE), // 97
        Map.entry("stone bricks", Material.STONE_BRICKS), // 98
        Map.entry("mossy stone bricks", Material.MOSSY_STONE_BRICKS), // 98:1
        Map.entry("cracked stone bricks", Material.CRACKED_STONE_BRICKS), // 98:2
        Map.entry("chiseled stone bricks", Material.CHISELED_STONE_BRICKS), // 98:3
        Map.entry("iron bars", Material.IRON_BARS), // 101
        Map.entry("glass pane", Material.GLASS_PANE), // 102
        Map.entry("melon", Material.MELON), // 103
        Map.entry("vine", Material.VINE), // 106
        Map.entry("enchanting table", Material.ENCHANTING_TABLE), // 116
        Map.entry("end portal frame", Material.END_PORTAL_FRAME), // 120
        Map.entry("ender chest", Material.ENDER_CHEST), // 130
        Map.entry("emerald ore", Material.EMERALD_ORE), // 129
        Map.entry("emerald block", Material.EMERALD_BLOCK), // 133
        Map.entry("beacon", Material.BEACON), // 138
        Map.entry("anvil", Material.ANVIL), // 145
        Map.entry("trapped chest", Material.TRAPPED_CHEST), // 146
        Map.entry("redstone block", Material.REDSTONE_BLOCK), // 152
        Map.entry("nether quartz ore", Material.NETHER_QUARTZ_ORE), // 153
        Map.entry("hopper", Material.HOPPER), // 154
        Map.entry("quartz block", Material.QUARTZ_BLOCK), // 155
        Map.entry("chiseled quartz block", Material.CHISELED_QUARTZ_BLOCK), // 155:1
        Map.entry("quartz pillar", Material.QUARTZ_PILLAR), // 155:2
        Map.entry("quartz stairs", Material.QUARTZ_STAIRS), // 156
        Map.entry("spruce fence", Material.SPRUCE_FENCE), // 188
        Map.entry("birch fence", Material.BIRCH_FENCE), // 189
        Map.entry("jungle fence", Material.JUNGLE_FENCE), // 190
        Map.entry("acacia fence", Material.ACACIA_FENCE), // 192
        Map.entry("dark oak fence", Material.DARK_OAK_FENCE), // 191
        Map.entry("bed", Material.BED) // 355
    );

    public static String applyMaterialPlaceholders(String input) {
        for (Map.Entry<String, Material> entry : MATERIAL_ALIASES.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue().name());
        }
        return input;
    }
}
