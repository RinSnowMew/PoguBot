package commands;

import core.Command;
import dataStructures.*;

public class CommandEightBall extends Command
{
	String [] answers = {"I say yes.", "Me thinks so.","No doubts.",
			"Define-itely!", "For sure!", "Biiiig maybe.", "Think so...","Look good.", "Yes!",
			"is possible.","Am no sure, ask later.","Maybe later.","Better not tell now.","Don't know.","What say?","Don't count it.",
			"Nope", "Me think not.","Yeesss...? hm.. noo?.","Doubt it."};
	public CommandEightBall(KittyRole level, KittyRating rating) 
	{ 
		super(level, rating); 
	}
	
	@Override
	public String HelpText() { return "Answers a yes or no question! Warning: Kitty can not actually tell the future,"
			+ " she claims no responsibility for any lion mauling, lack of lottery wins, or felony charges."; }
	
	@Override
	public void OnRun(KittyGuild guild, KittyChannel channel, KittyUser user, UserInput input, Response res)
	{
		res.Call(answers[(int) (Math.random()*answers.length)]);
	}
}
