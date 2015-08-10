package javabuckets.mods.rcm.guis;

import java.util.Random;

import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.utility.DateUtil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class GUIDailyGift extends GuiScreen
{
	public GUIDailyGift() 
	{
		
	}
	
	public void initGui() 
	{
		buttonList.clear();
		
		this.buttonList.add(new GUICustomButton(0, width / 2 - 50, height / 2 - 10, 100, 20, "Get Gift!"));
	}
	
	protected void actionPerformed(GuiButton button) 
	{
		Random rand = new Random();
		
		switch (button.id)
		{
			case 0:
			{
				if (RCM.instance.dailyGiftHandler.getDate() == DateUtil.getDate())
				{
					
				}
				else
				{
					RCM.instance.gpHandler.addGPToPouch((long)rand.nextInt(200000));
				}
				
				this.closeGui();
			}
		}
	}
	
	public void closeGui()
	{
		this.mc.displayGuiScreen((GuiScreen)null);
		this.mc.setIngameFocus();
	}
	
	public boolean doesGuiPauseGame() 
	{
		return true;
	}
	
	public void onGuiClosed() 
	{

	}
	
	public void drawScreen(int par1, int par2, float par3) 
	{
		this.drawDefaultBackground();
		
		this.drawCenteredString(mc.fontRenderer, "Daily's Gift's!", width / 2, 15, 0xFFFFFF);
		
		super.drawScreen(par1, par2, par3);
	}
}