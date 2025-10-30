package com.natamus.spookyjams.registry.item.base;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.config.ConfigHandler;
import com.natamus.spookyjams.items.SpookyJamsItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JamItem extends Item {
	public static FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(1).saturationMod(1F).alwaysEat().build();

	public JamItem(Properties properties) {
		super(properties);
	}

	protected List<Pair<MobEffect, Integer>> getConsumeEffects() {
		return List.of();
	}

	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);

		player.startUsingItem(interactionHand);
		return InteractionResultHolder.consume(itemStack);
    }

    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
		if (livingEntity instanceof Player player) {
			List<Pair<MobEffect, Integer>> consumeEffects = getConsumeEffects();
			if (!consumeEffects.isEmpty()) {
				for (Pair<MobEffect, Integer> mobEffectPair : consumeEffects) {
					livingEntity.addEffect(new MobEffectInstance(mobEffectPair.getFirst(), (int)(mobEffectPair.getSecond() * ConfigHandler.jamConsumeEffectsModifier)));
				}
			}

			if (!player.getAbilities().instabuild) {
				if (itemStack.isEmpty()) {
					return new ItemStack(SpookyJamsItems.GLASS_JAR);
				}
				else {
					player.getInventory().add(new ItemStack(SpookyJamsItems.GLASS_JAR));
				}
			}
		}

        return livingEntity.eat(level, itemStack);
    }
}
