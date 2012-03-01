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
		
		
		if(lang.contains("disable_complete")) {
			Language.disable_complete = lang.getString("disable_complete", "Disable Complete");
		} else {
			lang.set("disable_complete", "Disable Complete"); 
		}


		
		return Language;
	}

}
