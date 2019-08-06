package com.revature.beans;

public class VideoGame {
	private int vgID;
	public VideoGame(int i, String string, int j) {
		super();
		// TODO Auto-generated constructor stub
	}
	private String vgName;
	private int vgMetaScore;
	public int getVgID() {
		return vgID;
	}
	public void setVgID(int vgID) {
		this.vgID = vgID;
	}
	public String getVgName() {
		return vgName;
	}
	public void setVgName(String vgName) {
		this.vgName = vgName;
	}
	public int getVgMetaScore() {
		return vgMetaScore;
	}
	public void setVgMetaScore(int vgMetaScore) {
		this.vgMetaScore = vgMetaScore;
	}
	@Override
	public String toString() {
		return "VideoGame [vgID=" + vgID + ", vgName=" + vgName + ", vgMetaScore=" + vgMetaScore + "]";
	}
	
}
