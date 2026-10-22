package com.serilum.spookyjams.config;

import com.natamus.collective.config.DuskConfig;
import com.serilum.spookyjams.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0.0, max = 1000.0) public static double jamConsumeEffectsModifier = 1.0;
	@Entry(min = 0.0, max = 1.0) public static double spookyYamSeedsDropChance = 0.05;
	@Entry public static boolean spookyYamSeedsOnlyDropInOctober = false;

	public static void initConfig() {
		configMetaData.put("jamConsumeEffectsModifier", Arrays.asList(
			"Can be used to decrease or increase the effects given when a player consumes a Spooky Jam."
		));
		configMetaData.put("spookyYamSeedsDropChance", Arrays.asList(
			"The chance a player gets Spooky Yam Seeds when breaking short grass, tall grass or a fern without shears. Set to 0 to disable."
		));
		configMetaData.put("spookyYamSeedsOnlyDropInOctober", Arrays.asList(
			"Whether Spooky Yam Seeds should only drop from grass and ferns during October, based on the real-world date."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}