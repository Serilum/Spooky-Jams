package com.natamus.spookyjams.registry.item;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.registry.item.base.JamItem;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class PhantomsVeilJamItem extends JamItem {
	public PhantomsVeilJamItem(Properties properties) {
		super(properties.food(JamItem.foodProperties).stacksTo(1));
	}

	protected List<Pair<Holder<MobEffect>, Integer>> getConsumeEffects() {
		return List.of(
			Pair.of(MobEffects.SLOW_FALLING, 6000),
			Pair.of(MobEffects.NIGHT_VISION, 6000),
			Pair.of(MobEffects.JUMP_BOOST, 1200),
			Pair.of(MobEffects.INVISIBILITY, 400)
		);
	}
}
