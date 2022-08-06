package com.gamingroom;

public class Entity {
	long id;
	String name;
	
	
	//Default constructor made private to prevent being called
	private Entity() {
		
	}
	
	//Public constructor with ID and name
	public Entity(long id, String name) {
		this.id = id;
		this.name =name;
	}
	
	//Getters
	public long getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	//to string prints out formatted string with id and name
	
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
}
