package com.sadmean.mc.ScubaKit;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import com.sadmean.mc.ScubaKit.config.ScubaLang;
import com.sadmean.mc.ScubaKit.config.UpdateConfigFile;
import com.sadmean.mc.ScubaKit.config.UpdateLangFile;



/**
 * @version 1.0.0
 * @author Choelian
 *	ScubaKit allows players wearing a specified block on their head to 
 *	stay underwater for a different (probably larger) chunk of time.
 * 
 * @TODO 
 * 	HIGH PRIORITY:
 *  	Allow config of higher default air to override lower air provided by helms
 *  LOW PRIORITY:
 *  	Recharge time for scubagear
 *  	Consumables? maybe.
 *  
 */
public class ScubaKit extends JavaPlugin {
	
	static String mainDirectory = "plugins/ScubaKit"; //plugin directory
	
	//private final ScubaPlayerListener playerListener = new ScubaPlayerListener(this); //the player listener.
		
	static public File configFile = new File(mainDirectory + File.separator + "config.yml"); //location of configfile. 
	static public File langFile = new File(mainDirectory + File.separator + "lang.yml"); //location of the language file
	
	//default settings
	public static int pumpkinAir = 320; // default value for maxAir (air after putting on the scuba helm
	public static int defaultAir = 320; //default value for defaultAir (air when not wearing the scuba helm
	public static int goldAir = defaultAir;
	public static int diamondAir = defaultAir;
	public static int ironAir = defaultAir;
	public static int chainAir = defaultAir;
	public static int leatherAir = defaultAir;
	public static boolean debugLogs = false;
	public static boolean ignorePermissions = true;
	public static boolean complexPermissions = false;
	public static boolean airOverridesIfHigher = true;
	public static boolean blockHatInstalled = false;
	public static boolean displayRemainingAirMessage = true;
	public static boolean firstRun = true;
	public static int configVersion = 0;
	public static boolean SuperPerms = true;
	//Blockhat settings here:
	public static int maxBlockHatValue = 150;
	public static int[] blockHatValues;
	//language
	public static ScubaLang Language;
	//THESE VALUES SHOULD BE OVERWRITTEN BY CONFIG.YML
	
	
	
	public static int latestConfigVersion = 3;
	
	int theFan = -1;
	int shit;
	
	public static PermissionHandler permissionHandler; //permissions handler
	
	private static ScubaKit thisPlugin = null; //I don't know what this does. Necessary for fancy log
    
	
	public static Logger log = Logger.getLogger("Minecraft"); //logger object. can be written to directly with "log.info("herp derp")
    
	public static ScubaKit getThisPlugin() { //I do not know. Needed for fancy log
		return thisPlugin; 
	}

	private static void setThisPlugin(final ScubaKit thisPlugin) {
		ScubaKit.thisPlugin = thisPlugin;
	}
	

	public void onLoad() {
		setThisPlugin(this); //not 100% sure
	}
	    
