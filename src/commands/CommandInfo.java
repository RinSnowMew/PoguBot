package commands;

import core.Command;
import dataStructures.KittyChannel;
import dataStructures.KittyGuild;
import dataStructures.KittyRating;
import dataStructures.KittyRole;
import dataStructures.KittyUser;
import dataStructures.Response;
import dataStructures.UserInput;

public class CommandInfo extends Command 
{
	public CommandInfo(KittyRole level, KittyRating rating) { super(level, rating); }
	
	@Override
	public String HelpText() { return "Provides author info and a link to Kitty's website"; }
	
	@Override
	public void OnRun(KittyGuild guild, KittyChannel channel, KittyUser user, UserInput input, Response res)
	{
		String info = "I'm made by `Rin#8904` and `Reverie Wisp#3703`!\n"
				+ "I'm made from kittybot! You can find out more about her at `https://kittybot.net`!\n"
				+ "My icon was drawn by the one and only Drako!" ;
		res.Call(info);
	}
}