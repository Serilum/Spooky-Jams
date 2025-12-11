package com.natamus.spookyjams.registry.item;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.registry.item.base.JamItem;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class SlimesSquishJamItem extends JamItem {
	public SlimesSquishJamItem(Properties properties) {
		super(properties.food(JamItem.foodProperties).stacksTo(1));
	}

	protected List<Pair<Holder<MobEffect>, Integer>> getConsumeEffects() {
		return List.of(
			Pair.of(MobEffects.JUMP_BOOST, 6000),
			Pair.of(MobEffects.ABSORPTION, 1200),
			Pair.of(MobEffects.SLOW_FALLING, 300),
			Pair.of(MobEffects.SLOWNESS, 160)
		);
	}
}
