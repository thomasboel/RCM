package javabuckets.mods.rcm.init;

import javabuckets.mods.rcm.creativetabs.CreativeTabRCM;
import net.minecraft.creativetab.CreativeTabs;

public class ModCreativeTabs 
{
	public static CreativeTabs rcmWeapons, rcmTools, rcmResources, rcmLoot, rcmMagic, rcmRunecrafting, rcmSummoning;
	public static String[] creativeTabNames = { "Weaponry/Gear", "Tools", "Resources", "Drop/Loot", "Magic", "Runecrafting", "Summoning" };
	
	public static void init()
	{
		rcmWeapons = new CreativeTabRCM(creativeTabNames[0]);
		rcmTools = new CreativeTabRCM(creativeTabNames[1]);
		rcmResources = new CreativeTabRCM(creativeTabNames[2]);
		rcmLoot = new CreativeTabRCM(creativeTabNames[3]);
		rcmMagic = new CreativeTabRCM(creativeTabNames[4]);
		rcmRunecrafting = new CreativeTabRCM(creativeTabNames[5]);
		rcmSummoning = new CreativeTabRCM(creativeTabNames[6]);
	}
}