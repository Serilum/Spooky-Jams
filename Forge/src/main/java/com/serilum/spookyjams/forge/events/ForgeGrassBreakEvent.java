package com.serilum.spookyjams.forge.events;

import com.natamus.collective.functions.WorldFunctions;
import com.serilum.spookyjams.events.GrassBreakEvent;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

public class ForgeGrassBreakEvent {
	public static void registerEventsInBus() {
		BlockEvent.BreakEvent.BUS.addListener(ForgeGrassBreakEvent::onBlockBreak);
	}

	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent e) {
		Level level = WorldFunctions.getWorldIfInstanceOfAndNotRemote(e.getLevel());
		if (level == null) {
			return;
		}

		GrassBreakEvent.onGrassBreak(level, e.getPlayer(), e.getPos(), e.getState());
	}
}
