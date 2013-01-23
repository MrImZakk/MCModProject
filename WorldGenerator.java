package arcanemod.common;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorMod implements IWorldGenerator 
{

  @Override
	public void generate(Random random, int chunkX, int chunkZ, World world,   // Generates each of the dimensions in minecraft
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.dimensionId) 
		{

		case 1:

		generateNether(world, random, chunkX * 16, chunkZ * 16);

		case 0:

		generateSurface(world, random, chunkX * 16, chunkZ * 16);

		case -1:

		generateEnd(world, random, chunkX * 16, chunkZ * 16);

		}
		

	}
	private void generateNether(World world, Random random, int blockX, int blockZ) 
	{

	}
	private void generateEnd(World world, Random random, int blockX, int blockZ) 
	{

	}

	private void generateSurface(World world, Random random, int blockX, int blockZ) 
	{

	for (int i = 0; i < 17; i++)  // Basically says how often the block will spawn
	{

	int Xcoord = blockX + random.nextInt(16);

	int Ycoord = random.nextInt(64); // How many blocks down it starts to spawn

	int Zcoord = blockZ + random.nextInt(16);

	(new WorldGenMinable(arcanemod.RedArcaneOre.blockID, 6)).generate(world, random, Xcoord, Ycoord, Zcoord); // Basically says how many blocks in a vein can spawn at once

	}

	}



}
