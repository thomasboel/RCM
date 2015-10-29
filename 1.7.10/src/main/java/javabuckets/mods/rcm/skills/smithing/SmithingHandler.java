package javabuckets.mods.rcm.skills.smithing;

import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.skills.BaseSkill;
import javabuckets.mods.rcm.utility.LevelUpUtil;
import javabuckets.mods.rcm.utility.SkillReference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class SmithingHandler extends BaseSkill
{
	public boolean running = false;
	private int resetTimer = 5;
	
	public boolean isSmithing = false;
	private int smithingResetTimer = 10;

	public void smithing(EntityPlayer player, World world) 
	{
		setLvlFromXPList();
		smithingChecker();
		smithingUpdater();
	}

	public void smithingChecker()
	{
		if (isSmithing)
		{
			--smithingResetTimer;

			if (smithingResetTimer <= 0)
			{
				isSmithing = false;
				smithingResetTimer = 10;
			}
		}
	}
	
	public void smithingUpdater()
	{
		if (running)
		{
			resetTimer--;
		}
		
		if (resetTimer <= 0)
		{
			running = false;
			resetTimer = 5;
		}
	}

	public void setLvlFromXPList()
	{
		if (isSmithing)
		{
			for (int i = 1; i <= 120; i++)
			{
				setLvlFromXP(SkillReference.getXpFromLvl(i), SkillReference.getXpFromLvl(i+1), i);
			}

			setbackXPIfTooHigh(200000000D);
			setbackLvlIfTooHigh(99);
			
			if (!(LevelUpUtil.getLevel(SkillReference.smith) == RCM.instance.skillHandler.getLevel(SkillReference.smith)))
			{
				RCM.instance.skillHandler.levelUp(SkillReference.smith, RCM.instance.skillHandler.getLevel(SkillReference.smith));
				LevelUpUtil.lvlHandling();
			}
		}
	}

	public void setLvlFromXP(double xpMin, double xpMax, int level) 
	{
		if (RCM.instance.skillHandler.getExperience(SkillReference.smith) > xpMin && RCM.instance.skillHandler.getExperience(SkillReference.smith) < xpMax)
		{
			RCM.instance.skillHandler.setLevel(SkillReference.smith, level, RCM.instance.skillHandler.getExperience(SkillReference.smith));
		}
	}

	public void setbackLvlIfTooHigh(int level) 
	{
		if (RCM.instance.skillHandler.getLevel(SkillReference.smith) > level) 
		{
			RCM.instance.skillHandler.setLevel(SkillReference.smith, level, RCM.instance.skillHandler.getExperience(SkillReference.smith));
		}
	}

	public void setbackXPIfTooHigh(double xp) 
	{
		if (RCM.instance.skillHandler.getExperience(SkillReference.smith) > xp)
		{
			RCM.instance.skillHandler.setExperience(SkillReference.smith, xp);
		}
	}
}