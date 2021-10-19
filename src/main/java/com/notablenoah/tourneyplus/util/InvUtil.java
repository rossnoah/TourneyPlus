package com.notablenoah.tourneyplus.util;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvUtil {

    public static Inventory addItem(Inventory inv,int slot,Material material,int quantity,String name,boolean enchanted){
        ItemStack item = new ItemStack(material,quantity);
        if(enchanted){
            ItemUtil.addEnchantLook(item);
        }
        if(!name.equalsIgnoreCase("false")) {
            ItemUtil.setName(item,name);
        }
        inv.setItem(slot,item);
        return  inv;
    }

}
