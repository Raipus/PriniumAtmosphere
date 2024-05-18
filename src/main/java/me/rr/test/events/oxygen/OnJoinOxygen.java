package me.rr.test.events.oxygen;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getLogger;

public class OnJoinOxygen implements Listener {

    private final JavaPlugin plugin;

    public OnJoinOxygen(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        player.setMaximumAir(330);
        player.setRemainingAir(20);
//        if (player.getRemainingAir() > 20) {
//            player.setRemainingAir(20);
//        }
        getLogger().info("Значение при заходе: " + player.getRemainingAir());
        getLogger().info("Значение макс воздуха: " + player.getMaximumAir());
        AirTimerTask2 airTimerTask = new AirTimerTask2(player);
        airTimerTask.runTaskTimer(plugin, 40L, 40L);

        AirTimerTask3 airTimerTask3 = new AirTimerTask3(player);
        airTimerTask3.runTaskTimer(plugin, 1L, 1L);

        //AirTimerTask airTimerTask = new AirTimerTask(player);
        //airTimerTask.runTaskTimer(plugin, 20L, 20L);
        //player.setMetadata("playerTimerTask", new FixedMetadataValue(plugin, airTimerTask));
    }
}
