package com.notablenoah.tourneyplus.helpermethods;

import com.notablenoah.tourneyplus.Main;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SaveKit {


    public static void saveKit(Player p, ItemStack[] i, String name) {

        boolean doesExist = false;
        for (int k = 0; k < 41; k++) {
            if (i[k] != null) {
                doesExist = true;
                break;
            }
        }
        if (doesExist) {
            Main.data.put(p.getUniqueId() + name, i);
            p.sendMessage("Saved "+name+"!");
        } else {
            p.sendMessage("Error. No changes made");
        }
    }
}
