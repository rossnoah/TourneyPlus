package com.notablenoah.tourneyplus.gui;

import com.notablenoah.tourneyplus.util.InvUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MainMenu {

    public static void openMenu (Player p){

        Inventory inv = Bukkit.createInventory(null,54,ChatColor.GOLD+"TourneyPlus");
        for (int i =0; i<inv.getSize();i++){
            InvUtil.addItem(inv,i, Material.BLUE_STAINED_GLASS_PANE,1," ",false);
        }
        InvUtil.addItem(inv,22, Material.CHEST,1,"&a&lINVENTORY",false);
        InvUtil.addItem(inv,31, Material.ENDER_CHEST,1,"&9&lENDER CHEST",false);

        p.openInventory(inv);

    }




}
