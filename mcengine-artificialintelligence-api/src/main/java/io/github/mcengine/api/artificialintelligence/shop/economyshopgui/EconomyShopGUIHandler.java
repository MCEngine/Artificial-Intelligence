package io.github.mcengine.api.artificialintelligence.shop.economyshopgui;

import me.gypopo.economyshopgui.api.EconomyShopGUIHook;
import me.gypopo.economyshopgui.objects.ShopItem;
import me.gypopo.economyshopgui.providers.EconomyProvider;
import me.gypopo.economyshopgui.util.EcoType;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.mcengine.api.artificialintelligence.shop.IShopHandler;

public class EconomyShopGUIHandler implements IShopHandler {

    @Override
    public boolean buy(Player player, String itemName, int amount) {
        Material material = Material.matchMaterial(itemName.toUpperCase().replace(" ", "_"));
        if (material == null) return false;

        ItemStack stack = new ItemStack(material, amount);
        ShopItem shopItem = EconomyShopGUIHook.getShopItem(player, stack);
        if (shopItem == null || !EconomyShopGUIHook.isBuyAble(shopItem)) return false;

        double price = EconomyShopGUIHook.getItemBuyPrice(shopItem, player, amount);
        EconomyProvider econ = EconomyShopGUIHook.getEcon(shopItem.getEcoType());

        if (econ == null || !econ.hasBalance(player, price)) return false;

        econ.withdraw(player, price);
        player.getInventory().addItem(stack);
        EconomyShopGUIHook.buyItem(shopItem, amount);
        return true;
    }
}
