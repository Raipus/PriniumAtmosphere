package me.rr.test.events.oxygen;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getLogger;

public class AirTimerTask2 extends BukkitRunnable {

    public Player player;

    public AirTimerTask2(Player player) {
        this.player = player;
    }

    @Override
    public void run() {


        int remainAir = player.getRemainingAir();
        getLogger().info("Значение до: " + remainAir);
        if (player.getEyeLocation().getBlock().isLiquid()) {
            if (remainAir < 21) {
                player.setRemainingAir(remainAir + 1);
                getLogger().info("Значение после прибавления: " + player.getRemainingAir());
            }
        }
        else {
            if (remainAir > 0) {
                player.setRemainingAir(remainAir - 10);
                getLogger().info("Значение после убавления: " + player.getRemainingAir());
            }
        }
    }
}
