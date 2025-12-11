package com.natamus.spookyjams.registry.item;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.registry.item.base.JamItem;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class WitchsHexJamItem extends JamItem {
	public WitchsHexJamItem(Properties properties) {
		super(properties.food(JamItem.foodProperties).stacksTo(1));
	}

	protected List<Pair<Holder<MobEffect>, Integer>> getConsumeEffects() {
		return List.of(
			Pair.of(MobEffects.LUCK, 3600),
			Pair.of(MobEffects.REGENERATION, 400),
			Pair.of(MobEffects.RESISTANCE, 300),
			Pair.of(MobEffects.UNLUCK, 120)
		);
	}
}
