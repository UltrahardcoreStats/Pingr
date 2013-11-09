package com.ttaylorr.uhc.pingr.events;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PingSendEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	private Player sender;
	private Player recipient;
	private Sound sound;
	
	public PingSendEvent(Player sender, Player recipient, Sound sound) {
		this.sender = sender;
		this.recipient = recipient;
		this.sound = sound;
	}
	
	public Player getSender() {
		return this.sender;
	}
	
	public Player getRecipient() {
		return this.recipient;
	}
	
	public Sound getSound() {
		return this.sound;
	}
	
	public HandlerList getHandlers() {
	    return handlers;
	}
	 
	public static HandlerList getHandlerList() {
	    return handlers;
	}
	
	
	
}
