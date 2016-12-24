package me.xize.secretxmass.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.xize.secretxmass.Xmass;

public class MainCommand implements CommandExecutor {

	private final Xmass pl;

	public MainCommand(Xmass pl) {
		this.pl = pl;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("xmass")) {
			if(sender.hasPermission("xmass.plugin")) {
				if(args.length == 0) {
					imsg(sender, new String[] {
							"this plugin shows all the sub commands!",
							"help - shows help",
							"create - creates a session",
							"stop - stops the session",
							"start - starts the session",
							"tree - spawns a enderman which creates a xmass tree",
							"image <name> - spawns a enderman which builds a live structure of a image",
							"image <name> circle - like image<name> it builds a image but now it will fire a circle of fireworks around it"
					});
				} else if(args.length == 1) {

				} else if(args.length == 2) {

				}
			}
		}
		return false;
	}

	private void imsg(CommandSender sender, String[] msgs) {
		sender.sendMessage(ChatColor.GOLD + "===[xmass plugin made bye xize]===");
		for(String msg : msgs) {
			sender.sendMessage(ChatColor.RED + msg);
		}
		sender.sendMessage(ChatColor.GOLD + "==================================");
	}



}
