package javabuckets.mods.rcm.items.prayer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import javabuckets.mods.rcm.items.ItemBase;
import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.skills.prayer.ModPrayerItems;
import javabuckets.mods.rcm.utility.SkillReference;

public class ItemBones extends ItemBase
{
	public ItemBones(String unlocalizedName)
	{
		super(unlocalizedName);
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int i, float f1, float f2, float f3) 
	{
		if (player.isSneaking() && player.isInWater() == false) 
		{
			addBone(player, itemstack, ModPrayerItems.bones, 4.5);
			addBone(player, itemstack, ModPrayerItems.bigBones, 15);
			addBone(player, itemstack, ModPrayerItems.dragonBones, 72);
			
			if (!player.capabilities.isCreativeMode)
			{
				--itemstack.stackSize;
			}
		}
		return true;
	}

	public void addBone(EntityPlayer player, ItemStack itemstack, Item bone, double xp)
	{
		if (itemstack.getItem() == bone && RCM.instance.prayer.canPlayerBuryBone)
		{
			RCM.instance.prayer.isPraying = true;
			RCM.instance.skillHandler.addXPToSkill(SkillReference.pray, xp);
		}
	}
}