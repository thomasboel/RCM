package javabuckets.mods.rcm.init;

import javabuckets.mods.rcm.skills.mining.ModMiningBlocks;
import javabuckets.mods.rcm.skills.prayer.ModPrayerBlocks;
import javabuckets.mods.rcm.skills.runecrafting.ModRunecraftingBlocks;
import javabuckets.mods.rcm.skills.summoning.ModSummoningBlocks;
import javabuckets.mods.rcm.skills.woodcutting.ModWoodcuttingBlocks;

public class ModBlocks 
{
	public static void init()
	{
		ModMiningBlocks.init();
		ModPrayerBlocks.init();
		ModWoodcuttingBlocks.init();
		ModRunecraftingBlocks.init();
		ModSummoningBlocks.init();
		ModFixBlocks.init();
	}
}
