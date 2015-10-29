package javabuckets.mods.rcm.init;

import javabuckets.mods.rcm.skills.fishing.ModFishingItems;
import javabuckets.mods.rcm.skills.herblore.ModHerbloreItems;
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
		ModHerbloreItems.init();
		ModPrayerItems.init();
		ModWoodcuttingItems.init();
		
		//ModQuestItems.init();
		DropTable.init();
		
		ModArmor.init();
		ModWeapons.init();
	}
}