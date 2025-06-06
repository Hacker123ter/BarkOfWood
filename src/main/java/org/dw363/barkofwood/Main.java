package org.dw363.barkofwood;

import org.bukkit.plugin.java.JavaPlugin;
import org.dw363.barkofwood.listener.BarkInteractListener;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BarkInteractListener(), this);
    }
}