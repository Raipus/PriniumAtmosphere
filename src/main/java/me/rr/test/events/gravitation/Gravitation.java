package me.rr.test.events.gravitation;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Collection;

public class Gravitation implements Listener {
    @EventHandler
    public void gravitation(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Collection<ArmorStand> armorStand = player.getWorld().getEntitiesByClass(ArmorStand.class);
        //Вечная гравитация Марса
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, PotionEffect.INFINITE_DURATION, 1, false,false, false));
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, PotionEffect.INFINITE_DURATION, 1, false,false, false));
        //Генератор гравитации Земли
        for (ArmorStand armorStand1 : armorStand) {
            if (armorStand1.getEquipment().getHelmet().getType().equals(Material.PAPER)
                    && armorStand1.getEquipment().getHelmet().getItemMeta().getLore().equals(Arrays.asList("Это мощное устройство, изменяющее силу притяжения вокруг себя. Требует N-ое количество энергии."))
                    && armorStand1.getEquipment().getHelmet().getItemMeta().getDisplayName().equals("Генератор гравитации")){
                if (isPlayerInRadius(player, armorStand1.getLocation(), 10)) {
                    player.removePotionEffect(PotionEffectType.JUMP);
                    player.removePotionEffect(PotionEffectType.SLOW_FALLING);
                }
            }
        }
    }
    //Проверка игрока в радиусе
    public boolean isPlayerInRadius(Player player, Location center, double radius) {
        Location playerLocation = player.getLocation();
        return center.distance(playerLocation) <= radius;
    }
}
