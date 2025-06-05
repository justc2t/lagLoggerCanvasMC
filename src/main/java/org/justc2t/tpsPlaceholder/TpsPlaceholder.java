package org.justc2t.tpsPlaceholder;

import io.canvasmc.canvas.ThreadedBukkitServer;
import org.bukkit.plugin.java.JavaPlugin;
public final class TpsPlaceholder extends JavaPlugin {

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")){
            new tpsRequest(this).register();
        }
        getCommand("canvasmc").setExecutor(new canvasmccommand());
        getCommand("canvasmc").setTabCompleter(new canvasmccommandtabcompleter());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
