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
import io.github.mcengine.api.artificialintelligence.util.PluginHook;

public class EconomyShopGUIHandler implements IShopHandler {

    private static final Economy economy = PluginHook.getEconomy();

    @Override
    public boolean buy(Player player, String itemName, int amount) {
        if (economy == null) {
            Bukkit.getLogger().warning("[MCEngineAI] Economy provider not available.");
            return false;
        }

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
