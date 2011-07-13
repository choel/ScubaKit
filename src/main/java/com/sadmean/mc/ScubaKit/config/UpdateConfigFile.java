package com.sadmean.mc.ScubaKit.config;

import org.bukkit.util.config.Configuration;

import com.sadmean.mc.ScubaKit.ScubaKit;

public class UpdateConfigFile {
	
	public static boolean update() {
		ScubaKit.log_It("warning", "Config update in progress");
		ScubaKit.log_It("info", "Checking for config version 0");
		if(ScubaKit.configVersion == 0) {
			ScubaKit.log_It("info", "found config version 0");
			if(!update_from_0_to_1()) return false;
		}
		ScubaKit.log_It("info", "Checking for config version 1");
		if(ScubaKit.configVersion == 1) {
			ScubaKit.log_It("info", "found config version 1");
			if(!update_from_1_to_2()) return false;
		}
		return true;
	}

	static boolean update_from_0_to_1() {
		ScubaKit.log_It("info", "Attempting to update from config version 0 to config version 1");
		Configuration configYAML = ScubaKit.getThisPlugin().getConfiguration(); //... load the blank new file 
 		configYAML.setProperty("scubaValues.defaultAir", ScubaKit.defaultAir); 
 		configYAML.setProperty("scubaValues.pumpkinAir", ScubaKit.pumpkinAir); 
 		configYAML.setProperty("scubaValues.diamondAir", ScubaKit.diamondAir);
 		configYAML.setProperty("scubaValues.goldAir", ScubaKit.goldAir);
 		configYAML.setProperty("scubaValues.ironAir", ScubaKit.ironAir);
 		configYAML.setProperty("scubaValues.leatherAir", ScubaKit.leatherAir);
 		configYAML.setProperty("scubaValues.chainAir", ScubaKit.chainAir);
 		configYAML.setProperty("scubaValues.ignorePermissions", ScubaKit.ignorePermissions);
 		configYAML.setProperty("scubaValues.complexPermissions", ScubaKit.complexPermissions);
 		configYAML.setProperty("scubaValues.configVersion", 1);
 		if(!configYAML.save()) { //attempt to save, if fails then
 			ScubaKit.log_It("severe", "Attempted to save config.yml, got saving error!"); //IT FAILED!
 			return false;
 		} else {
 			return true;
 		}
	}
	
	static boolean update_from_1_to_2() {
		ScubaKit.log_It("info", "Attempting to update from config version 1 to config version 2");
		Configuration configYAML = ScubaKit.getThisPlugin().getConfiguration(); 
		configYAML.setProperty("scubaValues.configVersion", 2);
		configYAML.setProperty("system.ignorePermissions", configYAML.getBoolean("scubaValues.ignorePermissions", ScubaKit.ignorePermissions));
 		configYAML.setProperty("system.complexPermissions", configYAML.getBoolean("scubaValues.complexPermissions", ScubaKit.complexPermissions));
 		if(!configYAML.save()) { //attempt to save, if fails then
 			ScubaKit.log_It("severe", "Attempted to save config.yml, got saving error!"); //IT FAILED!
 			return false;
 		} else {
 			return true;
 		}
	}
	
	public static boolean newfile() {
    	Configuration configYAML = ScubaKit.getThisPlugin().getConfiguration(); //... load the blank new file ...
 		configYAML.setProperty("scubaValues.defaultAir", ScubaKit.defaultAir); //..set defaultAir
 		configYAML.setProperty("scubaValues.pumpkinAir", ScubaKit.pumpkinAir); //... then set some values`
 		configYAML.setProperty("scubaValues.diamondAir", ScubaKit.diamondAir);
 		configYAML.setProperty("scubaValues.goldAir", ScubaKit.goldAir);
 		configYAML.setProperty("scubaValues.ironAir", ScubaKit.ironAir);
 		configYAML.setProperty("scubaValues.leatherAir", ScubaKit.leatherAir);
 		configYAML.setProperty("scubaValues.chainAir", ScubaKit.chainAir);
 		configYAML.setProperty("system.ignorePermissions", ScubaKit.ignorePermissions);
 		configYAML.setProperty("system.complexPermissions", ScubaKit.complexPermissions);
 		//set the current config version
 		configYAML.setProperty("system.configVersion", ScubaKit.latestConfigVersion);
 		
 		if(!configYAML.save()) { //attempt to save, if fails then
 			ScubaKit.log_It("severe", "Attempted to save config.yml, got saving error!"); //IT FAILED!
 			return false;
 		} else {
 			return true;
 		}
	}
}
