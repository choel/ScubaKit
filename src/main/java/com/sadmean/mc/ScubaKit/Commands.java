package com.sadmean.mc.ScubaKit;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands {
	
	public static void commandParse(String[] args, CommandSender sender) {
		Player player;
		player = sender.getServer().getPlayer(sender.toString());
		if(args[1] == "diamondLength") {
			if(ScubaKit.permCheck(player, "ScubaKit.Commands.Diamond")) {
				
			}
		}
	}
}
