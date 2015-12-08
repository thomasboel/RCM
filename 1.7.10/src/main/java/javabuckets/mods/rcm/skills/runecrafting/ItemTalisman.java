package javabuckets.mods.rcm.skills.runecrafting;

import javabuckets.mods.rcm.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTalisman extends ItemBase
{
	public ItemTalisman(String unlocalizedName) 
	{
		super(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		this.setMaxStackSize(1);
	}
}