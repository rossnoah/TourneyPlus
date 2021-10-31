package com.notablenoah.tourneyplus.gui;

import com.notablenoah.tourneyplus.Main;
import com.notablenoah.tourneyplus.util.InvUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EnderChestMenu {

    public static void openEditMenu(String s, Player p){
        Inventory inv;
String slot = "ender";
        if(Main.data.get(s+slot)!=null){

            if (p.getUniqueId().toString().equals(s)){
                 inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Editing: Ender Chest");
            }else {
                 inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Viewing (id):" + s +": "+ slot);
            }
            inv.setContents(Main.data.get(s + slot));

            for(int i=36;i<50;i++){
                InvUtil.addItem(inv,i,Material.BLUE_STAINED_GLASS_PANE,1," ",false);
            }

            InvUtil.addItem(inv,50,Material.OAK_DOOR,1,"&7&lEXIT",false);
            InvUtil.addItem(inv,51,Material.ENDER_CHEST,1,"&a&lIMPORT CURRENT ENDERCHEST",false);
            InvUtil.addItem(inv,52,Material.STRUCTURE_VOID,1,"&c&lCLEAR KIT",false);
            InvUtil.addItem(inv,53,Material.CHEST,1,"&9&lINVENTORY",false);
            p.openInventory(inv);

        }else {

            if (p.getUniqueId().toString().equals(s)){
                inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Editing: Ender Chest");
                for(int i=27;i<50;i++){
                    InvUtil.addItem(inv,i,Material.BLUE_STAINED_GLASS_PANE,1," ",false);
                }
                InvUtil.addItem(inv,50,Material.OAK_DOOR,1,"&7&lEXIT",false);
                InvUtil.addItem(inv,51,Material.ENDER_CHEST,1,"&a&lIMPORT CURRENT ENDERCHEST",false);
                InvUtil.addItem(inv,52,Material.STRUCTURE_VOID,1,"&c&lCLEAR KIT",false);
                InvUtil.addItem(inv,53,Material.CHEST,1,"&9&lENDERCHEST",false);
                p.openInventory(inv);

            }else {
                p.sendMessage(ChatColor.RED + "Kit does not exist.");
            }
        }
    }


}
