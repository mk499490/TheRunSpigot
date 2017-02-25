package com.mk499490.therun;

import net.minecraft.server.v1_11_R1.IChatBaseComponent;
import net.minecraft.server.v1_11_R1.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Lobby implements Listener{

    ItemStack cancel = new CustomItem(Material.BARRIER, "§c§lCancel");

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

        // ロビーアイテムの定義。(§は「セクション」と言う。)
        ItemStack mapSelector = new CustomItem(Material.CHAINMAIL_HELMET, "§e§lMap Selector");
        ItemStack itemBox = new CustomItem(Material.CHEST, "§e§lItem");
        ItemStack store = new CustomItem(Material.EMERALD, "§e§lStore");
        ItemStack settings = new CustomItem(Material.ANVIL, "§e§lSettings");
        ItemStack gameMasterTool = new CustomItem(Material.COMMAND, "§e§lGame Master Tool");

        // ロビーアイテムの付与処理
        player.getInventory().setItem(0, mapSelector);
        player.getInventory().setItem(2, itemBox);
        player.getInventory().setItem(3, store);
        player.getInventory().setItem(5, settings);

        if (player.isOp() || player.hasPermission("gamemaster")) {
            player.getInventory().setItem(7, gameMasterTool);
        }

    }

    @EventHandler
    public void onArmorWear(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        //event.setCancelled(true);
        //ItemStack air = new CustomItem(Material.AIR);
        //player.getInventory().setItem(103, air);

        // ItemStack cancel = new CustomItem(Material.BARRIER, "§c§lCancel");

        if (player.getInventory().getItemInMainHand().getType().equals(Material.CHAINMAIL_HELMET)) {
            event.setCancelled(true);
            Inventory gameRoomSelectorGUI;
            // ItemStack cancel = new CustomItem(Material.BARRIER, "§c§lCancel");
            gameRoomSelectorGUI = Bukkit.createInventory(null, 9, "Map Selector");
            gameRoomSelectorGUI.setItem(8, cancel);
            player.openInventory(gameRoomSelectorGUI);
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void ballFiring(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (((player.getItemInHand().getType().equals(Material.CHEST)))) {
            event.setCancelled(true);
            Inventory itemGUI;
            itemGUI = Bukkit.createInventory(null, 27, "Item");
            itemGUI.setItem(26, cancel);
            player.openInventory(itemGUI);
        }

        if (((player.getItemInHand().getType().equals(Material.EMERALD)))) {
            event.setCancelled(true);
            Inventory store;
            store = Bukkit.createInventory(null, 27, "Store");
            store.setItem(26, cancel);
            player.openInventory(store);
        }

        if (((player.getItemInHand().getType().equals(Material.ANVIL)))) {
            event.setCancelled(true);
            Inventory settings;
            settings = Bukkit.createInventory(null, 27, "Settings");
            settings.setItem(26, cancel);
            player.openInventory(settings);
        }

        if (((player.getItemInHand().getType().equals(Material.COMMAND)))) {
            event.setCancelled(true);
            Inventory gameMasterTool;
            gameMasterTool = Bukkit.createInventory(null, 27, "Game Master Tool");
            gameMasterTool.setItem(26, cancel);
            player.openInventory(gameMasterTool);
        }

        else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        Inventory inventory = event.getInventory();

        if (inventory.getName().equals(inventory.getName())) {
            if (clicked.getType() == Material.BARRIER) {
                event.setCancelled(true);
                player.closeInventory();
            }

        }

        if (player.getOpenInventory().getTopInventory().getName().equals("Item")) {

        }

        if (player.getOpenInventory().getTopInventory().getName().equals("Store")) {

        }

        if (player.getOpenInventory().getTopInventory().getName().equals("Settings")) {

        }

        if (player.getOpenInventory().getTopInventory().getName().equals("Game Master Tool")) {

        }

        if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§e§lCancel")) {
            player.closeInventory();
        }

        else {
            event.setCancelled(false);
        }
    }
}
