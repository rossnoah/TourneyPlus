package com.notablenoah.tourneyplus.listeners;

import com.notablenoah.tourneyplus.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (Main.tourneyMode) {
            Player p = e.getPlayer();
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You have joined during a tourney, your permissions have been removed and you have been placed in spectator mode, please standby until the time of your fight. Good Luck!");
            p.setGameMode(GameMode.SPECTATOR);


        }else{
            if(e.getPlayer().getGameMode()==GameMode.SPECTATOR){
                e.getPlayer().setGameMode(GameMode.SURVIVAL);
            }
        }

    }
}
