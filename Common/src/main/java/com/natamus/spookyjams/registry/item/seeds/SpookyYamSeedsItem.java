package com.natamus.spookyjams.registry.item.seeds;

import com.natamus.spookyjams.items.SpookyJamsBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SpookyYamSeedsItem extends Item {
	public SpookyYamSeedsItem(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
		Level level = context.getLevel();
		BlockPos pos = context.getClickedPos();
		BlockPos placePos = pos.above();
		ItemStack itemstack = context.getItemInHand();

		if (context.getClickedFace() != Direction.UP) {
			return InteractionResult.FAIL;
		} else if (!context.getPlayer().mayUseItemAt(placePos, context.getClickedFace(), itemstack)) {
			return InteractionResult.FAIL;
		} else {
			BlockState soil = level.getBlockState(pos);
			if (soil.getBlock() instanceof FarmBlock && level.isEmptyBlock(placePos)) {
				BlockState crop = SpookyJamsBlocks.SPOOKY_YAM_CROP.defaultBlockState();
				level.setBlock(placePos, crop, 11);

				if (!context.getPlayer().getAbilities().instabuild) {
					itemstack.shrink(1);
				}

				return InteractionResult.SUCCESS;
			} else {
				return InteractionResult.FAIL;
			}
		}
	}
}
