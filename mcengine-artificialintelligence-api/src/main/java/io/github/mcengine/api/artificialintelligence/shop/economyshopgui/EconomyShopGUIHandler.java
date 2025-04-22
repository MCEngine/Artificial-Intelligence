package io.github.mcengine.api.artificialintelligence.shop.economyshopgui;

import me.gypopo.economyshopgui.api.EconomyShopGUIHook;
import me.gypopo.economyshopgui.objects.ShopItem;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import io.github.mcengine.api.artificialintelligence.shop.IShopHandler;
import io.github.mcengine.api.artificialintelligence.functions.calling.FunctionCallingLoaderMCItem;

public class EconomyShopGUIHandler implements IShopHandler {

    private static Economy economy;

    static {
        if (Bukkit.getPluginManager().getPlugin("Vault") != null) {
            var registration = Bukkit.getServicesManager().getRegistration(Economy.class);
            if (registration != null) {
                economy = registration.getProvider();
            } else {
                Bukkit.getLogger().warning("[MCEngineArtificialIntelligence] Vault is installed but no Economy provider found.");
            }
        } else {
            Bukkit.getLogger().warning("[MCEngineArtificialIntelligence] Vault plugin not found.");
        }
    }

    @Override
    public boolean buy(Player player, String itemName, int amount) {
        if (economy == null) {
            Bukkit.getLogger().warning("[MCEngineAI] Economy provider not available.");
            return false;
        }

        // Resolve material using alias first, then fallback to Bukkit Material
        Material material = FunctionCallingLoaderMCItem.MATERIAL_ALIASES.getOrDefault(
            itemName.toLowerCase(), 
            Material.matchMaterial(itemName.toUpperCase().replace(" ", "_"))
        );

        if (material == null) {
            Bukkit.getLogger().warning("[MCEngineAI] Unknown material for item: " + itemName);
            return false;
        }

        ItemStack stack = new ItemStack(material, amount);
        ShopItem shopItem = EconomyShopGUIHook.getShopItem(player, stack);

        if (shopItem == null || !EconomyShopGUIHook.isBuyAble(shopItem)) {
            Bukkit.getLogger().warning("[MCEngineAI] Item not buyable or not found in shop: " + itemName);
            return false;
        }

        double price = EconomyShopGUIHook.getItemBuyPrice(shopItem, player, amount);
        if (economy.getBalance(player) < price) {
            player.sendMessage("§cYou don't have enough funds to buy " + amount + "x " + itemName + ".");
            return false;
        }

        economy.withdrawPlayer(player, price);
        player.getInventory().addItem(stack);
        EconomyShopGUIHook.buyItem(shopItem, amount);

        player.sendMessage("§aSuccessfully bought " + amount + "x " + itemName + " for " + price + "!");
        return true;
    }
}
