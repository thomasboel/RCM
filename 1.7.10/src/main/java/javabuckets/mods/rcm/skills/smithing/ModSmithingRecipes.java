package javabuckets.mods.rcm.skills.smithing;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import javabuckets.mods.rcm.skills.mining.ModMiningItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModSmithingRecipes 
{
	public static void init()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ModMiningItems.copper_tin), new Object[] {
			ModMiningItems.copperOre, ModMiningItems.tinOre	});
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModMiningItems.iron_coal), new Object[] {
			ModMiningItems.ironOre, Items.coal, Items.coal });
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModMiningItems.mithril_coal), new Object[] {
			ModMiningItems.mithrilOre, Items.coal, Items.coal, Items.coal, Items.coal });
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModMiningItems.adamant_coal), new Object[] {
			ModMiningItems.adamantiteOre, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal });
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModMiningItems.rune_coal), new Object[] {
			ModMiningItems.runiteOre, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal });
		
		GameRegistry.addSmelting(ModMiningItems.copper_tin, new ItemStack(ModSmithingItems.bronzeBar), 1F);
		GameRegistry.addSmelting(ModMiningItems.ironOre, new ItemStack(Items.iron_ingot), 1.5F);
		GameRegistry.addSmelting(ModMiningItems.iron_coal, new ItemStack(ModSmithingItems.steelBar), 2F);
		GameRegistry.addSmelting(ModMiningItems.silverOre, new ItemStack(ModSmithingItems.silverBar), 3.5F);
		GameRegistry.addSmelting(ModMiningItems.goldOre, new ItemStack(Items.gold_ingot), 5F);
		GameRegistry.addSmelting(ModMiningItems.mithril_coal, new ItemStack(ModSmithingItems.mithrilBar), 7.5F);
		GameRegistry.addSmelting(ModMiningItems.adamant_coal, new ItemStack(ModSmithingItems.adamantBar), 8F);
		GameRegistry.addSmelting(ModMiningItems.rune_coal, new ItemStack(ModSmithingItems.runeBar), 10F);
	}
}