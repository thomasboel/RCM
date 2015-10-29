package javabuckets.mods.rcm.skills.combat.magic;

import javabuckets.mods.rcm.items.ItemBase;
import net.minecraft.creativetab.CreativeTabs;

public class ItemStaff extends ItemBase
{
	public ItemStaff(String unlocalizedName) 
	{
		super(unlocalizedName);
		this.setMaxStackSize(1);
		this.setFull3D();
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	public ItemStaff(String unlocalizedName, String element) 
	{
		this(unlocalizedName);
	}
}