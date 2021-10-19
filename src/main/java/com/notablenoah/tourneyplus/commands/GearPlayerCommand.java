package com.notablenoah.tourneyplus.commands;

import com.notablenoah.tourneyplus.helpermethods.GearPlayer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GearPlayerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player executor = (Player) sender;
            if (args.length!=1){
                executor.sendMessage("Incorrect usage");
                executor.sendMessage("Usage: /gear <player>");
                return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if(target!=null){
                GearPlayer.gearPlayer(target,executor);
                return true;
            }
            executor.sendMessage("Target a real player");

        }
        sender.sendMessage("Only players can run this command");
        return true;
    }
}
