package com.notablenoah.tourneyplus.commands;

import com.notablenoah.tourneyplus.gui.MainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player) sender;
            MainMenu.openMenu(p);
            return true;
        }
        sender.sendMessage("You must be a player to run this command");
        return true;
    }
}