	public void onEnable(){  //onEnable is called after onLoad
		getServer().getPluginManager().registerEvents(new ScubaPlayerListener(this), this);
		
		blockHatValues = new int[maxBlockHatValue + 1];
		new File(mainDirectory).mkdir();  //makes our directory if needed
		if(!langFile.exists()) { //if your lang file does not exist then ...
			try {
				log_It("info", "No language file detected. Creating default English file");
				langFile.createNewFile();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else {
			//it does exist
		}
		if(!configFile.exists()){ //if your config does not exist then ...
	         try {
	        	log_It("info", "No config file defected. Creating default config file");
	        	configFile.createNewFile(); //... we create it then ...
	         } catch (IOException ex) { 
	             ex.printStackTrace(); //not needed anymore probably
	             //oh wait yeah it totally is because of the new fucked up config loading.
	             //fuck this I should just go to XML or something.
	         }
	 
		} else { 
			//it does exist?
		}
		//start setting values
		UpdateConfigFile.load();
		Language = UpdateLangFile.load();
		if (firstRun) {
			UpdateConfigFile.firstRun();
			log_It("warning", "This appears to be your first run of ScubaKit 3.x, Please note that some things have changed since ScubaKit 2.x.");
			log_It("warning", "1. The simple permission system is gone. If any players had the node ScubaKit.ScubaGear, it must be replaced with ");
			log_It("warning", "ScubaKit.ScubaGear.*");
			log_It("warning", "2. If you used blockHat or simmilar mod, your scubakit settings related to those mods have been rearranged, please go check them now");
			log_It("warning", "3. We now support SuperPerms, which is enabled by default. If you want to use a legacy permissions plugin, please set SuperPerms to false in the config file.");
		} else {
			log_It("info", "Remember to update any permissions nodes of ScubaKit.ScubaGear to ScubaKit.ScubaGear.*");
		}
		
		setupPermissions(); //set up permissions yah!!!
			
		if(pumpkinAir == 0 && defaultAir == 0 && goldAir == 0 && chainAir == 0 && leatherAir == 0 && diamondAir == 0) {
			log_It("severe", "All values reported as zero, this should never happen"); 
			//if all values are zero, then the config file is 1 of 3 things
			//1. Blank, maybe the save failed when we tried to create it?
			//2. Does not exist, but why didn't we create it earlier in onEnable()?
			//3. Values were manually set to Zero in the config. I have no idea why you would do that, but you could
		}
		
		shit = getThisPlugin().getServer().getScheduler().scheduleSyncRepeatingTask(getThisPlugin(), new Runnable() {

		    public void run() {
		    	log_It("fine", "ScubaTask is on the case!");
		        int worldNumber = 0;
		        int playerNumber = 0;
		        int airLeft;
		        Player player;
		        List<World> worlds = getServer().getWorlds();
				while (worldNumber < worlds.size()) {
					List<Player> playerList = worlds.get(worldNumber).getPlayers();
						while (playerNumber < playerList.size()) {
							player = playerList.get(playerNumber);
							if (player.getMaximumAir() != player.getRemainingAir()) {
								//Air Check and message send
								airLeft = player.getRemainingAir();
								//log_It("warning", player.getName() + " has " + Integer.toString(airLeft) + " tics of air left");
								airLeft = airLeft / 20;
								if (airLeft == 0) {
									//if(displayRemainingAirMessage) player.sendMessage(ChatColor.DARK_AQUA + "[ScubaKit] " + ChatColor.RED + "YOU ARE OUT OF AIR!"); break;
								} else {
									//if(displayRemainingAirMessage) player.sendMessage(ChatColor.DARK_AQUA + "[ScubaKit] " + ChatColor.GRAY + Integer.toString(airLeft) + " seconds of air remaining");	
								}
							}
							playerNumber++;
						}
						worldNumber++;
						playerNumber = 0;
					}
		        
		    }
		}, 60L, 300L);

		if (shit == theFan) {
			log_It("severe", "Schedule failed. This is really bad");
		}
	} 
	
	public void onDisable(){  
		if (getThisPlugin().getServer().getScheduler().isCurrentlyRunning(shit)) {
			getThisPlugin().getServer().getScheduler().cancelTask(shit);
			log_It("info", Language.disable_complete); 
		} else {
			log_It("info", Language.disable_complete); //log us not doing anything.
			//log_It("warning", "Disabled Completed, but with errors");
		}
	}
	
	private void setupPermissions() {
		Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
		if(!SuperPerms) {
			if (this.permissionHandler == null) {
				if (permissionsPlugin != null) {
					this.permissionHandler = ((Permissions) permissionsPlugin).getHandler();
				} else {
					log_It("info", "Permission system not detected, ignorePermissions has be set to true");
					ignorePermissions = true;
				}
			}
		} else {
			log_It("info", "SuperPerms is set to true, aborting legacy permissions hook");
		}
	}
	
	public static boolean permCheck(Player player, String perm) {
		if (ignorePermissions) {
			return true;
		}
		if(SuperPerms) {
			if(player.hasPermission(perm)) {
				return true;
			} else {
				return false;
			}
		} else {
			//legacy permissions support
			if(permissionHandler.has(player, perm)) {
				return true;
			} else {
				return false;
			}
		}
		
		
	}

	
	/**
	 * @param maxAir
	 * @param defaultAir
	 * @param player
	 */
	public static void setAir(Player player) {
		//lets start with a permissions check
		String typeID;
		ItemStack helm;
		PlayerInventory armor;
		armor = player.getInventory();
		helm = armor.getHelmet();
		switch (helm.getTypeId()) {
			case 86: //pumpkin
				typeID = "Pumpkin";
				break;
			case 310: //diamond
				typeID = "Diamond";
				break;
			case 314:
				typeID = "Gold";
				break;
			case 306:
				typeID = "Iron";
				break;
			case 298:
				typeID = "Leather";
				break;
			case 302:
				typeID = "Chain";
				break;
			default:
				typeID = Integer.toString(helm.getTypeId());
		}
		
		if (permCheck(player, "ScubaKit.ScubaGear." + typeID)) {
			//Checks to see what the player is wearing, then adjusts their lungs accordingly.
						
			switch (helm.getTypeId()) {
				case 0: //speed fix? we'll see
					player.setMaximumAir(defaultAir);
					log_It("finest", "set max air to default levels");
					break;
				case 86: //pumpkin head
					player.setMaximumAir(pumpkinAir);
					log_It("finest", "set max air to pumpkin levels");
					break;
				case 310: //diamond helm 
					player.setMaximumAir(diamondAir);
					log_It("finest", "set max air to diamond levels");
					break;
				case 314: //gold helm
					player.setMaximumAir(goldAir);
					log_It("finest", "set max air to gold levels");
					break;
				case 306: //iron helm
					player.setMaximumAir(ironAir);
					log_It("finest", "set max air to iron levels");
					break;
				case 298: //leather helm
					player.setMaximumAir(leatherAir);
					log_It("finest", "set max air to leather levels");
					break;
				case 302: //chain helm
					player.setMaximumAir(chainAir);
					log_It("finest", "set max air to chain levels");
					break;
				default: 
					//start blockhat stuff.
					if(blockHatInstalled) {
						if(helm.getTypeId() < maxBlockHatValue && helm.getTypeId() > 0) {
							player.setMaximumAir(blockHatValues[helm.getTypeId()]);
							log_It("finest", "set air to block." + Integer.toString(blockHatValues[helm.getTypeId()]) + " levels"); 
						} else { //not a configured helm
							player.setMaximumAir(defaultAir);
							log_It("finest", "Player wearing unknown block. TypeID is : " + Integer.toString(helm.getTypeId()));
						}
					} else {
						player.setMaximumAir(defaultAir);
						log_It("finest", "set air to default"); 						
					}
					break;
			} //this one ends our switch
		} else {
			//do nothing because those code is NO LONGER NEEDED!						
		}		
	}
	
	/**
	 * @param message
	 */
	public static void log_It(String message) {
		//converts 1 string log_it to a 2 string log it. Fixes leftovers.
		String level = "undefined";
		log_It("warning", "this message's priority was not properly set");
		log_It(level, message);
	}
	
	/**
	 * @param level
	 * @param message
	 */
	public static void log_It(String level, String message) {
		PluginDescriptionFile thisYAML = getThisPlugin().getDescription();
		String pluginName = thisYAML.getName();
		String pluginVersion = thisYAML.getVersion();
		String fullName = "[" + pluginName + "][" + pluginVersion + "] ";
		//convert our level into an int for logging
		int level_int = 6;
		
		if(level == "finest") level_int = 0;
		if(level == "finer") level_int = 1;
		if(level == "fine") level_int = 2;
		if(level == "info") level_int = 3;
		if(level == "warning") level_int = 4;
		if(level == "severe") level_int = 5;
		if(level == "undefined") level_int = 6;
		
	
		switch (level_int) {
		case 0: if(debugLogs) log.finest(fullName + message); break; //for people who like logs in the hexabytes
		case 1: if(debugLogs) log.finer(fullName + message); break; //for people who like log file sizes in the petabytes
		case 2: if(debugLogs) log.fine(fullName + message); break; //for people who like log file sizes in the terabytes
		case 3: log.info(fullName + message); break; //for people who like log file sizes in the gigabytes
		case 4: log.warning(fullName + message); break; //for people who like log file sizes in the megabytes
		case 5: log.severe(fullName + message); break; //for people who like log file sizes in the kilobytes
		case 6: log.warning(fullName + message); break; //for me, 'cause I forgot to specify what level of logging
		default: log.warning(fullName + "warning defaulted, maybe a typo: " + message); //also for me, because I spelled the logging level wrong
			break;
		}
	}

}