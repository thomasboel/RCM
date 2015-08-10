package javabuckets.mods.rcm.guis;

import javabuckets.mods.rcm.main.RCM;
import javabuckets.mods.rcm.utility.LevelUpUtil;
import javabuckets.mods.rcm.utility.SkillReference;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.stats.StatList;
import net.minecraft.util.StatCollector;

public class GUIRCMMainMenu extends GuiScreen
{
	public GUIRCMMainMenu()
	{
		
	}
	
	public void initGui()
	{
		buttonList.clear();
		
		buttonList.add(new GUICustomButton(0, width / 2 - 100, 70, 200, 20, StatCollector.translateToLocal("Back to Game")));
		buttonList.add(new GUICustomButton(1, width / 2 - 100, 95, 97, 20, StatCollector.translateToLocal("Interface Settings")));
		buttonList.add(new GUICustomButton(2, width / 2 + 3, 95, 97, 20, StatCollector.translateToLocal("Fade Test")));
		buttonList.add(new GUICustomButton(3, width / 2 - 100, 145 + 25, 200, 20, StatCollector.translateToLocal("Save and Quit to Title")));
		buttonList.add(new GUICustomButton(4, width / 2 - 100, 120, 97, 20, StatCollector.translateToLocal("Skill Guides")));
	}
	
	protected void actionPerformed(GuiButton button) 
	{
		switch (button.id)
		{
			case 0:
			{
				this.mc.displayGuiScreen((GuiScreen)null);
				this.mc.setIngameFocus();
				break;
			}
			
			case 1:
			{
				//GuiRunescapeInterfaceSettings()
				break;
			}
			
			case 2:
			{
				//GuiTest()
				//GuiTest.isFading = true;
				break;
			}
			
			case 3:
			{
				button.enabled = false;
                this.mc.theWorld.sendQuittingDisconnectingPacket();
                this.mc.loadWorld((WorldClient)null);
                this.mc.displayGuiScreen(new GuiMainMenu());
			}
			
			case 4:
			{
				//GuiSkillGuides()
				break;
			}
		}
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
		
		this.drawCenteredString(mc.fontRenderer, "Runescape game menu", width / 2, 40, 0xFFFFFF);
		
		super.drawScreen(par1, par2, par3);
	}
}
