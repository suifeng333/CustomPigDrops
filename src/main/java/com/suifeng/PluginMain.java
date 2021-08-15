package com.suifeng;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class PluginMain extends PluginBase{

    public static Config config;
    private static PluginMain ins;

    public static PluginMain getInstance(){
        return ins;
    }

    @Override
    public void onLoad(){
        this.getLogger().info("自定义猪猪掉落物加载完毕！");
    }

    @Override
    public void onEnable(){
        this.saveDefaultConfig();
        this.config = new Config(this.getDataFolder() + "/config.yml");
        this.getServer().getPluginManager().registerEvents(new PluginListener(),this);
    }

    @Override
    public void onDisable(){

    }

}