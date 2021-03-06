package javabuckets.mods.rcm.renderers.blocks;

import org.lwjgl.opengl.GL11;

import javabuckets.mods.rcm.blocks.tileentities.TileEntityFire;
import javabuckets.mods.rcm.models.ModelFire;
import javabuckets.mods.rcm.utility.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class BlockRendererFire extends TileEntitySpecialRenderer
{
	private ModelFire model;
	
	public BlockRendererFire() 
	{
		model = new ModelFire();
	}
	
	public void renderAModelAt(TileEntityFire tile, double x, double y, double z, float f)
	{
		int rotation = 0;
		
		if (tile.getWorldObj() != null)
		{
			rotation = tile.getBlockMetadata();
		}
		
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/fire.png"));
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glRotatef(rotation*90, 0F, 1F, 0F);
		model.renderModel(0.0625F);
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f)
	{
		this.renderAModelAt((TileEntityFire)tileEntity, x, y, z, f);
	}
}