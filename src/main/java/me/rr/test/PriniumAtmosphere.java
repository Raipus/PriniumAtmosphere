package me.rr.test;

import me.rr.test.events.generatorGravitation;
import me.rr.test.events.gravitation;
import me.rr.test.items.giveGraviGenerator;
import org.bukkit.plugin.java.JavaPlugin;

public final class PriniumAtmosphere extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new gravitation(), this);
        getServer().getPluginManager().registerEvents(new generatorGravitation(),this);
        getCommand("giveGraviGenerator").setExecutor(new giveGraviGenerator());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
