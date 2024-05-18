package me.rr.test.events.oxygen;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityAirChangeEvent;

public class OxygenTest implements Listener {
    @EventHandler
    public void entityAirChangeEvent(EntityAirChangeEvent event){
        if (event.getEntity() instanceof Player) {
            event.setCancelled(true);
        }
    }
}
