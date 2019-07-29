package com.revature.beans;

public class Superpower {
private int id;
private String name;
public Superpower(int id, String superpowerName) {
	super();
	this.id = id;
	this.name = name;
}
public Superpower() {
	
}
@Override
public String toString() {
	return "Superpower [id=" + id + ", name=" + name + "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSuperpowerName() {
	return name;
}
public void setSuperpowerName(String name) {
	this.name = name;
}
}
