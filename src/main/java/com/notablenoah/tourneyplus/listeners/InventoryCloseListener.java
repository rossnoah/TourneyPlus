package com.notablenoah.tourneyplus.listeners;

import com.notablenoah.tourneyplus.helpermethods.SaveKit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class InventoryCloseListener implements Listener {

    @EventHandler
    public void onInvClose(InventoryCloseEvent e) {



            if (e.getInventory().getType() == InventoryType.CHEST && e.getInventory().getSize() == 54 && e.getInventory().getLocation() == null)
            if (e.getPlayer() instanceof Player) {
                Player p = (Player) e.getPlayer();

                String kitslot;
                String name = null;
                if (e.getView().getTitle().contains("§6Editing: ")) {
                    kitslot = e.getView().getTitle().replace("§6Editing: ", "");

                    name = kitslot;
                    if (name.equals("Ender Chest")) {
                        name = "ender";
                    }
                    if (name.equals("Inventory")) {
                        name = "inventory";
                    }
                }
                if (name != null) {


                    ItemStack[] i = e.getInventory().getContents();
                    boolean doesExist = false;

                    if (name.equals("ender")) {

                        for (int k = 0; k < 41; k++) {
                            if (i[k] != null) {
                                doesExist = true;
                                break;
                            }
                        }
                        if (doesExist) {
                            ItemStack[] out = new ItemStack[41];
                            System.arraycopy(i, 0, out, 0, 41);
                            SaveKit.saveKit(p, out, name);
                        }
                    } else {
                        for (int k = 0; k < 41; k++) {
                            if (i[k] != null) {
                                doesExist = true;
                                break;
                            }
                        }
                        if (doesExist) {
                            ItemStack[] out = new ItemStack[41];
                            System.arraycopy(i, 0, out, 0, 41);
                            SaveKit.saveKit(p, out, name);
                        }


                    }
                }
            }

    }
}