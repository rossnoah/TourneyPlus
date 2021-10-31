package com.notablenoah.tourneyplus.commands;

import com.notablenoah.tourneyplus.helpermethods.LoadKit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoadKitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player executor = (Player) sender;

            if (args.length > 3) {
                executor.sendMessage("Incorrect Usage");
                return true;
            }
            if (args.length == 0) {
                executor.sendMessage("You must select a kit slot");
                return true;
            }
            int slot = Integer.parseInt(args[0]);
            if (slot > 0 && slot <= 6) {
                if (args.length == 1) {
                    LoadKit.loadKit(executor, slot, true, executor);
                    return true;
                }
                Player target = Bukkit.getPlayerExact(args[1]);
                if (target == null) {
                    executor.sendMessage("Select a real player");
                    return true;
                }

                if (args.length == 2) {
                    LoadKit.loadKit(target, slot, true, executor);
                    return true;
                }
                if (args.length == 3) {
                    if (!(args[2].equals("-s") || args[2].equals("silent") || args[2].equals("s") || args[2].equals("false") || args[2].equals("true"))) {
                        executor.sendMessage("Incorrect Usage!");
                        return true;
                    }
                    if (args[2].equals("true")) {
                        LoadKit.loadKit(target, slot, true, executor);
                        return true;
                    } else {
                        LoadKit.loadKit(target, slot, false, executor);
                        return true;


                    }
                }
            }else{
                executor.sendMessage("Error. Select kit slot 1-6");
            }

        }
        sender.sendMessage("This command can only be run by players");
        return true;
    }
}

