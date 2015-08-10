package javabuckets.mods.rcm.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.minecraft.client.Minecraft;
import javabuckets.mods.rcm.guis.GUIDailyGift;
import javabuckets.mods.rcm.main.RCM;

public class DateUtil 
{
	public static String date;
	
	public static String getDate()
	{
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");
		
		return ft.format(dNow);
	}
	
	public static void dateHandling()
	{
		Minecraft mc = Minecraft.getMinecraft();
		
		date = RCM.instance.dailyGiftHandler.getDate();
		mc.displayGuiScreen(new GUIDailyGift());
		
		RCM.instance.dailyGiftHandler.setDate(getDate());
	}
}