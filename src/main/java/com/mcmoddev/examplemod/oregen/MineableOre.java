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
	
	public MineableOre(IBlockState state, int minHeight, int maxHeight, int dimension, int count) {
		super(state, count);
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.dimension = dimension;
	}
	
	public MineableOre(IBlockState state, int blockCount) {
		this(state, 0, 256, WorldGenerator.DIMENSION_ANY_OVERWORLD, blockCount);
	}

	public MineableOre(IBlockState state, int blockCount, Predicate<IBlockState> blockMatch) {
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
	
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	
	public void setMinHeight(int minHeight) {
		if(minHeight >= this.maxHeight) {
			throw new IllegalArgumentException("minimum height must be below maximum height");
		} else {
			this.minHeight = minHeight;
		}
	}

	public void setMaxHeight(int maxHeight) {
		if(maxHeight <= this.minHeight) {
			throw new IllegalArgumentException("maximum height must be above minimum height");
		} else {
			this.maxHeight = maxHeight;
		}
	}
	
	@Override 
	public boolean generate(World world, Random random, BlockPos pos) {
		int bound = this.maxHeight - this.minHeight;
		return super.generate(world, random, pos.add(8+random.nextInt(8), 
				random.nextInt(bound)+this.minHeight, 8+random.nextInt(8)));
	}
}
