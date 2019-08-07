package com.revature.beans;

public class VideoGame {
	private int id;
	private String name;
	private int metaScore;

	public VideoGame() {
		// TODO Auto-generated constructor stub
	}
	public VideoGame(int a, String b, int c) {
		this.id=a;
		this.name=b;
		this.metaScore=c;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMetaScore() {
		return metaScore;
	}
	public void setMetaScore(int metaScore) {
		this.metaScore = metaScore;
	}
	
}
