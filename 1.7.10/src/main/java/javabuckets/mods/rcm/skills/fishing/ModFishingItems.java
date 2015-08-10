package javabuckets.mods.rcm.skills.fishing;

import cpw.mods.fml.common.registry.GameRegistry;
import javabuckets.mods.rcm.items.fishing.ItemFishingNet;
import javabuckets.mods.rcm.utility.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModFishingItems 
{
	public static Item fishingNet;
	
	public static void init()
	{
		fishingNet = new ItemFishingNet("small_fishingnet");
		GameRegistry.registerItem(fishingNet, "small_fishingnet", Reference.MOD_ID);
	}
}