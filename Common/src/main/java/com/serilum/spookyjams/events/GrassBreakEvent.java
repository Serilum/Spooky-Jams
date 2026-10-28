package com.serilum.spookyjams.events;

import com.natamus.collective.data.GlobalVariables;
import com.natamus.collective.services.Services;
import com.serilum.spookyjams.config.ConfigHandler;
import com.serilum.spookyjams.items.SpookyJamsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class GrassBreakEvent {
	private static final List<Block> seedDroppingBlocks = List.of(Blocks.SHORT_GRASS, Blocks.TALL_GRASS, Blocks.FERN, Blocks.LARGE_FERN);

	public static void onGrassBreak(Level level, Player player, BlockPos blockPos, BlockState blockState) {
		if (level.isClientSide()) {
			return;
		}

		if (player.isCreative()) {
			return;
		}

		if (!seedDroppingBlocks.contains(blockState.getBlock())) {
			return;
		}

		if (Services.TOOLFUNCTIONS.isShears(player.getItemInHand(InteractionHand.MAIN_HAND))) {
			return;
		}

		if (!seedsCanDropInMonth(LocalDate.now().getMonth())) {
			return;
		}

		if (GlobalVariables.random.nextDouble() >= ConfigHandler.spookyYamSeedsDropChance) {
			return;
		}

		Block.popResource(level, blockPos, new ItemStack(SpookyJamsItems.SPOOKY_YAM_SEEDS));
	}

	public static boolean seedsCanDropInMonth(Month month) {
		if (!ConfigHandler.spookyYamSeedsOnlyDropInOctober) {
			return true;
		}
		return month.equals(Month.OCTOBER);
	}
}
