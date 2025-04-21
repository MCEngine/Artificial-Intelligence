package io.github.mcengine.api.artificialintelligence.functions.calling;

import org.bukkit.Material;
import java.util.Map;

public class FunctionCallingLoaderMCItem {

    public static final Map<String, Material> MATERIAL_ALIASES = Map.ofEntries(
        Map.entry("acacia boat", Material.ACACIA_BOAT),
        Map.entry("acacia button", Material.ACACIA_BUTTON),
        Map.entry("acacia chest boat", Material.ACACIA_CHEST_BOAT),
        Map.entry("acacia door", Material.ACACIA_DOOR),
        Map.entry("acacia fence", Material.ACACIA_FENCE),
        Map.entry("acacia fence gate", Material.ACACIA_FENCE_GATE),
        Map.entry("acacia hanging sign", Material.ACACIA_HANGING_SIGN),
        Map.entry("acacia leaves", Material.ACACIA_LEAVES),
        Map.entry("acacia log", Material.ACACIA_LOG),
        Map.entry("acacia planks", Material.ACACIA_PLANKS),
        Map.entry("acacia pressure plate", Material.ACACIA_PRESSURE_PLATE),
        Map.entry("acacia sapling", Material.ACACIA_SAPLING),
        Map.entry("acacia sign", Material.ACACIA_SIGN),
        Map.entry("acacia slab", Material.ACACIA_SLAB),
        Map.entry("acacia stairs", Material.ACACIA_STAIRS),
        Map.entry("acacia trapdoor", Material.ACACIA_TRAPDOOR),
        Map.entry("acacia wall hanging sign", Material.ACACIA_WALL_HANGING_SIGN),
        Map.entry("acacia wall sign", Material.ACACIA_WALL_SIGN),
        Map.entry("acacia wood", Material.ACACIA_WOOD),
        Map.entry("activator rail", Material.ACTIVATOR_RAIL),
        Map.entry("air", Material.AIR),
        Map.entry("allay spawn egg", Material.ALLAY_SPAWN_EGG),
        Map.entry("allium", Material.ALLIUM),
        Map.entry("amethyst block", Material.AMETHYST_BLOCK),
        Map.entry("amethyst cluster", Material.AMETHYST_CLUSTER),
        Map.entry("amethyst shard", Material.AMETHYST_SHARD),
        Map.entry("ancient debris", Material.ANCIENT_DEBRIS),
        Map.entry("andesite", Material.ANDESITE),
        Map.entry("andesite slab", Material.ANDESITE_SLAB),
        Map.entry("andesite stairs", Material.ANDESITE_STAIRS),
        Map.entry("andesite wall", Material.ANDESITE_WALL),
        Map.entry("angler pottery sherd", Material.ANGLER_POTTERY_SHERD),
        Map.entry("anvil", Material.ANVIL),
        Map.entry("apple", Material.APPLE),
        Map.entry("archer pottery sherd", Material.ARCHER_POTTERY_SHERD),
        Map.entry("armadillo scute", Material.ARMADILLO_SCUTE),
        Map.entry("armadillo spawn egg", Material.ARMADILLO_SPAWN_EGG),
        Map.entry("armor stand", Material.ARMOR_STAND),
        Map.entry("arms up pottery sherd", Material.ARMS_UP_POTTERY_SHERD),
        Map.entry("arrow", Material.ARROW),
        Map.entry("attached melon stem", Material.ATTACHED_MELON_STEM),
        Map.entry("attached pumpkin stem", Material.ATTACHED_PUMPKIN_STEM),
        Map.entry("axolotl bucket", Material.AXOLOTL_BUCKET),
        Map.entry("axolotl spawn egg", Material.AXOLOTL_SPAWN_EGG),
        Map.entry("azalea", Material.AZALEA),
        Map.entry("azalea leaves", Material.AZALEA_LEAVES),
        Map.entry("azure bluet", Material.AZURE_BLUET)
    );

    public static String applyMaterialPlaceholders(String input) {
        for (Map.Entry<String, Material> entry : MATERIAL_ALIASES.entrySet()) {
            input = input.replace(entry.getKey(), entry.getValue().name());
        }
        return input;
    }
}
