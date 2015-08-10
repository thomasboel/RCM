package javabuckets.mods.rcm.main;

import javabuckets.mods.rcm.commands.CommandFixErrors;
import javabuckets.mods.rcm.commands.CommandSetBossTask;
import javabuckets.mods.rcm.commands.CommandSetGp;
import javabuckets.mods.rcm.commands.CommandSetLevel;
import javabuckets.mods.rcm.commands.CommandSetLvlChecker;
import javabuckets.mods.rcm.commands.CommandSetMisc;
import javabuckets.mods.rcm.commands.CommandSetSlayerTask;
import javabuckets.mods.rcm.generators.WorldOreGenerator;
import javabuckets.mods.rcm.handlers.DailyGiftHandler;
import javabuckets.mods.rcm.handlers.EntityEventHandler;
import javabuckets.mods.rcm.handlers.GuiHandler;
import javabuckets.mods.rcm.handlers.RCMEventHandler;
import javabuckets.mods.rcm.handlers.RCMGpHandler;
import javabuckets.mods.rcm.huds.HUDOverlay;
import javabuckets.mods.rcm.init.ModBlocks;
import javabuckets.mods.rcm.init.ModEnums;
import javabuckets.mods.rcm.init.ModItems;
import javabuckets.mods.rcm.init.ModRecipes;
import javabuckets.mods.rcm.proxies.CommonProxy;
import javabuckets.mods.rcm.skills.BaseSkill;
import javabuckets.mods.rcm.skills.SkillHandler;
import javabuckets.mods.rcm.skills.combat.CombatEventHandler;
import javabuckets.mods.rcm.skills.combat.CombatHandler;
import javabuckets.mods.rcm.skills.combat.constitution.ConstitutionEventHandler;
import javabuckets.mods.rcm.skills.combat.defence.DefenceEventHandler;
import javabuckets.mods.rcm.skills.combat.strength.StrengthEventHandler;
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

public class RCM 
{
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
	
	public DailyGiftHandler dailyGiftHandler = new DailyGiftHandler();

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
		MinecraftForge.EVENT_BUS.register(new RCMEventHandler());
		MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		GameRegistry.registerWorldGenerator(new WorldOreGenerator(), 0);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new CombatEventHandler());
		MinecraftForge.EVENT_BUS.register(new ConstitutionEventHandler());
		MinecraftForge.EVENT_BUS.register(new MiningEventHandler());
		MinecraftForge.EVENT_BUS.register(new StrengthEventHandler());
		MinecraftForge.EVENT_BUS.register(new DefenceEventHandler());
		FMLCommonHandler.instance().bus().register(new SmithingEventHandler());
		MinecraftForge.EVENT_BUS.register(new FishingEventHandler());
		MinecraftForge.EVENT_BUS.register(new ThievingEventHandler());
		MinecraftForge.EVENT_BUS.register(new PrayerEventHandler());
		MinecraftForge.EVENT_BUS.register(new WoodcuttingEventHandler());
		MinecraftForge.EVENT_BUS.register(new SlayerEventHandler());
	}

	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandSetLevel());
		event.registerServerCommand(new CommandSetGp());
		event.registerServerCommand(new CommandSetMisc());

		event.registerServerCommand(new CommandFixErrors());

		event.registerServerCommand(new CommandSetSlayerTask());
		event.registerServerCommand(new CommandSetBossTask());
	}
}