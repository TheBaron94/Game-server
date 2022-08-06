package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	//private list of current teams
	private static List<Team> teams = new ArrayList<Team>();


	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}
	
	public Team addTeam(String name) {
		
	// a local instance
		Team team = null;
				
		for (int i = 0; i < teams.size(); i++) {
			if (((teams.get(i)).getName()).equals(name)) { // search list using getName 
					team = teams.get(i); //if found assigns object to local variable
			}
		}
		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			team = new Team(GameService.getInstance().getNextTeamId(), name);
			teams.add(team);
		}
				
		
		return team;
	}


	
	//override toString method from Entity superclass
	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
