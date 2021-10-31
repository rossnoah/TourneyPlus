package com.notablenoah.tourneyplus.commands;

import com.notablenoah.tourneyplus.gui.Dashboard;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenDashboardCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            Dashboard.openDashboard(p);
            return true;
        }
        sender.sendMessage("Only players can run this command");
        return true;

    }
}
