package javabuckets.mods.rcm.init;

import javabuckets.mods.rcm.blocks.BlockFixLog;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;

public class ModFixBlocks 
{
	public static Block unbreakable;
	
	public static Block oakLog;
	public static Block spruceLog;
	public static Block jungleLog;
	public static Block birchLog;
	public static Block acaciaLog;
	public static Block darkOakLog;
	
	public static void init()
	{
		/*unbreakable = new BlockUnbreakable(479).setUnlocalizedName("null").setBlockUnbreakable().setStepSound(Block.soundStoneFootstep);
		GameRegistry.registerBlock(unbreakable, "null"); LanguageRegistry.addName(unbreakable, "Experiment XY23uI9");*/
		
		oakLog = new BlockFixLog().setHardness(2.0F).setBlockTextureName("oak_log").setBlockName("oak_log");
		GameRegistry.registerBlock(oakLog, "oak_log");
		
		spruceLog = new BlockFixLog().setHardness(2.0F).setBlockTextureName("spruce_log").setBlockName("spruce_log");
		GameRegistry.registerBlock(spruceLog, "spruce_log");
		
		birchLog = new BlockFixLog().setHardness(2.0F).setBlockTextureName("birch_log").setBlockName("birch_log");
		GameRegistry.registerBlock(birchLog, "birch_log");
		
		jungleLog = new BlockFixLog().setHardness(2.0F).setBlockTextureName("jungle_log").setBlockName("jungle_log");
		GameRegistry.registerBlock(jungleLog, "jungle_log");
		
		acaciaLog = new BlockFixLog().setHardness(2.0F).setBlockTextureName("acacia_log").setBlockName("acacia_log");
		GameRegistry.registerBlock(acaciaLog, "acacia_log");
		
		darkOakLog = new BlockFixLog().setHardness(2.0F).setBlockTextureName("dark_oak_log").setBlockName("dark_oak_log");
		GameRegistry.registerBlock(darkOakLog, "dark_oak_log");
	}
}