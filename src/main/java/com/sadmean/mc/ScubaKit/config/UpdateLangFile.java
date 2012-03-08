package com.sadmean.mc.ScubaKit.config;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import com.sadmean.mc.ScubaKit.ScubaKit;

public class UpdateLangFile {

	public static ScubaLang load() {

		FileConfiguration lang;
		lang = ScubaKit.getThisPlugin().getConfig();
		try {
			lang.load(ScubaKit.langFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ScubaLang Language = new ScubaLang();
		
		
		if(lang.contains("sys.disable_complete")) {
			Language.sys_disable_complete = lang.getString("sys.disable_complete", "Disable Complete");
		} else {
			lang.set("sys.disable_complete", "Disable Complete");
			Language.sys_disable_complete = "Disable Complete";
		}
		
		if(lang.contains("sys.no_config_exists")) {
			Language.sys_no_config_exists = lang.getString("sys.no_config_exists", "No config File Exists. Creating one...");
		} else {
			lang.set("sys.no_config_exists", "No config File Exists. Creating one...");
			Language.sys_no_config_exists = "No config File Exists. Creating one...";
		}

		if(lang.contains("sys.no_permission")) {
			Language.sys_no_permission = lang.getString("sys.no_permission", "No Permissions system detected.");
		} else {
			lang.set("sys.no_permissione", "No Permissions system detected.");
			Language.sys_no_permission = "No Permissions system detected.";
		}
		
		if(lang.contains("sys.super_perms_active")) {
			Language.sys_super_perms_active = lang.getString("sys.super_perms_active", "Super Permissions Active");
		} else {
			lang.set("sys.super_perms_active", "Super Permissions Active");
			Language.sys_super_perms_active = "Super Permissions Active";
		}
		
		if(lang.contains("load.error_config404")) {
			Language.load_error_config404 = lang.getString("load.error_config404", "Config file not found");
		} else {
			lang.set("load.error_config404", "Config file not found");
			Language.load_error_config404 = "Config file not found";
		}
		
		if(lang.contains("load.error_IOexception")) {
			Language.load_error_IOexception = lang.getString("load.error_IOexception", "This should really never happen");
		} else {
			lang.set("load.error_IOexception", "This should really never happen"); 
			Language.load_error_IOexception = "This should really never happen";
		}

		if(lang.contains("load.error_invalid_config_file")) {
			Language.load_error_invalidConfig = lang.getString("load.error_invalid_config_file", "Your config file is invalid");
		} else {
			lang.set("load.error_invalid_config_file", "Your config file is invalid"); 
			Language.load_error_invalidConfig = "Your config file is invalid";
		}
		//done with loading errors
		
		//first run stuff
		if(lang.contains("first_run.1")) {
			Language.first_run_1 = lang.getString("first_run.1", "Thanks for using ScubaKit!");
		} else {
			lang.set("first_run.1", "Thanks for using ScubaKit!"); 
			Language.first_run_1 = "Thanks for using ScubaKit!";
		}
		
		if(lang.contains("reminder")) {
			Language.reminder = lang.getString("reminder", "Remeber to change ScubaKit.ScubaGear to ScubaKit.ScubaGear.* in your permissions!");
		} else {
			lang.set("reminder", "Remeber to change ScubaKit.ScubaGear to ScubaKit.ScubaGear.* in your permissions!"); 
			Language.reminder = "Remeber to change ScubaKit.ScubaGear to ScubaKit.ScubaGear.* in your permissions!";
		}
		
		if(lang.contains("error.all_values_0")) {
			Language.all_values_0 = lang.getString("error.all_values_0", "All values returned as 0. Possible loading error.");
		} else {
			lang.set("error.all_values_0", "All values returned as 0. Possible loading error."); 
			Language.all_values_0 = "All values returned as 0. Possible loading error.";
		}
		
		//done
		try {
			lang.save(ScubaKit.langFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Language;
	}

}
