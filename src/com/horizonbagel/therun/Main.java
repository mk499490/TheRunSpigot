package com.horizonbagel.therun;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    @Override
    public void onEnable(){
        //this.getServer().getPluginManager().registerEvents(new Lobby(), this);
        this.getServer().getPluginManager().registerEvents(new Lobby(), this);
        this.getLogger().info("ロード完了");

    }

    @Override
    public void onDisable(){
        this.getLogger().info("アンロード完了");
    }
}
