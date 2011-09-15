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
		
		if(map.containsKey("system.SuperPerms")) {
			ScubaKit.SuperPerms = configYAML.getBoolean("system.SuperPerms", true);
		} else {
			configYAML.setProperty("system.SuperPerms", ScubaKit.SuperPerms); 
		}
		//complex permissions
		/** NO LONGER USED
		if(map.containsKey("system.complexPermissions")) {
			ScubaKit.complexPermissions = configYAML.getBoolean("system.complexPermissions", false);
		} else {
			configYAML.setProperty("system.complexPermissions", configYAML.getBoolean("scubaValues.complexPermissions", ScubaKit.complexPermissions)); 
		}
		**/		
		//version 0 values done
		if(map.containsKey("system.airOverridesIfHigher")) {
			ScubaKit.airOverridesIfHigher = configYAML.getBoolean("system.airOverridesIfHigher", false);
		} else {
			configYAML.setProperty("system.airOverridesIfHigher", ScubaKit.airOverridesIfHigher); 
		}
		
		if(map.containsKey("system.debugLogs")) {
			ScubaKit.debugLogs = configYAML.getBoolean("system.debugLogs", false);
		} else {
			configYAML.setProperty("system.debugLogs", ScubaKit.debugLogs); 
		}
		
		if(map.containsKey("system.firstRun")) {
			ScubaKit.firstRun = configYAML.getBoolean("system.firstRun", true);
		} else {
			configYAML.setProperty("system.firstRun", ScubaKit.firstRun); 
		}
				
		//blockhat integration
		if(map.containsKey("system.blockHatInstalled")) {
			ScubaKit.blockHatInstalled = configYAML.getBoolean("system.blockHatInstalled", false);
		} else {
			configYAML.setProperty("system.blockHatInstalled", ScubaKit.blockHatInstalled); 
		}
		
		if(ScubaKit.blockHatInstalled) {
			ScubaKit.log_It("info", "blockHatInstalled is true, checking and expanding config");
			ScubaKit.log_It("info", "Max TypeID is " + Integer.toString(ScubaKit.maxBlockHatValue));
			//block hat settings start
			int i = 1;
			while (i <= ScubaKit.maxBlockHatValue) {
				if(map.containsKey("scubaValues.blocks." + Integer.toString(i))) {
					ScubaKit.blockHatValues[i] = configYAML.getInt("scubaValues.blocks." + Integer.toString(i), ScubaKit.defaultAir);
				} else {
					configYAML.setProperty("scubaValues.blocks." + Integer.toString(i), ScubaKit.defaultAir);
					ScubaKit.blockHatValues[i] = configYAML.getInt("scubaValues.blocks." + Integer.toString(i), ScubaKit.defaultAir);
				}
				i++;
			}
			
			//special fix for hack from 2.1.7
			if(map.containsKey("scubaValues.blocks.GlassAir")) {
				ScubaKit.blockHatValues[20] = configYAML.getInt("scubaValues.blocks.GlassAir", ScubaKit.defaultAir); 
				configYAML.setProperty("scubaValues.blocks.20", configYAML.getInt("scubaValues.blocks.GlassAir", ScubaKit.defaultAir));
				configYAML.removeProperty("scubaValues.blocks.GlassAir");
			}
			
		}
		
		//remove old values
		if(map.containsKey("scubaValues.configVersion")) {
			configYAML.removeProperty("scubaValues.configVersion");
			ScubaKit.log_It("info", "OLD VALUE: scubaValues.configVersion removed"); 
		}
		
		if(map.containsKey("system.configVersion")) {
			configYAML.removeProperty("system.configVersion");
			ScubaKit.log_It("info", "OLD VALUE: system.configVersion removed"); 
		}
		
		if(map.containsKey("scubaValues.ignorePermission")) {
			configYAML.removeProperty("scubaValues.ignorePermissions");
			ScubaKit.log_It("info", "OLD VALUE: scubaValues.ignorePermission removed"); 
		}
		
		if(map.containsKey("scubaValues.complexPermissions")) {
			configYAML.removeProperty("scubaValues.complexPermissions");
			ScubaKit.log_It("info", "OLD VALUE: scubaValues.complexPermissions removed"); 
		}
		
		if(map.containsKey("system.complexPermissions")) {
			configYAML.removeProperty("system.complexPermissions");
			ScubaKit.log_It("info", "OLD VALUE: system.complexPermissions removed"); 
		}
		
		if(map.containsKey("scubaValues.blocks.Glass")) {
			configYAML.removeProperty("scubaValues.blocks.Glass");
			ScubaKit.log_It("info", "OLD VALUE: scubaValues.blocks.Glass removed"); 
		}
						
		//check for integrity 
		if (ScubaKit.defaultAir == -1) {
			ScubaKit.log_It("severe", "value key map load failed. This is very bad");
			ScubaKit.log_It("severe", "You probably need to delete your config file");
			return false;
		}
		
		if(!configYAML.save()) {
			ScubaKit.log_It("severe", "Saving error, this should never happen");
			return false;
		}
		return true;
	}
	
	public static boolean firstRun() {
		Configuration configYAML = ScubaKit.getThisPlugin().getConfiguration();
		configYAML.load();
		configYAML.setProperty("system.firstRun", false);
		if(configYAML.save()) {
			return true;
		} else {
			ScubaKit.log_It("severe", "Saving error, this should never happen");
			return false;
		}
	}
	
	
}
