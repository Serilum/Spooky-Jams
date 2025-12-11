package com.natamus.spookyjams.registry.item;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.registry.item.base.JamItem;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class GuardiansBrineJamItem extends JamItem {
	public GuardiansBrineJamItem(Properties properties) {
		super(properties.food(JamItem.foodProperties).stacksTo(1));
	}

	protected List<Pair<Holder<MobEffect>, Integer>> getConsumeEffects() {
		return List.of(
			Pair.of(MobEffects.CONDUIT_POWER, 3600),
			Pair.of(MobEffects.DOLPHINS_GRACE, 600),
			Pair.of(MobEffects.NIGHT_VISION, 1200),
			Pair.of(MobEffects.SLOWNESS, 100)
		);
	}
}
