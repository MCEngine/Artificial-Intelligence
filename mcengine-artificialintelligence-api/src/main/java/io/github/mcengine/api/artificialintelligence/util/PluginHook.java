package io.github.mcengine.api.artificialintelligence.util;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;

public class PluginHook {

    private static Economy economy;

    static {
        setupEconomy();
    }

    private static void setupEconomy() {
        if (Bukkit.getPluginManager().getPlugin("Vault") != null) {
            RegisteredServiceProvider<Economy> registration = Bukkit.getServicesManager().getRegistration(Economy.class);
            if (registration != null) {
                economy = registration.getProvider();
            } else {
                Bukkit.getLogger().warning("[MCEngineArtificialIntelligence] Vault is installed but no Economy provider found.");
            }
        } else {
            Bukkit.getLogger().warning("[MCEngineArtificialIntelligence] Vault plugin not found.");
        }
    }

    public static Economy getEconomy() {
        return economy;
    }
}
