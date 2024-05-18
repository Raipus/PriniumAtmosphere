package me.rr.test.events.oxygen;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class AirTimerTask extends BukkitRunnable {

    public Player player;

    public AirTimerTask(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        int currentAir = player.getRemainingAir();
        if (currentAir > 0) {
            player.setRemainingAir(currentAir - 1);
        } else {
            player.damage(1.0);
        }
    }
}
