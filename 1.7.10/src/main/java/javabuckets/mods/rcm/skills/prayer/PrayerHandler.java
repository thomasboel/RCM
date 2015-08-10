package javabuckets.mods.rcm.skills.prayer;

import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.skills.BaseSkill;
import javabuckets.mods.rcm.utility.LevelUpUtil;
import javabuckets.mods.rcm.utility.LogHelper;
import javabuckets.mods.rcm.utility.SkillReference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

public class PrayerHandler extends BaseSkill
{
	public boolean isPraying = false;
	private int prayerResetTimer = 10;
	public boolean canPlayerBuryBone = true;

	public void prayer(EntityPlayer player, World world) 
	{		
		setLvlFromXPList();
		prayerChecker();
	}

	public void prayerChecker()
	{
		if (isPraying)
		{
			--prayerResetTimer;
			canPlayerBuryBone = false;
			
			if (prayerResetTimer <= 0)
			{
				isPraying = false;
				prayerResetTimer = 10;
				canPlayerBuryBone = true;
			}
		}
	}
	
	public void setLvlFromXPList()
	{
		if (isPraying)
		{
			setLvlFromXP(0D, 83D, 1);
			setLvlFromXP(83D, 174D, 2);
			setLvlFromXP(174D, 276D, 3);
			setLvlFromXP(276D, 388D, 4);
			setLvlFromXP(388D, 512D, 5);
			setLvlFromXP(512D, 650D, 6);
			setLvlFromXP(650D, 801D, 7);
			setLvlFromXP(801D, 969D, 8);
			setLvlFromXP(969D, 1154D, 9);
			setLvlFromXP(1154D, 1358D, 10);
			setLvlFromXP(1358D, 1584D, 11);
			setLvlFromXP(1584D, 1833D, 12);
			setLvlFromXP(1833D, 2107D, 13);
			setLvlFromXP(2107D, 2411D, 14);
			setLvlFromXP(2411D, 2746D, 15);
			setLvlFromXP(2746D, 3115D, 16);
			setLvlFromXP(3115D, 3523D, 17);
			setLvlFromXP(3523D, 3973D, 18);
			setLvlFromXP(3973D, 4470D, 19);
			setLvlFromXP(4470D, 5018D, 20);
			setLvlFromXP(5018D, 5624D, 21);
			setLvlFromXP(5624D, 6291D, 22);
			setLvlFromXP(6291D, 7028D, 23);
			setLvlFromXP(7028D, 7842D, 24);
			setLvlFromXP(7842D, 8740D, 25);
			setLvlFromXP(8740D, 9730D, 26);
			setLvlFromXP(9730D, 10824D, 27);
			setLvlFromXP(10824D, 12031D, 28);
			setLvlFromXP(12031D, 13363D, 29);
			setLvlFromXP(13363D, 14833D, 30);
			setLvlFromXP(14833D, 16456D, 31);
			setLvlFromXP(16456D, 18247D, 32);
			setLvlFromXP(18247D, 20224D, 33);
			setLvlFromXP(20224D, 22406D, 34);
			setLvlFromXP(22406D, 24815D, 35);
			setLvlFromXP(24815D, 27473D, 36);
			setLvlFromXP(27473D, 30408D, 37);
			setLvlFromXP(30408D, 33648D, 38);
			setLvlFromXP(33648D, 37224D, 39);
			setLvlFromXP(37224D, 41171D, 40);
			setLvlFromXP(41171D, 45529D, 41);
			setLvlFromXP(45529D, 50339D, 42);
			setLvlFromXP(50339D, 55649D, 43);
			setLvlFromXP(55649D, 61512D, 44);
			setLvlFromXP(61512D, 67983D, 45);
			setLvlFromXP(67983D, 75127D, 46);
			setLvlFromXP(75127D, 83014D, 47);
			setLvlFromXP(83014D, 91721D, 48);
			setLvlFromXP(91721D, 101333D, 49);
			setLvlFromXP(101333D, 111945D, 50);
			setLvlFromXP(111945D, 123660D, 51);
			setLvlFromXP(123660D, 136594D, 52);
			setLvlFromXP(136594D, 150872D, 53);
			setLvlFromXP(150872D, 166636D, 54);
			setLvlFromXP(166636D, 184040D, 55);
			setLvlFromXP(184040D, 203254D, 56);
			setLvlFromXP(203254D, 224466D, 57);
			setLvlFromXP(224466D, 247886D, 58);
			setLvlFromXP(247886D, 273742D, 59);
			setLvlFromXP(273742D, 302288D, 60);
			setLvlFromXP(302288D, 333804D, 61);
			setLvlFromXP(333804D, 368599D, 62);
			setLvlFromXP(368599D, 407015D, 63);
			setLvlFromXP(407015D, 449428D, 64);
			setLvlFromXP(449428D, 496254D, 65);
			setLvlFromXP(496254D, 547953D, 66);
			setLvlFromXP(547953D, 605032D, 67);
			setLvlFromXP(605032D, 668051D, 68);
			setLvlFromXP(668051D, 737627D, 69);
			setLvlFromXP(737627D, 814445D, 70);
			setLvlFromXP(814445D, 899257D, 71);
			setLvlFromXP(899257D, 992895D, 72);
			setLvlFromXP(992895D, 1096278D, 73);
			setLvlFromXP(1096278D, 1210421D, 74);
			setLvlFromXP(1210421D, 1336443D, 75);
			setLvlFromXP(1336443D, 1475581D, 76);
			setLvlFromXP(1475581D, 1629200D, 77);
			setLvlFromXP(1629200D, 1798808D, 78);
			setLvlFromXP(1798808D, 1986068D, 79);
			setLvlFromXP(1986068D, 2192818D, 80);
			setLvlFromXP(2192818D, 2421087D, 81);
			setLvlFromXP(2421087D, 2673114D, 82);
			setLvlFromXP(2673114D, 2951373D, 83);
			setLvlFromXP(2951373D, 3258594D, 84);
			setLvlFromXP(3258594D, 3597792D, 85);
			setLvlFromXP(3597792D, 3972294D, 86);
			setLvlFromXP(3972294D, 4385776D, 87);
			setLvlFromXP(4385776D, 4842295D, 88);
			setLvlFromXP(4842295D, 5346332D, 89);
			setLvlFromXP(5346332D, 5902831D, 90);
			setLvlFromXP(5902831D, 6517253D, 91);
			setLvlFromXP(6517253D, 7195629D, 92);
			setLvlFromXP(7195629D, 7944614D, 93);
			setLvlFromXP(7944614D, 8771558D, 94);
			setLvlFromXP(8771558D, 9684577D, 95);
			setLvlFromXP(9684577D, 10692629D, 96);
			setLvlFromXP(10692629D, 11805606D, 97);
			setLvlFromXP(11805606D, 13034431D, 98);
			setLvlFromXP(13034431D, 200000000D, 99);

			setbackXPIfTooHigh(200000000D);
			setbackLvlIfTooHigh(99);
			
			if (!(LevelUpUtil.prayerLvl == RCM.instance.skillHandler.getLevel(SkillReference.pray)))
			{
				RCM.instance.skillHandler.levelUp(SkillReference.pray, RCM.instance.skillHandler.getLevel(SkillReference.pray));
				LevelUpUtil.lvlHandling();
			}
		}
	}

	public void setLvlFromXP(double xpMin, double xpMax, int level) 
	{
		if (RCM.instance.skillHandler.getExperience(SkillReference.pray) > xpMin && RCM.instance.skillHandler.getExperience(SkillReference.pray) < xpMax)
		{
			RCM.instance.skillHandler.setLevel(SkillReference.pray, level, RCM.instance.skillHandler.getExperience(SkillReference.pray));
		}
	}

	public void setbackLvlIfTooHigh(int level) 
	{
		if (RCM.instance.skillHandler.getLevel(SkillReference.pray) > level) 
		{
			RCM.instance.skillHandler.setLevel(SkillReference.pray, level, RCM.instance.skillHandler.getExperience(SkillReference.pray));
		}
	}

	public void setbackXPIfTooHigh(double xp) 
	{
		if (RCM.instance.skillHandler.getExperience(SkillReference.pray) > xp)
		{
			RCM.instance.skillHandler.setExperience(SkillReference.pray, xp);
		}
	}
}