package me.rr.test.events.gravitation;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collection;

public class RemoveGraviGen implements Listener {
    @EventHandler
    public void onPlayerInteract(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            if (event.getEntity() instanceof Shulker && event.getEntity().getCustomName().equals("Генератор гравитации")) {
                Collection<ArmorStand> armorStands = event.getEntity().getWorld().getNearbyEntitiesByType(ArmorStand.class,event.getEntity().getLocation(),1);
                event.getEntity().remove();
                for (ArmorStand aS : armorStands){
                    aS.remove();
                }

                ItemStack item = new ItemStack(Material.PAPER);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("Генератор гравитации");
                meta.setLore(Arrays.asList("Это мощное устройство, изменяющее силу притяжения вокруг себя. Требует N-ое количество энергии."));
                item.setItemMeta(meta);
                player.getInventory().addItem(item);
                player.getWorld().playSound(event.getEntity().getLocation(), Sound.BLOCK_ANVIL_BREAK, 1.0f, 1.0f);
            }
        }
    }
}
