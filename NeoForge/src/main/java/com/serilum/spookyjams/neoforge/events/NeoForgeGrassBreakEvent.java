package com.serilum.spookyjams.neoforge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.serilum.spookyjams.events.GrassBreakEvent;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;

public class NeoForgeGrassBreakEvent {
	@SubscribeEvent
	public static void onBlockBreak(BreakBlockEvent e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}

		GrassBreakEvent.onGrassBreak(level, e.getPlayer(), e.getPos(), e.getState());
	}
}
