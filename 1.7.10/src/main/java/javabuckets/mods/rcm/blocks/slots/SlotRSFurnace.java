package javabuckets.mods.rcm.blocks.slots;

import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.skills.smithing.ModSmithingItems;
import javabuckets.mods.rcm.utility.SkillReference;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotRSFurnace extends Slot
{
	private EntityPlayer player;
	private int field;
	
	public SlotRSFurnace(EntityPlayer player, IInventory playerInv, int id, int x, int y)
	{
		super(playerInv, id, x, y);
		this.player = player;
	}
	
	@Override
	public boolean isItemValid(ItemStack itemstack) 
	{
		return false;
	}
	
	@Override
	public ItemStack decrStackSize(int amount) 
	{
		if (this.getHasStack())
		{
			this.field += Math.min(amount, this.getStack().stackSize);
		}
		
		return super.decrStackSize(amount);
	}
	
	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack itemstack) 
	{
		this.onCrafting(itemstack);
		super.onPickupFromSlot(player, itemstack);
	}
	
	@Override
	protected void onCrafting(ItemStack itemstack, int par2) 
	{
		this.field += par2;
		this.onCrafting(itemstack);
	}
	
	@Override
	protected void onCrafting(ItemStack itemstack) 
	{
		itemstack.onCrafting(this.player.worldObj, this.player, this.field);
		
		if (!this.player.worldObj.isRemote)
		{
			RCM.instance.skillHandler.addXPToSkill(SkillReference.smith, getXPFromBar(itemstack.getItem()));
		}
	}
	
	public int getXPFromBar(Item bar)
	{
		if (bar == ModSmithingItems.bronzeBar) return 7;
		else if (bar == Items.iron_ingot) return 15;
		else return 0;
	}
}