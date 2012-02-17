package com.sadmean.mc.ScubaKit;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;


public class ScubaPlayerListener implements Listener {
	
	Player player;
	String airEnder = " seconds of air remaining";
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		player = event.getPlayer();
		ScubaKit.log_It("fine", player.getName() + " joined the server. Checking air!");
		ScubaKit.setAir(player);
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event){
		player = event.getPlayer();
		ScubaKit.setAir(player);
		//Dan's trick fix
		if(player.getRemainingAir() > player.getMaximumAir()) {
			player.setRemainingAir(player.getMaximumAir());
		}
	}
	
	public static ScubaKit plugin; public ScubaPlayerListener(ScubaKit instance) { 
		plugin = instance;
	}


}
