package com.natamus.spookyjams.registry.item;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.registry.item.base.JamItem;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

import java.util.List;

public class CreepersDelightJamItem extends JamItem {
	public CreepersDelightJamItem(Properties properties) {
		super(properties.food(JamItem.foodProperties).stacksTo(1));
	}

	protected List<Pair<Holder<MobEffect>, Integer>> getConsumeEffects() {
		return List.of(
			Pair.of(MobEffects.SPEED, 1800),
			Pair.of(MobEffects.INVISIBILITY, 400),
			Pair.of(MobEffects.RESISTANCE, 400),
			Pair.of(MobEffects.ABSORPTION, 1200)
		);
	}
}
