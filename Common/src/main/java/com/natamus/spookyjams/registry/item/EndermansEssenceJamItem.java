package com.natamus.spookyjams.registry.item;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.registry.item.base.JamItem;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class EndermansEssenceJamItem extends JamItem {
	public EndermansEssenceJamItem(Properties properties) {
		super(properties.food(JamItem.foodProperties).stacksTo(1));
	}

	protected List<Pair<Holder<MobEffect>, Integer>> getConsumeEffects() {
		return List.of(
			Pair.of(MobEffects.INVISIBILITY, 2400),
			Pair.of(MobEffects.NIGHT_VISION, 2400),
			Pair.of(MobEffects.SLOW_FALLING, 600),
			Pair.of(MobEffects.SPEED, 1200)
		);
	}
}
