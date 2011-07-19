package com.sadmean.mc.ScubaKit.config;

import java.util.Map;

import org.bukkit.util.config.Configuration;

import com.sadmean.mc.ScubaKit.ScubaKit;

public class UpdateConfigFile {
		
	public static boolean load() {
		Configuration configYAML = ScubaKit.getThisPlugin().getConfiguration();
		configYAML.load();
		Map<String, Object> map = configYAML.getAll();
		
		//check for defaultAir, if exists. If exists, load it into plugin. Else, set from default values.
		if(map.containsKey("scubaValues.defaultAir")) {
			ScubaKit.defaultAir = configYAML.getInt("scubaValues.defaultAir", 0);
		} else {
			configYAML.setProperty("scubaValues.defaultAir", ScubaKit.defaultAir); 
		}
		
		//now for pumpkin air
		if(map.containsKey("scubaValues.pumpkinAir")) {
			ScubaKit.pumpkinAir = configYAML.getInt("scubaValues.pumpkinAir", 0);
		} else {
			configYAML.setProperty("scubaValues.pumpkinAir", ScubaKit.pumpkinAir); 
		}
		
		//next we check diamondAir
		if(map.containsKey("scubaValues.diamondAir")) {
			ScubaKit.diamondAir = configYAML.getInt("scubaValues.diamondAir", 0);
		} else {
			configYAML.setProperty("scubaValues.diamondAir", ScubaKit.diamondAir); 
		}
		
		//goldAir
		if(map.containsKey("scubaValues.goldAir")) {
			ScubaKit.goldAir = configYAML.getInt("scubaValues.goldAir", 0);
		} else {
			configYAML.setProperty("scubaValues.goldAir", ScubaKit.goldAir); 
		}
		
		//ironAir
		if(map.containsKey("scubaValues.ironAir")) {
			ScubaKit.ironAir = configYAML.getInt("scubaValues.ironAir", 0);
		} else {
			configYAML.setProperty("scubaValues.ironAir", ScubaKit.ironAir); 
		}
		
		//leatherAir
		if(map.containsKey("scubaValues.leatherAir")) {
			ScubaKit.leatherAir = configYAML.getInt("scubaValues.leatherAir", 0);
		} else {
			configYAML.setProperty("scubaValues.leatherAir", ScubaKit.leatherAir); 
		}
		
		//chainAir
		if(map.containsKey("scubaValues.chainAir")) {
			ScubaKit.chainAir = configYAML.getInt("scubaValues.chainAir", 0);
		} else {
			configYAML.setProperty("scubaValues.chainAir", ScubaKit.chainAir); 
		}
		
		//ignorePermissions
		if(map.containsKey("system.ignorePermissions")) {
			ScubaKit.ignorePermissions = configYAML.getBoolean("system.ignorePermissions", true);
		} else {
			configYAML.setProperty("system.ignorePermissions", configYAML.getBoolean("scubaValues.ignorePermissions", ScubaKit.ignorePermissions)); 
		}
		
		//complex permissions
		if(map.containsKey("system.complexPermissions")) {
			ScubaKit.complexPermissions = configYAML.getBoolean("system.complexPermissions", false);
		} else {
			configYAML.setProperty("system.complexPermissions", configYAML.getBoolean("scubaValues.complexPermissions", ScubaKit.complexPermissions)); 
		}
		
		//version 0 values done
		if(map.containsKey("system.airOverridesIfHigher")) {
			ScubaKit.airOverridesIfHigher = configYAML.getBoolean("system.airOverridesIfHigher", false);
		} else {
			configYAML.setProperty("system.airOverridesIfHigher", ScubaKit.airOverridesIfHigher); 
		}
		
		
		//remove old values
		configYAML.removeProperty("scubaValues.configVersion");
		configYAML.removeProperty("system.configVersion");
		configYAML.removeProperty("scubaValues.ignorePermissions");
		configYAML.removeProperty("scubaValues.complexPermissions");
		//check for integrity 
		if (ScubaKit.defaultAir == -1) {
			ScubaKit.log_It("severe", "value key map load failed. This is very bad");
			return false;
		}
		
		if(!configYAML.save()) {
			ScubaKit.log_It("severe", "Saving error, this should never happen");
		}
		return true;
	}
	
	
}
