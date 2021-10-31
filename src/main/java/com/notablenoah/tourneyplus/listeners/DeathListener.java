package com.notablenoah.tourneyplus.listeners;

import com.notablenoah.tourneyplus.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath (PlayerDeathEvent e){

        if(Main.customDeathMsg){
            e.setDeathMessage(ChatColor.RED+""+ChatColor.BOLD+e.getDeathMessage());
        }
        if(Main.spectatorOnDeath){
            e.getEntity().setGameMode(GameMode.SPECTATOR);
            e.getEntity().sendMessage("You have died and your gamemode was set to spectator");
        }

        if(Main.spectatorOnKill) {
            if (e.getEntity().getKiller() != null) {
                e.getEntity().getKiller().setGameMode(GameMode.SPECTATOR);
                e.getEntity().getKiller().sendMessage("You have killed your opponent and your gamemode was set to spectator");
            }
        }


    }
}
