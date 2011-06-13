package sadmean.mc.scubaKit;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListener;


//THIS CLASS IS NO LONGER USED AND SHOULD REALLY JUST BE DELETED
public class ScubaServerListener extends ServerListener {
	
	public Player player;
	
	public void onPlayerJoin(PlayerJoinEvent event) {
		player = event.getPlayer();
		ScubaKit.log_It("fine", player.getName() + " joined the server. Checking air!");
		ScubaKit.setAir(player);
	}
	
	
	public static ScubaKit plugin; public ScubaServerListener(ScubaKit instance) { 
		 
        plugin = instance;
 }
}
