package com.natamus.spookyjams.registry.item;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.registry.item.base.JamItem;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class SpookyYamJamItem extends JamItem {
	public SpookyYamJamItem(Properties properties) {
		super(properties.food(JamItem.foodProperties).stacksTo(1));
	}

	protected List<Pair<Holder<MobEffect>, Integer>> getConsumeEffects() {
		return List.of(
			Pair.of(MobEffects.HEALTH_BOOST, 2400),
			Pair.of(MobEffects.REGENERATION, 600),
			Pair.of(MobEffects.DAMAGE_RESISTANCE, 600),
			Pair.of(MobEffects.GLOWING, 120)
		);
	}
}
