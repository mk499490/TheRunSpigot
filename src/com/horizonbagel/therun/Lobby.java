package com.horizonbagel.therun;

import net.minecraft.server.v1_8_R3.CommandTellRaw;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class Lobby implements Listener{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GOLD + "Welcome," + player.getName() + "!");

        //if(((CraftPlayer) event.getPlayer()).getHandle().playerConnection.networkManager.getVersion() >= 47)
        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"You are using 1.8.x!\"}");
        PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
        ((CraftPlayer) event.getPlayer()).getHandle().playerConnection.sendPacket(title);
        //PacketPlayOutTitle length = newPacketTitle()

        //ItemStack mapSelector = new ItemStack(Material.ENDER_PORTAL_FRAME);
        //player.getInventory().setItem(0, mapSelector);
        //itemMeta.setDisplayName(name);

        ItemStack obsidian = new ItemStack(Material.OBSIDIAN, 64);

        ItemStack mapSelector = new CustomItem(Material.ENDER_PORTAL_FRAME, "§e§lMap Selector");
        player.getInventory().setItem(0, mapSelector);

    }
}
