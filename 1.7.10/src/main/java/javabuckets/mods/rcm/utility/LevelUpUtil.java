package javabuckets.mods.rcm.utility;

import javabuckets.mods.rcm.main.RCM;

public class LevelUpUtil 
{
	public static int attackLvl;
	public static int constitutionLvl;
	public static int miningLvl;
	public static int strengthLvl;
	public static int agilityLvl;
	public static int smithingLvl;
	public static int defenceLvl;
	public static int herbloreLvl;
	public static int fishingLvl;
	public static int rangedLvl;
	public static int thievingLvl;
	public static int cookingLvl;
	public static int prayerLvl;
	public static int craftingLvl;
	public static int firemakingLvl;
	public static int magicLvl;
	public static int fletchingLvl;
	public static int woodcuttingLvl;
	public static int runecraftingLvl;
	public static int slayerLvl;
	public static int farmingLvl;
	public static int constructionLvl;
	public static int hunterLvl;
	public static int summoningLvl;
	public static int dungeoneeringLvl;
	public static int divinationLvl;
	
	public static void lvlHandling()
	{
		attackLvl = RCM.instance.skillHandler.getAttackLvl();
		constitutionLvl = RCM.instance.skillHandler.getConstitutionLvl();
		miningLvl = RCM.instance.skillHandler.getMiningLvl();
		strengthLvl = RCM.instance.skillHandler.getStrengthLvl();
		agilityLvl = RCM.instance.skillHandler.getAgilityLvl();
		smithingLvl = RCM.instance.skillHandler.getSmithingLvl();
		defenceLvl = RCM.instance.skillHandler.getDefenceLvl();
		herbloreLvl = RCM.instance.skillHandler.getHerbloreLvl();
		fishingLvl = RCM.instance.skillHandler.getFishingLvl();
		rangedLvl = RCM.instance.skillHandler.getRangedLvl();
		thievingLvl = RCM.instance.skillHandler.getThievingLvl();
		cookingLvl = RCM.instance.skillHandler.getCookingLvl();
		prayerLvl = RCM.instance.skillHandler.getPrayerLvl();
		craftingLvl = RCM.instance.skillHandler.getCraftingLvl();
		firemakingLvl = RCM.instance.skillHandler.getFiremakingLvl();
		magicLvl = RCM.instance.skillHandler.getMagicLvl();
		fletchingLvl = RCM.instance.skillHandler.getFletchingLvl();
		woodcuttingLvl = RCM.instance.skillHandler.getWoodcuttingLvl();
		runecraftingLvl = RCM.instance.skillHandler.getRunecraftingLvl();
		slayerLvl = RCM.instance.skillHandler.getSlayerLvl();
		farmingLvl = RCM.instance.skillHandler.getFarmingLvl();
		constructionLvl = RCM.instance.skillHandler.getConstructionLvl();
		hunterLvl = RCM.instance.skillHandler.getHunterLvl();
		summoningLvl = RCM.instance.skillHandler.getSummoningLvl();
		dungeoneeringLvl = RCM.instance.skillHandler.getDungeoneeringLvl();
		divinationLvl = RCM.instance.skillHandler.getDivinationLvl();
	}
}