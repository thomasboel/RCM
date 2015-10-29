package javabuckets.mods.rcm.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import javabuckets.mods.rcm.blocks.tileentities.*;
import javabuckets.mods.rcm.renderers.*;
import javabuckets.mods.rcm.skills.prayer.ModPrayerBlocks;
import javabuckets.mods.rcm.skills.summoning.ModSummoningBlocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy 
{
	@SideOnly(Side.CLIENT)
	public void proxy() 
	{
		GameRegistry.registerTileEntity(TileEntitySummoningObelisk.class, "summoning_obelisk");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySummoningObelisk.class, new RenderSummoningObelisk());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModSummoningBlocks.summoningObelisk), new ItemRenderSummoningObelisk());
		
		GameRegistry.registerTileEntity(TileEntityPrayerAltar.class, "prayer_altar");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPrayerAltar.class, new RenderPrayerAltar());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModPrayerBlocks.prayerAltar), new ItemRenderPrayerAltar());
	}
}
