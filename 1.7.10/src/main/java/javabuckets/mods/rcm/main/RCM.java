package javabuckets.mods.rcm.main;

import net.minecraftforge.common.MinecraftForge;
import javabuckets.mods.rcm.commands.CommandSetLevel;
import javabuckets.mods.rcm.handlers.*;
import javabuckets.mods.rcm.huds.*;
import javabuckets.mods.rcm.init.*;
import javabuckets.mods.rcm.proxies.*;
import javabuckets.mods.rcm.skills.BaseSkill;
import javabuckets.mods.rcm.skills.SkillHandler;
import javabuckets.mods.rcm.skills.combat.*;
import javabuckets.mods.rcm.skills.mining.*;
import javabuckets.mods.rcm.skills.woodcutting.*;
import javabuckets.mods.rcm.utility.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)

public class RCM 
{
	@SidedProxy(clientSide = "javabuckets.mods.rcm.proxies.ClientProxy", serverSide = "javabuckets.mods.rcm.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance(Reference.MOD_ID)
	public static RCM instance;
	
	public SkillHandler skillHandler = new SkillHandler();
	public BaseSkill skill = new BaseSkill();
	
	public CombatHandler combat = new CombatHandler();
	public MiningHandler mining = new MiningHandler();
	public WoodcuttingHandler woodcutting = new WoodcuttingHandler();
	
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
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(new CombatEventHandler());
		MinecraftForge.EVENT_BUS.register(new MiningEventHandler());
		MinecraftForge.EVENT_BUS.register(new WoodcuttingEventHandler());
	}
	
	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandSetLevel());
	}
}
