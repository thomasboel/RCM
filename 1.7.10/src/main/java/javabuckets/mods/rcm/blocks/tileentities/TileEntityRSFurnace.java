package javabuckets.mods.rcm.blocks.tileentities;

import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.skills.mining.ModMiningItems;
import javabuckets.mods.rcm.skills.smithing.ModSmithingItems;
import javabuckets.mods.rcm.utility.LogHelper;
import javabuckets.mods.rcm.utility.SkillReference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRSFurnace extends TileEntity implements IInventory
{
	private ItemStack[] furnaceInventory;
	
	public TileEntityRSFurnace() 
	{
		this.furnaceInventory = new ItemStack[4];
	}
	
	boolean flag = true;
	
	@Override
	public void updateEntity() 
	{
		ItemStack fuel = this.furnaceInventory[0];
		ItemStack inputMain = this.furnaceInventory[1];
		ItemStack inputSecond = this.furnaceInventory[2];
		ItemStack output = this.furnaceInventory[3];
		
		if (!this.worldObj.isRemote)
		{
			
			
			/*if (this.canSmelt())
			{
				this.smeltItem();
			}*/
			
			if (flag)
			{
				setInventorySlotContents(0, new ItemStack(Items.coal));
				setInventorySlotContents(1, new ItemStack(ModMiningItems.copperOre));
				setInventorySlotContents(2, new ItemStack(ModMiningItems.tinOre));
				flag = false;
			}
		}
	}
	
	public ItemStack getResult(ItemStack mainInput, ItemStack secondInput)
	{
		if (mainInput.getItem() == ModMiningItems.copperOre && secondInput.getItem() == ModMiningItems.tinOre) {
			return new ItemStack(ModSmithingItems.bronzeBar); }
		
		else if (mainInput.getItem() == ModMiningItems.ironOre && secondInput == null) {
			return new ItemStack(Items.iron_ingot); }
		
		else 
		{
			return null;
		}
	}
	
	/**
	 * Checks if a lot of conditions are true such as fuel and input not being null, that the player has required level for bar, that fuel is actually coal, etc.
	 */
	public boolean canSmelt()
	{
		ItemStack fuel = this.furnaceInventory[0];
		ItemStack inputMain = this.furnaceInventory[1];
		ItemStack inputSecond = this.furnaceInventory[2];
		ItemStack output = this.furnaceInventory[3];
		
		if (fuel != null && inputMain != null)
		{
//			if (isSmithingLevelSufficientForBar(this.getResult(inputMain, inputSecond).getItem()))
//			{
				if (fuel.getItem() == Items.coal)
				{
					if (isInputSufficient()) return true;
					else return false;
				}
				else
				{
					return false;
				}
//			}
//			else
//			{
//				return false;
//			}
		}
		else
		{
			return false;
		}
	}
	
	public boolean isSmithingLevelSufficientForBar(Item bar)
	{
		if (RCM.instance.skillHandler.getLevel(SkillReference.smith) >= getRequiredLevelForBar(bar))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getRequiredLevelForBar(Item bar)
	{
		if (bar == ModSmithingItems.bronzeBar) return 1;
		else if (bar == Items.iron_ingot) return 5;
		else if (bar == ModSmithingItems.silverBar) return 10;
		else if (bar == ModSmithingItems.steelBar) return 20;
		else if (bar == Items.gold_ingot) return 30;
		else if (bar == ModSmithingItems.mithrilBar) return 40;
		else if (bar == ModSmithingItems.adamantBar) return 55;
		else if (bar == ModSmithingItems.runeBar) return 70;
		else return 0;
	}
	
	public boolean isInputSufficient()
	{
		ItemStack inputMain = this.furnaceInventory[1];
		ItemStack inputSecond = this.furnaceInventory[2];
		
		if (inputMain.getItem() == ModMiningItems.copperOre && inputSecond.getItem() == ModMiningItems.tinOre) return true;
		else if (inputMain.getItem() == ModMiningItems.ironOre && inputSecond == null) return true;
		else return false;
	}
	
	/**
	 * Smelts the input main and second (if it's there) into a bar and yields smithing xp to the player smelting
	 */
	public void smeltItem()
	{
		ItemStack fuel = this.furnaceInventory[0];
		ItemStack inputMain = this.furnaceInventory[1];
		ItemStack inputSecond = this.furnaceInventory[2];
		ItemStack output = this.furnaceInventory[3];
		
		if (this.canSmelt())
		{
			ItemStack itemstack = this.getResult(inputMain, inputSecond);
			
			if (itemstack == null)
			{
				LogHelper.error("Return value is null and there is therefore no output for the furnace");
			}
			else
			{
				if (output == null)
				{
					output = itemstack.copy();
				}
				else if (output.isItemEqual(itemstack))
				{
					output.stackSize += itemstack.stackSize;
				}
				
				--fuel.stackSize;
				--inputMain.stackSize;
				if (inputSecond != null) --inputSecond.stackSize;
				
				if (fuel.stackSize <= 0)
				{
					fuel = null;
				}
				if (inputMain.stackSize <= 0)
				{
					inputMain = null;
				}
				if (inputSecond != null)
				{
					if (inputSecond.stackSize <= 0)
					{
						inputSecond = null;
					}
				}
			}
		}
	}
	
	@Override
	public int getSizeInventory() 
	{
		return this.furnaceInventory.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int slot) 
	{
		return this.furnaceInventory[slot];
	}
	
	@Override
	public ItemStack decrStackSize(int slot, int count) 
	{
		ItemStack itemstack = getStackInSlot(slot);
		
		if (itemstack != null)
		{
			// If when removing an itemstack from the inventory, is a left click (removing the itemstack completely) or (else) a right click (removing half of the contents)
			if (itemstack.stackSize <= count)
			{
				setInventorySlotContents(slot, null);
			}
			else
			{
				itemstack = itemstack.splitStack(count);
			}
		}
		return itemstack;
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) 
	{
		ItemStack itemstack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return itemstack;
	}
	
	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) 
	{
		this.furnaceInventory[slot] = itemstack;
		
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
		{
			itemstack.stackSize = getInventoryStackLimit();
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbttagcompound) 
	{
		super.writeToNBT(nbttagcompound);
		
		NBTTagList list = new NBTTagList();
		
		for (int i = 0; i < getSizeInventory(); i++)
		{
			ItemStack itemstack = getStackInSlot(i);
			
			if (itemstack != null)
			{
				NBTTagCompound item = new NBTTagCompound();
				
				item.setByte("SlotRSFurnace", (byte) i);
				itemstack.writeToNBT(item);
				
				list.appendTag(item);
			}
		}
		
		nbttagcompound.setTag("ItemsRSFurnace", list);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound) 
	{
		super.readFromNBT(nbttagcompound);
		
		NBTTagList list = nbttagcompound.getTagList("ItemsRSFurnace", 10);

		for (int i = 0; i < list.tagCount(); i++)
		{
			NBTTagCompound item = (NBTTagCompound) list.getCompoundTagAt(i);
			int slot = item.getByte("SlotRSFurnace");

			if (slot >= 0 && slot < getSizeInventory())
			{
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}
	
	@Override
	public String getInventoryName() 
	{
		return "RCM - Furnace";
	}
	
	@Override
	public boolean hasCustomInventoryName() 
	{
		return true;
	}
	
	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
	}
	
	@Override
	public void openInventory() 
	{
		
	}
	
	@Override
	public void closeInventory() 
	{
		
	}
	
	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) 
	{
		return true;
	}
}