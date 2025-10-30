package com.natamus.spookyjams.registry.item;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.registry.item.base.JamItem;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class GlimmeringGloomJamItem extends JamItem {

	public GlimmeringGloomJamItem(Properties properties) {
		super(properties.food(JamItem.foodProperties).stacksTo(1));
	}

	protected List<Pair<Holder<MobEffect>, Integer>> getConsumeEffects() {
		return List.of(
			Pair.of(MobEffects.NIGHT_VISION, 6000),
			Pair.of(MobEffects.WATER_BREATHING, 2400),
			Pair.of(MobEffects.GLOWING, 400),
			Pair.of(MobEffects.MOVEMENT_SLOWDOWN, 200)
		);
	}
}
