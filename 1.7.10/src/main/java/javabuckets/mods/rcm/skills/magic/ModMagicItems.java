package javabuckets.mods.rcm.skills.magic;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModMagicItems 
{
	public static Item airRune;
	public static Item mindRune;
	public static Item waterRune;
	public static Item earthRune;
	public static Item fireRune;
	public static Item bodyRune;
	public static Item cosmicRune;
	public static Item chaosRune;
	public static Item astralRune;
	public static Item natureRune;
	public static Item lawRune;
	public static Item deathRune;
	public static Item bloodRune;
	public static Item soulRune;
	public static Item armadylRune;
	
	public static void init()
	{
		airRune = new ItemRune("air_rune");
		GameRegistry.registerItem(airRune, "air_rune");
		
		mindRune = new ItemRune("mind_rune");
		GameRegistry.registerItem(mindRune, "mind_rune");
		
		waterRune = new ItemRune("water_rune");
		GameRegistry.registerItem(waterRune, "water_rune");
		
		earthRune = new ItemRune("earth_rune");
		GameRegistry.registerItem(earthRune, "earth_rune");
		
		fireRune = new ItemRune("fire_rune");
		GameRegistry.registerItem(fireRune, "fire_rune");
		
		bodyRune = new ItemRune("body_rune");
		GameRegistry.registerItem(bodyRune, "body_rune");
		
		cosmicRune = new ItemRune("cosmic_rune");
		GameRegistry.registerItem(cosmicRune, "cosmic_rune");
		
		chaosRune = new ItemRune("chaos_rune");
		GameRegistry.registerItem(chaosRune, "chaos_rune");
		
		astralRune = new ItemRune("astral_rune");
		GameRegistry.registerItem(astralRune, "astral_rune");
		
		natureRune = new ItemRune("nature_rune");
		GameRegistry.registerItem(natureRune, "nature_rune");
		
		lawRune = new ItemRune("law_rune");
		GameRegistry.registerItem(lawRune, "law_rune");
		
		deathRune = new ItemRune("death_rune");
		GameRegistry.registerItem(deathRune, "death_rune");
		
		bloodRune = new ItemRune("blood_rune");
		GameRegistry.registerItem(bloodRune, "blood_rune");
		
		soulRune = new ItemRune("soul_rune");
		GameRegistry.registerItem(soulRune, "soul_rune");
		
		armadylRune = new ItemRune("armadyl_rune");
		GameRegistry.registerItem(armadylRune, "armadyl_rune");
	}
}