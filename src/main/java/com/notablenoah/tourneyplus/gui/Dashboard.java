package com.notablenoah.tourneyplus.gui;

import com.notablenoah.tourneyplus.Main;
import com.notablenoah.tourneyplus.util.InvUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Dashboard {
    public static void openDashboard (Player p){

        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Tourney Dashboard");
        if(Main.tourneyMode){
            InvUtil.addItem(inv,0, Material.GREEN_CONCRETE,1,"tourneyMode",false);
        }else{
            InvUtil.addItem(inv,0, Material.RED_CONCRETE,1,"tourneyMode",false);
        }
        if(Main.spectatorOnDeath){
            InvUtil.addItem(inv,1, Material.GREEN_CONCRETE,1,"spectatorOnDeath",false);
        }else{
            InvUtil.addItem(inv,1, Material.RED_CONCRETE,1,"spectatorOnDeath",false);
        }
        if(Main.spectatorOnKill){
            InvUtil.addItem(inv,2, Material.GREEN_CONCRETE,1,"spectatorOnKill",false);
        }else{
            InvUtil.addItem(inv,2, Material.RED_CONCRETE,1,"spectatorOnKill",false);
        }
        if(Main.customDeathMsg){
            InvUtil.addItem(inv,3, Material.GREEN_CONCRETE,1,"customDeathMsg",false);
        }else{
            InvUtil.addItem(inv,3, Material.RED_CONCRETE,1,"customDeathMsg",false);
        }
        p.openInventory(inv);
    }


}
