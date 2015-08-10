package javabuckets.mods.rcm.utility;

import javabuckets.mods.rcm.main.RCM;

public class LevelUpUtil 
{
	/**
	 * Non-updated variables when it comes to lvls.
	 * These int's are set to be the corresponding lvl at the start at the game.
	 * When a lvl doesn't match up with the corresponding lvl, an if statement is called somewhere,
	 * and the code recognizes this as a level up. The Non-updated version updates to the new value.
	 */
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
		attackLvl = RCM.instance.skillHandler.getLevel(SkillReference.att);
		constitutionLvl = RCM.instance.skillHandler.getLevel(SkillReference.cons);
		miningLvl = RCM.instance.skillHandler.getLevel(SkillReference.mine);
		strengthLvl = RCM.instance.skillHandler.getLevel(SkillReference.str);
		agilityLvl = RCM.instance.skillHandler.getLevel(SkillReference.agi);
		smithingLvl = RCM.instance.skillHandler.getLevel(SkillReference.smith);
		defenceLvl = RCM.instance.skillHandler.getLevel(SkillReference.def);
		herbloreLvl = RCM.instance.skillHandler.getLevel(SkillReference.herb);
		fishingLvl = RCM.instance.skillHandler.getLevel(SkillReference.fish);
		rangedLvl = RCM.instance.skillHandler.getLevel(SkillReference.range);
		thievingLvl = RCM.instance.skillHandler.getLevel(SkillReference.thiev);
		cookingLvl = RCM.instance.skillHandler.getLevel(SkillReference.cook);
		prayerLvl = RCM.instance.skillHandler.getLevel(SkillReference.pray);
		craftingLvl = RCM.instance.skillHandler.getLevel(SkillReference.craft);
		firemakingLvl = RCM.instance.skillHandler.getLevel(SkillReference.fm);
		magicLvl = RCM.instance.skillHandler.getLevel(SkillReference.mage);
		fletchingLvl = RCM.instance.skillHandler.getLevel(SkillReference.fletch);
		woodcuttingLvl = RCM.instance.skillHandler.getLevel(SkillReference.wc);
		runecraftingLvl = RCM.instance.skillHandler.getLevel(SkillReference.rc);
		slayerLvl = RCM.instance.skillHandler.getLevel(SkillReference.slay);
		farmingLvl = RCM.instance.skillHandler.getLevel(SkillReference.farm);
		constructionLvl = RCM.instance.skillHandler.getLevel(SkillReference.con);
		hunterLvl = RCM.instance.skillHandler.getLevel(SkillReference.hunt);
		summoningLvl = RCM.instance.skillHandler.getLevel(SkillReference.summ);
		dungeoneeringLvl = RCM.instance.skillHandler.getLevel(SkillReference.dung);
		divinationLvl = RCM.instance.skillHandler.getLevel(SkillReference.div);
	}
}