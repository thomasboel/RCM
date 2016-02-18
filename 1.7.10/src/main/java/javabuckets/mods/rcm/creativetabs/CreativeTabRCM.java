package javabuckets.mods.rcm.creativetabs;

import javabuckets.mods.rcm.init.ModCreativeTabs;
import javabuckets.mods.rcm.skills.attack.ModWeapons;
import javabuckets.mods.rcm.skills.farming.ModFarmingItems;
import javabuckets.mods.rcm.skills.magic.ModMagicWeapons;
import javabuckets.mods.rcm.skills.mining.ModMiningItems;
import javabuckets.mods.rcm.skills.prayer.ModPrayerItems;
import javabuckets.mods.rcm.skills.runecrafting.ModRunecraftingItems;
import javabuckets.mods.rcm.skills.smithing.ModSmithingItems;
import javabuckets.mods.rcm.skills.summoning.ModSummoningItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabRCM extends CreativeTabs
{
	private String tabLabel;
	
	public CreativeTabRCM(String name) 
	{
		super(name.toLowerCase().replace('/', ' '));
		this.tabLabel = name;
	}

	@Override
	public Item getTabIconItem() 
	{
		if (tabLabel.equals(ModCreativeTabs.creativeTabNames[0])) {
			return ModWeapons.dragonLongsword;
		}
		else if (tabLabel.equals(ModCreativeTabs.creativeTabNames[1])) {
			return ModMiningItems.runePickaxe;
		}
		else if (tabLabel.equals(ModCreativeTabs.creativeTabNames[2])) {
			return ModMiningItems.mithrilOre;
		}
		else if (tabLabel.equals(ModCreativeTabs.creativeTabNames[3])) {
			return ModPrayerItems.bigBones;
		}
		else if (tabLabel.equals(ModCreativeTabs.creativeTabNames[4])) {
			return ModMagicWeapons.airStaff;
		}
		else if (tabLabel.equals(ModCreativeTabs.creativeTabNames[5])) {
			return ModFarmingItems.allotmentseed_cabbage;	
		}
		else if (tabLabel.equals(ModCreativeTabs.creativeTabNames[6])) {
			return ModRunecraftingItems.omniTalisman;
		}
		else if (tabLabel.equals(ModCreativeTabs.creativeTabNames[7])) {
			return ModSummoningItems.pouch_spiritWolf;
		}
		
		else { return null; }
	}
	
	@Override
	public String getTranslatedTabLabel()
	{
		return tabLabel;
	}
}