package com.horizonbagel.therun;

import net.minecraft.server.v1_8_R3.CommandTellRaw;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TestEvent implements Listener{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GOLD + "Welcome," + player.getName() + "!");

        //if(((CraftPlayer) event.getPlayer()).getHandle().playerConnection.networkManager.getVersion() >= 47)
        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"You are using 1.8.x!\"}");
        PacketPlayOutTitle title = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle);
        ((CraftPlayer) event.getPlayer()).getHandle().playerConnection.sendPacket(title);
        //PacketPlayOutTitle length = newPacketTitle()

    }
}
