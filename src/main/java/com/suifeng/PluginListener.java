package com.suifeng;

import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDeathEvent;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;

import java.util.ArrayList;

public class PluginListener implements Listener {

    private Config config = new Config();

    @EventHandler
    public void PigEvents(EntityDeathEvent ev){
        Entity e = ev.getEntity();
        if(e.getNetworkId()==12){
            ArrayList<Item> ite = new ArrayList<>();
            Item item; //方法内无需修饰符
            for (String str : config.getStringList("PigDrops")){
                item = Item.fromString(str);
                item.setCount(Integer.parseInt(str.split(":")[2]));
                ite.add(item);
            }
            ev.setDrops(ite.toArray(new Item[0]));
        }
    }
}
