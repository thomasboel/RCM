package javabuckets.mods.rcm.utility;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class UtilAPI 
{
	public static int getAmountOfItemInInventory(InventoryPlayer inventory, String itemDisplayName)
	{
		int amount = 0;
		
		for (int i = 0; i < inventory.mainInventory.length; i++)
		{
			if (inventory.getStackInSlot(i) != null && inventory.mainInventory[i].getDisplayName().equals(itemDisplayName))
			{
				amount += inventory.mainInventory[i].stackSize;
			}
		}
		
		return amount;
	}
}