package me.rr.test.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Shulker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillShulker implements Listener {
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof Shulker && entity.getCustomName().equals("Генератор гравитации")) {
            event.getDrops().clear();
            Shulker hitbox = entity.getWorld().spawn(entity.getLocation(), Shulker.class);
            hitbox.setAI(false);
            hitbox.setCollidable(true);
            hitbox.setSilent(true);
            hitbox.clearLootTable();
            hitbox.setInvisible(true);
            hitbox.canBreatheUnderwater();
            hitbox.setCustomName("Генератор гравитации");
            hitbox.setCustomNameVisible(false);
            //Можно после этого ломать генератор, придется чинить?
        }
    }
}
