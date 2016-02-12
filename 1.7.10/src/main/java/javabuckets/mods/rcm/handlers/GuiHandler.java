package javabuckets.mods.rcm.handlers;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import javabuckets.mods.rcm.blocks.containers.ContainerRSFurnace;
import javabuckets.mods.rcm.blocks.tileentities.TileEntityRSFurnace;
import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.skills.smithing.GUIRSFurnace;
import javabuckets.mods.rcm.skills.smithing.ModSmithingBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getTileEntity(x, y, z);
		
		switch (ID)
		{
		case 0:
			if (entity != null && entity instanceof TileEntityRSFurnace) return new ContainerRSFurnace(player.inventory, (TileEntityRSFurnace) entity);
			else return null;
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		TileEntity entity = world.getTileEntity(x, y, z);
		
		switch (ID)
		{
		case 0:
			if (entity != null && entity instanceof TileEntityRSFurnace) return new GUIRSFurnace(player.inventory, (TileEntityRSFurnace) entity);
			else return null;
		default:
			return null;
		}
	}
}