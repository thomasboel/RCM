package javabuckets.mods.rcm.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ModEnums 
{
	public static Item.ToolMaterial bronze = EnumHelper.addToolMaterial("BRONZE", 1, 172, 5.0F, 1.5F, 10);
	public static Item.ToolMaterial steel = EnumHelper.addToolMaterial("STEEL", 2, 478, 6.75F, 2.3F, 10);
	public static Item.ToolMaterial black = EnumHelper.addToolMaterial("BLACK", 2, 768, 7.5F, 2.7F, 10);
	public static Item.ToolMaterial white = EnumHelper.addToolMaterial("WHITE", 2, 823, 7.5F, 2.8F, 10);
	public static Item.ToolMaterial mithril = EnumHelper.addToolMaterial("MITHRIL", 3, 1054, 8.4F, 3.2F, 10);
	public static Item.ToolMaterial adamantite = EnumHelper.addToolMaterial("ADAMANTITE", 3, 1467, 9.0F, 3.6F, 10);
	public static Item.ToolMaterial runite = EnumHelper.addToolMaterial("RUNITE", 3, 1845, 9.9F, 4.5F, 10);
	public static Item.ToolMaterial bronzeLong = EnumHelper.addToolMaterial("BRONZE", 1, 201, 5.3F, 1.75F, 15);
	public static Item.ToolMaterial steelLong = EnumHelper.addToolMaterial("STEEL", 2, 523, 7.0F, 2.6F, 15);
	public static Item.ToolMaterial blackLong = EnumHelper.addToolMaterial("BLACK", 2, 834, 7.8F, 2.9F, 15);
	public static Item.ToolMaterial whiteLong = EnumHelper.addToolMaterial("WHITE", 2, 956, 7.8F, 3.0F, 15);
	public static Item.ToolMaterial mithrilLong = EnumHelper.addToolMaterial("MITHRIL", 3, 1278, 8.9F, 3.5F, 15);
	public static Item.ToolMaterial adamantiteLong = EnumHelper.addToolMaterial("ADAMANTITE", 3, 1604, 9.4F, 3.9F, 15);
	public static Item.ToolMaterial runiteLong = EnumHelper.addToolMaterial("RUNITE", 3, 2100, 10.3F, 4.8F, 15);
	public static Item.ToolMaterial dragonTool = EnumHelper.addToolMaterial("DRAGONTOOL", 3, 5346, 14.2F, 12.6F, 15);
	public static Item.ToolMaterial dragonDagger = EnumHelper.addToolMaterial("DRAGONDAGGER", 3, 5287, 14.2F, 10.9F, 15);
	public static Item.ToolMaterial dragonLong = EnumHelper.addToolMaterial("DRAGONLONGSWORD", 3, 5346, 14.2F, 14.6F, 15);
	public static Item.ToolMaterial dragonMace = EnumHelper.addToolMaterial("DRAGONMACE", 3, 5321, 14.2F, 13.8F, 15);
	public static Item.ToolMaterial abyssalWhip = EnumHelper.addToolMaterial("ABYSSALWHIP", 3, 6754, 16.5F, 15.8F, 18);
	public static Item.ToolMaterial godSword = EnumHelper.addToolMaterial("GODSWORD", 3, 15452, 21.4F, 34.4F, 23);
	public static Item.ToolMaterial drygoreLong = EnumHelper.addToolMaterial("DRYGORE", 3, 12976, 23.8F, 24.9F, 26);
	public static Item.ToolMaterial drygoreRapier = EnumHelper.addToolMaterial("DRYGORRAPIER", 3, 12976, 23.8F, 24.0F, 26);
	public static Item.ToolMaterial drygoreMace = EnumHelper.addToolMaterial("DRYGOREMACE", 3, 12976, 23.8F, 25.2F, 26);
	
	public static ItemArmor.ArmorMaterial bronzeArmory = EnumHelper.addArmorMaterial("BRONZEARMORY", 10, new int[]{1, 4, 3, 1}, 20);
	public static ItemArmor.ArmorMaterial steelArmory = EnumHelper.addArmorMaterial("STEELARMORY", 25, new int[]{2, 6, 6, 2}, 20);
	public static ItemArmor.ArmorMaterial blackArmory = EnumHelper.addArmorMaterial("BLACKARMORY", 28, new int[]{2, 7, 6, 2}, 20);
	public static ItemArmor.ArmorMaterial whiteArmory = EnumHelper.addArmorMaterial("WHITEARMORY", 31, new int[]{2, 7, 6, 2}, 20);
	public static ItemArmor.ArmorMaterial mithrilArmory = EnumHelper.addArmorMaterial("MITHRILARMORY", 36, new int[]{4, 9, 7, 3}, 20);
	public static ItemArmor.ArmorMaterial adamantArmory = EnumHelper.addArmorMaterial("ADAMANTARMORY", 40, new int[]{5, 11, 8, 4}, 20);
	public static ItemArmor.ArmorMaterial runeArmory = EnumHelper.addArmorMaterial("RUNELARMORY", 45, new int[]{6, 13, 10, 5}, 20);
	public static ItemArmor.ArmorMaterial dragonArmory = EnumHelper.addArmorMaterial("DRAGONARMORY", 52, new int[]{8, 18, 13, 6}, 20);
	public static ItemArmor.ArmorMaterial bandosArmory = EnumHelper.addArmorMaterial("BANDOSARMORY", 59, new int[]{9, 21, 14, 7}, 25);
}