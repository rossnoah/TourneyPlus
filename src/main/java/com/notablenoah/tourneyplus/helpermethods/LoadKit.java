package com.notablenoah.tourneyplus.helpermethods;

import com.notablenoah.tourneyplus.Main;
import com.sun.tools.javac.jvm.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LoadKit {


    public static void loadKit (Player target, int slot, boolean announce, Player executor) {
        boolean doesExist = true;
        if (Main.data.get(executor.getUniqueId().toString() + slot) == null){
            doesExist=false;
        }
        if (doesExist) {
            doesExist = false;
            for (int k = 0; k < 41; k++) {
                if (Main.data.get(executor.getUniqueId().toString() + slot)[k] != null) {
                    doesExist = true;
                    break;
                }
            }
        }

        if (doesExist) {
            target.getInventory().clear();
            target.getInventory().setContents(Main.data.get(executor.getUniqueId().toString() + slot));
            target.sendMessage("Loaded kit " + slot + "!");
            if (target != executor) {
                executor.sendMessage("Loaded kit for " + target.getName());
            }
            if (announce) {
                for (Player broadcastPlayer : Bukkit.getOnlinePlayers()) {
                    if (target.getWorld() == broadcastPlayer.getWorld()) {
                        broadcastPlayer.sendMessage(target.getName() + " loaded a kit!");

                    }
                }
            }
        } else {

            target.sendMessage("Error. Kit does not exist");
            if (target != executor) {
                executor.sendMessage("Loading kit for " + target.getName() + " failed. Kit does not exist");
            }
        }


    }


}
