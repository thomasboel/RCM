package javabuckets.mods.rcm.skills.combat;

import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.skills.BaseSkill;
import javabuckets.mods.rcm.utility.LevelUpUtil;
import javabuckets.mods.rcm.utility.LogHelper;
import javabuckets.mods.rcm.utility.SkillReference;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class CombatHandler extends BaseSkill
{
	public static boolean isCombating = false;
	private int combatingResetTimer = 10;
	
	private boolean isTrainingAttackMelee = true;
	private boolean isTrainingStrengthMelee = false;
	private boolean isTrainingDefenceMelee = false;
	
	private boolean isTrainingMagicMaging = true;
	private boolean isTrainingDefenceMaging = false;
	
	private boolean isTrainingRangedRanging = true;
	private boolean isTrainingStrengthRanging = false;
	private boolean isTrainingDefenceRanging = false;
	
	public void combat(EntityPlayer player, World world)
	{
		setLvlFromXPList(player);
		combatingChecker();
	}
	
	public void combatingChecker()
	{
		if (isCombating)
		{
			--combatingResetTimer;
			
			if (combatingResetTimer <= 0)
			{
				isCombating = false;
				combatingResetTimer = 10;
			}
		}
	}
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		par1NBTTagCompound.setBoolean("AttackFromMelee", isTrainingAttackMelee);
		par1NBTTagCompound.setBoolean("StrengthFromMelee", isTrainingStrengthMelee);
		par1NBTTagCompound.setBoolean("DefenceFromMelee", isTrainingDefenceMelee);
		
		par1NBTTagCompound.setBoolean("MagicFromMaging", isTrainingMagicMaging);
		par1NBTTagCompound.setBoolean("DefenceFromMaging", isTrainingDefenceMaging);
		
		par1NBTTagCompound.setBoolean("RangedFromRanging", isTrainingRangedRanging);
		par1NBTTagCompound.setBoolean("StrengthFromRanging", isTrainingStrengthRanging);
		par1NBTTagCompound.setBoolean("DefenceFromRanging", isTrainingDefenceRanging);
	}
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		isTrainingAttackMelee = par1NBTTagCompound.getBoolean("AttackFromMelee");
		isTrainingStrengthMelee = par1NBTTagCompound.getBoolean("StrengthFromMelee");
		isTrainingDefenceMelee = par1NBTTagCompound.getBoolean("DefenceFromMelee");
		
		isTrainingMagicMaging = par1NBTTagCompound.getBoolean("MagicFromMaging");
		isTrainingDefenceMaging = par1NBTTagCompound.getBoolean("DefenceFromMaging");
		
		isTrainingRangedRanging = par1NBTTagCompound.getBoolean("RangedFromRanging");
		isTrainingStrengthRanging = par1NBTTagCompound.getBoolean("StrengthFromRanging");
		isTrainingDefenceRanging = par1NBTTagCompound.getBoolean("DefenceFromRanging");
	}
	
	public boolean getIsTrainingAttackMelee() { return isTrainingAttackMelee; } public void setIsTrainingAttackMelee(boolean value) { isTrainingAttackMelee = value; }
	public boolean getIsTrainingStrengthMelee() { return isTrainingStrengthMelee; } public void setIsTrainingStrengthMelee(boolean value) { isTrainingStrengthMelee = value; }
	public boolean getIsTrainingDefenceMelee() { return isTrainingDefenceMelee; } public void setIsTrainingDefenceMelee(boolean value) { isTrainingDefenceMelee = value; }
	
	public boolean getIsTrainingMagicMaging() { return isTrainingMagicMaging; } public void setIsTrainingMagicMaging(boolean value) { isTrainingMagicMaging = value; }
	public boolean getIsTrainingDefenceMaging() { return isTrainingDefenceMaging; } public void setIsTrainingDefenceMaging(boolean value) { isTrainingDefenceMaging = value; }
	
	public boolean getIsTrainingRangedRanging() { return isTrainingRangedRanging; } public void setIsTrainingRangedRanging(boolean value) { isTrainingRangedRanging = value; }
	public boolean getIsTrainingStrengthRanging() { return isTrainingStrengthRanging; } public void setIsTrainingStrengthRanging(boolean value) { isTrainingStrengthRanging = value; }
	public boolean getIsTrainingDefenceRanging() { return isTrainingDefenceRanging; } public void setIsTrainingDefenceRanging(boolean value) { isTrainingDefenceRanging = value; }
	
	
	public void setLvlFromXPList(EntityPlayer player)
	{
		if (isCombating)
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
			
			if (!(LevelUpUtil.attackLvl == RCM.instance.skillHandler.getLevel(SkillReference.att)))
			{
				RCM.instance.skillHandler.levelUp(SkillReference.att, RCM.instance.skillHandler.getLevel(SkillReference.att));
				LevelUpUtil.lvlHandling();
			}
			if (!(LevelUpUtil.strengthLvl == RCM.instance.skillHandler.getLevel(SkillReference.str)))
			{
				RCM.instance.skillHandler.levelUp(SkillReference.str, RCM.instance.skillHandler.getLevel(SkillReference.str));
				LevelUpUtil.lvlHandling();
			}
			if (!(LevelUpUtil.defenceLvl == RCM.instance.skillHandler.getLevel(SkillReference.def)))
			{
				RCM.instance.skillHandler.levelUp(SkillReference.def, RCM.instance.skillHandler.getLevel(SkillReference.def));
				LevelUpUtil.lvlHandling();
			}
			if (!(LevelUpUtil.magicLvl == RCM.instance.skillHandler.getLevel(SkillReference.mage)))
			{
				RCM.instance.skillHandler.levelUp(SkillReference.mage, RCM.instance.skillHandler.getLevel(SkillReference.mage));
				LevelUpUtil.lvlHandling();
			}
			if (!(LevelUpUtil.rangedLvl == RCM.instance.skillHandler.getLevel(SkillReference.range)))
			{
				RCM.instance.skillHandler.levelUp(SkillReference.range, RCM.instance.skillHandler.getLevel(SkillReference.range));
				LevelUpUtil.lvlHandling();
			}
			if (!(LevelUpUtil.constitutionLvl == RCM.instance.skillHandler.getLevel(SkillReference.cons)))
			{
				RCM.instance.skillHandler.levelUp(SkillReference.cons, RCM.instance.skillHandler.getLevel(SkillReference.cons));
				LevelUpUtil.lvlHandling();
				
				
				player.removePotionEffect(Potion.field_76434_w.id);
				double amp = RCM.instance.skillHandler.getLevel(SkillReference.cons) / 7;
				player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, Integer.MAX_VALUE, (int)amp));
				player.addPotionEffect(new PotionEffect(Potion.heal.id, 10, 4));
			}
		}
	} 
	
	public void setLvlFromXP(double xp1, double xp2, int level)
	{	
		if (RCM.instance.skillHandler.getExperience(SkillReference.att) >= xp1 && RCM.instance.skillHandler.getExperience(SkillReference.att) < xp2)
		{
			RCM.instance.skillHandler.setLevel(SkillReference.att, level, RCM.instance.skillHandler.getExperience(SkillReference.att));
		}
		if (RCM.instance.skillHandler.getExperience(SkillReference.str) >= xp1 && RCM.instance.skillHandler.getExperience(SkillReference.str) < xp2)
		{
			RCM.instance.skillHandler.setLevel(SkillReference.str, level, RCM.instance.skillHandler.getExperience(SkillReference.str));
		}
		if (RCM.instance.skillHandler.getExperience(SkillReference.def) >= xp1 && RCM.instance.skillHandler.getExperience(SkillReference.def) < xp2)
		{
			RCM.instance.skillHandler.setLevel(SkillReference.def, level, RCM.instance.skillHandler.getExperience(SkillReference.def));
		}
		if (RCM.instance.skillHandler.getExperience(SkillReference.mage) >= xp1 && RCM.instance.skillHandler.getExperience(SkillReference.mage) < xp2)
		{
			RCM.instance.skillHandler.setLevel(SkillReference.mage, level, RCM.instance.skillHandler.getExperience(SkillReference.mage));
		}
		if (RCM.instance.skillHandler.getExperience(SkillReference.range) >= xp1 && RCM.instance.skillHandler.getExperience(SkillReference.range) < xp2)
		{
			RCM.instance.skillHandler.setLevel(SkillReference.range, level, RCM.instance.skillHandler.getExperience(SkillReference.range));
		}
		if (RCM.instance.skillHandler.getExperience(SkillReference.cons) >= xp1 && RCM.instance.skillHandler.getExperience(SkillReference.cons) < xp2)
		{
			RCM.instance.skillHandler.setLevel(SkillReference.cons, level, RCM.instance.skillHandler.getExperience(SkillReference.cons));
		}
	}
	
	public void setbackLvlIfTooHigh(int level)
	{
		if (RCM.instance.skillHandler.getLevel(SkillReference.att) > level) 
		{
			RCM.instance.skillHandler.setLevel(SkillReference.att, level, RCM.instance.skillHandler.getExperience(SkillReference.att)); 
		}
		if (RCM.instance.skillHandler.getLevel(SkillReference.str) > level) 
		{
			RCM.instance.skillHandler.setLevel(SkillReference.str, level, RCM.instance.skillHandler.getExperience(SkillReference.str)); 
		}
		if (RCM.instance.skillHandler.getLevel(SkillReference.def) > level) 
		{
			RCM.instance.skillHandler.setLevel(SkillReference.def, level, RCM.instance.skillHandler.getExperience(SkillReference.def)); 
		}
		if (RCM.instance.skillHandler.getLevel(SkillReference.mage) > level) 
		{
			RCM.instance.skillHandler.setLevel(SkillReference.mage, level, RCM.instance.skillHandler.getExperience(SkillReference.mage)); 
		}
		if (RCM.instance.skillHandler.getLevel(SkillReference.range) > level) 
		{
			RCM.instance.skillHandler.setLevel(SkillReference.range, level, RCM.instance.skillHandler.getExperience(SkillReference.range)); 
		}
		if (RCM.instance.skillHandler.getLevel(SkillReference.cons) > level) 
		{
			RCM.instance.skillHandler.setLevel(SkillReference.cons, level, RCM.instance.skillHandler.getExperience(SkillReference.cons)); 
		}
	}
	
	public void setbackXPIfTooHigh(double xp)
	{
		if (RCM.instance.skillHandler.getExperience(SkillReference.att) > xp) 
		{
			RCM.instance.skillHandler.setExperience(SkillReference.att, xp); 
		}
		if (RCM.instance.skillHandler.getExperience(SkillReference.str) > xp) 
		{
			RCM.instance.skillHandler.setExperience(SkillReference.str, xp); 
		}
		if (RCM.instance.skillHandler.getExperience(SkillReference.def) > xp) 
		{
			RCM.instance.skillHandler.setExperience(SkillReference.def, xp); 
		}
		if (RCM.instance.skillHandler.getExperience(SkillReference.mage) > xp) 
		{
			RCM.instance.skillHandler.setExperience(SkillReference.mage, xp); 
		}
		if (RCM.instance.skillHandler.getExperience(SkillReference.range) > xp) 
		{
			RCM.instance.skillHandler.setExperience(SkillReference.range, xp); 
		}
		if (RCM.instance.skillHandler.getExperience(SkillReference.cons) > xp) 
		{
			RCM.instance.skillHandler.setExperience(SkillReference.cons, xp); 
		}
	}
}