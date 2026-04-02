package com.natamus.spookyjams;

import com.natamus.collective.check.ShouldLoadCheck;
import com.natamus.spookyjams.util.Reference;
import net.fabricmc.api.ClientModInitializer;

public class ModFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() { 
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		registerEvents();
		ModCommon.setBlockRender();
	}
	
	private void registerEvents() {

	}
}
