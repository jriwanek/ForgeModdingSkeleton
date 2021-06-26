package com.mcmoddev.examplemod.oregen;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

/**
 *
 * @author madman
 */
public class WorldGenerator implements IWorldGenerator {

	/**
	 *
	 */
	private final List<MineableOre> myOres;

	/**
	 *
	 */
	public static final int DIMENSION_OVERWORLD = 0;

	/**
	 *
	 */
	public static final int DIMENSION_NETHER = -1;
	/**
	 *
	 */
	public static final int DIMENSION_END = 1;

	/**
	 *
	 */
	public static final int DIMENSION_ANY_OVERWORLD = Integer.MAX_VALUE;

	/**
	 *
	 */
	public WorldGenerator() {
		this.myOres = new LinkedList<>();
	}

	/**
	 * @see net.minecraftforge.fml.common.IWorldGenerator#generate(java.util.Random,
	 * int, int, net.minecraft.world.World, net.minecraft.world.gen.IChunkGenerator,
	 * net.minecraft.world.chunk.IChunkProvider)
	 */
	@Override
	public void generate(final Random random, final int chunkX, final int chunkZ, final World world,
			final IChunkGenerator chunkGenerator,
			final IChunkProvider chunkProvider) {
		final int currentDim = world.provider.getDimension();
		final DimensionType dimType = world.provider.getDimensionType();
		switch (currentDim) {
		case DIMENSION_OVERWORLD:
		case DIMENSION_NETHER:
		case DIMENSION_END:
			this.myOres.stream().filter(ore -> ore.getDimension() == currentDim
			|| (ore.getDimension() == DIMENSION_ANY_OVERWORLD && dimType == DimensionType.OVERWORLD))
			.forEach(ore -> ore.generate(world, random, new BlockPos(chunkX * 16, 0, chunkZ * 16)));
			break;
		default:
			if (dimType == DimensionType.OVERWORLD) {
				this.myOres.stream().filter(ore -> ore.getDimension() == DIMENSION_ANY_OVERWORLD
						&& dimType == DimensionType.OVERWORLD)
				.forEach(ore -> ore.generate(world, random, new BlockPos(chunkX * 16, 0, chunkZ * 16)));
			}
			break;
		}
	}

	/**
	 *
	 * @param oreBlock Block
	 * @param dimension int
	 * @param minHeight int
	 * @param maxHeight int
	 * @param nodeSize int
	 */
	public void addOre(final Block oreBlock, final int dimension, final int minHeight, final int maxHeight,
			final int nodeSize) {
		this.myOres.add(new MineableOre(oreBlock.getDefaultState(), minHeight, maxHeight, dimension, nodeSize));
	}

	/**
	 *
	 * @param oreBlock IBlockState
	 * @param dimension int
	 * @param minHeight int
	 * @param maxHeight int
	 * @param nodeSize int
	 */
	public void addOre(final IBlockState oreBlock, final int dimension, final int minHeight, final int maxHeight,
			final int nodeSize) {
		this.myOres.add(new MineableOre(oreBlock, minHeight, maxHeight, dimension, nodeSize));
	}
}
