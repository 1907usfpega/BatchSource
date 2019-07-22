package com.revature.bankingapppt1;

import java.util.ArrayList;
import java.util.List;

public class Screen {
	private String screenName;
	private List<String> links = new ArrayList<String>();
	
	public void displayScreen() {
		System.out.println();
	}

	public Screen() {
		// TODO Auto-generated constructor stub
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String menuName) {
		this.screenName = menuName;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}

}
