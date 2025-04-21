package io.github.mcengine.api.artificialintelligence.shop.economyshopgui;

import me.gypopo.economyshopgui.api.EconomyShopGUIHook;
import me.gypopo.economyshopgui.objects.ShopItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import net.milkbowl.vault.economy.Economy;

import io.github.mcengine.api.artificialintelligence.shop.IShopHandler;

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
        if (economy == null) return false;

        Material material = Material.matchMaterial(itemName.toUpperCase().replace(" ", "_"));
        if (material == null) return false;

        ItemStack stack = new ItemStack(material, amount);
        ShopItem shopItem = EconomyShopGUIHook.getShopItem(player, stack);
        if (shopItem == null || !EconomyShopGUIHook.isBuyAble(shopItem)) return false;

        double price = EconomyShopGUIHook.getItemBuyPrice(shopItem, player, amount);

        if (economy.getBalance(player) < price) return false;

        economy.withdrawPlayer(player, price);
        player.getInventory().addItem(stack);
        EconomyShopGUIHook.buyItem(shopItem, amount);
        return true;
    }
}
