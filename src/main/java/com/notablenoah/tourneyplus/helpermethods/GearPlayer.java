package com.notablenoah.tourneyplus.helpermethods;

import com.notablenoah.tourneyplus.Main;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GearPlayer {

    public static void gearPlayer (Player target, Player executor) {
        boolean echest = true;
        boolean kitsaved = true;
        if (Main.data.get(target.getUniqueId().toString() + "inventory") == null) {
            executor.sendMessage("Error, player does not have an inventory saved!");
            kitsaved = false;
        } else if (Main.data.get(target.getUniqueId().toString() + "ender") == null) {
            executor.sendMessage("Player does not have an ender chest saved, only loading inventory");
            echest = false;
        }
        if (kitsaved) {
            if (echest) {
                ItemStack[] out = new ItemStack[27];
                for (int i = 0; i < 27; i++) {
                    out[i] = Main.data.get(target.getUniqueId().toString() + "ender")[i];
                }
                target.getEnderChest().setContents(out);
            }
            if (kitsaved) {
                target.getInventory().setContents(Main.data.get(target.getUniqueId().toString() + "inventory"));
                target.setGameMode(GameMode.SURVIVAL);
                target.setHealth(20);
                target.setFoodLevel(20);
                target.setSaturation(20);
                target.sendMessage("You have been geared!");
                target.teleport(executor);
                executor.sendMessage(target.getName() + " has been geared and teleported to you!");


            }
        }
    }
}
