package javabuckets.mods.rcm.init;

import javabuckets.mods.rcm.skills.smithing.ModSmithingRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes 
{
	public static void init()
	{
		ModFixRecipes.init();
		ModSmithingRecipes.init();
		
	}
}