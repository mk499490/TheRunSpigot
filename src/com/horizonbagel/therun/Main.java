package com.horizonbagel.therun;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    @Override
    public void onEnable(){
        this.getServer().getPluginManager().registerEvents(new TestEvent(), this);
        this.getServer().getPluginManager().registerEvents(new TestEvent2(), this);
        this.getCommand("hey").setExecutor(new TestEvent3());
        this.getLogger().info("ロード完了");
        //this.getLogger().warning("危なげなやつ");

    }

    @Override
    public void onDisable(){
        this.getLogger().info("アンロード完了");
    }
}
