/**
 * This class was created by <Surseance> or his SC2 development team.
 * This class is available as part of the Steamcraft 2 Mod for Minecraft.
 *
 * Steamcraft 2 is open-source and is distributed under the MMPL v1.0 License.
 * (http://www.mod-buildcraft.com/MMPL-1.0.txt)
 *
 * Steamcraft 2 is based on the original Steamcraft Mod created by Proloe.
 * Steamcraft (c) Proloe 2011
 * (http://www.minecraftforum.net/topic/251532-181-steamcraft-source-code-releasedmlv054wip/)
 *
 * File created @ 25-May-2014
 */
package boilerplate.client.utils;

import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.world.World;

// TODO: Auto-generated Javadoc
/**
 * The Class EffectUtils.
 */
public class EffectUtils
{

	/**
	 * Sparkle.
	 *
	 * @param world the world
	 * @param x the x
	 * @param y the y
	 * @param z the z
	 * @param particleName the particle name
	 */
	public static void sparkle(final World world, final int x, final int y,
			final int z, final String particleName)
	{
		final Random random = world.rand;
		final double offset = 0.0625D;

		for (int amount = 0; amount < 6; amount++)
		{
			double dx = x + random.nextFloat();
			double dy = y + random.nextFloat();
			double dz = z + random.nextFloat();

			if ((amount == 0)
					&& (!world.isBlockNormalCubeDefault(x, y + 1, z, false)))
			{
				dy = y + 1 + offset;
			}

			if ((amount == 1)
					&& (!world.isBlockNormalCubeDefault(x, y - 1, z, false)))
			{
				dy = y + 0 - offset;
			}

			if ((amount == 2)
					&& (!world.isBlockNormalCubeDefault(x, y, z + 1, false)))
			{
				dz = z + 1 + offset;
			}

			if ((amount == 3)
					&& (!world.isBlockNormalCubeDefault(x, y, z - 1, false)))
			{
				dz = z + 0 - offset;
			}

			if ((amount == 4)
					&& (!world.isBlockNormalCubeDefault(x + 1, y, z, false)))
			{
				dx = x + 1 + offset;
			}

			if ((amount == 5)
					&& (!world.isBlockNormalCubeDefault(x - 1, y, z, false)))
			{
				dx = x + 0 - offset;
			}

			if ((dx < x) || (dx > x + 1) || (dy < 0.0D) || (dy > y + 1)
					|| (dz < z) || (dz > z + 1))
			{
				world.spawnParticle(particleName, dx, dy, dz, -1.0D, 1.0D,
						-1.0D);
				// Steamcraft.proxy.smokeFX(world, dx, dy, dz, FXSmoke.class);
			}
		}
	}
	public static void blockSparkle(World world, int x, int y, int z, int count)
	{
		if (!world.isRemote)
			return;

		for (; count < 10; ++count)
		{
			double startX = x + world.rand.nextFloat();
			double startY = y + world.rand.nextFloat() * 1.0F;
			double startZ = z + world.rand.nextFloat();

			double endX = world.rand.nextGaussian() * 0.02D;
			double endY = world.rand.nextGaussian() * 0.02D;
			double endZ = world.rand.nextGaussian() * 0.02D;

			EntityFlameFX ef = new EntityFlameFX(world, startX, startY, startZ, endX, endY, endZ);
			ef.setRBGColorF(0.45F, 0.0F, 0.35F);
			ef.setParticleTextureIndex(82);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(ef);
		}
	}

	public static void blockFlameFX(World world, int x, int y, int z, int count)
	{
		for (; count < 10; ++count)
		{
			double startX = x + world.rand.nextFloat();
			double startY = y + world.rand.nextFloat() * 1.0F;
			double startZ = z + world.rand.nextFloat();

			double endX = world.rand.nextGaussian() * 0.02D;
			double endY = world.rand.nextGaussian() * 0.02D;
			double endZ = world.rand.nextGaussian() * 0.02D;

			EntityFlameFX ef = new EntityFlameFX(world, startX, startY, startZ, endX, endY, endZ);
			FMLClientHandler.instance().getClient().effectRenderer.addEffect(ef);
		}
	}

}