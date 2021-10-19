package com.notablenoah.tourneyplus.gui;

import com.notablenoah.tourneyplus.Main;
import com.notablenoah.tourneyplus.util.InvUtil;
import com.notablenoah.tourneyplus.util.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryMenu {

    public static void openEditMenu(String s, Player p){
        Inventory inv;
String slot = "inventory";
        if(Main.data.get(s+slot)!=null){

            if (p.getUniqueId().toString().equals(s)){
                 inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Editing: Inventory");
            }else {
                 inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Viewing (id):" + s +": "+ slot);
            }
            inv.setContents(Main.data.get(s + slot));

            InvUtil.addItem(inv,41,Material.BLUE_STAINED_GLASS_PANE,1," ",false);
            InvUtil.addItem(inv,42,Material.BLUE_STAINED_GLASS_PANE,1," ",false);
            InvUtil.addItem(inv,43,Material.BLUE_STAINED_GLASS_PANE,1," ",false);
            InvUtil.addItem(inv,44,Material.BLUE_STAINED_GLASS_PANE,1," ",false);


            InvUtil.addItem(inv,45,Material.CHAINMAIL_BOOTS,1,"&8&lBOOTS ↑",false);
            InvUtil.addItem(inv,46,Material.CHAINMAIL_LEGGINGS,1,"&8&lLEGGINGS ↑",false);
            InvUtil.addItem(inv,47,Material.CHAINMAIL_CHESTPLATE,1,"&8&lCHESTPLATE ↑",false);
            InvUtil.addItem(inv,48,Material.CHAINMAIL_HELMET,1,"&8&lHELMET ↑",false);
            InvUtil.addItem(inv,49,Material.SHIELD,1,"&8&lOFFHAND ↑",false);

            InvUtil.addItem(inv,50,Material.OAK_DOOR,1,"&7&lEXIT",false);
            InvUtil.addItem(inv,51,Material.CHEST,1,"&a&lIMPORT INVENTORY",false);
            InvUtil.addItem(inv,52,Material.STRUCTURE_VOID,1,"&c&lCLEAR KIT",false);
            InvUtil.addItem(inv,53,Material.ENDER_CHEST,1,"&9&lENDERCHEST",false);
            p.openInventory(inv);

        }else {

            if (p.getUniqueId().toString().equals(s)){
                inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Editing: Inventory");

                InvUtil.addItem(inv,41,Material.BLUE_STAINED_GLASS_PANE,1," ",false);
                InvUtil.addItem(inv,42,Material.BLUE_STAINED_GLASS_PANE,1," ",false);
                InvUtil.addItem(inv,43,Material.BLUE_STAINED_GLASS_PANE,1," ",false);
                InvUtil.addItem(inv,44,Material.BLUE_STAINED_GLASS_PANE,1," ",false);


                InvUtil.addItem(inv,45,Material.CHAINMAIL_BOOTS,1,"&8&lBOOTS ↑",false);
                InvUtil.addItem(inv,46,Material.CHAINMAIL_LEGGINGS,1,"&8&lLEGGINGS ↑",false);
                InvUtil.addItem(inv,47,Material.CHAINMAIL_CHESTPLATE,1,"&8&lCHESTPLATE ↑",false);
                InvUtil.addItem(inv,48,Material.CHAINMAIL_HELMET,1,"&8&lHELMET ↑",false);
                InvUtil.addItem(inv,49,Material.SHIELD,1,"&8&lOFFHAND ↑",false);

                InvUtil.addItem(inv,50,Material.OAK_DOOR,1,"&7&lEXIT",false);
                InvUtil.addItem(inv,51,Material.CHEST,1,"&a&lIMPORT INVENTORY",false);
                InvUtil.addItem(inv,52,Material.STRUCTURE_VOID,1,"&c&lCLEAR KIT",false);
                InvUtil.addItem(inv,53,Material.ENDER_CHEST,1,"&9&lENDERCHEST",false);
                p.openInventory(inv);

                p.openInventory(inv);

            }else {
                p.sendMessage(ChatColor.RED + "Kit does not exist.");
            }
        }
    }


}
