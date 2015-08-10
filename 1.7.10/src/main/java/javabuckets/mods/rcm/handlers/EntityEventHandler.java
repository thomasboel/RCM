package javabuckets.mods.rcm.handlers;

import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.skills.prayer.ModPrayerItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityEventHandler 
{
	@SubscribeEvent
	public void entityDrops(LivingDropsEvent event)
	{
		if (event.entity instanceof EntityAnimal || event.entity instanceof EntityMob) {
			addDropToEntity(event, 1.00D, ModPrayerItems.bones, 1); }

		if (event.entity instanceof EntityWither) 
		{
			for (int i = 0; i < 15; ++i)
			{
				addDropToEntity(event, 1.00D, ModPrayerItems.bigBones, 1);	
			} 

			//addDropToEntity(event, 0.05, 4072, 1);
		}

		if (event.entity instanceof EntityDragon) 
		{
			for (int i = 0; i < 20; ++i)
			{
				addDropToEntity(event, 1.00D, ModPrayerItems.dragonBones, 1); 
			}

			//addDropToEntity(event, 0.5, 4061, 1);
			//addDropToEntity(event, 0.3, 4072, 1);
			//addDropToEntity(event, 0.5, 3273, 1);
		}
	}

	public void addDropToEntity(LivingDropsEvent event, double chance, Item item, int count)
	{
		if (event.source.getDamageType().equals("player"))
		{
			double rand = Math.random();

			if (event.entity instanceof Entity)
			{
				if (rand < chance)
				{
					event.entity.dropItem(item, count);
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event)
	{
		if (event.source.getDamageType().equals("player") || event.source.isProjectile())
		{
			if (event.entity instanceof EntityMob) 
			{
				addGpDropWithChance(0.5D, 18);
				addGpDropWithChance(0.2D, 12);
				addGpDropWithChance(0.1D, 33);
				addGpDropWithChance(0.075D, 176);
			}
			
			if (event.entity instanceof EntityWither) 
			{
				addGpDropWithChance(1D, 15000);
			}
			
			if (event.entity instanceof EntityDragon) 
			{
				addGpDropWithChance(1D, 250000);
			}
		}
	}

	public void addGpDropWithChance(double chance, long gp) 
	{
		double rand = Math.random();

		if (rand < chance)
		{
			RCM.instance.gpHandler.setGoldPointsInPouch(RCM.instance.gpHandler.getGoldPointsInPouch() + gp);
		}
	}

	public void addRandomGpWithChance(LivingDropsEvent event, double differentDrops, double chance, long gp) 
	{

	}

	public void addRandomGp(LivingDropsEvent event, double differentDrops, long gp)
	{

	}
}
