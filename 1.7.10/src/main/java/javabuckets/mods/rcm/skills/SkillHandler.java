package javabuckets.mods.rcm.skills;

import javabuckets.mods.rcm.huds.HUDSkills;
import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.utility.LogHelper;
import javabuckets.mods.rcm.utility.SkillReference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class SkillHandler 
{
	// Attack
	private int attackLvl = 1; private double attackxp = 0D;
	private int attackLvlB = attackLvl;
	// Constitution
	private int constitutionLvl = 10; private double constitutionxp = 1154D;
	//private int constitutionLvlB = constitutionLvl;
	// Mining
	private int miningLvl = 1; private double miningxp = 0D;
	private int miningLvlB = miningLvl;
	// Strength
	private int strengthLvl = 1; private double strengthxp = 0D;
	private int strengthLvlB = strengthLvl;
	// Agility
	private int agilityLvl = 1; private double agilityxp = 0D;
	private int agilityLvlB = agilityLvl;
	// Smithing
	private int smithingLvl = 1; private double smithingxp = 0D;
	private int smithingLvlB = attackLvl;
	// Defence
	private int defenceLvl = 1; private double defencexp = 0D;
	private int defenceLvlB = defenceLvl;
	// Herblore
	private int herbloreLvl = 1; private double herblorexp = 0D;
	private int herbloreLvlB = herbloreLvl;
	// Fishing
	private int fishingLvl = 1; private double fishingxp = 0D;
	private int fishingLvlB = fishingLvl;
	// Ranged
	private int rangedLvl = 1; private double rangedxp = 0D;
	private int rangedLvlB = rangedLvl;
	// Thieving
	private int thievingLvl = 1; private double thievingxp = 0D;
	private int thievingLvlB = thievingLvl;
	// Cooking
	private int cookingLvl = 1; private double cookingxp = 0D;
	private int cookingLvlB = cookingLvl;
	// Prayer
	private int prayerLvl = 1; private double prayerxp = 0D;
	private int prayerLvlB = prayerLvl;
	// Crafting
	private int craftingLvl = 1; private double craftingxp = 0D;
	private int craftingLvlB = craftingLvl;
	// Firemaking
	private int firemakingLvl = 1; private double firemakingxp = 0D;
	private int firemakingLvlB = firemakingLvl;
	// Magic
	private int magicLvl = 1; private double magicxp = 0D;
	private int magicLvlB = magicLvl;
	// Fletching
	private int fletchingLvl = 1; private double fletchingxp = 0D;
	private int fletchingLvlB = fletchingLvl;
	// Woodcutting
	private int woodcuttingLvl = 1; private double woodcuttingxp = 0D;
	private int woodcuttingLvlB = woodcuttingLvl;
	// Runecrafting
	private int runecraftingLvl = 1; private double runecraftingxp = 0D;
	private int runecraftingLvlB = runecraftingLvl;
	// Slayer
	private int slayerLvl = 1; private double slayerxp = 0D;
	private int slayerLvlB = slayerLvl;
	// Farming
	private int farmingLvl = 1; private double farmingxp = 0D;
	private int farmingLvlB = farmingLvl;
	// Construction
	private int constructionLvl = 1; private double constructionxp = 0D;
	private int constructionLvlB = constructionLvl;
	// Hunter
	private int hunterLvl = 1; private double hunterxp = 0D;
	private int hunterLvlB = hunterLvl;
	// Summoning
	private int summoningLvl = 1; private double summoningxp = 0D;
	private int summoningLvlB = summoningLvl;
	// Dungeoneering
	private int dungeoneeringLvl = 1; private double dungeoneeringxp = 0D;
	private int dungeoneeringLvlB = dungeoneeringLvl;
	// Divination
	private int divinationLvl = 1; private double divinationxp = 0D;
	private int divinationLvlB = divinationLvl;

	// Combat Level
	private double combatLvl;

	// If this is the first time the game is run (per session)
	private boolean hasRunned = false;

	/**
	 * Update method including player and world param's
	 * @param player The EntityPlayer
	 * @param world The World
	 */
	public void onUpdate(EntityPlayer player, World world)
	{
		RCM.instance.skill.skill(player, world);
		checkCombatLevel();
		boostedLvlHandling();

		// Updates boost lvl's upon player entering the world (only runs once)
		if (!hasRunned)
		{
			updateBoostLvls();
			hasRunned = true;
		}
	}

	private boolean isFirstTimeLogon = true;
	
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		// Attack
		par1NBTTagCompound.setInteger("AttackLevel", attackLvl);
		par1NBTTagCompound.setDouble("AttackExperience", attackxp);
		// Constitution
		par1NBTTagCompound.setInteger("ConstitutionLevel", constitutionLvl);
		par1NBTTagCompound.setDouble("ConstitutionExperience", constitutionxp);
		// Mining
		par1NBTTagCompound.setInteger("MiningLevel", miningLvl);
		par1NBTTagCompound.setDouble("MiningExperience", miningxp);
		// Strength
		par1NBTTagCompound.setInteger("StrengthLevel", strengthLvl);
		par1NBTTagCompound.setDouble("StrengthExperience", strengthxp);
		// Agility
		par1NBTTagCompound.setInteger("AgilityLevel", agilityLvl);
		par1NBTTagCompound.setDouble("AgilityExperience", agilityxp);
		// Smithing
		par1NBTTagCompound.setInteger("SmithingLevel", smithingLvl);
		par1NBTTagCompound.setDouble("SmithingExperience", smithingxp);
		// Defence
		par1NBTTagCompound.setInteger("DefenceLevel", defenceLvl);
		par1NBTTagCompound.setDouble("DefenceExperience", defencexp);
		// Herblore
		par1NBTTagCompound.setInteger("HerbloreLevel", herbloreLvl);
		par1NBTTagCompound.setDouble("HerbloreExperience", herblorexp);
		// Fishing
		par1NBTTagCompound.setInteger("FishingLevel", fishingLvl);
		par1NBTTagCompound.setDouble("FishingExperience", fishingxp);
		// Ranged
		par1NBTTagCompound.setInteger("RangedLevel", rangedLvl);
		par1NBTTagCompound.setDouble("RangedExperience", rangedxp);		
		// Thieving
		par1NBTTagCompound.setInteger("ThievingLevel", thievingLvl);
		par1NBTTagCompound.setDouble("ThievingExperience", thievingxp);
		// Cooking
		par1NBTTagCompound.setInteger("CookingLevel", cookingLvl);
		par1NBTTagCompound.setDouble("CookingExperience", cookingxp);
		// Prayer
		par1NBTTagCompound.setInteger("PrayerLevel", prayerLvl);
		par1NBTTagCompound.setDouble("PrayerExperience", prayerxp);
		par1NBTTagCompound.setInteger("PrayerLevelBoost", prayerLvlB);
		// Crafting
		par1NBTTagCompound.setInteger("CraftingLevel", craftingLvl);
		par1NBTTagCompound.setDouble("CraftingExperience", craftingxp);
		// Firemaking
		par1NBTTagCompound.setInteger("FiremakingLevel", firemakingLvl);
		par1NBTTagCompound.setDouble("FiremakingExperience", firemakingxp);
		// Magic
		par1NBTTagCompound.setInteger("MagicLevel", magicLvl);
		par1NBTTagCompound.setDouble("MagicExperience", magicxp);
		// Fletching
		par1NBTTagCompound.setInteger("FletchingLevel", fletchingLvl);
		par1NBTTagCompound.setDouble("FletchingExperience", fletchingxp);
		// Woodcutting
		par1NBTTagCompound.setInteger("WoodcuttingLevel", woodcuttingLvl);
		par1NBTTagCompound.setDouble("WoodcuttingExperience", woodcuttingxp);
		// Runecrafting
		par1NBTTagCompound.setInteger("RunecraftingLevel", runecraftingLvl);
		par1NBTTagCompound.setDouble("RunecraftingExperience", runecraftingxp);
		// Slayer
		par1NBTTagCompound.setInteger("SlayerLevel", slayerLvl);
		par1NBTTagCompound.setDouble("SlayerExperience", slayerxp);
		// Farming
		par1NBTTagCompound.setInteger("FarmingLevel", farmingLvl);
		par1NBTTagCompound.setDouble("FarmingExperience", farmingxp);
		// Construction
		par1NBTTagCompound.setInteger("ConstructionLevel", constructionLvl);
		par1NBTTagCompound.setDouble("ConstructionExperience", constructionxp);
		// Hunter
		par1NBTTagCompound.setInteger("HunterLevel", hunterLvl);
		par1NBTTagCompound.setDouble("HunterExperience", hunterxp);
		// Summoning
		par1NBTTagCompound.setInteger("SummoningLevel", summoningLvl);
		par1NBTTagCompound.setDouble("SummoningExperience", summoningxp);
		// Dungeoneering
		par1NBTTagCompound.setInteger("DungeoneeringLevel", dungeoneeringLvl);
		par1NBTTagCompound.setDouble("DungeoneeringExperience", dungeoneeringxp);
		// Divination
		par1NBTTagCompound.setInteger("DivinationLevel", divinationLvl);
		par1NBTTagCompound.setDouble("DivinationExperience", divinationxp);

		// Combat Level
		par1NBTTagCompound.setDouble("CombatLevel", combatLvl);
		
		par1NBTTagCompound.setBoolean("isFirstTimeLogon", isFirstTimeLogon);
	}

	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		// Attack
		attackLvl = par1NBTTagCompound.getInteger("AttackLevel");
		attackxp = par1NBTTagCompound.getDouble("AttackExperience");
		// Constitution
		constitutionLvl = par1NBTTagCompound.getInteger("ConstitutionLevel");
		constitutionxp = par1NBTTagCompound.getDouble("ConstitutionExperience");
		// Mining
		miningLvl = par1NBTTagCompound.getInteger("MiningLevel");
		miningxp = par1NBTTagCompound.getDouble("MiningExperience");
		// Strength
		strengthLvl = par1NBTTagCompound.getInteger("StrengthLevel");
		strengthxp = par1NBTTagCompound.getDouble("StrengthExperience");
		// Agility
		agilityLvl = par1NBTTagCompound.getInteger("AgilityLevel");
		agilityxp = par1NBTTagCompound.getDouble("AgilityExperience");
		// Smithing
		smithingLvl = par1NBTTagCompound.getInteger("SmithingLevel");
		smithingxp = par1NBTTagCompound.getDouble("SmithingExperience");
		// Defence
		defenceLvl = par1NBTTagCompound.getInteger("DefenceLevel");
		defencexp = par1NBTTagCompound.getDouble("DefenceExperience");
		// Herblore
		herbloreLvl = par1NBTTagCompound.getInteger("HerbloreLevel");
		herblorexp = par1NBTTagCompound.getDouble("HerbloreExperience");
		// Fishing
		fishingLvl = par1NBTTagCompound.getInteger("FishingLevel");
		fishingxp = par1NBTTagCompound.getDouble("FishingExperience");
		// Ranged
		rangedLvl = par1NBTTagCompound.getInteger("RangedLevel");
		rangedxp = par1NBTTagCompound.getDouble("RangedExperience");
		// Thieving
		thievingLvl = par1NBTTagCompound.getInteger("ThievingLevel");
		thievingxp = par1NBTTagCompound.getDouble("ThievingExperience");
		// Cooking
		cookingLvl = par1NBTTagCompound.getInteger("CookingLevel");
		cookingxp = par1NBTTagCompound.getDouble("CookingExperience");
		// Prayer
		prayerLvl = par1NBTTagCompound.getInteger("PrayerLevel");
		prayerxp = par1NBTTagCompound.getDouble("PrayerExperience");
		prayerLvlB = par1NBTTagCompound.getInteger("PrayerLevelBoost");
		// Crafting
		craftingLvl = par1NBTTagCompound.getInteger("CraftingLevel");
		craftingxp = par1NBTTagCompound.getDouble("CraftingExperience");
		// Firemaking
		firemakingLvl = par1NBTTagCompound.getInteger("FiremakingLevel");
		firemakingxp = par1NBTTagCompound.getDouble("FiremakingExperience");
		// Magic
		magicLvl = par1NBTTagCompound.getInteger("MagicLevel");
		magicxp = par1NBTTagCompound.getDouble("MagicExperience");
		// Fletching
		fletchingLvl = par1NBTTagCompound.getInteger("FletchingLevel");
		fletchingxp = par1NBTTagCompound.getDouble("FletchingExperience");
		// Woodcutting
		woodcuttingLvl = par1NBTTagCompound.getInteger("WoodcuttingLevel");
		woodcuttingxp = par1NBTTagCompound.getDouble("WoodcuttingExperience");
		// Runecrafting
		runecraftingLvl = par1NBTTagCompound.getInteger("RunecraftingLevel");
		runecraftingxp = par1NBTTagCompound.getDouble("RunecraftingExperience");
		// Slayer
		slayerLvl = par1NBTTagCompound.getInteger("SlayerLevel");
		slayerxp = par1NBTTagCompound.getDouble("SlayerExperience");
		// Farming
		farmingLvl = par1NBTTagCompound.getInteger("FarmingLevel");
		farmingxp = par1NBTTagCompound.getDouble("FarmingExperience");
		// Construction
		constructionLvl = par1NBTTagCompound.getInteger("ConstructionLevel");
		constructionxp = par1NBTTagCompound.getDouble("ConstructionExperience");
		// Hunter
		hunterLvl = par1NBTTagCompound.getInteger("HunterLevel");
		hunterxp = par1NBTTagCompound.getDouble("HunterExperience");
		// Summoning
		summoningLvl = par1NBTTagCompound.getInteger("SummoningLevel");
		summoningxp = par1NBTTagCompound.getDouble("SummoningExperience");
		// Dungeoneering
		dungeoneeringLvl = par1NBTTagCompound.getInteger("DungeoneeringLevel");
		dungeoneeringxp = par1NBTTagCompound.getDouble("DungeoneeringExperience");
		// Divination
		divinationLvl = par1NBTTagCompound.getInteger("DivinationLevel");
		divinationxp = par1NBTTagCompound.getDouble("DivinationExperience");

		// Combat Level
		combatLvl = par1NBTTagCompound.getDouble("CombatLevel");
		
		isFirstTimeLogon = par1NBTTagCompound.getBoolean("isFirstTimeLogon");
	}
	
	public boolean isFirstTimeLogon()
	{
		return this.isFirstTimeLogon;
	}
	
	public void setFirstTimeLogon(boolean value) 
	{
		this.isFirstTimeLogon = value;
	}

	public void setLevel(String skill, int level, double xp)
	{
		if (skill.equalsIgnoreCase(SkillReference.att)) { this.attackLvl = level; this.attackxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.cons)) { this.constitutionLvl = level; this.constitutionxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.mine)) { this.miningLvl = level; this.miningxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.str)) { this.strengthLvl = level; this.strengthxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.agi)) { this.agilityLvl = level; this.agilityxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.smith)) { this.smithingLvl = level; this.smithingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.def)) { this.defenceLvl = level; this.defencexp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.herb)) { this.herbloreLvl = level; this.herblorexp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.fish)) { this.fishingLvl = level; this.fishingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.range)) { this.rangedLvl = level; this.rangedxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.thiev)) { this.thievingLvl = level; this.thievingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.cook)) { this.cookingLvl = level; this.cookingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.pray)) { this.prayerLvl = level; this.prayerxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.craft)) { this.craftingLvl = level; this.craftingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.fm)) { this.firemakingLvl = level; this.firemakingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.mage)) { this.magicLvl = level; this.magicxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.fletch)) { this.fletchingLvl = level; this.fletchingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.wc)) { this.woodcuttingLvl = level; this.woodcuttingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.rc)) { this.runecraftingLvl = level; this.runecraftingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.slay)) { this.slayerLvl = level; this.slayerxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.farm)) { this.farmingLvl = level; this.farmingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.con)) { this.constructionLvl = level; this.constructionxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.hunt)) { this.hunterLvl = level; this.hunterxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.summ)) { this.summoningLvl = level; this.summoningxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.dung)) { this.dungeoneeringLvl = level; this.dungeoneeringxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.div)) { this.divinationLvl = level; this.divinationxp = xp; }
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

	public int getLevelB(String skill)
	{
		if (skill.equalsIgnoreCase(SkillReference.att)) { return this.attackLvlB; }
		//else if (skill.equalsIgnoreCase(SkillReference.cons)) { return this.constitutionLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.mine)) { return this.miningLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.str)) { return this.strengthLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.agi)) { return this.agilityLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.smith)) { return this.smithingLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.def)) { return this.defenceLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.herb)) { return this.herbloreLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.fish)) { return this.fishingLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.range)) { return this.rangedLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.thiev)) { return this.thievingLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.cook)) { return this.cookingLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.pray)) { return this.prayerLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.craft)) { return this.craftingLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.fm)) { return this.firemakingLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.mage)) { return this.magicLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.fletch)) { return this.fletchingLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.wc)) { return this.woodcuttingLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.rc)) { return this.runecraftingLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.slay)) { return this.slayerLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.farm)) { return this.farmingLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.con)) { return this.constructionLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.hunt)) { return this.hunterLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.summ)) { return this.summoningLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.dung)) { return this.dungeoneeringLvlB; }
		else if (skill.equalsIgnoreCase(SkillReference.div)) { return this.divinationLvlB; }
		else { return 0; }
	}

	public void setExperience(String skill, double xp)
	{
		if (skill.equalsIgnoreCase(SkillReference.att)) { this.attackxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.cons)) { this.constitutionxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.mine)) { this.miningxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.str)) { this.strengthxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.agi)) { this.agilityxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.smith)) { this.smithingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.def)) { this.defencexp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.herb)) { this.herblorexp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.fish)) { this.fishingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.range)) { this.rangedxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.thiev)) { this.thievingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.cook)) { this.cookingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.pray)) { this.prayerxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.craft)) { this.craftingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.fm)) { this.firemakingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.mage)) { this.magicxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.fletch)) { this.fletchingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.wc)) { this.woodcuttingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.rc)) { this.runecraftingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.slay)) { this.slayerxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.farm)) { this.farmingxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.con)) { this.constructionxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.hunt)) { this.hunterxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.summ)) { this.summoningxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.dung)) { this.dungeoneeringxp = xp; }
		else if (skill.equalsIgnoreCase(SkillReference.div)) { this.divinationxp = xp; }
	}

	public double getExperience(String skill)
	{
		if (skill.equalsIgnoreCase(SkillReference.att)) { return this.attackxp; }
		else if (skill.equalsIgnoreCase(SkillReference.cons)) { return this.constitutionxp; }
		else if (skill.equalsIgnoreCase(SkillReference.mine)) { return this.miningxp; }
		else if (skill.equalsIgnoreCase(SkillReference.str)) { return this.strengthxp; }
		else if (skill.equalsIgnoreCase(SkillReference.agi)) { return this.agilityxp; }
		else if (skill.equalsIgnoreCase(SkillReference.smith)) { return this.smithingxp; }
		else if (skill.equalsIgnoreCase(SkillReference.def)) { return this.defencexp; }
		else if (skill.equalsIgnoreCase(SkillReference.herb)) { return this.herblorexp; }
		else if (skill.equalsIgnoreCase(SkillReference.fish)) { return this.fishingxp; }
		else if (skill.equalsIgnoreCase(SkillReference.range)) { return this.rangedxp; }
		else if (skill.equalsIgnoreCase(SkillReference.thiev)) { return this.thievingxp; }
		else if (skill.equalsIgnoreCase(SkillReference.cook)) { return this.cookingxp; }
		else if (skill.equalsIgnoreCase(SkillReference.pray)) { return this.prayerxp; }
		else if (skill.equalsIgnoreCase(SkillReference.craft)) { return this.craftingxp; }
		else if (skill.equalsIgnoreCase(SkillReference.fm)) { return this.firemakingxp; }
		else if (skill.equalsIgnoreCase(SkillReference.mage)) { return this.magicxp; }
		else if (skill.equalsIgnoreCase(SkillReference.fletch)) { return this.fletchingxp; }
		else if (skill.equalsIgnoreCase(SkillReference.wc)) { return this.woodcuttingxp; }
		else if (skill.equalsIgnoreCase(SkillReference.rc)) { return this.runecraftingxp; }
		else if (skill.equalsIgnoreCase(SkillReference.slay)) { return this.slayerxp; }
		else if (skill.equalsIgnoreCase(SkillReference.farm)) { return this.farmingxp; }
		else if (skill.equalsIgnoreCase(SkillReference.con)) { return this.constructionxp; }
		else if (skill.equalsIgnoreCase(SkillReference.hunt)) { return this.hunterxp; }
		else if (skill.equalsIgnoreCase(SkillReference.summ)) { return this.summoningxp; }
		else if (skill.equalsIgnoreCase(SkillReference.dung)) { return this.dungeoneeringxp; }
		else if (skill.equalsIgnoreCase(SkillReference.div)) { return this.divinationxp; }
		else { return 0; }
	}

	public int getTotalLvl()
	{
		return attackLvl + constitutionLvl + miningLvl + strengthLvl + agilityLvl + smithingLvl + defenceLvl + herbloreLvl + fishingLvl + rangedLvl + thievingLvl + cookingLvl + prayerLvl + craftingLvl + firemakingLvl + magicLvl + fletchingLvl + woodcuttingLvl + runecraftingLvl + slayerLvl + farmingLvl + constructionLvl + hunterLvl + summoningLvl + dungeoneeringLvl + divinationLvl;
	}

	public double getTotalXp()
	{
		return attackxp + constitutionxp + miningxp + strengthxp + agilityxp + smithingxp + defencexp + herblorexp + fishingxp + rangedxp + thievingxp + cookingxp + prayerxp + craftingxp + firemakingxp + magicxp + fletchingxp + woodcuttingxp + runecraftingxp + slayerxp + farmingxp + constructionxp + hunterxp + summoningxp + dungeoneeringxp + divinationxp;
	}

	public double getCombatLvl()
	{ 
		return this.combatLvl; 
	}

	/**
	 * Gets the amount of experience needed in a skill till the player levels up.
	 */
	public double getXpToNextLevel(String skill)
	{
		int currentLvl = getLevel(skill);
		double currentXp = getExperience(skill);

		return SkillReference.getXpFromLvl(currentLvl + 1) - currentXp;
	}

	/**
	 * Checks every Tick what Calculate Method should be used to determine the Combat Level, and Calculates it.
	 */
	private void checkCombatLevel()
	{
		if (attackLvl + strengthLvl >= magicLvl * 1.5 && attackLvl + strengthLvl >= rangedLvl * 1.5)
		{
			this.combatLvl = (int) (defenceLvl + constitutionLvl + (prayerLvl / 2) + (summoningLvl / 2) + 1.3 * (attackLvl + strengthLvl)) / 4;
		}
		else if (magicLvl * 1.5 >= attackLvl + strengthLvl && magicLvl * 2 >= rangedLvl * 1.5)
		{
			this.combatLvl = (int) (defenceLvl + constitutionLvl + (prayerLvl / 2) + (summoningLvl / 2) + 1.3 * (magicLvl * 2)) / 4;
		}
		else if (rangedLvl * 1.5 >= magicLvl * 2 && rangedLvl * 1.5 >= attackLvl + strengthLvl)
		{
			this.combatLvl = (int) (defenceLvl + constitutionLvl + (prayerLvl / 2) + (summoningLvl / 2) + 1.3 * (rangedLvl * 2)) / 4;
		}
	}

	/**
	 * Method used instead of doing the set-(get-plus) method.
	 * This also makes sure that the HUD for the skill shows up and that xp earned is displayed on screen.
	 */
	public void addXPToSkill(String skill, double xp)
	{
		setExperience(skill, getExperience(skill) + xp);

		RCM.instance.skill.showSkillHUD = true; RCM.instance.skill.resetTimer();
		HUDSkills.resetXPToDisplay();
		HUDSkills.addXPToDisplay(skill, xp);

		LogHelper.info(xp + " xp gained in " + skill + "!");
	}

	public void addXPToCombatSkill(String skill, double xp)
	{
		setExperience(skill, getExperience(skill) + xp);
		setExperience(SkillReference.cons, getExperience(SkillReference.cons) + xp / 3);

		RCM.instance.skill.showSkillHUD = true; RCM.instance.skill.resetTimer();
		HUDSkills.resetXPToDisplay();
		HUDSkills.addXPToDisplay(skill, xp + (xp / 3));

		LogHelper.info(xp + " xp gained in " + skill + "!");
		LogHelper.info(xp / 3 + " xp gained in " + SkillReference.cons + "!");
	}

	/**
	 * Called upon leveling up a skill.
	 */
	public void levelUp(String skill, int level)
	{
		LogHelper.info("You leveled up in " + skill + "! You are now level " + level + "!");
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("You leveled up in " + skill + "! You are now level " + level + "!"));
	}

	/**
	 * Boosts the player's level temporarily.
	 */
	public void boostLvlBy(String skill, int amount)
	{
		if (skill.equalsIgnoreCase(SkillReference.att)) { attackLvlB = attackLvl + amount; }
		//else if (skill.equalsIgnoreCase(SkillReference.cons)) { constitutionLvlB = constitutionLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.mine)) { miningLvlB = miningLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.str)) { strengthLvlB = strengthLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.agi)) { agilityLvlB = agilityLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.smith)) { smithingLvlB = smithingLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.def)) { defenceLvlB = defenceLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.herb)) { herbloreLvlB = herbloreLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.fish)) { fishingLvlB = fishingLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.range)) { rangedLvlB = rangedLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.thiev)) { thievingLvlB = thievingLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.cook)) { cookingLvlB = cookingLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.pray)) { prayerLvlB = prayerLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.craft)) { craftingLvlB = craftingLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.fm)) { firemakingLvlB = firemakingLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.mage)) { magicLvlB = magicLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.fletch)) { fletchingLvlB = fletchingLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.wc)) { woodcuttingLvlB = woodcuttingLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.rc)) { runecraftingLvlB = runecraftingLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.slay)) { slayerLvlB = slayerLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.farm)) { farmingLvlB = farmingLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.con)) { constructionLvlB = constructionLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.hunt)) { hunterLvlB = hunterLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.summ)) { summoningLvlB = summoningLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.dung)) { dungeoneeringLvlB = dungeoneeringLvl + amount; }
		else if (skill.equalsIgnoreCase(SkillReference.div)) { divinationLvlB = divinationLvl + amount; }
	}

	private int ticksPassed = 0;
	private int minuteInTicks = 3600;

	/**
	 * Makes sure that boosted levels decreases over time.
	 */
	private void boostedLvlHandling() 
	{
		ticksPassed++;

		if (ticksPassed >= minuteInTicks)
		{
			decreaseBoostedLvls();
			ticksPassed = 0;
		}
	}

	private void decreaseBoostedLvls()
	{
		if (attackLvlB > attackLvl) { attackLvlB--; }   																				if (miningLvlB > miningLvl) { miningLvlB--; }	
		if (strengthLvlB > strengthLvl) { strengthLvlB--; }					if (agilityLvlB > agilityLvl) { agilityLvlB--; }			if (smithingLvlB > smithingLvl) { smithingLvlB--; }
		if (defenceLvlB > defenceLvl) { defenceLvlB--; }					if (herbloreLvlB > herbloreLvl) { herbloreLvlB--; }			if (fishingLvlB > fishingLvl) { fishingLvlB--; }
		if (rangedLvlB > rangedLvl) { rangedLvlB--; }						if (thievingLvlB > thievingLvl) { thievingLvlB--; }			if (cookingLvlB > cookingLvl) { cookingLvlB--; }
		if (craftingLvlB > craftingLvl) { craftingLvlB--; }			if (firemakingLvlB > firemakingLvl) { firemakingLvlB--; }
		if (magicLvlB > magicLvl) { magicLvlB--; }							if (fletchingLvlB > fletchingLvl) { fletchingLvlB--; }		if (woodcuttingLvlB > woodcuttingLvl) { woodcuttingLvlB--; }
		if (runecraftingLvlB > runecraftingLvl) { runecraftingLvlB--; }		if (slayerLvlB > slayerLvl) { slayerLvlB--; }				if (farmingLvlB > farmingLvl) { farmingLvlB--; }
		if (constructionLvlB > constructionLvl) { constructionLvlB--; }		if (hunterLvlB > hunterLvl) { hunterLvlB--; }				if (summoningLvlB > summoningLvl) { summoningLvlB--; }
		if (dungeoneeringLvlB > dungeoneeringLvl) { dungeoneeringLvlB--; }	if (divinationLvlB > divinationLvl) { divinationLvlB--; }		
	}

	public void updateBoostLvls()
	{
		attackLvlB = attackLvl; 												miningLvlB = miningLvl;
		strengthLvlB = strengthLvl; 			agilityLvlB = agilityLvl; 		smithingLvlB = smithingLvl;
		defenceLvlB = defenceLvl; 				herbloreLvlB = herbloreLvl; 	fishingLvlB = fishingLvl;
		rangedLvlB = rangedLvl; 				thievingLvlB = thievingLvl; 	cookingLvlB = cookingLvl;
		craftingLvlB = craftingLvl; 	firemakingLvlB = firemakingLvl;
		magicLvlB = magicLvl; 					fletchingLvlB = fletchingLvl; 	woodcuttingLvlB = woodcuttingLvl;
		runecraftingLvlB = runecraftingLvl; 	slayerLvlB = slayerLvl; 		farmingLvlB = farmingLvl;
		constructionLvlB = constructionLvl; 	hunterLvlB = hunterLvl; 		summoningLvlB = summoningLvl;
		dungeoneeringLvlB = dungeoneeringLvl; 	divinationLvlB = divinationLvl;
	}

	public void decreasePrayerLvl()
	{
		prayerLvlB--;
	}

	/**
	 * Resets all xp and Lvl's that the player has earned in his/hers playtime with the mod.
	 * (Use with caution!!!)
	 */
	public void resetPlayer()
	{	
		// Attack
		setLevel(SkillReference.att, 1, 0);
		// Constitution
		setLevel(SkillReference.cons, 10, 1154D);
		// Mining
		setLevel(SkillReference.mine, 1, 0);
		// Strength
		setLevel(SkillReference.str, 1, 0);
		// Agility
		setLevel(SkillReference.agi, 1, 0);
		// Smithing
		setLevel(SkillReference.smith, 1, 0);
		// Defence
		setLevel(SkillReference.def, 1, 0);
		// Herblore
		setLevel(SkillReference.herb, 1, 0);
		// Fishing
		setLevel(SkillReference.fish, 1, 0);
		// Ranged
		setLevel(SkillReference.range, 1, 0);
		// Thieving
		setLevel(SkillReference.thiev, 1, 0);
		// Cooking
		setLevel(SkillReference.cook, 1, 0);
		// Prayer
		setLevel(SkillReference.pray, 1, 0);
		// Crafting
		setLevel(SkillReference.craft, 1, 0);
		// Firemaking
		setLevel(SkillReference.fm, 1, 0);
		// Magic
		setLevel(SkillReference.mage, 1, 0);
		// Fletching
		setLevel(SkillReference.fletch, 1, 0);
		// Woodcutting
		setLevel(SkillReference.wc, 1, 0);
		// Runecrafting
		setLevel(SkillReference.rc, 1, 0);
		// Slayer
		setLevel(SkillReference.slay, 1, 0);
		// Farming
		setLevel(SkillReference.farm, 1, 0);
		// Construction
		setLevel(SkillReference.con, 1, 0);
		// Hunter
		setLevel(SkillReference.hunt, 1, 0);
		// Summoning
		setLevel(SkillReference.summ, 1, 0);
		// Dungeoneering
		setLevel(SkillReference.dung, 1, 0);
		// Divination
		setLevel(SkillReference.div, 1, 0);
	}

	public void setAllLevels99()
	{
		// Attack
		setLevel(SkillReference.att, 99, 13034431);
		// Constitution
		setLevel(SkillReference.cons, 99, 13034431);
		// Mining
		setLevel(SkillReference.mine, 99, 13034431);
		// Strength
		setLevel(SkillReference.str, 99, 13034431);
		// Agility
		setLevel(SkillReference.agi, 99, 13034431);
		// Smithing
		setLevel(SkillReference.smith, 99, 13034431);
		// Defence
		setLevel(SkillReference.def, 99, 13034431);
		// Herblore
		setLevel(SkillReference.herb, 99, 13034431);
		// Fishing
		setLevel(SkillReference.fish, 99, 13034431);
		// Ranged
		setLevel(SkillReference.range, 99, 13034431);
		// Thieving
		setLevel(SkillReference.thiev, 99, 13034431);
		// Cooking
		setLevel(SkillReference.cook, 99, 13034431);
		// Prayer
		setLevel(SkillReference.pray, 99, 13034431);
		// Crafting
		setLevel(SkillReference.craft, 99, 13034431);
		// Firemaking
		setLevel(SkillReference.fm, 99, 13034431);
		// Magic
		setLevel(SkillReference.mage, 99, 13034431);
		// Fletching
		setLevel(SkillReference.fletch, 99, 13034431);
		// Woodcutting
		setLevel(SkillReference.wc, 99, 13034431);
		// Runecrafting
		setLevel(SkillReference.rc, 99, 13034431);
		// Slayer
		setLevel(SkillReference.slay, 99, 13034431);
		// Farming
		setLevel(SkillReference.farm, 99, 13034431);
		// Construction
		setLevel(SkillReference.con, 99, 13034431);
		// Hunter
		setLevel(SkillReference.hunt, 99, 13034431);
		// Summoning
		setLevel(SkillReference.summ, 99, 13034431);
		// Dungeoneering
		setLevel(SkillReference.dung, 99, 13034431);
		// Divination
		setLevel(SkillReference.div, 99, 13034431);
	}

	public void setAllToMax()
	{
		// Attack
		setLevel(SkillReference.att, 99, 200000000);
		// Constitution
		setLevel(SkillReference.cons, 99, 200000000);
		// Mining
		setLevel(SkillReference.mine, 99, 200000000);
		// Strength
		setLevel(SkillReference.str, 99, 200000000);
		// Agility
		setLevel(SkillReference.agi, 99, 200000000);
		// Smithing
		setLevel(SkillReference.smith, 99, 200000000);
		// Defence
		setLevel(SkillReference.def, 99, 200000000);
		// Herblore
		setLevel(SkillReference.herb, 99, 200000000);
		// Fishing
		setLevel(SkillReference.fish, 99, 200000000);
		// Ranged
		setLevel(SkillReference.range, 99, 200000000);
		// Thieving
		setLevel(SkillReference.thiev, 99, 200000000);
		// Cooking
		setLevel(SkillReference.cook, 99, 200000000);
		// Prayer
		setLevel(SkillReference.pray, 99, 200000000);
		// Crafting
		setLevel(SkillReference.craft, 99, 200000000);
		// Firemaking
		setLevel(SkillReference.fm, 99, 200000000);
		// Magic
		setLevel(SkillReference.mage, 99, 200000000);
		// Fletching
		setLevel(SkillReference.fletch, 99, 200000000);
		// Woodcutting
		setLevel(SkillReference.wc, 99, 200000000);
		// Runecrafting
		setLevel(SkillReference.rc, 99, 200000000);
		// Slayer
		setLevel(SkillReference.slay, 99, 200000000);
		// Farming
		setLevel(SkillReference.farm, 99, 200000000);
		// Construction
		setLevel(SkillReference.con, 99, 200000000);
		// Hunter
		setLevel(SkillReference.hunt, 99, 200000000);
		// Summoning
		setLevel(SkillReference.summ, 99, 200000000);
		// Dungeoneering
		setLevel(SkillReference.dung, 120, 200000000);
		// Divination
		setLevel(SkillReference.div, 99, 200000000);
	}
}