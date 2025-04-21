package io.github.mcengine.api.artificialintelligence.shop;

import org.bukkit.entity.Player;

public interface IShopHandler {
    boolean buy(Player player, String itemName, int amount);
    boolean supportsItem(String itemName);
}
