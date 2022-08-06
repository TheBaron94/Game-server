package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	
	//private list to hold players
	private static List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}
	
	public Player addPlayer(String name) {
		
		// a local instance
			Player player = null;
					
			for (int i = 0; i < players.size(); i++) {
				if (((players.get(i)).getName()).equals(name)) { // search list using getName 
						player = players.get(i); //if found assigns object to local variable
				}
			}
			// if not found, make a new team instance and add to list of teams
			if (player == null) {
				player = new Player(GameService.getInstance().getNextPlayerId(), name);
				players.add(player);
			}
					
			
			return player;
		}

	
	//overrides super's toString method
	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
	
}
