package javabuckets.mods.rcm.skills.farming;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import javabuckets.mods.rcm.init.ModFixBlocks;
import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.utility.SkillReference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class FarmingEventHandler 
{
	@SubscribeEvent
	public void onHarvest(HarvestDropsEvent event)
	{
		addXPOnHarvest(event, Blocks.wheat, 7, 1, 8.5);
		addXPOnHarvest(event, Blocks.potatoes, 7, 1, 9.2);
		addXPOnHarvest(event, Blocks.carrots, 7, 1, 9.2);
		addXPOnHarvest(event, Blocks.pumpkin, 1, 14.5);
		addXPOnHarvest(event, Blocks.melon_block, 47, 55);
		addXPOnHarvest(event, Blocks.cocoa, 1, 2, 10.4);
		
		replaceFarmingDrops(event, Blocks.pumpkin, ModFixBlocks.pumpkin);
	}

	public void addXPOnHarvest(HarvestDropsEvent event, Block block, int requiredLvl, double xp)
	{
		if (event.harvester instanceof EntityPlayer)
		{
			RCM.instance.farming.isFarming = true;
			
			if (event.block == block && RCM.instance.skillHandler.getLevel(SkillReference.farm) >= requiredLvl)
			{
				RCM.instance.skillHandler.addXPToSkill(SkillReference.farm, xp);
			}
			else if (event.block == block && RCM.instance.skillHandler.getLevel(SkillReference.farm) < requiredLvl)
			{
				event.dropChance = 0.00F;
				Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You need a level of at least: " + requiredLvl + " in Farming, to harvest this crop!"));
				event.world.setBlock(event.x, event.y, event.z, event.block, event.blockMetadata, 2);
			}
		}
	}
	
	public void addXPOnHarvest(HarvestDropsEvent event, Block block, int metadata, int requiredLvl, double xp)
	{
		if (event.harvester instanceof EntityPlayer)
		{
			RCM.instance.farming.isFarming = true;
			
			if (event.block == block && event.blockMetadata >= metadata && RCM.instance.skillHandler.getLevel(SkillReference.farm) >= requiredLvl)
			{
				RCM.instance.skillHandler.addXPToSkill(SkillReference.farm, xp);
			}
			else if (event.block == block && event.blockMetadata >= metadata && RCM.instance.skillHandler.getLevel(SkillReference.farm) < requiredLvl)
			{
				event.dropChance = 0.00F;
				Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You need a level of at least: " + requiredLvl + " in Farming, to harvest this crop!"));
				event.world.setBlock(event.x, event.y, event.z, event.block, event.blockMetadata, 2);
			}
		}
	}
	
	public void replaceFarmingDrops(HarvestDropsEvent event, Block block, Block newBlock)
	{
		if (event.block == block)
		{
			event.drops.clear();
			event.drops.add(new ItemStack(newBlock));
		}
	}
	
	public void replaceFarmingDrops(HarvestDropsEvent event, Block block, Item item)
	{
		if (event.block == block)
		{
			event.drops.clear();
			event.drops.add(new ItemStack(item));
		}
	}
}