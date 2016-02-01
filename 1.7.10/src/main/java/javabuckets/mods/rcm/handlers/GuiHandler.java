package javabuckets.mods.rcm.handlers;

import javabuckets.mods.rcm.skills.combat.GUICombatSelection;
import javabuckets.mods.rcm.skills.smithing.GUIRSFurnace;
import javabuckets.mods.rcm.skills.smithing.ModSmithingBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		
		switch(ID)
		{	
			//case 0: return ID == 0 && world.getBlock(x, y, z) == ModBlocks.crystalCharger ? new ContainerCharger(player.inventory, (TileEntityCharger)tile_entity) : null;
			//case 1: return ID == 1 && world.getBlock(x, y, z) == ModBlocks.weaponForge ? new ContainerWeaponForge(player.inventory, world, x, y, z) : null;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity tile_entity = world.getTileEntity(x, y, z);
		
		switch(ID)
		{		
			//case 0: return ID == 0 && world.getBlock(x, y, z) == ModBlocks.crystalCharger ? new GuiCharger(player.inventory, (TileEntityCharger)tile_entity) : null;
			//case 1: return ID == 1 && world.getBlock(x, y, z) == ModBlocks.weaponForge ? new GuiWeaponForge(player.inventory, world, x, y, z) : null;
			case 1: return ID == 1 && world.getBlock(x, y, z) == ModSmithingBlocks.rsFurnace ? new GUIRSFurnace(player) : null;
		}
		return null;
	}

}