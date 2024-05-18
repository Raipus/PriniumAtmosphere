package me.rr.test.events.oxygen;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static org.bukkit.Bukkit.getLogger;

public class AirTimerTask3 extends BukkitRunnable {

    public Player player;

    public AirTimerTask3(Player player) {
        this.player = player;
    }

    @Override
    public void run() {
        if (player.getRemainingAir() == 300) {
            player.setRemainingAir(player.getMaximumAir()); // Установка максимального уровня воздуха
        }
    }
}
