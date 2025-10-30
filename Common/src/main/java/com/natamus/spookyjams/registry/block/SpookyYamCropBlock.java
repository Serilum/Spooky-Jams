package com.natamus.spookyjams.registry.block;

import com.natamus.spookyjams.items.SpookyJamsItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SpookyYamCropBlock extends CropBlock {
	public static final int MAX_AGE = 3;
	public static final IntegerProperty AGE;
	private static final float AABB_OFFSET = 3.0F;
	private static final VoxelShape[] SHAPE_BY_AGE;
	private static final int BONEMEAL_INCREASE = 1;

	public SpookyYamCropBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> $$0) {
		$$0.add(AGE);
	}

	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext ctx) {
		return SHAPE_BY_AGE[this.getAge(state)];
	}

	protected @NotNull IntegerProperty getAgeProperty() {
		return AGE;
	}

	public int getMaxAge() {
		return MAX_AGE;
	}

	protected @NotNull ItemLike getBaseSeedId() {
		return SpookyJamsItems.SPOOKY_YAM_SEEDS;
	}

	public @NotNull BlockState getStateForAge(int age) {
		return super.getStateForAge(age);
	}

	public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, RandomSource rand) {
		if (rand.nextInt(3) != 0) {
			super.randomTick(state, level, pos, rand);
		}
	}

	protected int getBonemealAgeIncrease(@NotNull Level level) {
		return 1;
	}

    public void animateTick(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource rand) {
        if (!level.isClientSide) return;

        int age = this.getAge(state);
        if (age <= 0) return;

        float baseChance = 0.2F;
        float matureBonus = (age == 3) ? 0.2F : 0.0F;
        if (rand.nextFloat() > baseChance + matureBonus) return;

        double height;
        switch (age) {
            case 1 -> height = 6.0D / 16.0D;
            case 2 -> height = 9.0D / 16.0D;
            case 3 -> height = 13.0D / 16.0D;
            default -> height = 3.0D / 16.0D;
        }
        double x = pos.getX() + 0.25D + rand.nextDouble() * 0.50D;
        double z = pos.getZ() + 0.25D + rand.nextDouble() * 0.50D;
        double y = pos.getY() + (height * (0.70D + rand.nextDouble() * 0.30D));

        float r = 96 / 255.0F;
        float g = 120 / 255.0F;
        float b = 210 / 255.0F;

        float scale = 0.35F;

        double vx = 0.0D;
        double vy = 0.0025D + rand.nextDouble() * 0.0035D;
        double vz = 0.0D;

        level.addParticle(new net.minecraft.core.particles.DustColorTransitionOptions(
            new org.joml.Vector3f(r, g, b),
            new org.joml.Vector3f(
                Math.min(1F, r + 0.10F),
                Math.min(1F, g + 0.12F),
                Math.min(1F, b + 0.06F)
            ),
            scale
        ), x, y, z, vx, vy, vz);
    }



	private static double getVisualHeightForAge(int age) {
		// mirrors your SHAPE_BY_AGE heights (3, 6, 9, 13 px)
		// convert pixels to blocks: px / 16.0
		return switch (age) {
			case 1 -> 6.0D / 16.0D;
			case 2 -> 9.0D / 16.0D;
			case 3 -> 13.0D / 16.0D;
			default -> 3.0D / 16.0D;
		};
	}

	static {
		AGE = BlockStateProperties.AGE_3;
		SHAPE_BY_AGE = new VoxelShape[] {
			Block.box(5.0D, 0.0D, 5.0D, 11.0D, 3.0D, 11.0D),  // stage 0 - 3px
			Block.box(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D),  // stage 1 - 6px
			Block.box(5.0D, 0.0D, 5.0D, 11.0D, 9.0D, 11.0D),  // stage 2 - 9px
			Block.box(5.0D, 0.0D, 5.0D, 11.0D, 13.0D, 11.0D)  // stage 3 - 13px
		};
	}
}
