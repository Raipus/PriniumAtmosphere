package me.rr.test.events.oxygen;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import me.rr.test.events.oxygen.OnJoinOxygen;

import java.util.Arrays;
import java.util.Collection;

public class Oxygen implements Listener {

    private final JavaPlugin plugin;

    public Oxygen(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Collection<ArmorStand> armorStand = player.getWorld().getEntitiesByClass(ArmorStand.class);
        AirTimerTask airTimerTask = (AirTimerTask) player.getMetadata("playerTimerTask").get(0).value();
        //Генератор атмосферы Земли
        if (!armorStand.isEmpty()){
            for (ArmorStand armorStand1 : armorStand) {
                if (armorStand1.getEquipment().getHelmet().getType().equals(Material.PAPER)
                        && armorStand1.getEquipment().getHelmet().getItemMeta().getLore().equals(Arrays.asList("Это мощное устройство, изменяющее состав воздуха вокруг себя. Требует N-ое количество энергии."))
                        && armorStand1.getEquipment().getHelmet().getItemMeta().getDisplayName().equals("Генератор атмосферы")){
                    if (isPlayerInRadius(player, armorStand1.getLocation(), 10)) {
                        airTimerTask.cancel();
                    }
                }
                else if (airTimerTask.isCancelled()) {airTimerTask.runTaskTimer(plugin, 20L, 20L);}
            }
        }
        else if (airTimerTask.isCancelled()) {airTimerTask.runTaskTimer(plugin, 20L, 20L);}
    }
    //Проверка игрока в радиусе
    public boolean isPlayerInRadius(Player player, Location center, double radius) {
        Location playerLocation = player.getLocation();
        return center.distance(playerLocation) <= radius;
    }
}
