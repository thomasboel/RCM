package javabuckets.mods.rcm.init;

import javabuckets.mods.rcm.skills.fishing.ModFishingItems;
import javabuckets.mods.rcm.skills.mining.ModMiningItems;
import javabuckets.mods.rcm.skills.prayer.ModPrayerItems;
import javabuckets.mods.rcm.skills.smithing.ModSmithingItems;
import javabuckets.mods.rcm.skills.woodcutting.ModWoodcuttingItems;

public class ModItems
{
	public static void init()
	{
		ModMiningItems.init();
		ModSmithingItems.init();
		ModFishingItems.init();
		ModPrayerItems.init();
		ModWoodcuttingItems.init();
	}
}