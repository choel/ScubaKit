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
			//block hat settings start
			
			if(map.containsKey("scubaValues.blocks.1")) {
				ScubaKit.block1Air = configYAML.getInt("scubaValues.blocks.1", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.1", ScubaKit.block1Air); 
			}
			
			if(map.containsKey("scubaValues.blocks.2")) {
				ScubaKit.block2Air = configYAML.getInt("scubaValues.blocks.2", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.2", ScubaKit.block2Air); 
			}

			if(map.containsKey("scubaValues.blocks.3")) {
				ScubaKit.block3Air = configYAML.getInt("scubaValues.blocks.3", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.3", ScubaKit.block3Air); 
			}

			if(map.containsKey("scubaValues.blocks.4")) {
				ScubaKit.block4Air = configYAML.getInt("scubaValues.blocks.4", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.4", ScubaKit.block4Air); 
			}

			if(map.containsKey("scubaValues.blocks.5")) {
				ScubaKit.block5Air = configYAML.getInt("scubaValues.blocks.5", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.5", ScubaKit.block5Air); 
			}

			if(map.containsKey("scubaValues.blocks.6")) {
				ScubaKit.block6Air = configYAML.getInt("scubaValues.blocks.6", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.6", ScubaKit.block6Air); 
			}

			if(map.containsKey("scubaValues.blocks.7")) {
				ScubaKit.block7Air = configYAML.getInt("scubaValues.blocks.7", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.7", ScubaKit.block7Air); 
			}

			if(map.containsKey("scubaValues.blocks.8")) {
				ScubaKit.block8Air = configYAML.getInt("scubaValues.blocks.8", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.8", ScubaKit.block8Air); 
			}

			if(map.containsKey("scubaValues.blocks.9")) {
				ScubaKit.block9Air = configYAML.getInt("scubaValues.blocks.9", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.9", ScubaKit.block9Air); 
			}

			if(map.containsKey("scubaValues.blocks.10")) {
				ScubaKit.block10Air = configYAML.getInt("scubaValues.blocks.10", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.10", ScubaKit.block10Air); 
			}

			if(map.containsKey("scubaValues.blocks.11")) {
				ScubaKit.block11Air = configYAML.getInt("scubaValues.blocks.11", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.11", ScubaKit.block11Air); 
			}

			if(map.containsKey("scubaValues.blocks.12")) {
				ScubaKit.block12Air = configYAML.getInt("scubaValues.blocks.12", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.12", ScubaKit.block12Air); 
			}

			if(map.containsKey("scubaValues.blocks.13")) {
				ScubaKit.block13Air = configYAML.getInt("scubaValues.blocks.13", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.13", ScubaKit.block13Air); 
			}

			if(map.containsKey("scubaValues.blocks.14")) {
				ScubaKit.block14Air = configYAML.getInt("scubaValues.blocks.14", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.14", ScubaKit.block14Air); 
			}

			if(map.containsKey("scubaValues.blocks.15")) {
				ScubaKit.block15Air = configYAML.getInt("scubaValues.blocks.15", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.15", ScubaKit.block15Air); 
			}

			if(map.containsKey("scubaValues.blocks.16")) {
				ScubaKit.block16Air = configYAML.getInt("scubaValues.blocks.16", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.16", ScubaKit.block16Air); 
			}

			if(map.containsKey("scubaValues.blocks.17")) {
				ScubaKit.block17Air = configYAML.getInt("scubaValues.blocks.17", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.17", ScubaKit.block17Air); 
			}

			if(map.containsKey("scubaValues.blocks.18")) {
				ScubaKit.block18Air = configYAML.getInt("scubaValues.blocks.18", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.18", ScubaKit.block18Air); 
			}

			if(map.containsKey("scubaValues.blocks.19")) {
				ScubaKit.block19Air = configYAML.getInt("scubaValues.blocks.19", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.19", ScubaKit.block19Air); 
			}

			if(map.containsKey("scubaValues.blocks.20")) {
				ScubaKit.block20Air = configYAML.getInt("scubaValues.blocks.20", configYAML.getInt("scubaValues.blocks.GlassAir", ScubaKit.defaultAir)); //special fix for hack from 2.1.7
			} else {
				configYAML.setProperty("scubaValues.blocks.20", ScubaKit.block20Air); 
			}

			if(map.containsKey("scubaValues.blocks.21")) {
				ScubaKit.block21Air = configYAML.getInt("scubaValues.blocks.21", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.21", ScubaKit.block21Air); 
			}

			if(map.containsKey("scubaValues.blocks.22")) {
				ScubaKit.block20Air = configYAML.getInt("scubaValues.blocks.22", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.22", ScubaKit.block22Air); 
			}

			if(map.containsKey("scubaValues.blocks.23")) {
				ScubaKit.block23Air = configYAML.getInt("scubaValues.blocks.23", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.23", ScubaKit.block23Air); 
			}

			if(map.containsKey("scubaValues.blocks.24")) {
				ScubaKit.block24Air = configYAML.getInt("scubaValues.blocks.24", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.24", ScubaKit.block24Air); 
			}

			if(map.containsKey("scubaValues.blocks.25")) {
				ScubaKit.block25Air = configYAML.getInt("scubaValues.blocks.25", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.25", ScubaKit.block25Air); 
			}

			if(map.containsKey("scubaValues.blocks.26")) {
				ScubaKit.block26Air = configYAML.getInt("scubaValues.blocks.26", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.26", ScubaKit.block26Air); 
			}

			if(map.containsKey("scubaValues.blocks.27")) {
				ScubaKit.block27Air = configYAML.getInt("scubaValues.blocks.27", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.27", ScubaKit.block27Air); 
			}

			if(map.containsKey("scubaValues.blocks.28")) {
				ScubaKit.block28Air = configYAML.getInt("scubaValues.blocks.28", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.28", ScubaKit.block28Air); 
			}

			if(map.containsKey("scubaValues.blocks.29")) {
				ScubaKit.block29Air = configYAML.getInt("scubaValues.blocks.29", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.29", ScubaKit.block29Air); 
			}

			if(map.containsKey("scubaValues.blocks.30")) {
				ScubaKit.block30Air = configYAML.getInt("scubaValues.blocks.30", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.30", ScubaKit.block30Air); 
			}

			if(map.containsKey("scubaValues.blocks.31")) {
				ScubaKit.block31Air = configYAML.getInt("scubaValues.blocks.31", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.31", ScubaKit.block31Air); 
			}

			if(map.containsKey("scubaValues.blocks.32")) {
				ScubaKit.block32Air = configYAML.getInt("scubaValues.blocks.32", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.32", ScubaKit.block32Air); 
			}

			if(map.containsKey("scubaValues.blocks.33")) {
				ScubaKit.block33Air = configYAML.getInt("scubaValues.blocks.33", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.33", ScubaKit.block33Air); 
			}

			if(map.containsKey("scubaValues.blocks.34")) {
				ScubaKit.block34Air = configYAML.getInt("scubaValues.blocks.34", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.34", ScubaKit.block34Air); 
			}

			if(map.containsKey("scubaValues.blocks.35")) {
				ScubaKit.block35Air = configYAML.getInt("scubaValues.blocks.35", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.35", ScubaKit.block35Air); 
			}

			if(map.containsKey("scubaValues.blocks.36")) {
				ScubaKit.block36Air = configYAML.getInt("scubaValues.blocks.36", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.36", ScubaKit.block36Air); 
			}

			if(map.containsKey("scubaValues.blocks.37")) {
				ScubaKit.block37Air = configYAML.getInt("scubaValues.blocks.37", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.37", ScubaKit.block37Air); 
			}

			if(map.containsKey("scubaValues.blocks.38")) {
				ScubaKit.block38Air = configYAML.getInt("scubaValues.blocks.38", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.38", ScubaKit.block38Air); 
			}

			if(map.containsKey("scubaValues.blocks.39")) {
				ScubaKit.block39Air = configYAML.getInt("scubaValues.blocks.39", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.39", ScubaKit.block39Air); 
			}

			if(map.containsKey("scubaValues.blocks.40")) {
				ScubaKit.block40Air = configYAML.getInt("scubaValues.blocks.40", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.40", ScubaKit.block40Air); 
			}

			if(map.containsKey("scubaValues.blocks.41")) {
				ScubaKit.block41Air = configYAML.getInt("scubaValues.blocks.41", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.41", ScubaKit.block41Air); 
			}

			if(map.containsKey("scubaValues.blocks.42")) {
				ScubaKit.block42Air = configYAML.getInt("scubaValues.blocks.42", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.42", ScubaKit.block42Air); 
			}

			if(map.containsKey("scubaValues.blocks.43")) {
				ScubaKit.block43Air = configYAML.getInt("scubaValues.blocks.43", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.43", ScubaKit.block43Air); 
			}

			if(map.containsKey("scubaValues.blocks.44")) {
				ScubaKit.block44Air = configYAML.getInt("scubaValues.blocks.44", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.44", ScubaKit.block44Air); 
			}

			if(map.containsKey("scubaValues.blocks.45")) {
				ScubaKit.block45Air = configYAML.getInt("scubaValues.blocks.45", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.45", ScubaKit.block45Air); 
			}

			if(map.containsKey("scubaValues.blocks.46")) {
				ScubaKit.block46Air = configYAML.getInt("scubaValues.blocks.46", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.46", ScubaKit.block46Air); 
			}

			if(map.containsKey("scubaValues.blocks.47")) {
				ScubaKit.block47Air = configYAML.getInt("scubaValues.blocks.47", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.47", ScubaKit.block47Air); 
			}

			if(map.containsKey("scubaValues.blocks.48")) {
				ScubaKit.block48Air = configYAML.getInt("scubaValues.blocks.48", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.48", ScubaKit.block48Air); 
			}

			if(map.containsKey("scubaValues.blocks.49")) {
				ScubaKit.block49Air = configYAML.getInt("scubaValues.blocks.49", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.49", ScubaKit.block49Air); 
			}

			if(map.containsKey("scubaValues.blocks.50")) {
				ScubaKit.block50Air = configYAML.getInt("scubaValues.blocks.50", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.50", ScubaKit.block50Air); 
			}

			if(map.containsKey("scubaValues.blocks.51")) {
				ScubaKit.block51Air = configYAML.getInt("scubaValues.blocks.51", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.51", ScubaKit.block51Air); 
			}

			if(map.containsKey("scubaValues.blocks.52")) {
				ScubaKit.block52Air = configYAML.getInt("scubaValues.blocks.52", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.52", ScubaKit.block52Air); 
			}

			if(map.containsKey("scubaValues.blocks.52")) {
				ScubaKit.block52Air = configYAML.getInt("scubaValues.blocks.52", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.52", ScubaKit.block52Air); 
			}

			if(map.containsKey("scubaValues.blocks.53")) {
				ScubaKit.block53Air = configYAML.getInt("scubaValues.blocks.53", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.53", ScubaKit.block53Air); 
			}

			if(map.containsKey("scubaValues.blocks.54")) {
				ScubaKit.block54Air = configYAML.getInt("scubaValues.blocks.54", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.54", ScubaKit.block54Air); 
			}

			if(map.containsKey("scubaValues.blocks.55")) {
				ScubaKit.block55Air = configYAML.getInt("scubaValues.blocks.55", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.55", ScubaKit.block55Air); 
			}

			if(map.containsKey("scubaValues.blocks.56")) {
				ScubaKit.block56Air = configYAML.getInt("scubaValues.blocks.56", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.56", ScubaKit.block56Air); 
			}

			if(map.containsKey("scubaValues.blocks.57")) {
				ScubaKit.block57Air = configYAML.getInt("scubaValues.blocks.57", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.57", ScubaKit.block57Air); 
			}

			if(map.containsKey("scubaValues.blocks.58")) {
				ScubaKit.block58Air = configYAML.getInt("scubaValues.blocks.58", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.58", ScubaKit.block58Air); 
			}

			if(map.containsKey("scubaValues.blocks.59")) {
				ScubaKit.block59Air = configYAML.getInt("scubaValues.blocks.59", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.59", ScubaKit.block59Air); 
			}

			if(map.containsKey("scubaValues.blocks.60")) {
				ScubaKit.block60Air = configYAML.getInt("scubaValues.blocks.60", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.60", ScubaKit.block60Air); 
			}

			if(map.containsKey("scubaValues.blocks.61")) {
				ScubaKit.block61Air = configYAML.getInt("scubaValues.blocks.61", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.61", ScubaKit.block61Air); 
			}

			if(map.containsKey("scubaValues.blocks.62")) {
				ScubaKit.block62Air = configYAML.getInt("scubaValues.blocks.62", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.62", ScubaKit.block62Air); 
			}

			if(map.containsKey("scubaValues.blocks.63")) {
				ScubaKit.block63Air = configYAML.getInt("scubaValues.blocks.63", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.63", ScubaKit.block63Air); 
			}

			if(map.containsKey("scubaValues.blocks.64")) {
				ScubaKit.block64Air = configYAML.getInt("scubaValues.blocks.64", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.64", ScubaKit.block64Air); 
			}

			if(map.containsKey("scubaValues.blocks.65")) {
				ScubaKit.block65Air = configYAML.getInt("scubaValues.blocks.65", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.65", ScubaKit.block65Air); 
			}

			if(map.containsKey("scubaValues.blocks.66")) {
				ScubaKit.block66Air = configYAML.getInt("scubaValues.blocks.66", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.66", ScubaKit.block66Air); 
			}

			if(map.containsKey("scubaValues.blocks.67")) {
				ScubaKit.block67Air = configYAML.getInt("scubaValues.blocks.67", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.67", ScubaKit.block67Air); 
			}

			if(map.containsKey("scubaValues.blocks.68")) {
				ScubaKit.block68Air = configYAML.getInt("scubaValues.blocks.68", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.68", ScubaKit.block68Air); 
			}

			if(map.containsKey("scubaValues.blocks.69")) {
				ScubaKit.block69Air = configYAML.getInt("scubaValues.blocks.69", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.69", ScubaKit.block69Air); 
			}

			if(map.containsKey("scubaValues.blocks.70")) {
				ScubaKit.block70Air = configYAML.getInt("scubaValues.blocks.70", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.70", ScubaKit.block70Air); 
			}

			if(map.containsKey("scubaValues.blocks.71")) {
				ScubaKit.block71Air = configYAML.getInt("scubaValues.blocks.71", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.71", ScubaKit.block71Air); 
			}

			if(map.containsKey("scubaValues.blocks.72")) {
				ScubaKit.block72Air = configYAML.getInt("scubaValues.blocks.72", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.72", ScubaKit.block72Air); 
			}

			if(map.containsKey("scubaValues.blocks.73")) {
				ScubaKit.block73Air = configYAML.getInt("scubaValues.blocks.73", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.73", ScubaKit.block73Air); 
			}

			if(map.containsKey("scubaValues.blocks.74")) {
				ScubaKit.block74Air = configYAML.getInt("scubaValues.blocks.74", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.74", ScubaKit.block74Air); 
			}

			if(map.containsKey("scubaValues.blocks.75")) {
				ScubaKit.block75Air = configYAML.getInt("scubaValues.blocks.75", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.75", ScubaKit.block75Air); 
			}

			if(map.containsKey("scubaValues.blocks.76")) {
				ScubaKit.block76Air = configYAML.getInt("scubaValues.blocks.76", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.76", ScubaKit.block76Air); 
			}

			if(map.containsKey("scubaValues.blocks.77")) {
				ScubaKit.block77Air = configYAML.getInt("scubaValues.blocks.77", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.77", ScubaKit.block77Air); 
			}

			if(map.containsKey("scubaValues.blocks.78")) {
				ScubaKit.block78Air = configYAML.getInt("scubaValues.blocks.78", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.78", ScubaKit.block78Air); 
			}

			if(map.containsKey("scubaValues.blocks.79")) {
				ScubaKit.block79Air = configYAML.getInt("scubaValues.blocks.79", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.79", ScubaKit.block79Air); 
			}

			if(map.containsKey("scubaValues.blocks.80")) {
				ScubaKit.block80Air = configYAML.getInt("scubaValues.blocks.80", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.80", ScubaKit.block80Air); 
			}

			if(map.containsKey("scubaValues.blocks.81")) {
				ScubaKit.block81Air = configYAML.getInt("scubaValues.blocks.81", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.81", ScubaKit.block81Air); 
			}

			if(map.containsKey("scubaValues.blocks.82")) {
				ScubaKit.block82Air = configYAML.getInt("scubaValues.blocks.82", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.82", ScubaKit.block82Air); 
			}

			if(map.containsKey("scubaValues.blocks.83")) {
				ScubaKit.block83Air = configYAML.getInt("scubaValues.blocks.83", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.83", ScubaKit.block83Air); 
			}

			if(map.containsKey("scubaValues.blocks.84")) {
				ScubaKit.block84Air = configYAML.getInt("scubaValues.blocks.84", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.84", ScubaKit.block84Air); 
			}

			if(map.containsKey("scubaValues.blocks.85")) {
				ScubaKit.block85Air = configYAML.getInt("scubaValues.blocks.85", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.85", ScubaKit.block85Air); 
			}

			if(map.containsKey("scubaValues.blocks.86")) {
				ScubaKit.block86Air = configYAML.getInt("scubaValues.blocks.86", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.86", ScubaKit.block86Air); 
			}

			if(map.containsKey("scubaValues.blocks.87")) {
				ScubaKit.block87Air = configYAML.getInt("scubaValues.blocks.87", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.87", ScubaKit.block87Air); 
			}

			if(map.containsKey("scubaValues.blocks.88")) {
				ScubaKit.block88Air = configYAML.getInt("scubaValues.blocks.88", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.88", ScubaKit.block88Air); 
			}

			if(map.containsKey("scubaValues.blocks.89")) {
				ScubaKit.block89Air = configYAML.getInt("scubaValues.blocks.89", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.89", ScubaKit.block89Air); 
			}

			if(map.containsKey("scubaValues.blocks.90")) {
				ScubaKit.block90Air = configYAML.getInt("scubaValues.blocks.90", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.90", ScubaKit.block90Air); 
			}

			if(map.containsKey("scubaValues.blocks.91")) {
				ScubaKit.block91Air = configYAML.getInt("scubaValues.blocks.91", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.91", ScubaKit.block91Air); 
			}

			if(map.containsKey("scubaValues.blocks.92")) {
				ScubaKit.block92Air = configYAML.getInt("scubaValues.blocks.92", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.92", ScubaKit.block92Air); 
			}

			if(map.containsKey("scubaValues.blocks.93")) {
				ScubaKit.block93Air = configYAML.getInt("scubaValues.blocks.93", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.93", ScubaKit.block93Air); 
			}

			if(map.containsKey("scubaValues.blocks.94")) {
				ScubaKit.block94Air = configYAML.getInt("scubaValues.blocks.94", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.94", ScubaKit.block94Air); 
			}

			if(map.containsKey("scubaValues.blocks.95")) {
				ScubaKit.block95Air = configYAML.getInt("scubaValues.blocks.95", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.95", ScubaKit.block95Air); 
			}

			if(map.containsKey("scubaValues.blocks.96")) {
				ScubaKit.block96Air = configYAML.getInt("scubaValues.blocks.96", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.96", ScubaKit.block96Air); 
			}

			if(map.containsKey("scubaValues.blocks.97")) {
				ScubaKit.block97Air = configYAML.getInt("scubaValues.blocks.97", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.97", ScubaKit.block97Air); 
			}

			if(map.containsKey("scubaValues.blocks.98")) {
				ScubaKit.block98Air = configYAML.getInt("scubaValues.blocks.98", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.98", ScubaKit.block98Air); 
			}

			if(map.containsKey("scubaValues.blocks.99")) {
				ScubaKit.block99Air = configYAML.getInt("scubaValues.blocks.99", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.99", ScubaKit.block99Air); 
			}

			if(map.containsKey("scubaValues.blocks.100")) {
				ScubaKit.block100Air = configYAML.getInt("scubaValues.blocks.100", ScubaKit.defaultAir);
			} else {
				configYAML.setProperty("scubaValues.blocks.100", ScubaKit.block100Air); 
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
