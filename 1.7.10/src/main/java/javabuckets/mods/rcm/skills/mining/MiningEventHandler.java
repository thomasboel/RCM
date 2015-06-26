package javabuckets.mods.rcm.skills.mining;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
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

public class MiningEventHandler 
{
	private boolean canPlayerUseWoodPickaxe;
	private boolean canPlayerUseGoldPickaxe;
	private boolean canPlayerUseStonePickaxe;
	private boolean canPlayerUseBronzePickaxe;
	private boolean canPlayerUseIronPickaxe;
	private boolean canPlayerUseSteelPickaxe;
	private boolean canPlayerUseDiamondPickaxe;
	private boolean canPlayerUseMithrilPickaxe;
	private boolean canPlayerUseAdamantPickaxe;
	private boolean canPlayerUseRunePickaxe;
	private boolean canPlayerUseDragonPickaxe;
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			canPlayerUseWoodPickaxe = isPickaxeUsable(event, Items.wooden_pickaxe, 1);
			canPlayerUseGoldPickaxe = isPickaxeUsable(event, Items.golden_pickaxe, 1);
			canPlayerUseStonePickaxe = isPickaxeUsable(event, Items.stone_pickaxe, 3);
			//canPlayerUseBronzePickaxe = isPickaxeUsable(event, 4056, 5);
			canPlayerUseIronPickaxe = isPickaxeUsable(event, Items.iron_pickaxe, 10);
			//canPlayerUseSteelPickaxe = isPickaxeUsable(event, 4057, 15);
			canPlayerUseDiamondPickaxe = isPickaxeUsable(event, Items.diamond_pickaxe, 20);
			//canPlayerUseMithrilPickaxe = isPickaxeUsable(event, 4058, 25);
			//canPlayerUseAdamantPickaxe = isPickaxeUsable(event, 4059, 31);
			//canPlayerUseRunePickaxe = isPickaxeUsable(event, 4060, 41);
			//canPlayerUseDragonPickaxe = isPickaxeUsable(event, 4061, 61);
		}
	}

	public boolean isPickaxeUsable(LivingUpdateEvent event, Item pickaxe, int requiredLevel)
	{
		EntityPlayer player = (EntityPlayer)event.entity;
		ItemStack heldItem = player.getHeldItem();

		if (heldItem != null && heldItem.getItem() == pickaxe && RCM.instance.skillHandler.getMiningLvl() >= requiredLevel)
		{
			return true;
		}
		else if (heldItem != null && heldItem.getItem() == pickaxe && RCM.instance.skillHandler.getMiningLvl() < requiredLevel)
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
			MiningHandler.isMining = true;
		
			addMiningXpFromBlock(event, Blocks.stone, 1, 3);
			//addMiningXpFromBlock(event, ModSkillBlocks.copperOre, 1, 7.5);
			//addMiningXpFromBlock(event, ModSkillBlocks.tinOre, 1, 7.5);
			addMiningXpFromBlock(event, Blocks.coal_ore, 5, 15);
			addMiningXpFromBlock(event, Blocks.iron_ore, 15, 37.5);
			//addMiningXpFromBlock(event, ModSkillBlocks.silverOre, 20, 42.5);
			addMiningXpFromBlock(event, Blocks.lapis_ore, 20, 50);
			addMiningXpFromBlock(event, Blocks.gold_ore, 25, 75);
			addMiningXpFromBlock(event, Blocks.redstone_ore, 30, 60);
			addMiningXpFromBlock(event, Blocks.diamond_ore, 30, 150);
			addMiningXpFromBlock(event, Blocks.emerald_ore, 50, 200);
			//addMiningXpFromBlock(event, ModSkillBlocks.mithrilOre, 50, 250);
			//addMiningXpFromBlock(event, ModSkillBlocks.adamantiteOre, 70, 500);
			//addMiningXpFromBlock(event, ModSkillBlocks.runiteOre, 85, 1000);

			getPickaxeUsageFromLevel(event, Items.wooden_pickaxe, 1);
			getPickaxeUsageFromLevel(event, Items.golden_pickaxe, 1);
			getPickaxeUsageFromLevel(event, Items.stone_pickaxe, 3);
			//getPickaxeUsageFromLevel(event, 4056, 5);
			getPickaxeUsageFromLevel(event, Items.iron_pickaxe, 10);
			//getPickaxeUsageFromLevel(event, 4057, 15);
			getPickaxeUsageFromLevel(event, Items.diamond_pickaxe, 20);
			//getPickaxeUsageFromLevel(event, 4058, 25);
			//getPickaxeUsageFromLevel(event, 4059, 31);
			//getPickaxeUsageFromLevel(event, 4060, 41);
			//getPickaxeUsageFromLevel(event, 4061, 61);

			//replaceMininingDrops(event, Blocks.oreIron, ModMaterials.ironOre);
			//replaceMininingDrops(event, Blocks.oreGold, ModMaterials.goldOre);
		}
	}

	public void addMiningXpFromBlock(HarvestDropsEvent event, Block block, int requiredLevel, double xp)
	{
		if (canPlayerUsePickaxe())
		{
			if (event.block == block && RCM.instance.skillHandler.getMiningLvl() >= requiredLevel)
			{
				RCM.instance.skillHandler.addXPToSkill("mining", xp);
			}
			else if (event.block == block && RCM.instance.skillHandler.getMiningLvl() < requiredLevel)
			{
				event.dropChance = 0.00F;
				Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You need a Level of at least: " + requiredLevel + " in Mining, to mine this ore!"));
				event.world.setBlock(event.x, event.y, event.z, block);
			}
		}
	}

	public void getPickaxeUsageFromLevel(HarvestDropsEvent event, Item pickaxe, int requiredLevel)
	{
		EntityPlayer player = event.harvester;
		ItemStack heldItem = player.getHeldItem();

		if (heldItem != null && heldItem.getItem() == pickaxe && RCM.instance.skillHandler.getMiningLvl() >= requiredLevel)
		{

		}
		else if (heldItem != null && heldItem.getItem() == pickaxe && RCM.instance.skillHandler.getMiningLvl() < requiredLevel)
		{
			event.dropChance = 0.00F;
			Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You need a Level of at least: " + requiredLevel + " in Mining, to use this pickaxe!"));
			event.world.setBlock(event.x, event.y, event.z, event.block);
		}
	}

	public void replaceMininingDrops(HarvestDropsEvent event, Block block, Item item)
	{
		if (event.block == block)
		{
			event.drops.clear();
			event.drops.add(new ItemStack(item));
		}
	}
	
	public boolean canPlayerUsePickaxe()
	{
		if (canPlayerUseWoodPickaxe || canPlayerUseGoldPickaxe || canPlayerUseStonePickaxe || canPlayerUseBronzePickaxe || canPlayerUseIronPickaxe || canPlayerUseSteelPickaxe || canPlayerUseDiamondPickaxe || canPlayerUseMithrilPickaxe || canPlayerUseAdamantPickaxe || canPlayerUseRunePickaxe || canPlayerUseDragonPickaxe)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}