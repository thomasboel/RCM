package javabuckets.mods.rcm.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMagicBolt extends ModelBase
{
	//fields
	ModelRenderer Bolt;

	public ModelMagicBolt()
	{
		textureWidth = 32;
		textureHeight = 32;

		Bolt = new ModelRenderer(this, 0, 0);
		Bolt.addBox(-1F, -1F, -1F, 2, 2, 2);
		Bolt.setRotationPoint(0F, 0F, 0F);
		Bolt.setTextureSize(32, 32);
		Bolt.mirror = true;
		setRotation(Bolt, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		Bolt.render(f5);
	}
	
	public void renderModel(float f5)
	{
		Bolt.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
	}
}