package javabuckets.mods.rcm.commands;

import java.util.List;

import javabuckets.mods.rcm.items.ItemBase;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;

public class AdminCommandBuy extends CommandBase
{

	public String getCommandName() 
	{
		return "buy";
	}

	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/buy <player> <item.name>";
	}

	public void processCommand(ICommandSender icommandsender, String[] astring) 
	{
		if (astring.length < 2)
        {
            throw new WrongUsageException("Usage: /buy <player> <item.name>", new Object[0]);
        }
        else
        {
            EntityPlayerMP entityplayermp = getPlayer(icommandsender, astring[0]);
            Item item = getItemByText(icommandsender, astring[1]);
            int i = 1;
            int j = 0;

            if (astring.length >= 3)
            {
                i = parseIntBounded(icommandsender, astring[2], 1, 64);
            }

            if (astring.length >= 4)
            {
                j = parseInt(icommandsender, astring[3]);
            }

            ItemStack itemstack = new ItemStack(item, i, j);

            if (astring.length >= 5)
            {
                String s = func_147178_a(icommandsender, astring, 4).getUnformattedText();

                try
                {
                    NBTBase nbtbase = JsonToNBT.func_150315_a(s);

                    if (!(nbtbase instanceof NBTTagCompound))
                    {
                        func_152373_a(icommandsender, this, "commands.give.tagError", new Object[] {"Not a valid tag"});
                        return;
                    }

                    itemstack.setTagCompound((NBTTagCompound)nbtbase);
                }
                catch (NBTException nbtexception)
                {
                    func_152373_a(icommandsender, this, "commands.give.tagError", new Object[] {nbtexception.getMessage()});
                    return;
                }
            }

            EntityItem entityitem = entityplayermp.dropPlayerItemWithRandomChoice(itemstack, false);
            entityitem.delayBeforeCanPickup = 0;
            entityitem.func_145797_a(entityplayermp.getCommandSenderName());
            func_152373_a(icommandsender, this, "Succesfully bought you your item(s)!", new Object[] {itemstack.func_151000_E(), Integer.valueOf(i), entityplayermp.getCommandSenderName()});
        }
	}
	
	public List addTabCompletionOptions(ICommandSender par1iCommandSender, String[] astring) 
	{
		if (astring.length == 1)
		{
			return getListOfStringsMatchingLastWord(astring, this.getPlayers());
		}
		if (astring.length == 2)
		{
			return getListOfStringsMatchingLastWord(astring, ItemBase.itemList.toArray(new String[ItemBase.itemList.size()]));
		}
		return null;
	}
	
    protected String[] getPlayers()
    {
        return MinecraftServer.getServer().getAllUsernames();
    }
    
    public boolean isUsernameIndex(String[] astring, int i)
    {
        return i == 0;
    }
}