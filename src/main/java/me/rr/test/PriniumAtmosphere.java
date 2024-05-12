package me.rr.test;

import me.rr.test.events.gravitation;
import org.bukkit.plugin.java.JavaPlugin;

public final class PriniumAtmosphere extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new gravitation(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
