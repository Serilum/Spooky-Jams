package com.natamus.spookyjams.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.spookyjams.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0.0, max = 1000.0) public static double jamConsumeEffectsModifier = 1.0;

	public static void initConfig() {
		configMetaData.put("jamConsumeEffectsModifier", Arrays.asList(
			"Can be used to decrease or increase the effects given when a player consumes a Spooky Jam."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}