package com.horizonbagel.therun;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Horizon Bagel on 2016/01/05.
 */
public class Main extends JavaPlugin{

    @Override
    public void onEnable(){
        this.getLogger().info("ロード完了");
        this.getLogger().warning("危なげなやつ");
        this.getServer().getPluginManager().registerEvents(new TestEvent(), this);
        this.getServer().getPluginManager().registerEvents(new TestEvent2(), this);
        this.getServer().getPluginManager().registerEvents(new TestEvent3(), this);
    }

    @Override
    public void onDisable(){
        this.getLogger().info("アンロード完了");
    }
}
