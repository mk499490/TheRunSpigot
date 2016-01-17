package com.horizonbagel.therun;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class TestEvent3 implements CommandExecutor{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player joinedPlayer = event.getPlayer();

        //ItemStack
    }

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
