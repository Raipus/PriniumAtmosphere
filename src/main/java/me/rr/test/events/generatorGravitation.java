package me.rr.test.events;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.EulerAngle;

import java.util.Arrays;

public class generatorGravitation implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            //убрать предмет из инвентаря
            ItemStack item = event.getItem();
            if (item != null && item.getType() == Material.PAPER
                    && item.getItemMeta().getLore().equals(Arrays.asList("Описание генератора","Gsgsg"))
                    && item.getItemMeta().getDisplayName().equals("Генератор атмосферы")) {
                ArmorStand armorStand = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), ArmorStand.class);
                armorStand.getEquipment().setHelmet(new ItemStack(Material.STONE));
                armorStand.setHeadPose(new EulerAngle(0, 0, 0));
                armorStand.setVisible(false);
            }
        }
    }
}
