package me.rr.test;

import me.rr.test.cmds.GiveOxyGenCMD;
import me.rr.test.events.gravitation.CreateGraviGen;
import me.rr.test.events.gravitation.Gravitation;
import me.rr.test.cmds.GiveGraviGenCMD;
import me.rr.test.events.KillShulker;
import me.rr.test.events.gravitation.RemoveGraviGen;
import me.rr.test.events.oxygen.CreateOxyGen;
import me.rr.test.events.oxygen.OnJoinOxygen;
import me.rr.test.events.oxygen.Oxygen;
import me.rr.test.events.oxygen.OxygenTest;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class PriniumAtmosphere extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new OnJoinOxygen(this), this);
        getServer().getPluginManager().registerEvents(new Gravitation(), this);
        getServer().getPluginManager().registerEvents(new CreateGraviGen(),this);
        getServer().getPluginManager().registerEvents(new RemoveGraviGen(),this);
        getServer().getPluginManager().registerEvents(new KillShulker(),this);
        //getServer().getPluginManager().registerEvents(new Oxygen(this),this);
        //getServer().getPluginManager().registerEvents(new CreateOxyGen(),this);
        getServer().getPluginManager().registerEvents(new OxygenTest(), this);

        getCommand("givegravigenerator").setExecutor(new GiveGraviGenCMD());
        getCommand("giveoxygengenerator").setExecutor(new GiveOxyGenCMD());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
