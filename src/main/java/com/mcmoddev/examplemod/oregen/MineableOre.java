package com.mcmoddev.examplemod.oregen;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

/**
 *
 * @author
 *
 */
public class MineableOre extends WorldGenMinable {

	/**
	 *
	 */
	private int minHeight;

	/**
	 *
	 */
	private int maxHeight;

	/**
	 *
	 */
	private int dimension;

	/**
	 *
	 */
	public MineableOre() {
		this(Blocks.AIR.getDefaultState(), 0);
	}

	/**
	 *
	 * @param state IBlockState
	 * @param minHeightIn int
	 * @param maxHeightIn int
	 * @param dimensionIn int
	 * @param count int
	 */
	public MineableOre(final IBlockState state, final int minHeightIn, final int maxHeightIn, final int dimensionIn,
			final int count) {
		super(state, count);
		this.minHeight = minHeightIn;
		this.maxHeight = maxHeightIn;
		this.dimension = dimensionIn;
	}

	/**
	 *
	 * @param state IBlockState
	 * @param blockCount int
	 */
	public MineableOre(final IBlockState state, final int blockCount) {
		this(state, 0, 256, WorldGenerator.DIMENSION_ANY_OVERWORLD, blockCount);
	}

	/**
	 *
	 * @param state IBlockState
	 * @param blockCount int
	 * @param blockMatch Predicate<IBlockState>
	 */
	public MineableOre(final IBlockState state, final int blockCount, final Predicate<IBlockState> blockMatch) {
		super(state, blockCount, blockMatch);
		this.minHeight = 0;
		this.maxHeight = 256;
		this.dimension = WorldGenerator.DIMENSION_ANY_OVERWORLD;
	}

	/**
	 *
	 * @return int Dimension
	 */
	public int getDimension() {
		return this.dimension;
	}

	/**
	 *
	 * @return int MinHeight
	 */
	public int getMinHeight() {
		return this.minHeight;
	}

	/**
	 *
	 * @return int MaxHeight
	 */
	public int getMaxHeight() {
		return this.maxHeight;
	}

	/**
	 *
	 * @param dimensionIn int
	 */
	public void setDimension(final int dimensionIn) {
		this.dimension = dimensionIn;
	}

	/**
	 *
	 * @param minHeightIn int
	 */
	public void setMinHeight(final int minHeightIn) {
		if (minHeightIn >= this.maxHeight) {
			throw new IllegalArgumentException("minimum height must be below maximum height");
		} else {
			this.minHeight = minHeightIn;
		}
	}

	/**
	 *
	 * @param maxHeightIn int
	 */
	public void setMaxHeight(final int maxHeightIn) {
		if (maxHeightIn <= this.minHeight) {
			throw new IllegalArgumentException("maximum height must be above minimum height");
		} else {
			this.maxHeight = maxHeightIn;
		}
	}

	/**
	 *
	 */
	@Override
	public boolean generate(final World world, final Random random, final BlockPos pos) {
		final int bound = this.maxHeight - this.minHeight;
		return super.generate(world, random, pos.add(8 + random.nextInt(8),
				random.nextInt(bound) + this.minHeight, 8 + random.nextInt(8)));
	}
}
