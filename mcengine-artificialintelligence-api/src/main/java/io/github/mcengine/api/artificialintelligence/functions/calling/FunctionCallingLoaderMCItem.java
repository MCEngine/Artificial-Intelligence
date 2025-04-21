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
        /* Map.entry("grass", Material.GRASS), // 2 */
        Map.entry("dirt", Material.DIRT), // 3
        Map.entry("coarse dirt", Material.COARSE_DIRT), // 3:1
        Map.entry("podzol", Material.PODZOL), // 3:2
        Map.entry("cobblestone", Material.COBBLESTONE), // 4
        Map.entry("oak planks", Material.OAK_PLANKS), // 5
        Map.entry("spruce planks", Material.SPRUCE_PLANKS), // 5:1
        Map.entry("birch planks", Material.BIRCH_PLANKS), // 5:2
        Map.entry("jungle planks", Material.JUNGLE_PLANKS), // 5:3
        Map.entry("acacia planks", Material.ACACIA_PLANKS), // 5:4
        Map.entry("dark oak planks", Material.DARK_OAK_PLANKS), // 5:5
        Map.entry("oak sapling", Material.OAK_SAPLING), // 6
        Map.entry("spruce sapling", Material.SPRUCE_SAPLING), // 6:1
        Map.entry("birch sapling", Material.BIRCH_SAPLING), // 6:2
        Map.entry("jungle sapling", Material.JUNGLE_SAPLING), // 6:3
        Map.entry("acacia sapling", Material.ACACIA_SAPLING), // 6:4
        Map.entry("dark oak sapling", Material.DARK_OAK_SAPLING), // 6:5
        Map.entry("bedrock", Material.BEDROCK), // 7
        Map.entry("water", Material.WATER), // 9
        Map.entry("lava", Material.LAVA), // 11
        Map.entry("sand", Material.SAND), // 12
        Map.entry("red sand", Material.RED_SAND), // 12:1
        Map.entry("gravel", Material.GRAVEL), // 13
        Map.entry("gold ore", Material.GOLD_ORE), // 14
        Map.entry("iron ore", Material.IRON_ORE), // 15
        Map.entry("coal ore", Material.COAL_ORE), // 16
        Map.entry("oak log", Material.OAK_LOG), // 17
        Map.entry("spruce log", Material.SPRUCE_LOG), // 17:1
        Map.entry("birch log", Material.BIRCH_LOG), // 17:2
        Map.entry("jungle log", Material.JUNGLE_LOG), // 17:3
        Map.entry("oak leaves", Material.OAK_LEAVES), // 18
        Map.entry("spruce leaves", Material.SPRUCE_LEAVES), // 18:1
        Map.entry("birch leaves", Material.BIRCH_LEAVES), // 18:2
        Map.entry("jungle leaves", Material.JUNGLE_LEAVES), // 18:3
        Map.entry("sponge", Material.SPONGE), // 19
        Map.entry("wet sponge", Material.WET_SPONGE), // 19:1
        Map.entry("glass", Material.GLASS), // 20
        Map.entry("lapis ore", Material.LAPIS_ORE), // 21
        Map.entry("lapis block", Material.LAPIS_BLOCK), // 22
        Map.entry("dispenser", Material.DISPENSER), // 23
        Map.entry("sandstone", Material.SANDSTONE), // 24
        Map.entry("chiseled sandstone", Material.CHISELED_SANDSTONE), // 24:1
        Map.entry("smooth sandstone", Material.SMOOTH_SANDSTONE), // 24:2
        Map.entry("note block", Material.NOTE_BLOCK), // 25
        /* Map.entry("bed", Material.BED), // 26 */
        Map.entry("powered rail", Material.POWERED_RAIL), // 27
        Map.entry("detector rail", Material.DETECTOR_RAIL), // 28
        Map.entry("sticky piston", Material.STICKY_PISTON), // 29
        Map.entry("cobweb", Material.COBWEB), // 30
        Map.entry("dead bush", Material.DEAD_BUSH), // 32
        Map.entry("piston", Material.PISTON), // 33
        Map.entry("piston head", Material.PISTON_HEAD), // 34
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
        Map.entry("red wool", Material.RED_WOOL), // 35:14
        Map.entry("black wool", Material.BLACK_WOOL), // 35:15
        Map.entry("dandelion", Material.DANDELION), // 37
        Map.entry("poppy", Material.POPPY), // 38
        Map.entry("blue orchid", Material.BLUE_ORCHID), // 38:1
        Map.entry("allium", Material.ALLIUM), // 38:2
        Map.entry("azure bluet", Material.AZURE_BLUET), // 38:3
        Map.entry("red tulip", Material.RED_TULIP), // 38:4
        Map.entry("orange tulip", Material.ORANGE_TULIP), // 38:5
        Map.entry("white tulip", Material.WHITE_TULIP), // 38:6
        Map.entry("pink tulip", Material.PINK_TULIP), // 38:7
        Map.entry("oxeye daisy", Material.OXEYE_DAISY), // 38:8
        Map.entry("brown mushroom", Material.BROWN_MUSHROOM), // 39
        Map.entry("red mushroom", Material.RED_MUSHROOM), // 40
        Map.entry("gold block", Material.GOLD_BLOCK), // 41
        Map.entry("iron block", Material.IRON_BLOCK), // 42
        Map.entry("torch", Material.TORCH), // 50
        Map.entry("diamond ore", Material.DIAMOND_ORE), // 56
        Map.entry("diamond block", Material.DIAMOND_BLOCK), // 57
        Map.entry("crafting table", Material.CRAFTING_TABLE), // 58
        Map.entry("wheat", Material.WHEAT), // 59
        Map.entry("farmland", Material.FARMLAND), // 60
        Map.entry("furnace", Material.FURNACE), // 61
        Map.entry("lit furnace", Material.FURNACE), // 62
        Map.entry("ladder", Material.LADDER), // 65
        Map.entry("rail", Material.RAIL), // 66
        Map.entry("cobblestone stairs", Material.COBBLESTONE_STAIRS), // 67
        Map.entry("lever", Material.LEVER), // 69
        Map.entry("stone pressure plate", Material.STONE_PRESSURE_PLATE), // 70
        Map.entry("iron door", Material.IRON_DOOR), // 71
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
        Map.entry("red nether brick", Material.RED_NETHER_BRICKS), // 215
        Map.entry("bone block", Material.BONE_BLOCK), // 216
        Map.entry("structure void", Material.STRUCTURE_VOID), // 217
        Map.entry("observer", Material.OBSERVER), // 218
        Map.entry("shulker box", Material.SHULKER_BOX), // 219
        Map.entry("white shulker box", Material.WHITE_SHULKER_BOX), // 220
        Map.entry("orange shulker box", Material.ORANGE_SHULKER_BOX), // 221
        Map.entry("magenta shulker box", Material.MAGENTA_SHULKER_BOX), // 222
        Map.entry("light blue shulker box", Material.LIGHT_BLUE_SHULKER_BOX), // 223
        Map.entry("yellow shulker box", Material.YELLOW_SHULKER_BOX), // 224
        Map.entry("lime shulker box", Material.LIME_SHULKER_BOX), // 225
        Map.entry("pink shulker box", Material.PINK_SHULKER_BOX), // 226
        Map.entry("gray shulker box", Material.GRAY_SHULKER_BOX), // 227
        Map.entry("light gray shulker box", Material.LIGHT_GRAY_SHULKER_BOX), // 228
        Map.entry("cyan shulker box", Material.CYAN_SHULKER_BOX), // 229
        Map.entry("purple shulker box", Material.PURPLE_SHULKER_BOX), // 230
        Map.entry("blue shulker box", Material.BLUE_SHULKER_BOX), // 231
        Map.entry("brown shulker box", Material.BROWN_SHULKER_BOX), // 232
        Map.entry("green shulker box", Material.GREEN_SHULKER_BOX), // 233
        Map.entry("red shulker box", Material.RED_SHULKER_BOX), // 234
        Map.entry("black shulker box", Material.BLACK_SHULKER_BOX), // 235
        /* Map.entry("bed", Material.BED), // 355 */
        Map.entry("shield", Material.SHIELD) // 442
    );

    public static String applyMaterialPlaceholders(String input) {
        for (Map.Entry<String, Material> entry : MATERIAL_ALIASES.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue().name());
        }
        return input;
    }
}
