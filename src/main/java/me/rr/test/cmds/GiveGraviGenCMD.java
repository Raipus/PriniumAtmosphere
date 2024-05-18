package me.rr.test.cmds;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;

public class GiveGraviGenCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;

        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Генератор гравитации");
        meta.setLore(Arrays.asList("Это мощное устройство, изменяющее силу притяжения вокруг себя. Требует N-ое количество энергии."));
        item.setItemMeta(meta);

        player.getInventory().addItem(item);

        return true;
    }
}
