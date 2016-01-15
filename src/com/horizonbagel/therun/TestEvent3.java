package com.horizonbagel.therun;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Masahiro Kitada on 2016/01/14.
 */
public class TestEvent3 implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack diamond = new ItemStack(Material.DIAMOND, 64);

            player.getInventory().addItem(diamond);

            Bukkit.broadcastMessage(ChatColor.GOLD + "Hey," + player.getName() + "!");

        }
        return true;
    }
}
