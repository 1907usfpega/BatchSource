package com.revature.banking;

import java.util.ArrayList;

public class Prompt 
{
	private String header;
	private String inputPrompt;
	private ArrayList<PromptChoice> choices;
	
	public Prompt(String header)
	{
		inputPrompt = "Enter your input: ";
		this.setHeader(header);
	}
	
	public Prompt(String header, String inputPrompt)
	{
		this.setHeader(header);
		this.setInputPrompt(inputPrompt);;
	}
	
	public Prompt(String header, ArrayList<PromptChoice> choices)
	{
		this.setHeader(header);
		this.setChoices(choices);
		inputPrompt = "Enter your input: ";
	}
	public Prompt(String header, String inputPrompt, ArrayList<PromptChoice> choices)
	{
		this.setHeader(header);
		this.setChoices(choices);
		this.inputPrompt = inputPrompt;
	}

	public String getHeader() 
	{
		return header;
	}

	public void setHeader(String header) 
	{
		this.header = header;
	}
	
	public String getInputPrompt() 
	{
		return inputPrompt;
	}

	public void setInputPrompt(String inputPrompt) 
	{
		this.inputPrompt = inputPrompt;
	}

	public ArrayList<PromptChoice> getChoices() 
	{
		return choices;
	}

	public void setChoices(ArrayList<PromptChoice> choices) 
	{
		this.choices = choices;
	}
	
	/*public String toString()
	{
		String output = "";
		output += header + "\n";
		if(!choices.isEmpty())
		{
			for(PromptChoice pc : choices)
			{
				output += pc.toString() + "\n";
			}
		}
		output += inputPrompt;
		return output;
	}*/

	
}

class PromptChoice
{
	private int choiceNum;
	private String choiceText;
	
	public PromptChoice(int choiceNum, String choiceText)
	{
		this.choiceNum = choiceNum;
		this.choiceText = choiceText;
	}

	// return the choiceNum
	public int getChoiceNum() 
	{
		return choiceNum;
	}

	//choiceNum the choiceNum to set
	public void setChoiceNum(int choiceNum) 
	{
		this.choiceNum = choiceNum;
	}

	public String getChoiceText() 
	{
		return choiceText;
	}

	public void setChoiceText(String choiceText) 
	{
		this.choiceText = choiceText;
	}
	
	public String toString()
	{
		return choiceNum + " : " + choiceText;
	}
}