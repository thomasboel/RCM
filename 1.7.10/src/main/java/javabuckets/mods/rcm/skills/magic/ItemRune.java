package javabuckets.mods.rcm.skills.magic;

import javabuckets.mods.rcm.items.ItemBase;
import javabuckets.mods.rcm.utility.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRune extends ItemBase
{
	public ItemRune(String unlocalizedName)
	{
		super(unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
}