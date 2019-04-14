package core;

import dataStructures.KittyUser;
import dataStructures.Response;
import dataStructures.UserInput;

public class ForbiddenWordManager 
{
	String [] words = {"purple"};
	long orginTime;
	
	public ForbiddenWordManager()
	{
		orginTime = System.currentTimeMillis();
	}
	
	public void check(KittyUser user, UserInput input, Response res)
	{
		long currentTime = System.currentTimeMillis();
		for(int i = 0; i < words.length; i ++)
		{
			if(input.message.toLowerCase().contains(words[i]))
			{
				long timeDif = currentTime - orginTime; 
				orginTime = currentTime;
				int days = (int) (timeDif / (1000*60*60*24));
				int hours = (int) ((timeDif / (1000*60*60)) % 24); 
				int mins = (int) ((timeDif/ (1000*60)) % 60); 
				int secs = (int) (timeDif / 1000) % 60; 
				
				res.Call("*Gasp* " + user.name + " said **the** word! It's been  " + days + " days, " + hours +" hours, " 
						+ mins +" minutes, and " + secs + " seconds since the last time.");
			}
		}
	}
}
