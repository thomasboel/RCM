package javabuckets.mods.rcm.items.farming;

import javabuckets.mods.rcm.init.ModCreativeTabs;
import javabuckets.mods.rcm.skills.farming.ModFarmingItems;
import javabuckets.mods.rcm.utility.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemHerbSeed extends Item 
{
	public ItemHerbSeed(String unlocalizedName) 
	{
		super();
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(ModCreativeTabs.rcmFarming);
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegistry) 
	{
		if (this.getUnlocalizedName().equals(ModFarmingItems.herbseed_spiritWeed)) {
			itemIcon = iconRegistry.registerIcon(Reference.MOD_ID + ":seed_spiritweed");
		}
		else if (this.getUnlocalizedName().equals(ModFarmingItems.herbseed_wergali)) {
			itemIcon = iconRegistry.registerIcon(Reference.MOD_ID + ":seed_wergali");
		}
		else if (this.getUnlocalizedName().equals(ModFarmingItems.herbseed_fellstalk)) {
			itemIcon = iconRegistry.registerIcon(Reference.MOD_ID + ":seed_fellstalk");
		}
		else
		{
			itemIcon = iconRegistry.registerIcon(Reference.MOD_ID + ":seed_herb");
		}
	}
}