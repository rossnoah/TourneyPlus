package com.notablenoah.tourneyplus.listeners;

import com.notablenoah.tourneyplus.Main;
import com.notablenoah.tourneyplus.gui.Dashboard;
import com.notablenoah.tourneyplus.gui.EnderChestMenu;
import com.notablenoah.tourneyplus.gui.InventoryMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class InventoryActionListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        if (e.getInventory().getType() == InventoryType.CHEST && e.getInventory().getSize() == 9 && e.getInventory().getLocation() == null){
            if (e.getView().getTitle().equals("§6Tourney Dashboard")) {
                e.setCancelled(true);
                Player p = (Player) e.getView().getPlayer();
            if(e.getSlot()==0){
                if(Main.tourneyMode){
                    Main.tourneyMode=false;
                }else{
                   Main.tourneyMode= true;
                }
            }
                if(e.getSlot()==1){
                    if(Main.spectatorOnDeath){
                        Main.spectatorOnDeath=false;
                    }else{
                        Main.spectatorOnDeath= true;
                    }
                }
                if(e.getSlot()==2){
                    if(Main.spectatorOnKill){
                        Main.spectatorOnKill=false;
                    }else{
                        Main.spectatorOnKill= true;
                    }
                }
                if(e.getSlot()==3){
                    if(Main.customDeathMsg){
                        Main.customDeathMsg=false;
                    }else{
                        Main.customDeathMsg= true;
                    }
                }
                e.getView().close();
               Dashboard.openDashboard((Player) e.getView().getPlayer());
            }

        }

        if (e.getView().getTitle().contains("Viewing (id):")) {
            e.setCancelled(true);
        }
        if (e.getView().getTitle().contains("§6Editing: ")) {
            if (e.getView().getTitle().contains("Inventory")) {
                if (e.getSlot() > 40) {
                    e.setCancelled(true);
                }
                if (e.getSlot() == 51) {
                    ItemStack[] i = e.getView().getBottomInventory().getContents();
                    boolean doesExist = false;
                    for (int k = 0; k < 41; k++) {
                        if (i[k] != null) {
                            doesExist = true;
                            break;
                        }
                    }
                    if (doesExist) {
                        for (int n = 0; n < 41; n++) {
                            e.getView().getTopInventory().setItem(n, i[n]);
                        }
                    }
                }
                if (e.getSlot() == 52) {
                    for (int k = 0; k < 41; k++) {
                        e.getView().getTopInventory().setItem(k, null);
                    }
                }
                if (e.getSlot() == 50) {
                    e.getView().close();
                }
                if (e.getSlot() == 53) {
                    e.getView().close();
                    EnderChestMenu.openEditMenu(e.getView().getPlayer().getUniqueId().toString(), (Player) e.getView().getPlayer());
                }
            }
            if (e.getView().getTitle().contains("Ender")) {
                if (e.getSlot() > 26) {
                    e.setCancelled(true);
                }
                if (e.getSlot() == 51) {
                    Player p = (Player) e.getView().getPlayer();
                    ItemStack[] i = p.getEnderChest().getContents();
                    boolean doesExist = false;
                    for (int k = 0; k < 27; k++) {
                        if (i[k] != null) {
                            doesExist = true;
                            break;
                        }
                    }
                    if (doesExist) {
                        for (int n = 0; n < 27; n++) {
                            e.getView().getTopInventory().setItem(n, i[n]);
                        }
                    }
                }
                if (e.getSlot() == 52) {
                    for (int k = 0; k < 41; k++) {
                        e.getView().getTopInventory().setItem(k, null);
                    }
                }
                if (e.getSlot() == 50) {
                    e.getView().close();
                }
                if (e.getSlot() == 53) {
                    e.getView().close();
                    InventoryMenu.openEditMenu(e.getView().getPlayer().getUniqueId().toString(), (Player) e.getView().getPlayer());
                }
            }


            }
        if (e.getInventory().getType() == InventoryType.CHEST && e.getInventory().getSize() == 54 && e.getInventory().getLocation() == null) {
            if (e.getView().getTitle().equals("§6TourneyPlus")){
                Player p = (Player) e.getView().getPlayer();
                e.setCancelled(true);
                if(e.getSlot()==22) {
                    InventoryMenu.openEditMenu(p.getUniqueId().toString(), p);
                }
                if(e.getSlot()==31) {
                    EnderChestMenu.openEditMenu(p.getUniqueId().toString(),p);
                }
            }
        }
    }
}