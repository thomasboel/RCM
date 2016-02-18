package javabuckets.mods.rcm.skills.firemaking;

import cpw.mods.fml.common.registry.GameRegistry;
import javabuckets.mods.rcm.items.firemaking.ItemTinderbox;
import javabuckets.mods.rcm.utility.ItemRegistry;
import net.minecraft.item.Item;

public class ModFiremakingItems 
{
	public static Item tinderbox;
	
	public static void init()
	{
		tinderbox = new ItemTinderbox("tinderbox");
		ItemRegistry.registerItem(tinderbox, true);
	}
}