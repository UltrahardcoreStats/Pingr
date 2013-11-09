package com.ttaylorr.uhc.pingr;

import org.bukkit.plugin.java.JavaPlugin;

import com.ttaylorr.uhc.pingr.commands.PingSendCommand;

public class PingrPlugin extends JavaPlugin {
	
	@Override
	public void onDisable() {
		
	}
	
	@Override
	public void onEnable() {
		getCommand("pingr").setExecutor(new PingSendCommand(this));
	}
	
}
