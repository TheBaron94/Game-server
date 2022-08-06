package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	//holds the next player identifier
	private static long nextPlayerId = 1;
	
	//holds the next team identifier
	private static long nextTeamId = 1;

	//private instance variable used to check if object already exists
	private static GameService instance = null;
	
	//private constructor to prevent multiples being made
	private GameService() {
	}
	
	// check if object already exists, returns either new object or existing one
	public static GameService getInstance() {
		
		if (instance == null) {
			instance = new GameService();
		}

		return instance;
	}
	
	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXed: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		
		for (int i = 0; i < getGameCount(); i++) {
			if (((games.get(i)).getName()).equals(name)) { // search list using getName 
				game = games.get(i); //if found assigns object to local game variable
			}
		}
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}
		

		


		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXed: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		for (int i = 0; i < getGameCount(); i++) {
			if (((games.get(i)).getId()) == id) { // search game list for game object based on ID number
				game = games.get(i); // if found assign game object to local variable
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXed: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		for (int i = 0; i < getGameCount(); i++) {
			if (((games.get(i)).getName()).equals(name)) { // search games list for object with same name
				game = games.get(i);// if found assign game object found to local game variable
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	//returns the current Player Id and increments for next use
	public long getNextPlayerId() {
		long id = nextPlayerId;
		nextPlayerId = nextPlayerId + 1;
		return id;
	}
	
	//returns the current team Id and increments
	public long getNextTeamId() {
		long id = nextTeamId;
		nextTeamId = nextTeamId + 1;
		return id;
	}
}

// Explanation: The purpose of a singleton pattern in this class is to prevent multiple instances of the Game Service
// from being created and each instance in turn creating games with the same names. The characteristics of the singleton 
// in this use are that only one instance of the GameServer will exist at any point by using the getInstance method to first check
// if an instance exists, if it does it passes along the existing instance, and if it does not exists it creates a new instance 
// and then passes that instance to the caller.
