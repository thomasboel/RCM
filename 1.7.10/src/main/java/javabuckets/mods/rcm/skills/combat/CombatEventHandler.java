package javabuckets.mods.rcm.skills.combat;

import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.utility.LogHelper;
import javabuckets.mods.rcm.utility.SkillReference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CombatEventHandler 
{
	@SubscribeEvent
	public void onEntityHitBeforeDmgIsApplied(LivingAttackEvent event)
	{
		/*if (event.entity instanceof EntitySlayerMaster)
		{
			event.setCanceled(true);
		}*/
		
		if (event.source.getDamageType().equals("player"))
		{
			addSwordFromLevel(event, Items.stone_sword, 5);
			addSwordFromLevel(event, Items.stone_axe, 5);
			addSwordFromLevel(event, Items.stone_pickaxe, 5);
			addSwordFromLevel(event, Items.stone_shovel, 5);

			addSwordFromLevel(event, Items.iron_sword, 10);
			addSwordFromLevel(event, Items.iron_axe, 10);
			addSwordFromLevel(event, Items.iron_pickaxe, 10);
			addSwordFromLevel(event, Items.iron_shovel, 10);

//			addSwordFromLevel(event, 3257, 20); //Steel
//			addSwordFromLevel(event, 3267, 20);
//			addSwordFromLevel(event, 4057, 20);
//			addSwordFromLevel(event, 4067, 20);
//
//			addSwordFromLevel(event, 3258, 25); //Black
//			addSwordFromLevel(event, 3268, 25);
//			addSwordFromLevel(event, 4068, 25);
//
//			addSwordFromLevel(event, 3259, 25); //White
//			addSwordFromLevel(event, 3269, 25);

			addSwordFromLevel(event, Items.diamond_sword, 27);
			addSwordFromLevel(event, Items.diamond_axe, 27);
			addSwordFromLevel(event, Items.diamond_pickaxe, 27);
			addSwordFromLevel(event, Items.diamond_shovel, 27);

//			addSwordFromLevel(event, 3260, 30); //Mithril
//			addSwordFromLevel(event, 3270, 30);
//			addSwordFromLevel(event, 4058, 30);
//			addSwordFromLevel(event, 4069, 30);
//
//			addSwordFromLevel(event, 3261, 40); //Adamant
//			addSwordFromLevel(event, 3271, 40);
//			addSwordFromLevel(event, 4059, 40);
//			addSwordFromLevel(event, 4070, 40);
//
//			addSwordFromLevel(event, 3262, 50); //Rune
//			addSwordFromLevel(event, 3272, 50);
//			addSwordFromLevel(event, 4060, 50);
//			addSwordFromLevel(event, 4071, 50);
//
//			addSwordFromLevel(event, 3273, 60); //Dragon
//			addSwordFromLevel(event, 4061, 60);
//			addSwordFromLevel(event, 4072, 60);
		}
	}

	public void addSwordFromLevel(LivingAttackEvent event, Item sword, int attackLevelRequired)
	{
		EntityPlayer player = (EntityPlayer)Minecraft.getMinecraft().thePlayer;
		ItemStack heldItem = player.getHeldItem();
		int attackLevel = RCM.instance.skillHandler.getLevel(SkillReference.att);

		if (event.source.getDamageType().equals("player"))
		{
			if (heldItem != null && heldItem.getItem() == sword && attackLevel < attackLevelRequired && !player.capabilities.isCreativeMode)
			{
				event.setCanceled(true);
				player.addChatMessage(new ChatComponentText("You need a level of atleast " + attackLevelRequired + " in Attack to use this weapon!"));
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event)
	{	
		if (!(event.entity instanceof EntityPlayer))
		{

			EntityLiving entity = (EntityLiving)event.entity;

			double xp = 0;

			if (event.entity instanceof EntityBat) { xp = 10D; }
			else if (event.entity instanceof EntityChicken) { xp = 15D; }
			else if (event.entity instanceof EntityCow || event.entity instanceof EntityMooshroom) { xp = 20D; }
			else if (event.entity instanceof EntityOcelot) { xp = 15D; }
			else if (event.entity instanceof EntityPig) { xp = 15D; }
			else if (event.entity instanceof EntitySheep) { xp = 15D; }
			else if (event.entity instanceof EntityHorse) { xp = 25D; }
			else if (event.entity instanceof EntityWolf) { xp = 20D; }
			else if (event.entity instanceof EntityBlaze) { xp = 50D; }
			else if (event.entity instanceof EntityCaveSpider) { xp = 33D; }
			else if (event.entity instanceof EntityCreeper) { xp = 50D; }
			else if (event.entity instanceof EntityEnderman) { xp = 75D; }
			else if (event.entity instanceof EntityGhast) { xp = 100D; }
			else if (event.entity instanceof EntityGiantZombie) { xp = 1000D; }
			else if (event.entity instanceof EntityIronGolem) { xp = 100D; }
			else if (event.entity instanceof EntityMagmaCube) { xp = 75D; }
			else if (event.entity instanceof EntityPigZombie) { xp = 60D; }
			else if (event.entity instanceof EntitySilverfish) { xp = 45D; }
			else if (event.entity instanceof EntitySkeleton) { xp = 70D; }
			else if (event.entity instanceof EntitySlime) { xp = 33D; }
			else if (event.entity instanceof EntitySpider) { xp = 65D; }
			else if (event.entity instanceof EntityWitch) { xp = 75D; }
			else if (event.entity instanceof EntityZombie) { xp = 60D; }
			else if (event.entity instanceof EntityDragon) { xp = 100000D; }
			else if (event.entity instanceof EntityWither) { xp = 15000D; }
			else { xp = 0D; }

			// Attack, Strength & Defence
			if (event.source.getDamageType().equals("player") && !event.source.isMagicDamage() && !event.source.isProjectile())
			{
				CombatHandler.isCombating = true;
				
				if (event.entity instanceof EntityLiving) 
				{				
					if (RCM.instance.combat.getIsTrainingAttackMelee())
					{
						RCM.instance.skillHandler.addXPToCombatSkill("attack", xp);
					}
					if (RCM.instance.combat.getIsTrainingStrengthMelee())
					{
						RCM.instance.skillHandler.addXPToCombatSkill("strength", xp);
					}
					if (RCM.instance.combat.getIsTrainingDefenceMelee())
					{
						RCM.instance.skillHandler.addXPToCombatSkill("defence", xp);
					}
				}
			}

			// Magic
			else if (event.source.isMagicDamage())
			{
				CombatHandler.isCombating = true;
				
				if (event.entity instanceof EntityLiving) 
				{
					if (RCM.instance.combat.getIsTrainingMagicMaging())
					{
						RCM.instance.skillHandler.addXPToCombatSkill("magic", xp);
					}
					if (RCM.instance.combat.getIsTrainingDefenceMaging())
					{
						RCM.instance.skillHandler.addXPToCombatSkill("defence", xp);
					}
				}
			}

			// Ranged
			else if (event.source.isProjectile())
			{
				CombatHandler.isCombating = true;
				
				if (event.entity instanceof EntityLiving) 
				{
					
					
					if (RCM.instance.combat.getIsTrainingRangedRanging())
					{
						RCM.instance.skillHandler.addXPToCombatSkill("ranged", xp);
					}
					
					if (RCM.instance.combat.getIsTrainingStrengthRanging())
					{
						RCM.instance.skillHandler.addXPToCombatSkill("strength", xp);
					}
					
					if (RCM.instance.combat.getIsTrainingDefenceRanging())
					{
						RCM.instance.skillHandler.addXPToCombatSkill("defence", xp);
					}
				}
			}
		}
	}
}
