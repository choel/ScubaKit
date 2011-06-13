package sadmean.mc.scubaKit;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;


public class ScubaPlayerListener extends PlayerListener {
	

	Player player;
	
	public void onPlayerJoin(PlayerJoinEvent event) {
		player = event.getPlayer();
		ScubaKit.log_It("fine", player.getName() + " joined the server. Checking air!");
		ScubaKit.setAir(player);
	}
	
	public void onPlayerMove(PlayerMoveEvent event){
		
		//and set
		player = event.getPlayer();
		
		ScubaKit.setAir(player);
		ScubaKit.log_It("finest", " Checking to see if a message needs to be sent to " + player.getName());
		int air = player.getRemainingAir();
		switch (air) {
		case 2000: player.sendMessage("You have 2000 tics of air left"); break;
		case 1500: player.sendMessage("You have 1500 tics of air left"); break;
		case 1000: player.sendMessage("You have 1000 tics of air left"); break;
		case 750: player.sendMessage("You have 750 tics of air left"); break;
		case 600: player.sendMessage("You have 600 tics of air left"); break;
		case 500: player.sendMessage("You have 500 tics of air left"); break;
		case 400: player.sendMessage("You have 400 tics of air left"); break;
		case 280: player.sendMessage("You have 300 tics of air left"); break;
		case 200: player.sendMessage("You have 200 tics of air left"); break;
		case 100: player.sendMessage("You have 100 tics of air left"); break;
		case 0: player.sendMessage("YOU ARE OUT OF AIR!"); break;
		default:
			break;
		}
	}
	
	public static ScubaKit plugin; public ScubaPlayerListener(ScubaKit instance) { 
		 
        plugin = instance;
 }


}
