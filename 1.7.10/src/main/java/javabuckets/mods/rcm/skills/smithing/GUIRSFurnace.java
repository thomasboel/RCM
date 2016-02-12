//package javabuckets.mods.rcm.skills.smithing;
//
//import org.lwjgl.opengl.GL11;
//
//import javabuckets.mods.rcm.guis.GUICustomButton;
//import javabuckets.mods.rcm.guis.GUICustomButtonInv;
//import javabuckets.mods.rcm.main.RCM;
//import javabuckets.mods.rcm.utility.GUIUtil;
//import javabuckets.mods.rcm.utility.LogHelper;
//import javabuckets.mods.rcm.utility.Reference;
//import javabuckets.mods.rcm.utility.SkillReference;
//import javabuckets.mods.rcm.utility.UtilAPI;
//import net.minecraft.client.gui.GuiButton;
//import net.minecraft.client.gui.GuiScreen;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.Items;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.ResourceLocation;
//
//public class GUIRSFurnace extends GuiScreen
//{
//	private String subject = "";
//	private double xpToShow = 0D;
//	private int requiredLevel = 0;
//
//	private int amountToCraft = 1;
//	
//	private int[] xAmount = new int[9];
//
//	private boolean hasRunned = false;
//
//	public static final ResourceLocation skillingWindow = new ResourceLocation(Reference.MOD_ID, "textures/gui/rcmskillingwindowsmelting.png");
//	public static final ResourceLocation smithingSkill = new ResourceLocation(Reference.MOD_ID, "textures/gui/interface/skills1.png");
//	public static final ResourceLocation smeltingSubjects = new ResourceLocation(Reference.MOD_ID, "textures/gui/subjects/smeltingsubjects.png");
//
//	public EntityPlayer player;
//
//	public GUIRSFurnace(EntityPlayer player)
//	{
//		this.player = player;
//	}
//
//	public void initGui() 
//	{
//		buttonList.clear();
//
//		buttonList.add(new GUICustomButtonInv(0, 347, 28, 18, 18, ""));
//
//		addCraftingOption(10, 130, 65); // Bronze Bar
//		addCraftingOption(11, 130 + (23 * 1), 65); // Iron Bar
//		addCraftingOption(12, 130 + (23 * 2), 65); // Silver Bar
//		addCraftingOption(13, 130 + (23 * 3), 65); // Steel Bar
//		addCraftingOption(14, 130, 65 + 23); // Gold Bar
//		addCraftingOption(15, 130 + (23 * 1), 65 + 23); // Mithril Bar
//		addCraftingOption(16, 130 + (23 * 2), 65 + 23); // Adamant Bar
//		addCraftingOption(17, 130 + (23 * 3), 65 + 23); // Rune Bar
//
//		buttonList.add(new GUICustomButtonInv(50, width / 2 - 7, height - 79, 109, 20, ""));
//
//		if (!hasRunned)
//		{
//			ItemStack[] inventory = player.inventory.mainInventory;
//
//			xAmount[0] = UtilAPI.getAmountOfItemInInventory(player.inventory, "Coal");
//			xAmount[1] = UtilAPI.getAmountOfItemInInventory(player.inventory, "Copper Ore");
//			xAmount[2] = UtilAPI.getAmountOfItemInInventory(player.inventory, "Tin Ore");
//			xAmount[3] = UtilAPI.getAmountOfItemInInventory(player.inventory, "Iron Ore");
//			xAmount[4] = UtilAPI.getAmountOfItemInInventory(player.inventory, "Silver Ore");
//			xAmount[5] = UtilAPI.getAmountOfItemInInventory(player.inventory, "Gold Ore");
//			xAmount[6] = UtilAPI.getAmountOfItemInInventory(player.inventory, "Mithril Ore");
//			xAmount[7] = UtilAPI.getAmountOfItemInInventory(player.inventory, "Adamantite Ore");
//			xAmount[8] = UtilAPI.getAmountOfItemInInventory(player.inventory, "Runite Ore");
//			
//			hasRunned = true;
//		}
//	}
//
//	public void addCraftingOption(int btnId, int width, int height)
//	{
//		buttonList.add(new GUICustomButton(btnId, width, height, 18, 18, ""));
//	}
//
//	protected void actionPerformed(GuiButton button) 
//	{
//		switch(button.id)
//		{
//		case 0: 
//		{
//			this.mc.displayGuiScreen((GuiScreen)null);
//			this.mc.setIngameFocus();
//			break;
//		}
//
//		case 10: { this.subject = "bronze_bar"; 	this.xpToShow = 7.5; 	this.requiredLevel = 1;  	break; }
//		case 11: { this.subject = "iron_bar"; 		this.xpToShow = 12.5; 	this.requiredLevel = 10; 	break; }
//		case 12: { this.subject = "silver_bar"; 	this.xpToShow = 15; 	this.requiredLevel = 20; 	break; }
//		case 13: { this.subject = "steel_bar"; 		this.xpToShow = 25; 	this.requiredLevel = 30; 	break; }
//		case 14: { this.subject = "gold_bar"; 		this.xpToShow = 30; 	this.requiredLevel = 40; 	break; }
//		case 15: { this.subject = "mithril_bar"; 	this.xpToShow = 45; 	this.requiredLevel = 50; 	break; }
//		case 16: { this.subject = "adamant_bar"; 	this.xpToShow = 75; 	this.requiredLevel = 70; 	break; }
//		case 17: { this.subject = "rune_bar";	 	this.xpToShow = 125; 	this.requiredLevel = 85; 	break; }
//		
//		case 50:
//		{
//			RCM.instance.smithing.meltBar(this.subject, this.xpToShow, this.requiredLevel, RCM.instance.skillHandler.getLevel(SkillReference.smith), xAmount, player.inventory, this.mc);
//			break;
//		}
//		}
//	}
//
//	public boolean doesGuiPauseGame() 
//	{
//		return false;
//	}
//
//	public void onGuiClosed() 
//	{
//		
//	}
//
//	public void drawScreen(int par1, int par2, float par3) 
//	{
//		GL11.glEnable(GL11.GL_BLEND);
//		GL11.glDisable(GL11.GL_TEXTURE_2D);
//		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
//		GL11.glColor4f(1F, 1F, 1F, 1F);
//		GL11.glEnable(GL11.GL_TEXTURE_2D);
//
//		GL11.glScalef(1.5F, 1.5F, 1.5F);
//
//		mc.renderEngine.bindTexture(skillingWindow);
//		drawTexturedModalRect(width / 2 - 163, 17, 0, 0, 333, 228);
//
//		GL11.glScalef(0.6667F, 0.6667F, 0.6667F);
//
//		super.drawScreen(par1, par2, par3);
//
//		GL11.glScalef(0.8F, 0.8F, 0.8F);
//		this.drawString(mc.fontRenderer, "" + amountToCraft, 426, 207, 0xAF6E1D);
//		this.drawString(mc.fontRenderer, "Value", 285, 110, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, "Requirements", 285, 141, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, "At least Smithing Level: " + this.requiredLevel, 290, 151, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, "Materials", 285, 173, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, this.subject.replace('_', ' '), 322, 80, 0xFFFFFF);
//
//		/**
//		 * New Stuff
//		 */
//
//		this.drawString(mc.fontRenderer, "Coal: " + xAmount[0], 50, 50, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, "Copper: " + xAmount[1], 50, 62, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, "Tin: " + xAmount[2], 50, 74, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, "Iron: " + xAmount[3], 50, 86, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, "Silver: " + xAmount[4], 50, 98, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, "Gold: " + xAmount[5], 50, 110, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, "Mithril: " + xAmount[6], 50, 122, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, "Adamantie: " + xAmount[7], 50, 134, 0xFFFFFF);
//		this.drawString(mc.fontRenderer, "Runite: " + xAmount[8], 50, 146, 0xFFFFFF);
//
//		/**
//		 * END New Stuff
//		 */	
//
//		GL11.glScalef(0.4F, 0.4F, 0.4F);
//		mc.renderEngine.bindTexture(smeltingSubjects);
//		drawTexturedModalRect(403, 198, 0, 0, 64, 64);
//		drawTexturedModalRect(403 + (72), 198, 64, 0, 64, 64);
//		drawTexturedModalRect(403 + (72 * 2), 198, 64+64, 0, 64, 64);
//		drawTexturedModalRect(403 + (72 * 3), 198, 64+64+64, 0, 64, 64);
//		drawTexturedModalRect(403, 270, 0, 64, 64, 64);
//		drawTexturedModalRect(403 + (72), 270, 64, 64, 64, 64);
//		drawTexturedModalRect(403 + (72 * 2), 270, 64+64, 64, 64, 64);
//		drawTexturedModalRect(403 + (72 * 3), 270, 64+64+64, 64, 64, 64);
//
//		if (this.subject == "bronze_bar") { drawTexturedModalRect(718, 178, 0, 0, 64, 64); }
//		else if (this.subject == "iron_bar") { drawTexturedModalRect(718, 178, 64, 0, 64, 64); }
//		else if (this.subject == "silver_bar") { drawTexturedModalRect(718, 178, 64+64, 0, 64, 64); }
//		else if (this.subject == "steel_bar") { drawTexturedModalRect(718, 178, 64+64+64, 0, 64, 64); }
//		else if (this.subject == "gold_bar") { drawTexturedModalRect(718, 178, 0, 64, 64, 64); }
//		else if (this.subject == "mithril_bar") { drawTexturedModalRect(718, 178, 64, 64, 64, 64); }
//		else if (this.subject == "adamant_bar") { drawTexturedModalRect(718, 178, 64+64, 64, 64, 64); }
//		else if (this.subject == "rune_bar") { drawTexturedModalRect(718, 178, 64+64+64, 64, 64, 64); }
//	}
//}
package javabuckets.mods.rcm.skills.smithing;

import org.lwjgl.opengl.GL11;

import javabuckets.mods.rcm.blocks.containers.ContainerRSFurnace;
import javabuckets.mods.rcm.blocks.tileentities.TileEntityRSFurnace;
import javabuckets.mods.rcm.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUIRSFurnace extends GuiContainer
{
	private TileEntityRSFurnace furnace;
	
    public GUIRSFurnace(InventoryPlayer playerInventory, TileEntityRSFurnace tile)
    {
    	super(new ContainerRSFurnace(playerInventory, tile));
    	this.furnace = tile;
    	this.xSize = 176;
    	this.ySize = 166;
    }
    
    public static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/smithing/rcmfurnace.png");
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int j, int i) 
    {
    	GL11.glColor4f(1F, 1F, 1F, 1F);
    	Minecraft.getMinecraft().renderEngine.bindTexture(texture);
    	drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
}