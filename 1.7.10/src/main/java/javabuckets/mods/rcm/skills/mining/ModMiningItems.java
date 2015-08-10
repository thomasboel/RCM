package javabuckets.mods.rcm.skills.mining;

import cpw.mods.fml.common.registry.GameRegistry;
import javabuckets.mods.rcm.init.ModEnums;
import javabuckets.mods.rcm.items.ItemBase;
import javabuckets.mods.rcm.items.mining.ItemPickaxe;
import javabuckets.mods.rcm.utility.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModMiningItems 
{
	public static Item copperOre;
	public static Item tinOre;
	public static Item ironOre;
	public static Item silverOre;
	public static Item goldOre;
	public static Item mithrilOre;
	public static Item adamantiteOre;
	public static Item runiteOre;
	
	public static Item copper_tin;
	public static Item iron_coal;
	public static Item mithril_coal;
	public static Item adamant_coal;
	public static Item rune_coal;
	
	public static Item bronzePickaxe;
	public static Item steelPickaxe;
	public static Item mithrilPickaxe;
	public static Item adamantPickaxe;
	public static Item runePickaxe;
	public static Item dragonPickaxe;
	
	public static void init()
	{
		copperOre = new ItemBase("copper_ore").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(copperOre, "ITEM_copper_ore");
		
		tinOre = new ItemBase("tin_ore").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(tinOre, "ITEM_tin_ore");
		
		ironOre = new ItemBase("iron_ore").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(ironOre, "ITEM_iron_ore");
		
		silverOre = new ItemBase("silver_ore").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(silverOre, "ITEM_silver_ore");
		
		goldOre = new ItemBase("gold_ore").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(goldOre, "ITEM_gold_ore");
		
		mithrilOre = new ItemBase("mithril_ore").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(mithrilOre, "ITEM_mithril_ore");
		
		adamantiteOre = new ItemBase("adamantite_ore").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(adamantiteOre, "ITEM_adamantite_ore");
		
		runiteOre = new ItemBase("runite_ore").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(runiteOre, "ITEM_runite_ore");
		
		
		copper_tin = new ItemBase("copper_tin").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(copper_tin, "copper_tin");
		
		iron_coal = new ItemBase("iron_coal").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(iron_coal, "iron_coal");
		
		mithril_coal = new ItemBase("mithril_coal").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(mithril_coal, "mithril_coal");
		
		adamant_coal = new ItemBase("adamant_coal").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(adamant_coal, "adamant_coal");
		
		rune_coal = new ItemBase("rune_coal").setCreativeTab(CreativeTabs.tabMaterials);
		GameRegistry.registerItem(rune_coal, "rune_coal");
		
		
		bronzePickaxe = new ItemPickaxe(ModEnums.bronze).setUnlocalizedName("bronze_pickaxe");
		GameRegistry.registerItem(bronzePickaxe, "bronze_pickaxe");
		
		steelPickaxe = new ItemPickaxe(ModEnums.steel).setUnlocalizedName("steel_pickaxe");
		GameRegistry.registerItem(steelPickaxe, "steel_pickaxe");
		
		mithrilPickaxe = new ItemPickaxe(ModEnums.mithril).setUnlocalizedName("mithril_pickaxe");
		GameRegistry.registerItem(mithrilPickaxe, "mithril_pickaxe");
		
		adamantPickaxe = new ItemPickaxe(ModEnums.adamantite).setUnlocalizedName("adamant_pickaxe");
		GameRegistry.registerItem(adamantPickaxe, "adamant_pickaxe");
		
		runePickaxe = new ItemPickaxe(ModEnums.runite).setUnlocalizedName("rune_pickaxe");
		GameRegistry.registerItem(runePickaxe, "rune_pickaxe");
		
		dragonPickaxe = new ItemPickaxe(ModEnums.dragonTool).setUnlocalizedName("dragon_pickaxe");
		GameRegistry.registerItem(dragonPickaxe, "dragon_pickaxe");
	}
}