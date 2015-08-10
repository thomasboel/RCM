package javabuckets.mods.rcm.items.mining;

import javabuckets.mods.rcm.utility.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemPickaxe extends net.minecraft.item.ItemPickaxe
{
	public ItemPickaxe(Item.ToolMaterial toolMaterial) 
	{
		super(toolMaterial);
	}
	
	public void registerIcons(IIconRegister par1IconRegister) 
	{
		itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
}