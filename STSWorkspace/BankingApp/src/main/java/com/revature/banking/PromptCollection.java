package com.revature.banking;

import java.util.ArrayList;

public class PromptCollection 
{
	public PromptChoice main1 = new PromptChoice(1, "Login");
	public PromptChoice main2 = new PromptChoice(2, "Create Account");
	public PromptChoice main3 = new PromptChoice(3, "Quit");
	public ArrayList<PromptChoice> list = new ArrayList<PromptChoice>();
	public Prompt test = new Prompt("Welcome!", list);
	
	public void initialize()
	{
		list.add(main1);
		list.add(main2);
		list.add(main3);
	}
}
