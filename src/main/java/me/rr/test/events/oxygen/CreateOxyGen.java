package me.rr.test.events.oxygen;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.EulerAngle;

import java.util.Arrays;

public class CreateOxyGen implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();
            if (item != null && item.getType() == Material.PAPER
                    && item.getItemMeta().getLore().equals(Arrays.asList("Это мощное устройство, изменяющее состав воздуха вокруг себя. Требует N-ое количество энергии."))
                    && item.getItemMeta().getDisplayName().equals("Генератор атмосферы")) {
                //Убираем предмет из инвентаря
                Player player = event.getPlayer();
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                //Создаем предмет для арморстенда
                ItemStack generator = new ItemStack(Material.PAPER);
                ItemMeta meta = generator.getItemMeta();
                meta.setDisplayName("Генератор атмосферы");
                meta.setLore(Arrays.asList("Это мощное устройство, изменяющее состав воздуха вокруг себя. Требует N-ое количество энергии."));
                generator.setItemMeta(meta);
                //Вычисляем блок на который смотрит игрок
                BlockIterator blockIterator = new BlockIterator(player, 5);
                Block targetBlock = null;
                while (blockIterator.hasNext()) {
                    Block block = blockIterator.next();
                    if (!block.isEmpty()) {
                        targetBlock = block;
                        break;
                    }
                }
                //Создаем арморстенд
                ArmorStand armorStand = event.getPlayer().getWorld().spawn(targetBlock.getLocation().add(0.5,0,0.5), ArmorStand.class);
                armorStand.getEquipment().setHelmet(generator);
                armorStand.setHeadPose(new EulerAngle(0, 0, 0));
                armorStand.setVisible(false);
                armorStand.setCanMove(false);
                armorStand.addEquipmentLock(EquipmentSlot.HEAD, ArmorStand.LockType.REMOVING_OR_CHANGING);
                armorStand.addEquipmentLock(EquipmentSlot.CHEST, ArmorStand.LockType.ADDING_OR_CHANGING);
                armorStand.addEquipmentLock(EquipmentSlot.LEGS, ArmorStand.LockType.ADDING_OR_CHANGING);
                armorStand.addEquipmentLock(EquipmentSlot.FEET, ArmorStand.LockType.ADDING_OR_CHANGING);
                Shulker hitbox = event.getPlayer().getWorld().spawn(targetBlock.getLocation().add(0.5,1,0.5), Shulker.class);
                hitbox.setAI(false);
                hitbox.setCollidable(true);
                hitbox.setSilent(true);
                hitbox.clearLootTable();
                hitbox.setInvisible(true);
                hitbox.canBreatheUnderwater();
                hitbox.setCustomName("Генератор атмосферы");
                hitbox.setCustomNameVisible(false);
                event.getPlayer().getWorld().playSound(targetBlock.getLocation(), Sound.BLOCK_ANVIL_PLACE, 1.0f, 1.0f);
                event.getPlayer().getWorld().spawnParticle(Particle.EXPLOSION_NORMAL,targetBlock.getLocation().add(0.5,0.9,0.5),5);
            }
        }
    }
}
