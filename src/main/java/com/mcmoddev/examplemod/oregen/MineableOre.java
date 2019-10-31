package com.mcmoddev.examplemod.oregen;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class MineableOre extends WorldGenMinable {
	private int minHeight;
	private int maxHeight;
	private int dimension;

	public MineableOre() {
		this(Blocks.AIR.getDefaultState(), 0);
	}

	public MineableOre(final IBlockState state, final int minHeight, final int maxHeight, final int dimension, final int count) {
		super(state, count);
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.dimension = dimension;
	}

	public MineableOre(final IBlockState state, final int blockCount) {
		this(state, 0, 256, WorldGenerator.DIMENSION_ANY_OVERWORLD, blockCount);
	}

	public MineableOre(final IBlockState state, final int blockCount, final Predicate<IBlockState> blockMatch) {
		super(state, blockCount, blockMatch);
		this.minHeight = 0;
		this.maxHeight = 256;
		this.dimension = WorldGenerator.DIMENSION_ANY_OVERWORLD;
	}

	public int getDimension() {
		return this.dimension;
	}

	public int getMinHeight() {
		return this.minHeight;
	}

	public int getMaxHeight() {
		return this.maxHeight;
	}

	public void setDimension(final int dimension) {
		this.dimension = dimension;
	}

	public void setMinHeight(final int minHeight) {
		if (minHeight >= this.maxHeight) {
			throw new IllegalArgumentException("minimum height must be below maximum height");
		} else {
			this.minHeight = minHeight;
		}
	}

	public void setMaxHeight(final int maxHeight) {
		if (maxHeight <= this.minHeight) {
			throw new IllegalArgumentException("maximum height must be above minimum height");
		} else {
			this.maxHeight = maxHeight;
		}
	}

	@Override
	public boolean generate(final World world, final Random random, final BlockPos pos) {
		int bound = this.maxHeight - this.minHeight;
		return super.generate(world, random, pos.add(8 + random.nextInt(8),
				random.nextInt(bound) + this.minHeight, 8 + random.nextInt(8)));
	}
}
