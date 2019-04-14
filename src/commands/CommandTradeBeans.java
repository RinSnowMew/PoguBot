package commands;

import core.Command;
import dataStructures.KittyChannel;
import dataStructures.KittyGuild;
import dataStructures.KittyRating;
import dataStructures.KittyRole;
import dataStructures.KittyUser;
import dataStructures.Response;
import dataStructures.UserInput;

public class CommandTradeBeans extends Command
{
	public CommandTradeBeans(KittyRole level, KittyRating rating) { super(level, rating); }
	
	@Override
	public String HelpText() { return "Gives another person some of your treats! Use is `tradetreats amount @person`!"; }
	
	@Override
	public void OnRun(KittyGuild guild, KittyChannel channel, KittyUser user, UserInput input, Response res)
	{
		if(input.mentions == null)
		{
			res.Call("You have to give *someone* your treats!");
			return;
		}
		
		int beans = 0;
		try {
			beans = Integer.parseInt(input.args.split(" ")[0]);
		}
		catch (NumberFormatException e)
		{
			res.Call("That not number!");
			return;
		}
		
		if(user.GetBeans() < beans)
		{
			res.Call("You no have many treats!");
			return;
		}
		
		if(beans < 0)
		{
			res.Call("No steal treat! Am take treat!");
			user.ChangeBeans(-10);
			return; 
		}
		
		input.mentions[0].ChangeBeans(beans);
		user.ChangeBeans(-beans);
		res.Call(user.name + " gave " + input.mentions[0].name + " " + beans + " of their treats!");
	}
}
