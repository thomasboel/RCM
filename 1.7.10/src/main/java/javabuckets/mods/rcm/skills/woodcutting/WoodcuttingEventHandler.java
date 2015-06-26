package javabuckets.mods.rcm.skills.woodcutting;

import javabuckets.mods.rcm.init.ModFixBlocks;
import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class WoodcuttingEventHandler 
{	
	private boolean canPlayerUseWoodAxe;
	private boolean canPlayerUseGoldAxe;
	private boolean canPlayerUseStoneAxe;
	private boolean canPlayerUseBronzeAxe;
	private boolean canPlayerUseIronAxe;
	private boolean canPlayerUseSteelAxe;
	private boolean canPlayerUseBlackAxe;
	private boolean canPlayerUseDiamondAxe;
	private boolean canPlayerUseMithrilAxe;
	private boolean canPlayerUseAdamantAxe;
	private boolean canPlayerUseRuneAxe;
	private boolean canPlayerUseDragonAxe;

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			canPlayerUseWoodAxe = isHatchetUsable(event, Items.wooden_axe, 1);
			canPlayerUseGoldAxe = isHatchetUsable(event, Items.golden_axe, 1);
			canPlayerUseStoneAxe = isHatchetUsable(event, Items.stone_axe, 3);
			//canPlayerUseBronzeAxe = isHatchetUsable(event, 4066, 5);
			canPlayerUseIronAxe = isHatchetUsable(event, Items.iron_axe, 10);
			//canPlayerUseSteelAxe = isHatchetUsable(event, 4067, 15);
			//canPlayerUseBlackAxe = isHatchetUsable(event, 4068, 18);
			canPlayerUseDiamondAxe = isHatchetUsable(event, Items.diamond_axe, 21);
			//canPlayerUseMithrilAxe = isHatchetUsable(event, 4069, 25);
			//canPlayerUseAdamantAxe = isHatchetUsable(event, 4070, 31);
			//canPlayerUseRuneAxe = isHatchetUsable(event, 4071, 41);
			//canPlayerUseDragonAxe = isHatchetUsable(event, 4072, 61);
		}
	}

	public boolean isHatchetUsable(LivingUpdateEvent event, Item hatchet, int requiredLevel)
	{
		EntityPlayer player = (EntityPlayer)event.entity;
		ItemStack heldItem = player.getHeldItem();

		if (heldItem != null && heldItem.getItem() == hatchet && RCM.instance.skillHandler.getWoodcuttingLvl() >= requiredLevel)
		{
			return true;
		}
		else if (heldItem != null && heldItem.getItem() == hatchet && RCM.instance.skillHandler.getWoodcuttingLvl() < requiredLevel)
		{
			return false;
		}
		else 
		{
			return false;
		}
	}

	@SubscribeEvent
	public void BlockHarvestChecker(HarvestDropsEvent event)
	{
		if (event.harvester instanceof EntityPlayer)
		{
			WoodcuttingHandler.isWoodcutting = true;

			addWoodcuttingXpFromTreeBlock(event, Blocks.log, 1, 15);
			addWoodcuttingXpFromTreeBlock(event, Blocks.log2, 1, 15);
			addWoodcuttingXpFromTreeBlock(event, Blocks.leaves, 1, 1);
			addWoodcuttingXpFromTreeBlock(event, Blocks.leaves2, 1, 1);

			getHatchetUsageFromLevel(event, Items.wooden_axe, 1);
			getHatchetUsageFromLevel(event, Items.golden_axe, 1);
			getHatchetUsageFromLevel(event, Items.stone_axe, 3);
			//getHatchetUsageFromLevel(event, 4066, 5);
			getHatchetUsageFromLevel(event, Items.iron_axe, 10);
			//getHatchetUsageFromLevel(event, 4067, 15);
			//getHatchetUsageFromLevel(event, 4068, 18);
			getHatchetUsageFromLevel(event, Items.diamond_axe, 21);
			//getHatchetUsageFromLevel(event, 4069, 25);
			//getHatchetUsageFromLevel(event, 4070, 31);
			//getHatchetUsageFromLevel(event, 4071, 41);
			//getHatchetUsageFromLevel(event, 4072, 61);
			
			replaceWoodcuttingDrops(event, Blocks.log, 0, ModFixBlocks.oakLog);
			replaceWoodcuttingDrops(event, Blocks.log, 4, ModFixBlocks.oakLog);
			replaceWoodcuttingDrops(event, Blocks.log, 8, ModFixBlocks.oakLog);
			replaceWoodcuttingDrops(event, Blocks.log, 12, ModFixBlocks.oakLog);
			replaceWoodcuttingDrops(event, Blocks.log, 1, ModFixBlocks.spruceLog);
			replaceWoodcuttingDrops(event, Blocks.log, 5, ModFixBlocks.spruceLog);
			replaceWoodcuttingDrops(event, Blocks.log, 9, ModFixBlocks.spruceLog);
			replaceWoodcuttingDrops(event, Blocks.log, 13, ModFixBlocks.spruceLog);
			replaceWoodcuttingDrops(event, Blocks.log, 2, ModFixBlocks.birchLog);
			replaceWoodcuttingDrops(event, Blocks.log, 6, ModFixBlocks.birchLog);
			replaceWoodcuttingDrops(event, Blocks.log, 10, ModFixBlocks.birchLog);
			replaceWoodcuttingDrops(event, Blocks.log, 14, ModFixBlocks.birchLog);
			replaceWoodcuttingDrops(event, Blocks.log, 3, ModFixBlocks.jungleLog);
			replaceWoodcuttingDrops(event, Blocks.log, 7, ModFixBlocks.jungleLog);
			replaceWoodcuttingDrops(event, Blocks.log, 11, ModFixBlocks.jungleLog);
			replaceWoodcuttingDrops(event, Blocks.log, 15, ModFixBlocks.jungleLog);
			replaceWoodcuttingDrops(event, Blocks.log2, 0, ModFixBlocks.acaciaLog);
			replaceWoodcuttingDrops(event, Blocks.log2, 4, ModFixBlocks.acaciaLog);
			replaceWoodcuttingDrops(event, Blocks.log2, 8, ModFixBlocks.acaciaLog);
			replaceWoodcuttingDrops(event, Blocks.log2, 12, ModFixBlocks.acaciaLog);	
			replaceWoodcuttingDrops(event, Blocks.log2, 1, ModFixBlocks.darkOakLog);
			replaceWoodcuttingDrops(event, Blocks.log2, 5, ModFixBlocks.darkOakLog);
			replaceWoodcuttingDrops(event, Blocks.log2, 9, ModFixBlocks.darkOakLog);
			replaceWoodcuttingDrops(event, Blocks.log2, 13, ModFixBlocks.darkOakLog);
		}
	}

	public void addWoodcuttingXpFromTreeBlock(HarvestDropsEvent event, Block block, int requiredLevel, int xp)
	{
		EntityPlayer player = (EntityPlayer)Minecraft.getMinecraft().thePlayer;
		ItemStack heldItem = player.getHeldItem();
		
		if (canPlayerUseHatchet())
		{
			if (event.block == block && RCM.instance.skillHandler.getWoodcuttingLvl() >= requiredLevel)
			{
				RCM.instance.skillHandler.addXPToSkill("woodcutting", xp);
			}
			else if (event.block == block && RCM.instance.skillHandler.getWoodcuttingLvl() < requiredLevel)
			{
				event.dropChance = 0.00F;
				Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You need a Level of at least: " + requiredLevel + " in Woodcutting, to chop this tree!"));
				event.world.setBlock(event.x, event.y, event.z, event.block, event.blockMetadata, 2);
			}
		}
		
		else if(heldItem == null || !isPlayerWieldingHatchet())
		{
			if (event.block == block && RCM.instance.skillHandler.getWoodcuttingLvl() == 1)
			{
				RCM.instance.skillHandler.addXPToSkill("woodcutting", xp);
			}
			else {}
		}
	}

	public void getHatchetUsageFromLevel(HarvestDropsEvent event, Item hatchet, int requiredLevel)
	{
		EntityPlayer player = (EntityPlayer)Minecraft.getMinecraft().thePlayer;
		ItemStack heldItem = player.getHeldItem();

		if (heldItem != null && heldItem.getItem() == hatchet && RCM.instance.skillHandler.getWoodcuttingLvl() >= requiredLevel)
		{

		}
		else if (heldItem != null && heldItem.getItem() == hatchet && RCM.instance.skillHandler.getWoodcuttingLvl() < requiredLevel)
		{
			event.dropChance = 0.00F;
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You need a Level of at least: " + requiredLevel + " in Woodcutting, to use this hatchet!"));
			event.world.setBlock(event.x, event.y, event.z, event.block, event.blockMetadata, 2);
		}
		else if (heldItem == null || !isPlayerWieldingHatchet())
		{
			if (RCM.instance.skillHandler.getWoodcuttingLvl() == 1)
			{
				
			}
			else
			{
				if (event.block == Blocks.log)
				{			
					event.dropChance = 0.00F;
					Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You must use a hatchet to chop tree's with!"));
					event.world.setBlock(event.x, event.y, event.z, event.block, event.blockMetadata, 2);
				}
			}
		}
	}
	
	public void replaceWoodcuttingDrops(HarvestDropsEvent event, Block block, int blockMetadata, Block newBlock)
	{
		if (event.block == block && event.blockMetadata == blockMetadata)
		{
			event.drops.clear();
			event.drops.add(new ItemStack(newBlock));
		}
	}
	
	public boolean canPlayerUseHatchet()
	{
		if (canPlayerUseWoodAxe || canPlayerUseGoldAxe || canPlayerUseStoneAxe || canPlayerUseBronzeAxe || canPlayerUseIronAxe || canPlayerUseSteelAxe || canPlayerUseBlackAxe || canPlayerUseDiamondAxe || canPlayerUseMithrilAxe || canPlayerUseAdamantAxe || canPlayerUseRuneAxe || canPlayerUseDragonAxe)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isPlayerWieldingHatchet()
	{
		EntityPlayer player = (EntityPlayer)Minecraft.getMinecraft().thePlayer;
		ItemStack heldItem = player.getHeldItem();
		
		if (heldItem != null)
		{
			if(heldItem.getItem() == Items.wooden_axe) { return true; }
			else if (heldItem.getItem() == Items.golden_axe) { return true; }
			else if (heldItem.getItem() == Items.stone_axe) { return true; }
			else if (heldItem.getItem() == Items.iron_axe) { return true; }
			else if (heldItem.getItem() == Items.diamond_axe) { return true; }
			else { return false; }
		}
		else
		{
			return false;
		}
	}
}