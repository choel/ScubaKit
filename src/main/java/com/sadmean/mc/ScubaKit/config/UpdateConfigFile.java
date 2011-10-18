package com.sadmean.mc.ScubaKit.config;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import com.sadmean.mc.ScubaKit.ScubaKit;

public class UpdateConfigFile {
		
	public static boolean load() {
		boolean displayWarning = false;
		FileConfiguration config;
		config = ScubaKit.getThisPlugin().getConfig();
		try {
			config.load(ScubaKit.configFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			ScubaKit.log_It("warning", "Config file not found. This error probably printed twice");
		} catch (IOException e) {
			e.printStackTrace();
			ScubaKit.log_It("warning", "This should really never happen");
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
			ScubaKit.log_It("warning", "Your config file appears to be damaged. Delete it!");
		}
		//check for defaultAir, if exists. If exists, load it into plugin. Else, set from default values.
		if(config.contains("scubaValues.defaultAir")) {
			ScubaKit.defaultAir = config.getInt("scubaValues.defaultAir", 0);
		} else {
			config.set("scubaValues.defaultAir", ScubaKit.defaultAir); 
		}
		
		//now for pumpkin air
		if(config.contains("scubaValues.pumpkinAir")) {
			ScubaKit.pumpkinAir = config.getInt("scubaValues.pumpkinAir", 0);
		} else {
			config.set("scubaValues.pumpkinAir", ScubaKit.pumpkinAir); 
		}
		
		//next we check diamondAir
		if(config.contains("scubaValues.diamondAir")) {
			ScubaKit.diamondAir = config.getInt("scubaValues.diamondAir", 0);
		} else {
			config.set("scubaValues.diamondAir", ScubaKit.diamondAir); 
		}
		
		//goldAir
		if(config.contains("scubaValues.goldAir")) {
			ScubaKit.goldAir = config.getInt("scubaValues.goldAir", 0);
		} else {
			config.set("scubaValues.goldAir", ScubaKit.goldAir); 
		}
		
		//ironAir
		if(config.contains("scubaValues.ironAir")) {
			ScubaKit.ironAir = config.getInt("scubaValues.ironAir", 0);
		} else {
			config.set("scubaValues.ironAir", ScubaKit.ironAir); 
		}
		
		//leatherAir
		if(config.contains("scubaValues.leatherAir")) {
			ScubaKit.leatherAir = config.getInt("scubaValues.leatherAir", 0);
		} else {
			config.set("scubaValues.leatherAir", ScubaKit.leatherAir); 
		}
		
		//chainAir
		if(config.contains("scubaValues.chainAir")) {
			ScubaKit.chainAir = config.getInt("scubaValues.chainAir", 0);
		} else {
			config.set("scubaValues.chainAir", ScubaKit.chainAir); 
		}
		
		//display remaining air message
		if(config.contains("system.displayRemainingAirMessage")) {
			ScubaKit.displayRemainingAirMessage = config.getBoolean("system.displayRemainingAirMessage", true);
		} else {
			config.set("system.displayRemainingAirMessage", ScubaKit.displayRemainingAirMessage); 
		}
				
		//ignorePermissions
		if(config.contains("system.ignorePermissions")) {
			ScubaKit.ignorePermissions = config.getBoolean("system.ignorePermissions", true);
		} else {
			config.set("system.ignorePermissions", config.getBoolean("scubaValues.ignorePermissions", ScubaKit.ignorePermissions)); 
		}
		
		if(config.contains("system.SuperPerms")) {
			ScubaKit.SuperPerms = config.getBoolean("system.SuperPerms", true);
		} else {
			config.set("system.SuperPerms", ScubaKit.SuperPerms); 
		}
		//complex permissions
		/** NO LONGER USED
		if(config.contains("system.complexPermissions")) {
			ScubaKit.complexPermissions = config.getBoolean("system.complexPermissions", false);
		} else {
			config.set("system.complexPermissions", config.getBoolean("scubaValues.complexPermissions", ScubaKit.complexPermissions)); 
		}
		**/		
		//version 0 values done
		if(config.contains("system.airOverridesIfHigher")) {
			ScubaKit.airOverridesIfHigher = config.getBoolean("system.airOverridesIfHigher", false);
		} else {
			config.set("system.airOverridesIfHigher", ScubaKit.airOverridesIfHigher); 
		}
		
		if(config.contains("system.debugLogs")) {
			ScubaKit.debugLogs = config.getBoolean("system.debugLogs", false);
		} else {
			config.set("system.debugLogs", ScubaKit.debugLogs); 
		}
		
		if(config.contains("system.firstRun")) {
			ScubaKit.firstRun = config.getBoolean("system.firstRun", true);
		} else {
			config.set("system.firstRun", ScubaKit.firstRun); 
		}
				
		//blockhat integration
		if(config.contains("system.blockHatInstalled")) {
			ScubaKit.blockHatInstalled = config.getBoolean("system.blockHatInstalled", false);
		} else {
			config.set("system.blockHatInstalled", ScubaKit.blockHatInstalled); 
		}
		
		if(ScubaKit.blockHatInstalled) {
			ScubaKit.log_It("info", "blockHatInstalled is true, checking and expanding config");
			ScubaKit.log_It("info", "Max TypeID is " + Integer.toString(ScubaKit.maxBlockHatValue));
			//block hat settings start
			int i = 1;
			while (i <= ScubaKit.maxBlockHatValue) {
				if(config.contains("scubaValues.blocks." + Integer.toString(i))) {
					ScubaKit.blockHatValues[i] = config.getInt("scubaValues.blocks." + Integer.toString(i), ScubaKit.defaultAir);
				} else {
					config.set("scubaValues.blocks." + Integer.toString(i), ScubaKit.defaultAir);
					ScubaKit.blockHatValues[i] = config.getInt("scubaValues.blocks." + Integer.toString(i), ScubaKit.defaultAir);
				}
				i++;
			}
			
			//special fix for hack from 2.1.7
			if(config.contains("scubaValues.blocks.GlassAir")) {
				ScubaKit.blockHatValues[20] = config.getInt("scubaValues.blocks.GlassAir", ScubaKit.defaultAir); 
				config.set("scubaValues.blocks.20", config.getInt("scubaValues.blocks.GlassAir", ScubaKit.defaultAir));
			}
			
		}
		
		//remove old values
		if(config.contains("scubaValues.configVersion")) {
			try {
			config.set("scubaValues.configVersion", null);
			} catch (IllegalArgumentException e) {
				displayWarning = true;
			}
			ScubaKit.log_It("info", "OLD VALUE: scubaValues.configVersion removed"); 
		}
		
		if(config.contains("system.configVersion")) {
			try {
				config.set("system.configVersion", null);
				} catch (IllegalArgumentException e) {
					displayWarning = true;
				}
			ScubaKit.log_It("info", "OLD VALUE: system.configVersion removed"); 
		}
		
		if(config.contains("scubaValues.ignorePermission")) {
			try {
				config.set("scubaValues.ignorePermissions", null);
			} catch (IllegalArgumentException e) {
				displayWarning = true;
			}
			ScubaKit.log_It("info", "OLD VALUE: scubaValues.ignorePermission removed"); 
		}
		
		if(config.contains("scubaValues.complexPermissions")) {
			try{
				config.set("scubaValues.complexPermissions", null);
			} catch (IllegalArgumentException e) {
				displayWarning = true;
			}
			ScubaKit.log_It("info", "OLD VALUE: scubaValues.complexPermissions removed"); 
		}
		
		if(config.contains("system.complexPermissions")) {
			try {
				config.set("system.complexPermissions", null);
			} catch (IllegalArgumentException e) {
				displayWarning = true;
			}
			ScubaKit.log_It("info", "OLD VALUE: system.complexPermissions removed"); 
		}
		
		if(config.contains("scubaValues.blocks.Glass")) {
			try {
				config.set("scubaValues.blocks.Glass", null);
			} catch (IllegalArgumentException e) {
				displayWarning = true;
			}
			ScubaKit.log_It("info", "OLD VALUE: scubaValues.blocks.Glass removed"); 
		}
		
		if(config.contains("scubaValues.blocks.GlassAir")) {
			try {
				config.set("scubaValues.blocks.GlassAir", null);
			} catch (IllegalArgumentException e) {
				displayWarning = true;
			}
			ScubaKit.log_It("info", "OLD VALUE: scubaValues.blocks.GlassAir removed"); 
		}
			
		//check for integrity 
		if (ScubaKit.defaultAir == -1) {
			ScubaKit.log_It("severe", "value key map load failed. This is very bad");
			ScubaKit.log_It("severe", "You probably need to delete your config file");
			return false;
		}
		
		//save
		try {
			config.save(ScubaKit.configFile);
		} catch (IOException e) {
			e.printStackTrace();
			ScubaKit.log_It("warning", "saving error!");
			return false;
		}

		if(displayWarning) {
			ScubaKit.log_It("warning", "got IllegalArgumentException on removing vaules. You probably are using CraftBukkit 1317. This warning will go away on the next RB of CraftBukkit");
		}
		return true;
	}
	
	public static boolean firstRun() {
		FileConfiguration config;
		config = ScubaKit.getThisPlugin().getConfig();
		try {
			config.load(ScubaKit.configFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			ScubaKit.log_It("warning", "Config file not found. This error probably printed twice");
		} catch (IOException e) {
			e.printStackTrace();
			ScubaKit.log_It("warning", "This should really never happen");
		} catch (InvalidConfigurationException e) {
			e.printStackTrace();
			ScubaKit.log_It("warning", "Your config file appears to be damaged. Delete it!");
		}
		config.set("system.firstRun", false);
		try {
			config.save(ScubaKit.configFile);
		} catch (IOException e) {
			e.printStackTrace();
			ScubaKit.log_It("warning", "saving error!");
			return false;
		}
		return true;
	}
	
	
}
