package sadmean.mc.scubaKit;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerMoveEvent;


public class ScubaPlayerListener extends PlayerListener {
	
	String chatStart = ChatColor.DARK_AQUA + "[ScubaKit] " +ChatColor.GRAY;
	Player player;
	String airEnder = " seconds of air remaining";
	
	public void onPlayerJoin(PlayerJoinEvent event) {
		player = event.getPlayer();
		ScubaKit.log_It("fine", player.getName() + " joined the server. Checking air!");
		ScubaKit.setAir(player);
	}
	
	public void onPlayerMove(PlayerMoveEvent event){
		
		//and set
		
		player = event.getPlayer();
		
		ScubaKit.setAir(player);
		/* commented out all those code because its useless. Will save for now.
		ScubaKit.log_It("finest", " Checking to see if a message needs to be sent to " + player.getName());
		int air = player.getRemainingAir();
		switch (air) {
		case 10000: player.sendMessage(chatStart + "500" + airEnder); break;
		case 9000: player.sendMessage(chatStart + "450" + airEnder); break;
		case 8000: player.sendMessage(chatStart + "400" + airEnder); break;
		case 7000: player.sendMessage(chatStart + "350" + airEnder); break;
		case 6000: player.sendMessage(chatStart + "300" + airEnder); break;
		case 5000: player.sendMessage(chatStart + "250" + airEnder); break;
		case 4000: player.sendMessage(chatStart + "200" + airEnder); break;
		case 3000: player.sendMessage(chatStart + "150" + airEnder); break;
		case 2000: player.sendMessage(chatStart + "100" + airEnder); break;
		case 1500: player.sendMessage(chatStart + "75" + airEnder); break;
		case 1000: player.sendMessage(chatStart + "50" + airEnder); break;
		case 800: player.sendMessage(chatStart + "40" + airEnder); break;
		case 600: player.sendMessage(chatStart + "30" + airEnder); break;
		case 500: player.sendMessage(chatStart + "25" + airEnder); break;
		case 400: player.sendMessage(chatStart + "20" + airEnder); break;
		case 300: player.sendMessage(chatStart + "15" + airEnder); break;
		case 200: player.sendMessage(chatStart + "10" + airEnder); break;
		case 100: player.sendMessage(chatStart + "5" + airEnder); break;
		case 0: player.sendMessage(chatStart + ChatColor.RED + "YOU ARE OUT OF AIR!"); break;
		default:
			break;
			
		} */
	}
	
	public static ScubaKit plugin; public ScubaPlayerListener(ScubaKit instance) { 
		 
        plugin = instance;
 }


}
