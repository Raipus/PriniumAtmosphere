package me.rr.test.events;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.EulerAngle;

import java.util.Arrays;

public class generatorGravitation implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().toString().contains("RIGHT")) {
            ItemStack item = event.getItem();
            if (item != null && item.getType() == Material.ARMOR_STAND && item.hasItemMeta()) {
                ArmorStand armorStand = event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), ArmorStand.class);
                armorStand.setHelmet(new ItemStack(Material.STONE));
                armorStand.setHeadPose(new EulerAngle(Math.toRadians(90), 0, 0));
            }
        }
    }

    public ItemStack createCustomArmorItem() {
        ItemStack item = new ItemStack(Material.ARMOR_STAND);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Генератор атмосферы");
        meta.setLore(Arrays.asList("Описание генератора"));
        item.setItemMeta(meta);
        return item;
    }
}
