package javabuckets.mods.rcm.skills.summoning;

import cpw.mods.fml.common.registry.GameRegistry;
import javabuckets.mods.rcm.init.ModCreativeTabs;
import javabuckets.mods.rcm.items.ItemBase;
import javabuckets.mods.rcm.items.summoning.PouchSpirirwolf;
import javabuckets.mods.rcm.utility.Reference;
import net.minecraft.item.Item;

public class ModSummoningItems 
{
	public static Item emptyPouch;
	public static Item spiritShards;
	
	public static Item goldCharm;
	public static Item greenCharm;
	public static Item redCharm;
	public static Item blueCharm;
	//public static Item elderCharm;
	
	/**
	 * Familiar Pouches
	 */
	public static Item pouch_spiritWolf;
	
	
	public static void init()
	{
		emptyPouch = new ItemBase("empty_pouch").setCreativeTab(ModCreativeTabs.rcmSummoning);;
		GameRegistry.registerItem(emptyPouch, "empty_pouch", Reference.MOD_ID);
		
		spiritShards = new ItemBase("spirit_shards").setCreativeTab(ModCreativeTabs.rcmSummoning);;
		GameRegistry.registerItem(spiritShards, "spirit_shards", Reference.MOD_ID);
		
		goldCharm = new ItemBase("gold_charm").setCreativeTab(ModCreativeTabs.rcmSummoning);;
		GameRegistry.registerItem(goldCharm, "gold_charm", Reference.MOD_ID);
		
		greenCharm = new ItemBase("green_charm").setCreativeTab(ModCreativeTabs.rcmSummoning);;
		GameRegistry.registerItem(greenCharm, "green_charm", Reference.MOD_ID);
		
		redCharm = new ItemBase("red_charm").setCreativeTab(ModCreativeTabs.rcmSummoning);;
		GameRegistry.registerItem(redCharm, "red_charm", Reference.MOD_ID);
		
		blueCharm = new ItemBase("blue_charm").setCreativeTab(ModCreativeTabs.rcmSummoning);;
		GameRegistry.registerItem(blueCharm, "blue_charm", Reference.MOD_ID);
		
		/*elderCharm = new ItemBase("elder_charm").setCreativeTab(ModCreativeTabs.rcmSummoning);;
		GameRegistry.registerItem(elderCharm, "elder_charm", Reference.MOD_ID);*/
		
		/**
		 * Familiar Pouches
		 */
		pouch_spiritWolf = new PouchSpirirwolf("pouch_spiritwolf");
		GameRegistry.registerItem(pouch_spiritWolf, "pouch_spiritwolf", Reference.MOD_ID);
	}
}