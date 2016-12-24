package me.xize.secretxmass;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.xize.secretxmass.commands.MainCommand;

public class Xmass extends JavaPlugin
{
    
	public void onEnable() {
		File f = new File(getDataFolder()+File.separator+"images");
		
		if(!f.exists() && !f.isDirectory()) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "[Xmass]:image folder not found!, creating one now.");
			f.mkdir();
		}
		
		this.getCommand("xmass").setExecutor(new MainCommand(this));
		Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "[Xmass]:has been enabled!");
	}
	
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "[Xmass]:has been disabled!");
	}
	
}
