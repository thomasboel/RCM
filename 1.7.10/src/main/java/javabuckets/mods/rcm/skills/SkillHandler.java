package javabuckets.mods.rcm.skills;

import javabuckets.mods.rcm.huds.HUDSkills;
import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.utility.LogHelper;
import javabuckets.mods.rcm.utility.SkillReference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class SkillHandler 
{
	// Attack
	private int attackLvl = 1; private double attackXP = 0D;
	// Constitution
	private int constitutionLvl = 10; private double constitutionXP = 1154D;
	// Mining
	private int miningLvl = 1; private double miningXP = 0D;
	// Strength
	private int strengthLvl = 1; private double strengthXP = 0D;
	// Agility
	private int agilityLvl = 1; private double agilityXP = 0D;
	// Smithing
	private int smithingLvl = 1; private double smithingXP = 0D;
	// Defence
	private int defenceLvl = 1; private double defenceXP = 0D;
	// Herblore
	private int herbloreLvl = 1; private double herbloreXP = 0D;
	// Fishing
	private int fishingLvl = 1; private double fishingXP = 0D;
	// Ranged
	private int rangedLvl = 1; private double rangedXP = 0D;
	// Thieving
	private int thievingLvl = 1; private double thievingXP = 0D;
	// Cooking
	private int cookingLvl = 1; private double cookingXP = 0D;
	// Prayer
	private int prayerLvl = 1; private double prayerXP = 0D;
	// Crafting
	private int craftingLvl = 1; private double craftingXP = 0D;
	// Firemaking
	private int firemakingLvl = 1; private double firemakingXP = 0D;
	// Magic
	private int magicLvl = 1; private double magicXP = 0D;
	// Fletching
	private int fletchingLvl = 1; private double fletchingXP = 0D;
	// Woodcutting
	private int woodcuttingLvl = 1; private double woodcuttingXP = 0D;
	// Runecrafting
	private int runecraftingLvl = 1; private double runecraftingXP = 0D;
	// Slayer
	private int slayerLvl = 1; private double slayerXP = 0D;
	// Farming
	private int farmingLvl = 1; private double farmingXP = 0D;
	// Construction
	private int constructionLvl = 1; private double constructionXP = 0D;
	// Hunter
	private int hunterLvl = 1; private double hunterXP = 0D;
	// Summoning
	private int summoningLvl = 1; private double summoningXP = 0D;
	// Dungeoneering
	private int dungeoneeringLvl = 1; private double dungeoneeringXP = 0D;
	// Divination
	private int divinationLvl = 1; private double divinationXP = 0D;

	// Combat Level
	private double combatLvl;

	/**
	 * Update method including player and world param's
	 * @param player The EntityPlayer
	 * @param world The World
	 */
	public void onUpdate(EntityPlayer player, World world)
	{
		RCM.instance.skill.skill(player, world);
		checkCombatLevel();
	}

	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		// Attack
		par1NBTTagCompound.setInteger("AttackLevel", attackLvl);
		par1NBTTagCompound.setDouble("AttackExperience", attackXP);
		// Constitution
		par1NBTTagCompound.setInteger("ConstitutionLevel", constitutionLvl);
		par1NBTTagCompound.setDouble("ConstitutionExperience", constitutionXP);
		// Mining
		par1NBTTagCompound.setInteger("MiningLevel", miningLvl);
		par1NBTTagCompound.setDouble("MiningExperience", miningXP);
		// Strength
		par1NBTTagCompound.setInteger("StrengthLevel", strengthLvl);
		par1NBTTagCompound.setDouble("StrengthExperience", strengthXP);
		// Agility
		par1NBTTagCompound.setInteger("AgilityLevel", agilityLvl);
		par1NBTTagCompound.setDouble("AgilityExperience", agilityXP);
		// Smithing
		par1NBTTagCompound.setInteger("SmithingLevel", smithingLvl);
		par1NBTTagCompound.setDouble("SmithingExperience", smithingXP);
		// Defence
		par1NBTTagCompound.setInteger("DefenceLevel", defenceLvl);
		par1NBTTagCompound.setDouble("DefenceExperience", defenceXP);
		// Herblore
		par1NBTTagCompound.setInteger("HerbloreLevel", herbloreLvl);
		par1NBTTagCompound.setDouble("HerbloreExperience", herbloreXP);
		// Fishing
		par1NBTTagCompound.setInteger("FishingLevel", fishingLvl);
		par1NBTTagCompound.setDouble("FishingExperience", fishingXP);
		// Ranged
		par1NBTTagCompound.setInteger("RangedLevel", rangedLvl);
		par1NBTTagCompound.setDouble("RangedExperience", rangedXP);		
		// Thieving
		par1NBTTagCompound.setInteger("ThievingLevel", thievingLvl);
		par1NBTTagCompound.setDouble("ThievingExperience", thievingXP);
		// Cooking
		par1NBTTagCompound.setInteger("CookingLevel", cookingLvl);
		par1NBTTagCompound.setDouble("CookingExperience", cookingXP);
		// Prayer
		par1NBTTagCompound.setInteger("PrayerLevel", prayerLvl);
		par1NBTTagCompound.setDouble("PrayerExperience", prayerXP);
		// Crafting
		par1NBTTagCompound.setInteger("CraftingLevel", craftingLvl);
		par1NBTTagCompound.setDouble("CraftingExperience", craftingXP);
		// Firemaking
		par1NBTTagCompound.setInteger("FiremakingLevel", firemakingLvl);
		par1NBTTagCompound.setDouble("FiremakingExperience", firemakingXP);
		// Magic
		par1NBTTagCompound.setInteger("MagicLevel", magicLvl);
		par1NBTTagCompound.setDouble("MagicExperience", magicXP);
		// Fletching
		par1NBTTagCompound.setInteger("FletchingLevel", fletchingLvl);
		par1NBTTagCompound.setDouble("FletchingExperience", fletchingXP);
		// Woodcutting
		par1NBTTagCompound.setInteger("WoodcuttingLevel", woodcuttingLvl);
		par1NBTTagCompound.setDouble("WoodcuttingExperience", woodcuttingXP);
		// Runecrafting
		par1NBTTagCompound.setInteger("RunecraftingLevel", runecraftingLvl);
		par1NBTTagCompound.setDouble("RunecraftingExperience", runecraftingXP);
		// Slayer
		par1NBTTagCompound.setInteger("SlayerLevel", slayerLvl);
		par1NBTTagCompound.setDouble("SlayerExperience", slayerXP);
		// Farming
		par1NBTTagCompound.setInteger("FarmingLevel", farmingLvl);
		par1NBTTagCompound.setDouble("FarmingExperience", farmingXP);
		// Construction
		par1NBTTagCompound.setInteger("ConstructionLevel", constructionLvl);
		par1NBTTagCompound.setDouble("ConstructionExperience", constructionXP);
		// Hunter
		par1NBTTagCompound.setInteger("HunterLevel", hunterLvl);
		par1NBTTagCompound.setDouble("HunterExperience", hunterXP);
		// Summoning
		par1NBTTagCompound.setInteger("SummoningLevel", summoningLvl);
		par1NBTTagCompound.setDouble("SummoningExperience", summoningXP);
		// Dungeoneering
		par1NBTTagCompound.setInteger("DungeoneeringLevel", dungeoneeringLvl);
		par1NBTTagCompound.setDouble("DungeoneeringExperience", dungeoneeringXP);
		// Divination
		par1NBTTagCompound.setInteger("DivinationLevel", divinationLvl);
		par1NBTTagCompound.setDouble("DivinationExperience", divinationXP);

		// Combat Level
		par1NBTTagCompound.setDouble("CombatLevel", combatLvl);
	}

	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		// Attack
		attackLvl = par1NBTTagCompound.getInteger("AttackLevel");
		attackXP = par1NBTTagCompound.getDouble("AttackExperience");
		// Constitution
		constitutionLvl = par1NBTTagCompound.getInteger("ConstitutionLevel");
		constitutionXP = par1NBTTagCompound.getDouble("ConstitutionExperience");
		// Mining
		miningLvl = par1NBTTagCompound.getInteger("MiningLevel");
		miningXP = par1NBTTagCompound.getDouble("MiningExperience");
		// Strength
		strengthLvl = par1NBTTagCompound.getInteger("StrengthLevel");
		strengthXP = par1NBTTagCompound.getDouble("StrengthExperience");
		// Agility
		agilityLvl = par1NBTTagCompound.getInteger("AgilityLevel");
		agilityXP = par1NBTTagCompound.getDouble("AgilityExperience");
		// Smithing
		smithingLvl = par1NBTTagCompound.getInteger("SmithingLevel");
		smithingXP = par1NBTTagCompound.getDouble("SmithingExperience");
		// Defence
		defenceLvl = par1NBTTagCompound.getInteger("DefenceLevel");
		defenceXP = par1NBTTagCompound.getDouble("DefenceExperience");
		// Herblore
		herbloreLvl = par1NBTTagCompound.getInteger("HerbloreLevel");
		herbloreXP = par1NBTTagCompound.getDouble("HerbloreExperience");
		// Fishing
		fishingLvl = par1NBTTagCompound.getInteger("FishingLevel");
		fishingXP = par1NBTTagCompound.getDouble("FishingExperience");
		// Ranged
		rangedLvl = par1NBTTagCompound.getInteger("RangedLevel");
		rangedXP = par1NBTTagCompound.getDouble("RangedExperience");
		// Thieving
		thievingLvl = par1NBTTagCompound.getInteger("ThievingLevel");
		thievingXP = par1NBTTagCompound.getDouble("ThievingExperience");
		// Cooking
		cookingLvl = par1NBTTagCompound.getInteger("CookingLevel");
		cookingXP = par1NBTTagCompound.getDouble("CookingExperience");
		// Prayer
		prayerLvl = par1NBTTagCompound.getInteger("PrayerLevel");
		prayerXP = par1NBTTagCompound.getDouble("PrayerExperience");
		// Crafting
		craftingLvl = par1NBTTagCompound.getInteger("CraftingLevel");
		craftingXP = par1NBTTagCompound.getDouble("CraftingExperience");
		// Firemaking
		firemakingLvl = par1NBTTagCompound.getInteger("FiremakingLevel");
		firemakingXP = par1NBTTagCompound.getDouble("FiremakingExperience");
		// Magic
		magicLvl = par1NBTTagCompound.getInteger("MagicLevel");
		magicXP = par1NBTTagCompound.getDouble("MagicExperience");
		// Fletching
		fletchingLvl = par1NBTTagCompound.getInteger("FletchingLevel");
		fletchingXP = par1NBTTagCompound.getDouble("FletchingExperience");
		// Woodcutting
		woodcuttingLvl = par1NBTTagCompound.getInteger("WoodcuttingLevel");
		woodcuttingXP = par1NBTTagCompound.getDouble("WoodcuttingExperience");
		// Runecrafting
		runecraftingLvl = par1NBTTagCompound.getInteger("RunecraftingLevel");
		runecraftingXP = par1NBTTagCompound.getDouble("RunecraftingExperience");
		// Slayer
		slayerLvl = par1NBTTagCompound.getInteger("SlayerLevel");
		slayerXP = par1NBTTagCompound.getDouble("SlayerExperience");
		// Farming
		farmingLvl = par1NBTTagCompound.getInteger("FarmingLevel");
		farmingXP = par1NBTTagCompound.getDouble("FarmingExperience");
		// Construction
		constructionLvl = par1NBTTagCompound.getInteger("ConstructionLevel");
		constructionXP = par1NBTTagCompound.getDouble("ConstructionExperience");
		// Hunter
		hunterLvl = par1NBTTagCompound.getInteger("HunterLevel");
		hunterXP = par1NBTTagCompound.getDouble("HunterExperience");
		// Summoning
		summoningLvl = par1NBTTagCompound.getInteger("SummoningLevel");
		summoningXP = par1NBTTagCompound.getDouble("SummoningExperience");
		// Dungeoneering
		dungeoneeringLvl = par1NBTTagCompound.getInteger("DungeoneeringLevel");
		dungeoneeringXP = par1NBTTagCompound.getDouble("DungeoneeringExperience");
		// Divination
		divinationLvl = par1NBTTagCompound.getInteger("DivinationLevel");
		divinationXP = par1NBTTagCompound.getDouble("DivinationExperience");

		// Combat Level
		combatLvl = par1NBTTagCompound.getDouble("CombatLevel");
	}
	
	public void setLevel(String skill, int level, double xp)
	{
		if (skill.equalsIgnoreCase(SkillReference.att)) { this.attackLvl = level; this.attackXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.cons)) { this.constitutionLvl = level; this.constitutionXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.mine)) { this.miningLvl = level; this.miningXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.str)) { this.strengthLvl = level; this.strengthXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.agi)) { this.agilityLvl = level; this.agilityXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.smith)) { this.smithingLvl = level; this.smithingXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.def)) { this.defenceLvl = level; this.defenceXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.herb)) { this.herbloreLvl = level; this.herbloreXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.fish)) { this.fishingLvl = level; this.fishingXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.range)) { this.rangedLvl = level; this.rangedXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.thiev)) { this.thievingLvl = level; this.thievingXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.cook)) { this.cookingLvl = level; this.cookingXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.pray)) { this.prayerLvl = level; this.prayerXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.craft)) { this.craftingLvl = level; this.craftingXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.fm)) { this.firemakingLvl = level; this.firemakingXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.mage)) { this.magicLvl = level; this.magicXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.fletch)) { this.fletchingLvl = level; this.fletchingXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.wc)) { this.woodcuttingLvl = level; this.woodcuttingXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.rc)) { this.runecraftingLvl = level; this.runecraftingXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.slay)) { this.slayerLvl = level; this.slayerXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.farm)) { this.farmingLvl = level; this.farmingXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.con)) { this.constructionLvl = level; this.constructionXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.hunt)) { this.hunterLvl = level; this.hunterXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.summ)) { this.summoningLvl = level; this.summoningXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.dung)) { this.dungeoneeringLvl = level; this.dungeoneeringXP = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.div)) { this.divinationLvl = level; this.divinationXP = xp; }
	}
	
	public int getLevel(String skill)
	{
		if (skill.equalsIgnoreCase(SkillReference.att)) { return this.attackLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.cons)) { return this.constitutionLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.mine)) { return this.miningLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.str)) { return this.strengthLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.agi)) { return this.agilityLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.smith)) { return this.smithingLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.def)) { return this.defenceLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.herb)) { return this.herbloreLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.fish)) { return this.fishingLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.range)) { return this.rangedLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.thiev)) { return this.thievingLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.cook)) { return this.cookingLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.pray)) { return this.prayerLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.craft)) { return this.craftingLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.fm)) { return this.firemakingLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.mage)) { return this.magicLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.fletch)) { return this.fletchingLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.wc)) { return this.woodcuttingLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.rc)) { return this.runecraftingLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.slay)) { return this.slayerLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.farm)) { return this.farmingLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.con)) { return this.constructionLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.hunt)) { return this.hunterLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.summ)) { return this.summoningLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.dung)) { return this.dungeoneeringLvl; }
		else if (skill.equalsIgnoreCase(SkillReference.div)) { return this.divinationLvl; }
		else { return 0; }
	}
	
	public double getExperience(String skill)
	{
		if (skill.equalsIgnoreCase(SkillReference.att)) { return this.attackXP; }
		else if (skill.equalsIgnoreCase(SkillReference.cons)) { return this.constitutionXP; }
		else if (skill.equalsIgnoreCase(SkillReference.mine)) { return this.miningXP; }
		else if (skill.equalsIgnoreCase(SkillReference.str)) { return this.strengthXP; }
		else if (skill.equalsIgnoreCase(SkillReference.agi)) { return this.agilityXP; }
		else if (skill.equalsIgnoreCase(SkillReference.smith)) { return this.smithingXP; }
		else if (skill.equalsIgnoreCase(SkillReference.def)) { return this.defenceXP; }
		else if (skill.equalsIgnoreCase(SkillReference.herb)) { return this.herbloreXP; }
		else if (skill.equalsIgnoreCase(SkillReference.fish)) { return this.fishingXP; }
		else if (skill.equalsIgnoreCase(SkillReference.range)) { return this.rangedXP; }
		else if (skill.equalsIgnoreCase(SkillReference.thiev)) { return this.thievingXP; }
		else if (skill.equalsIgnoreCase(SkillReference.cook)) { return this.cookingXP; }
		else if (skill.equalsIgnoreCase(SkillReference.pray)) { return this.prayerXP; }
		else if (skill.equalsIgnoreCase(SkillReference.craft)) { return this.craftingXP; }
		else if (skill.equalsIgnoreCase(SkillReference.fm)) { return this.firemakingXP; }
		else if (skill.equalsIgnoreCase(SkillReference.mage)) { return this.magicXP; }
		else if (skill.equalsIgnoreCase(SkillReference.fletch)) { return this.fletchingXP; }
		else if (skill.equalsIgnoreCase(SkillReference.wc)) { return this.woodcuttingXP; }
		else if (skill.equalsIgnoreCase(SkillReference.rc)) { return this.runecraftingXP; }
		else if (skill.equalsIgnoreCase(SkillReference.slay)) { return this.slayerXP; }
		else if (skill.equalsIgnoreCase(SkillReference.farm)) { return this.farmingXP; }
		else if (skill.equalsIgnoreCase(SkillReference.con)) { return this.constructionXP; }
		else if (skill.equalsIgnoreCase(SkillReference.hunt)) { return this.hunterXP; }
		else if (skill.equalsIgnoreCase(SkillReference.summ)) { return this.summoningXP; }
		else if (skill.equalsIgnoreCase(SkillReference.dung)) { return this.dungeoneeringXP; }
		else if (skill.equalsIgnoreCase(SkillReference.div)) { return this.divinationXP; }
		else { return 0; }
	}

	// Attack
	public int getAttackLvl() { return this.attackLvl; }   public void setAttackLvl(int attackLvl) { this.attackLvl = attackLvl; }	
	public double getAttackXP() { return this.attackXP; }   public void setAttackXP(double attackXP) { this.attackXP = attackXP; }	
	// Constitution
	public int getConstitutionLvl() { return this.constitutionLvl; }   public void setConstitutionLvl(int constitutionLvl) { this.constitutionLvl = constitutionLvl; }	
	public double getConstitutionXP() { return this.constitutionXP; }   public void setConstitutionXP(double constitutionXP) { this.constitutionXP = constitutionXP; }
	// Mining
	public int getMiningLvl() { return this.miningLvl; }   public void setMiningLvl(int miningLvl) { this.miningLvl = miningLvl; }	
	public double getMiningXP() { return this.miningXP; }   public void setMiningXP(double miningXP) { this.miningXP = miningXP; }	
	// Strength
	public int getStrengthLvl() { return this.strengthLvl; }   public void setStrengthLvl(int strengthLvl) { this.strengthLvl = strengthLvl; }	
	public double getStrengthXP() { return this.strengthXP; }   public void setStrengthXP(double strengthXP) { this.strengthXP = strengthXP; }	
	// Agility
	public int getAgilityLvl() { return this.agilityLvl; }   public void setAgilityLvl(int agilityLvl) { this.agilityLvl = agilityLvl; }	
	public double getAgilityXP() { return this.agilityXP; }   public void setAgilityXP(double agilityXP) { this.agilityXP = agilityXP; }	
	// Smithing
	public int getSmithingLvl() { return this.smithingLvl; }   public void setSmithingLvl(int smithingLvl) { this.smithingLvl = smithingLvl; }	
	public double getSmithingXP() { return this.smithingXP; }   public void setSmithingXP(double smithingXP) { this.smithingXP = smithingXP; }	
	// Defence
	public int getDefenceLvl() { return this.defenceLvl; }   public void setDefenceLvl(int defenceLvl) { this.defenceLvl = defenceLvl; }	
	public double getDefenceXP() { return this.defenceXP; }   public void setDefenceXP(double defenceXP) { this.defenceXP = defenceXP; }	
	// Herblore
	public int getHerbloreLvl() { return this.herbloreLvl; }   public void setHerbloreLvl(int herbloreLvl) { this.herbloreLvl = herbloreLvl; }	
	public double getHerbloreXP() { return this.herbloreXP; }   public void setHerbloreXP(double herbloreXP) { this.herbloreXP = herbloreXP; }	
	// Fishing
	public int getFishingLvl() { return this.fishingLvl; }   public void setFishingLvl(int fishingLvl) { this.fishingLvl = fishingLvl; }	
	public double getFishingXP() { return this.fishingXP; }   public void setFishingXP(double fishingXP) { this.fishingXP = fishingXP; }	
	// Ranged
	public int getRangedLvl() { return this.rangedLvl; }   public void setRangedLvl(int rangedLvl) { this.rangedLvl = rangedLvl; }	
	public double getRangedXP() { return this.rangedXP; }   public void setRangedXP(double rangedXP) { this.rangedXP = rangedXP; }	
	// Thieving
	public int getThievingLvl() { return this.thievingLvl; }   public void setThievingLvl(int thievingLvl) { this.thievingLvl = thievingLvl; }	
	public double getThievingXP() { return this.thievingXP; }   public void setThievingXP(double thievingXP) { this.thievingXP = thievingXP; }	
	// Cooking
	public int getCookingLvl() { return this.cookingLvl; }   public void setCookingLvl(int cookingLvl) { this.cookingLvl = cookingLvl; }	
	public double getCookingXP() { return this.cookingXP; }   public void setCookingXP(double cookingXP) { this.cookingXP = cookingXP; }	
	// Prayer
	public int getPrayerLvl() { return this.prayerLvl; }   public void setPrayerLvl(int prayerLvl) { this.prayerLvl = prayerLvl; }	
	public double getPrayerXP() { return this.prayerXP; }   public void setPrayerXP(double prayerXP) { this.prayerXP = prayerXP; }	
	// Crafting
	public int getCraftingLvl() { return this.craftingLvl; }   public void setCraftingLvl(int craftingLvl) { this.craftingLvl = craftingLvl; }	
	public double getCraftingXP() { return this.craftingXP; }   public void setCraftingXP(double craftingXP) { this.craftingXP = craftingXP; }	
	// Firemaking
	public int getFiremakingLvl() { return this.firemakingLvl; }   public void setFiremakingLvl(int firemakingLvl) { this.firemakingLvl = firemakingLvl; }	
	public double getFiremakingXP() { return this.firemakingXP; }   public void setFiremakingXP(double firemakingXP) { this.firemakingXP = firemakingXP; }	
	// Magic
	public int getMagicLvl() { return this.magicLvl; }   public void setMagicLvl(int magicLvl) { this.magicLvl = magicLvl; }	
	public double getMagicXP() { return this.magicXP; }   public void setMagicXP(double magicXP) { this.magicXP = magicXP; }	
	// Fletching
	public int getFletchingLvl() { return this.fletchingLvl; }   public void setFletchingLvl(int fletchingLvl) { this.fletchingLvl = fletchingLvl; }	
	public double getFletchingXP() { return this.fletchingXP; }   public void setFletchingXP(double fletchingXP) { this.fletchingXP = fletchingXP; }	
	// Woodcutting
	public int getWoodcuttingLvl() { return this.woodcuttingLvl; }   public void setWoodcuttingLvl(int woodcuttingLvl) { this.woodcuttingLvl = woodcuttingLvl; }	
	public double getWoodcuttingXP() { return this.woodcuttingXP; }   public void setWoodcuttingXP(double woodcuttingXP) { this.woodcuttingXP = woodcuttingXP; }	
	// Runecrafting
	public int getRunecraftingLvl() { return this.runecraftingLvl; }   public void setRunecraftingLvl(int runecraftingLvl) { this.runecraftingLvl = runecraftingLvl; }	
	public double getRunecraftingXP() { return this.runecraftingXP; }   public void setRunecraftingXP(double runecraftingXP) { this.runecraftingXP = runecraftingXP; }	
	// Slayer
	public int getSlayerLvl() { return this.slayerLvl; }   public void setSlayerLvl(int slayerLvl) { this.slayerLvl = slayerLvl; }	
	public double getSlayerXP() { return this.slayerXP; }   public void setSlayerXP(double slayerXP) { this.slayerXP = slayerXP; }	
	// Farming
	public int getFarmingLvl() { return this.farmingLvl; }   public void setFarmingLvl(int farmingLvl) { this.farmingLvl = farmingLvl; }	
	public double getFarmingXP() { return this.farmingXP; }   public void setFarmingXP(double farmingXP) { this.farmingXP = farmingXP; }	
	// Construction
	public int getConstructionLvl() { return this.constructionLvl; }   public void setConstructionLvl(int constructionLvl) { this.constructionLvl = constructionLvl; }	
	public double getConstructionXP() { return this.constructionXP; }   public void setConstructionXP(double constructionXP) { this.constructionXP = constructionXP; }	
	// Hunter
	public int getHunterLvl() { return this.hunterLvl; }   public void setHunterLvl(int hunterLvl) { this.hunterLvl = hunterLvl; }	
	public double getHunterXP() { return this.hunterXP; }   public void setHunterXP(double hunterXP) { this.hunterXP = hunterXP; }	
	// Summoning
	public int getSummoningLvl() { return this.summoningLvl; }   public void setSummoningLvl(int summoningLvl) { this.summoningLvl = summoningLvl; }	
	public double getSummoningXP() { return this.summoningXP; }   public void setSummoningXP(double summoningXP) { this.summoningXP = summoningXP; }	
	// Dungeoneering
	public int getDungeoneeringLvl() { return this.dungeoneeringLvl; }   public void setDungeoneeringLvl(int dungeoneeringLvl) { this.dungeoneeringLvl = dungeoneeringLvl; }	
	public double getDungeoneeringXP() { return this.dungeoneeringXP; }   public void setDungeoneeringXP(double dungeoneeringXP) { this.dungeoneeringXP = dungeoneeringXP; }	
	// Divination
	public int getDivinationLvl() { return this.divinationLvl; }   public void setDivinationLvl(int divinationLvl) { this.divinationLvl = divinationLvl; }	
	public double getDivinationXP() { return this.divinationXP; }   public void setDivinationXP(double divinationXP) { this.divinationXP = divinationXP; }	
	// Total Level
	public int getTotalLvl() { return this.attackLvl + this.constitutionLvl + this.miningLvl + this.strengthLvl + this.agilityLvl + this.smithingLvl + this.defenceLvl + this.herbloreLvl + this.fishingLvl + this.rangedLvl + this.thievingLvl + this.cookingLvl + this.prayerLvl + this.craftingLvl + this.firemakingLvl + this.magicLvl + this.fletchingLvl + this.woodcuttingLvl + this.runecraftingLvl + this.slayerLvl + this.farmingLvl + this.constructionLvl + this.hunterLvl + this.summoningLvl + this.dungeoneeringLvl + this.divinationLvl; }
	public double getTotalXP() { return this.attackXP + this.constitutionXP + this.miningXP + this.strengthXP + this.agilityXP + this.smithingXP + this.defenceXP + this.herbloreXP + this.fishingXP + this.rangedXP + this.thievingXP + this.cookingXP + this.prayerXP + this.craftingXP + this.firemakingXP + this.magicXP + this.fletchingXP + this.woodcuttingXP + this.runecraftingXP + this.slayerXP + this.farmingXP + this.constructionXP + this.hunterXP + this.summoningXP + this.dungeoneeringXP + this.divinationXP; }
	// Combat Level
	public double getCombatLvl() { return this.combatLvl; }

	/**
	 * Checks every Tick what Calculate Method should be used to determine the Combat Level, and Calculates it.
	 */
	public void checkCombatLevel()
	{
		if (getAttackLvl() + getStrengthLvl() >= getMagicLvl() * 1.5 && getAttackLvl() + getStrengthLvl() >= getRangedLvl() * 1.5)
		{
			this.combatLvl = (int) (getDefenceLvl() + getConstitutionLvl() + (getPrayerLvl() / 2) + (getSummoningLvl() / 2) + 1.3 * (getAttackLvl() + getStrengthLvl())) / 4;
		}
		else if (getMagicLvl() * 1.5 >= getAttackLvl() + getStrengthLvl() && getMagicLvl() * 2 >= getRangedLvl() * 1.5)
		{
			this.combatLvl = (int) (getDefenceLvl() + getConstitutionLvl() + (getPrayerLvl() / 2) + (getSummoningLvl() / 2) + 1.3 * (getMagicLvl() * 2)) / 4;
		}
		else if (getRangedLvl() * 1.5 >= getMagicLvl() * 2 && getRangedLvl() * 1.5 >= getAttackLvl() + getStrengthLvl())
		{
			this.combatLvl = (int) (getDefenceLvl() + getConstitutionLvl() + (getPrayerLvl() / 2) + (getSummoningLvl() / 2) + 1.3 * (getRangedLvl() * 2)) / 4;
		}
	}
	
	/**
	 * Method used instead of doing the set-(get-plus) method.
	 * This also makes sure that the HUD for the skill shows up and that xp earned is displayed on screen.
	 */
	public void addXPToSkill(String skill, double XP)
	{
		if (skill.equalsIgnoreCase(SkillReference.att)) { setAttackXP(getAttackXP() + XP); }
		else if (skill.equalsIgnoreCase(SkillReference.cons)) { setConstitutionXP(getConstitutionXP() + XP); }
		else if (skill.equalsIgnoreCase(SkillReference.mine)) { setMiningXP(getMiningXP() + XP); RCM.instance.mining.isMining = true;  }
		else if (skill.equalsIgnoreCase(SkillReference.str)) { setStrengthXP(getStrengthXP() + XP); }
		else if (skill.equalsIgnoreCase(SkillReference.agi)) { setAgilityXP(getAgilityXP() + XP); }
		else if (skill.equalsIgnoreCase(SkillReference.smith)) { setSmithingXP(getSmithingXP() + XP); }
		else if (skill.equalsIgnoreCase(SkillReference.def)) { setDefenceXP(getDefenceXP() + XP); }
		
		else if (skill.equalsIgnoreCase(SkillReference.range)) { setRangedXP(getRangedXP() + XP); }
		
		else if (skill.equalsIgnoreCase(SkillReference.mage)) { setMagicXP(getMagicXP() + XP); }
		else if (skill.equalsIgnoreCase(SkillReference.fletch)) { setFletchingXP(getFletchingXP() + XP); }
		else if (skill.equalsIgnoreCase(SkillReference.wc)) { setWoodcuttingXP(getWoodcuttingXP() + XP); }
		
		RCM.instance.skill.showSkillHUD = true; RCM.instance.skill.resetTimer();
		HUDSkills.resetXPToDisplay();
		HUDSkills.addXPToDisplay(skill, XP);
		
		LogHelper.info(XP + " xp gained in " + skill + "!");
	}
	
	public void addXPToCombatSkill(String skill, double XP)
	{
		if (skill.equalsIgnoreCase(SkillReference.att)) { setAttackXP(getAttackXP() + XP); }
		else if (skill.equalsIgnoreCase(SkillReference.str)) { setStrengthXP(getStrengthXP() + XP); }
		else if (skill.equalsIgnoreCase(SkillReference.def)) { setDefenceXP(getDefenceXP() + XP); }
		else if (skill.equalsIgnoreCase(SkillReference.range)) { setRangedXP(getRangedXP() + XP); }
		else if (skill.equalsIgnoreCase(SkillReference.mage)) { setMagicXP(getMagicXP() + XP); }
		
		setConstitutionXP(getConstitutionXP() + XP/3);
		
		RCM.instance.skill.showSkillHUD = true; RCM.instance.skill.resetTimer();
		HUDSkills.resetXPToDisplay();
		HUDSkills.addXPToDisplay(skill, XP+(XP/3));
	}
	
	/**
	 * Called upon leveling up a skill.
	 */
	public void levelUp(String skill, int level)
	{
		
		
		LogHelper.info("You leveled up in " + skill + "! You are now level " + level + "!");
	}

	/**
	 * Resets all XP and Lvl's that the player has earned in his/hers playtime with the mod.
	 * (Use with caution!!!)
	 */
	public void resetAllExperienceAndLevels()
	{	
		// Attack
		setAttackLvl(1); setAttackXP(0D);
		// Constitution
		setConstitutionLvl(10); setConstitutionXP(1154.00D);
		// Mining
		setMiningLvl(1); setMiningXP(0D);
		// Strength
		setStrengthLvl(1); setStrengthXP(0D);
		// Agility
		setAgilityLvl(1); setAgilityXP(0D);
		// Smithing
		setSmithingLvl(1); setSmithingXP(0D);
		// Defence
		setDefenceLvl(1); setDefenceXP(0D);
		// Herblore
		setHerbloreLvl(1); setHerbloreXP(0D);
		// Fishing
		setFishingLvl(1); setFishingXP(0D);
		// Ranged
		setRangedLvl(1); setRangedXP(0D);
		// Thieving
		setThievingLvl(1); setThievingXP(0D);
		// Cooking
		setCookingLvl(1); setCookingXP(0D);
		// Prayer
		setPrayerLvl(1); setPrayerXP(0D);
		// Crafting
		setCraftingLvl(1); setCraftingXP(0D);
		// Firemaking
		setFiremakingLvl(1); setFiremakingXP(0D);
		// Magic
		setMagicLvl(1); setMagicXP(0D);
		// Fletching
		setFletchingLvl(1); setFletchingXP(0D);
		// Woodcutting
		setWoodcuttingLvl(1); setWoodcuttingXP(0D);
		// Runecrafting
		setRunecraftingLvl(1); setRunecraftingXP(0D);
		// Slayer
		setSlayerLvl(1); setSlayerXP(0D);
		// Farming
		setFarmingLvl(1); setFarmingXP(0D);
		// Construction
		setConstructionLvl(1); setConstructionXP(0D);
		// Hunter
		setHunterLvl(1); setHunterXP(0D);
		// Summoning
		setSummoningLvl(1); setSummoningXP(0D);
		// Dungeoneering
		setDungeoneeringLvl(1); setDungeoneeringXP(0D);
		// Divination
		setDivinationLvl(1); setDivinationXP(0D);
	}

	public void setAllLevels99()
	{
		// Attack
		setAttackLvl(99); setAttackXP(13034431D);
		// Constitution
		setConstitutionLvl(99); setConstitutionXP(13034431D);
		// Mining
		setMiningLvl(99); setMiningXP(13034431D);
		// Strength
		setStrengthLvl(99); setStrengthXP(13034431D);
		// Agility
		setAgilityLvl(99); setAgilityXP(13034431D);
		// Smithing
		setSmithingLvl(99); setSmithingXP(13034431D);
		// Defence
		setDefenceLvl(99); setDefenceXP(13034431D);
		// Herblore
		setHerbloreLvl(99); setHerbloreXP(13034431D);
		// Fishing
		setFishingLvl(99); setFishingXP(13034431D);
		// Ranged
		setRangedLvl(99); setRangedXP(13034431D);
		// Thieving
		setThievingLvl(99); setThievingXP(13034431D);
		// Cooking
		setCookingLvl(99); setCookingXP(13034431D);
		// Prayer
		setPrayerLvl(99); setPrayerXP(13034431D);
		// Crafting
		setCraftingLvl(99); setCraftingXP(13034431D);
		// Firemaking
		setFiremakingLvl(99); setFiremakingXP(13034431D);
		// Magic
		setMagicLvl(99); setMagicXP(13034431D);
		// Fletching
		setFletchingLvl(99); setFletchingXP(13034431D);
		// Woodcutting
		setWoodcuttingLvl(99); setWoodcuttingXP(13034431D);
		// Runecrafting
		setRunecraftingLvl(99); setRunecraftingXP(13034431D);
		// Slayer
		setSlayerLvl(99); setSlayerXP(13034431D);
		// Farming
		setFarmingLvl(99); setFarmingXP(13034431D);
		// Construction
		setConstructionLvl(99); setConstructionXP(13034431D);
		// Hunter
		setHunterLvl(99); setHunterXP(13034431D);
		// Summoning
		setSummoningLvl(99); setSummoningXP(13034431D);
		// Dungeoneering
		setDungeoneeringLvl(99); setDungeoneeringXP(13034431D);
		// Divination
		setDivinationLvl(99); setDivinationXP(13034431D);
	}

	public void setAllToMax()
	{
		// Attack
		setAttackLvl(99); setAttackXP(200000000D);
		// Constitution
		setConstitutionLvl(99); setConstitutionXP(200000000D);
		// Mining
		setMiningLvl(99); setMiningXP(200000000D);
		// Strength
		setStrengthLvl(99); setStrengthXP(200000000D);
		// Agility
		setAgilityLvl(99); setAgilityXP(200000000D);
		// Smithing
		setSmithingLvl(99); setSmithingXP(200000000D);
		// Defence
		setDefenceLvl(99); setDefenceXP(200000000D);
		// Herblore
		setHerbloreLvl(99); setHerbloreXP(200000000D);
		// Fishing
		setFishingLvl(99); setFishingXP(200000000D);
		// Ranged
		setRangedLvl(99); setRangedXP(200000000D);
		// Thieving
		setThievingLvl(99); setThievingXP(200000000D);
		// Cooking
		setCookingLvl(99); setCookingXP(200000000D);
		// Prayer
		setPrayerLvl(99); setPrayerXP(200000000D);
		// Crafting
		setCraftingLvl(99); setCraftingXP(200000000D);
		// Firemaking
		setFiremakingLvl(99); setFiremakingXP(200000000D);
		// Magic
		setMagicLvl(99); setMagicXP(200000000D);
		// Fletching
		setFletchingLvl(99); setFletchingXP(200000000D);
		// Woodcutting
		setWoodcuttingLvl(99); setWoodcuttingXP(200000000D);
		// Runecrafting
		setRunecraftingLvl(99); setRunecraftingXP(200000000D);
		// Slayer
		setSlayerLvl(99); setSlayerXP(200000000D);
		// Farming
		setFarmingLvl(99); setFarmingXP(200000000D);
		// Construction
		setConstructionLvl(99); setConstructionXP(200000000D);
		// Hunter
		setHunterLvl(99); setHunterXP(200000000D);
		// Summoning
		setSummoningLvl(99); setSummoningXP(200000000D);
		// Dungeoneering
		setDungeoneeringLvl(120); setDungeoneeringXP(200000000D);
		// Divination
		setDivinationLvl(99); setDivinationXP(200000000D);
	}
}