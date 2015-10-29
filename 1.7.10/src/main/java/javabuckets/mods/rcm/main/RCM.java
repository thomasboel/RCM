package javabuckets.mods.rcm.main;

import javabuckets.mods.rcm.commands.CommandFixErrors;
import javabuckets.mods.rcm.commands.CommandSetBossTask;
import javabuckets.mods.rcm.commands.CommandSetGp;
import javabuckets.mods.rcm.commands.CommandSetLevel;
import javabuckets.mods.rcm.commands.CommandSetLvlChecker;
import javabuckets.mods.rcm.commands.CommandSetMisc;
import javabuckets.mods.rcm.commands.CommandSetSlayerTask;
import javabuckets.mods.rcm.generators.WorldOreGenerator;
import javabuckets.mods.rcm.handlers.DailyChallengeHandler;
import javabuckets.mods.rcm.handlers.DailyGiftHandler;
import javabuckets.mods.rcm.handlers.EntityEventHandler;
import javabuckets.mods.rcm.handlers.GuiHandler;
import javabuckets.mods.rcm.handlers.RCMEventHandler;
import javabuckets.mods.rcm.handlers.RCMGpHandler;
import javabuckets.mods.rcm.huds.HUDOverlay;
import javabuckets.mods.rcm.init.ModBlocks;
import javabuckets.mods.rcm.init.ModCommands;
import javabuckets.mods.rcm.init.ModEnums;
import javabuckets.mods.rcm.init.ModEvents;
import javabuckets.mods.rcm.init.ModItems;
import javabuckets.mods.rcm.init.ModRecipes;
import javabuckets.mods.rcm.player.PlayerBonuses;
import javabuckets.mods.rcm.proxies.CommonProxy;
import javabuckets.mods.rcm.skills.BaseSkill;
import javabuckets.mods.rcm.skills.SkillHandler;
import javabuckets.mods.rcm.skills.combat.CombatEventHandler;
import javabuckets.mods.rcm.skills.combat.CombatHandler;
import javabuckets.mods.rcm.skills.combat.constitution.ConstitutionEventHandler;
import javabuckets.mods.rcm.skills.combat.defence.DefenceEventHandler;
import javabuckets.mods.rcm.skills.combat.strength.StrengthEventHandler;
import javabuckets.mods.rcm.skills.farming.FarmingHandler;
import javabuckets.mods.rcm.skills.fishing.FishingEventHandler;
import javabuckets.mods.rcm.skills.fishing.FishingHandler;
import javabuckets.mods.rcm.skills.mining.MiningEventHandler;
import javabuckets.mods.rcm.skills.mining.MiningHandler;
import javabuckets.mods.rcm.skills.prayer.PrayerEventHandler;
import javabuckets.mods.rcm.skills.prayer.PrayerHandler;
import javabuckets.mods.rcm.skills.slayer.SlayerEventHandler;
import javabuckets.mods.rcm.skills.slayer.SlayerHandler;
import javabuckets.mods.rcm.skills.smithing.SmithingEventHandler;
import javabuckets.mods.rcm.skills.smithing.SmithingHandler;
import javabuckets.mods.rcm.skills.summoning.SummoningHandler;
import javabuckets.mods.rcm.skills.thieving.ThievingEventHandler;
import javabuckets.mods.rcm.skills.thieving.ThievingHandler;
import javabuckets.mods.rcm.skills.woodcutting.WoodcuttingEventHandler;
import javabuckets.mods.rcm.skills.woodcutting.WoodcuttingHandler;
import javabuckets.mods.rcm.utility.Reference;
import javabuckets.mods.rcm.utility.SkillReference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)

public class RCM // 478 63 349 HOME              -770 16 300 SOME CAVE                -915 13 290                  596 37 408 UNEXPLOIRED CAVE                        1405 80 -603 JUNGLE
{ // Home 718 81 -150		Farm 2147 64 -600
	@SidedProxy(clientSide = "javabuckets.mods.rcm.proxies.ClientProxy",
				serverSide = "javabuckets.mods.rcm.proxies.CommonProxy")
	public static CommonProxy proxy;

	@Instance(Reference.MOD_ID)
	public static RCM instance;

	public SkillHandler skillHandler = new SkillHandler();
	public BaseSkill skill = new BaseSkill();
	public RCMGpHandler gpHandler = new RCMGpHandler();

	public CombatHandler combat = new CombatHandler();
	public MiningHandler mining = new MiningHandler();
	public SmithingHandler smithing = new SmithingHandler();
	public FishingHandler fishing = new FishingHandler();
	public ThievingHandler thieving = new ThievingHandler();
	public PrayerHandler prayer = new PrayerHandler();
	public WoodcuttingHandler woodcutting = new WoodcuttingHandler();
	public SlayerHandler slayer = new SlayerHandler();
	public FarmingHandler farming = new FarmingHandler();
	public SummoningHandler summoning = new SummoningHandler();
	
	public DailyGiftHandler dailyGiftHandler = new DailyGiftHandler();
	public PlayerBonuses playerBonuses = new PlayerBonuses();
	public DailyChallengeHandler dailies = new DailyChallengeHandler();

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		HUDOverlay.init();
		ModBlocks.init();
		ModItems.init();
		ModRecipes.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ModEvents.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		ModEvents.postInit();
		proxy.proxy();
	}

	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event)
	{
		ModCommands.init(event);
	}
}