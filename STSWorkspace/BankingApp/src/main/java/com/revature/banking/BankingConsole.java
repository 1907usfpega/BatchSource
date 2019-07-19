package com.revature.banking;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingConsole 
{
	
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		String input;
		char answer = 'n';
		/*do
		{
			run();
			System.out.println("Do you wish to quit?: ");
			if(input.hasNext())
			{
				answer = input.next();
			}
			input.close();
			System.out.println(answer);
		}while(answer.toUpperCase().equals("YES") || answer.toUpperCase().equals("Y"));*/
		
		while(answer != 'y')
		{
			run();
			System.out.print("Do you wish to quit?(Y/N): ");
			input = s.next().toLowerCase();
			answer = input.charAt(0);
		}
		s.close();
	}
	
	public static void prompt(String text)
	{
		System.out.print(text+": ");
	}
	
	public static void promptChoose(String text)
	{
		System.out.print(text+": ");
	}
	
	public static int printChoicePrompt(Prompt p)
	{
		System.out.print(p.getHeader()+"\n");
		Scanner s = new Scanner(System.in);
		if(!p.getChoices().isEmpty())
		{
			//System.out.println("sadf");
			for(PromptChoice pc : p.getChoices())
			{
				//System.out.println("sadf");
				System.out.print("\t"+pc.getChoiceNum()+" "+pc.getChoiceText() + "\n");
			}
		}
		System.out.print(p.getInputPrompt());
		if(s.hasNextInt())
		{
			int choice = s.nextInt();
			//s.close();
			return choice;
		}
		s.close();
		return 0;
	}
	
	public static void run()
	{
		//prompt("");
		/*PromptChoice main1 = new PromptChoice(1, "Login");
		PromptChoice main2 = new PromptChoice(2, "Create Account");
		PromptChoice main3 = new PromptChoice(3, "Quit");
		ArrayList<PromptChoice> list = new ArrayList<PromptChoice>();
		list.add(main1);
		list.add(main2);
		list.add(main3);
		Prompt test = new Prompt("Welcome!", list);*/
		PromptCollection promptList = new PromptCollection();
		promptList.initialize();
		int mainMenuChoice = printChoicePrompt(promptList.test);
		switch(mainMenuChoice)
		{
			case 1:
				System.out.println("jasbfksjbd");
				break;
			case 2:
				System.out.println("akfhbfdkgnjf");
				break;
			case 3:
				System.out.println(" dhksdvbjfd");
				break;
			default:
				System.out.println("That is not a valid input. ");
				break;
		}
		//System.out.println(mainMenuChoice);
	}
}
