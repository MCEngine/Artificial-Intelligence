package io.github.mcengine.api.artificialintelligence;


import io.github.mcengine.api.artificialintelligence.util.MCEngineArtificialIntelligenceApiUtil;

import org.bukkit.plugin.Plugin;

import java.util.logging.Logger;

public class MCEngineArtificialIntelligenceApi {

    private final Plugin plugin;
    private final MCEngineArtificialIntelligenceApiUtil logger;

    public MCEngineArtificialIntelligenceApi(Plugin plugin) {
        this.plugin = plugin;
        this.logger = new MCEngineArtificialIntelligenceApiUtil(plugin.getLogger());
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }
    
    public void error(String message) {
        logger.error(message);
    }
}
