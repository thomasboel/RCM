package javabuckets.mods.rcm.huds;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class HUDScreen extends Gui
{
	private Minecraft mc;
	private RenderItem itemRenderer;
	
	public static final ResourceLocation skills1 = new ResourceLocation(Reference.MOD_ID, "textures/gui/interface/skills1.png");
	public static final ResourceLocation skills2 = new ResourceLocation(Reference.MOD_ID, "textures/gui/interface/skills2.png");

	public HUDScreen(Minecraft mc)
	{
		super();
		this.mc = mc;
		this.itemRenderer = new RenderItem();
	}

	@SubscribeEvent
	public void onRender(RenderGameOverlayEvent event)
	{
		int width = event.resolution.getScaledWidth();
		int height = event.resolution.getScaledHeight();
		renderScreen(event, width, height);
	}

	public void renderScreen(RenderGameOverlayEvent event, int width, int height)
	{
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}

		GL11.glScalef(0.25F, 0.25F, 0.25F);
		mc.renderEngine.bindTexture(skills1);
		drawTexturedModalRect(377, height * 3 + 176, 0, 192, 64, 64);
		mc.renderEngine.bindTexture(skills2);
		drawTexturedModalRect(1373, height * 3 + 176, 192, 64, 64, 64);
		GL11.glScalef(4F, 4F, 4F);
		
		drawString(mc.fontRenderer, "" + (int)RCM.instance.prayer.getPrayerPoints(), width / 2 - width / 4 - 10, height - 15, 0xFFFFFF);
		drawString(mc.fontRenderer, "" + (int)RCM.instance.summoning.getSummoningPoints(), width / 2 + width / 4, height - 15, 0xFFFFFF);
	}
}