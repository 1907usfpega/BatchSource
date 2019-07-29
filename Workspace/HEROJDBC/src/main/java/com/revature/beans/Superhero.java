package com.revature.beans;

public class Superhero {
	
	private String name;
	private int id;
	
	@Override
	public String toString() {
		return "Superhero [name=" + name + ", id=" + id + "]";
	}
	public Superhero(int id, String name ) {
		super();
		this.name = name;
		this.id = id;
	}
	public Superhero() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
