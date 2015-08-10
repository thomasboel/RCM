package javabuckets.mods.rcm.handlers;

import org.lwjgl.input.Keyboard;

import javabuckets.mods.rcm.guis.GUICombatSelection;
import javabuckets.mods.rcm.guis.GUIRCMMainMenu;
import javabuckets.mods.rcm.guis.GUISlayerMenu;
import javabuckets.mods.rcm.huds.HUDSkillsTab;
import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.player.ExtendedPlayer;
import javabuckets.mods.rcm.utility.DateUtil;
import javabuckets.mods.rcm.utility.LevelUpUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RCMEventHandler 
{
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer)event.entity) == null)
		{
			ExtendedPlayer.register((EntityPlayer)event.entity);
		}

		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
		{
			event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer)event.entity));
		}
	}
	
	private boolean skillTabOpened = false;
	private boolean isSkillTabTimerRunning = false;
	private int skillTabOpenCloseTimer = 20;
	
	public static boolean isKeyDown = false;
	public static boolean canKeyBeDown = true;
	public static int keyDownResetTimer = 5;
	
	public static boolean hasBeenRun = false;
	
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{	
			EntityPlayer player = (EntityPlayer) event.entity;
			Minecraft mc = Minecraft.getMinecraft();
			
			RCM.instance.skillHandler.onUpdate(player, player.worldObj);
			RCM.instance.gpHandler.onUpdate(player, player.worldObj);
			
			if (Keyboard.isKeyDown(Keyboard.KEY_W) && hasBeenRun == false)
			{
				if (RCM.instance.dailyGiftHandler.getDate() == DateUtil.getDate()) 
				{
					hasBeenRun = true;
				}
				else
				{
					DateUtil.dateHandling();
					hasBeenRun = true;
				}
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			{
				mc.displayGuiScreen(new GUIRCMMainMenu());
				player.addChatMessage(new ChatComponentText(DateUtil.getDate()));
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && Keyboard.isKeyDown(Keyboard.KEY_S))
			{
				mc.displayGuiScreen(new GUISlayerMenu());
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && Keyboard.isKeyDown(Keyboard.KEY_C))
			{
				mc.displayGuiScreen(new GUICombatSelection());
			}
			
			if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && Keyboard.isKeyDown(Keyboard.KEY_F) && skillTabOpened == false && skillTabOpenCloseTimer >= 20)
			{	
				HUDSkillsTab.displaySkillTabMsg = false;
				HUDSkillsTab.displaySkillTab = false;
				skillTabOpened = true;
				isSkillTabTimerRunning = true;
			}
			else if (Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) && Keyboard.isKeyDown(Keyboard.KEY_F) && skillTabOpened == true && skillTabOpenCloseTimer >= 20)
			{
				HUDSkillsTab.displaySkillTab = true;
				skillTabOpened = false;
				isSkillTabTimerRunning = true;
			}
			if (isSkillTabTimerRunning)
			{
				skillTabOpenCloseTimer--;
			}
			if (skillTabOpenCloseTimer <= 0)
			{
				isSkillTabTimerRunning = false;
				skillTabOpenCloseTimer = 20;
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerEnterWorld(EntityJoinWorldEvent event)
	{
		if (event.entity instanceof EntityPlayer)
		{
			LevelUpUtil.lvlHandling();
		}
	}
}
