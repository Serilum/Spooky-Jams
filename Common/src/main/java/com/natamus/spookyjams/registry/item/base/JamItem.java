package com.natamus.spookyjams.registry.item.base;

import com.mojang.datafixers.util.Pair;
import com.natamus.spookyjams.config.ConfigHandler;
import com.natamus.spookyjams.items.SpookyJamsItems;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class JamItem extends Item {
	public static FoodProperties foodProperties = (new FoodProperties.Builder()).nutrition(1).saturationModifier(1F).alwaysEdible().build();

	public JamItem(Properties properties) {
		super(properties);
	}

	protected List<Pair<Holder<MobEffect>, Integer>> getConsumeEffects() {
		return List.of();
	}

	public @NotNull InteractionResult use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
		ItemStack itemStack = player.getItemInHand(interactionHand);

		player.startUsingItem(interactionHand);
		return InteractionResult.CONSUME;
    }

	@Override
	public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity entity) {
		if (!level.isClientSide()) {
			List<Pair<Holder<MobEffect>, Integer>> consumeEffects = getConsumeEffects();
			if (!consumeEffects.isEmpty()) {
				for (Pair<Holder<MobEffect>, Integer> mobEffectPair : consumeEffects) {
					entity.addEffect(new MobEffectInstance(mobEffectPair.getFirst(),(int)(mobEffectPair.getSecond() * ConfigHandler.jamConsumeEffectsModifier)));
				}
			}
		}

		FoodProperties props = foodProperties;
		if (props != null && entity instanceof Player player && !level.isClientSide()) {
			player.getFoodData().eat(props.nutrition(), props.saturation());
			player.awardStat(Stats.ITEM_USED.get(this));
		}

		if (!level.isClientSide()) {
			level.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
				SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 1.0F, 1.0F);
			entity.gameEvent(GameEvent.EAT);
		}

		if (entity instanceof Player player && !player.getAbilities().instabuild) {
			stack.shrink(1);

			if (stack.isEmpty()) {
				return new ItemStack(SpookyJamsItems.GLASS_JAR);
			} else {
				player.getInventory().add(new ItemStack(SpookyJamsItems.GLASS_JAR));
			}
		}

		return stack;
	}
}
