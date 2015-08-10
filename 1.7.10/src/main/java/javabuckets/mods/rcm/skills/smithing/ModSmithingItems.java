package javabuckets.mods.rcm.skills.smithing;

import javabuckets.mods.rcm.items.ItemBase;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModSmithingItems 
{
	public static Item bronzeBar;
	public static Item steelBar;
	public static Item silverBar;
	public static Item mithrilBar;
	public static Item adamantBar;
	public static Item runeBar;
	
	public static void init()
	{
		bronzeBar = new ItemBase("bronze_bar").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(bronzeBar, "bronze_bar");
		
		steelBar = new ItemBase("steel_bar").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(steelBar, "steel_bar");
		
		silverBar = new ItemBase("silver_bar").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(silverBar, "silver_bar");
		
		mithrilBar = new ItemBase("mithril_bar").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(mithrilBar, "mithril_bar");
		
		adamantBar = new ItemBase("adamant_bar").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(adamantBar, "adamant_bar");

		runeBar = new ItemBase("rune_bar").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(runeBar, "rune_bar");
	}
}