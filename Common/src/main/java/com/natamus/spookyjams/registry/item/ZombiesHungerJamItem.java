package com.natamus.spookyjams.registry.item;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.registry.item.base.JamItem;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class ZombiesHungerJamItem extends JamItem {

	public ZombiesHungerJamItem(Properties properties) {
		super(properties.food(JamItem.foodProperties).stacksTo(1));
	}

	protected List<Pair<MobEffect, Integer>> getConsumeEffects() {
		return List.of(
			Pair.of(MobEffects.DAMAGE_BOOST, 3600),
			Pair.of(MobEffects.HEALTH_BOOST, 2400),
			Pair.of(MobEffects.REGENERATION, 300),
			Pair.of(MobEffects.HUNGER, 1800)
		);
	}

	public @NotNull Component getName(@NotNull ItemStack stack) {
		return Component.translatable(this.getDescriptionId(stack))
			.setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xa45c4e)));
	}

	public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
		super.appendHoverText(stack, level, tooltip, flag);

		String baseKey = this.getDescriptionId();
		Style style = Style.EMPTY.withColor(TextColor.fromRgb(0x763628)).withItalic(true);

		tooltip.add(Component.translatable(baseKey + ".desc.1").setStyle(style));
		tooltip.add(Component.literal(" ").append(Component.translatable(baseKey + ".desc.2")).setStyle(style));
	}
}
