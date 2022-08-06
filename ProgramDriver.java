package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		
		GameService service = GameService.getInstance(); 
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #2");
		System.out.println(game2);
		System.out.println();
		
		//add teams, first digit is game# second is team#
		Team Team11 = game1.addTeam("Team11");
		System.out.println(Team11);
		Team Team12 = game1.addTeam("Team12");
		System.out.println(Team12);
		Team Team21 = game2.addTeam("Team21");
		System.out.println(Team21);
		Team Team22 = game2.addTeam("Team22");
		System.out.println(Team22);
		System.out.println();
		
		//add players, first digit is game# second digit is team# and the third is the player#
		Player Player111 = Team11.addPlayer("Player 111");
		System.out.println(Player111);
		Player Player112 = Team11.addPlayer("Player 112");
		System.out.println(Player112);
		Player Player121 = Team12.addPlayer("Player 121");
		System.out.println(Player121);
		Player Player122 = Team12.addPlayer("Player 122");
		System.out.println(Player122);
		Player Player211 = Team21.addPlayer("Player 211");
		System.out.println(Player211);
		Player Player212 = Team21.addPlayer("Player 212");
		System.out.println(Player212);
		Player Player221 = Team22.addPlayer("Player 221");
		System.out.println(Player221);
		Player Player222 = Team22.addPlayer("Player 222");
		System.out.println(Player222);
		System.out.println();
		
		//testing section
		
		System.out.println("Begin testing Games, if Game Id's have changed then test has failed: \n");
		Game TestGame1 = service.addGame("Game #1");
		System.out.println("Test Game #1 " + TestGame1);
		Game TestGame2 = service.addGame("Game #2");
		System.out.println("Test Game #2 " + TestGame2);
		System.out.println();
		
		System.out.println("Begin testing Teams if team Id's have changed then test has failed: \n");
		Team TestTeam1 = game1.addTeam("Team11");
		System.out.println("TestTeam1 " + TestTeam1);
		Team TestTeam2 = game2.addTeam("Team22");
		System.out.println("TestTeam2 " + TestTeam2);
		System.out.println();
		
		System.out.println("Begin Testing Players if player Id's have changed then test has failed: \n");
		Player TestPlayer1 = Team11.addPlayer("Player 111");
		System.out.println("TestPlayer1 " + TestPlayer1);
		Player TestPlayer2 = Team22.addPlayer("Player 222");
		System.out.println("TestPlayer2 " + TestPlayer2);
		
		
		
		
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
