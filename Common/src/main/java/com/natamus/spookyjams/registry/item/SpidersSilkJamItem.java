package com.natamus.spookyjams.registry.item;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.registry.item.base.JamItem;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class SpidersSilkJamItem extends JamItem {
	public SpidersSilkJamItem(Properties properties) {
		super(properties.food(JamItem.foodProperties).stacksTo(1));
	}

	protected List<Pair<Holder<MobEffect>, Integer>> getConsumeEffects() {
		return List.of(
			Pair.of(MobEffects.SPEED, 2400),
			Pair.of(MobEffects.JUMP_BOOST, 1800),
			Pair.of(MobEffects.SLOW_FALLING, 400),
			Pair.of(MobEffects.POISON, 80)
		);
	}
}
