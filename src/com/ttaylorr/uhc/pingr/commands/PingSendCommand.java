package com.ttaylorr.uhc.pingr.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ttaylorr.uhc.pingr.PingrPlugin;
import com.ttaylorr.uhc.pingr.events.PingSendEvent;

public class PingSendCommand implements CommandExecutor {

	private PingrPlugin plugin;
	
	public PingSendCommand(PingrPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player))
			return false;
		
		Player player = (Player) sender;
		
		if(args.length != 1)
			return false;

		if(!(player.hasPermission("pingr.send")))
			return false;
		
		if(Bukkit.getPlayer(args[0]) == null)
			return false;
		
		Player recipient = Bukkit.getPlayer(args[0]);
		
		if(!(recipient.hasPermission("pingr.recieve")))
			return false;
		
		Sound sound = Sound.ORB_PICKUP;
		
		Bukkit.getServer().getPluginManager().callEvent(new PingSendEvent(player, recipient, sound));
		
		recipient.playSound(recipient.getLocation(), sound, 1.0f, 1.0f);
		

		return false;
	}

}
