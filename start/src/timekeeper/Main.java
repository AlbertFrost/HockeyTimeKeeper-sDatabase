
package timekeeper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import timekeeper.data.*;
import timekeeper.io.*;

/**
 * A simple Time Keeper Program for hockey
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 */
public class Main {

	/**
	 * Internal keyboard System.in scanner
	 */
	private static Scanner kb;

	/**
	 * Main of the program
	 * 
	 * @param args No arguments
	 * @throws FileNotFoundException Throws up if file not found for roster to
	 *                               load/save
	 */
	public static void main(String[] args) throws FileNotFoundException {
		kb = new Scanner(System.in);
		System.out.println("Enter Storage Filename (Blank to start new):");
		String filename = kb.nextLine();
		PlayerList list;
		if (filename.isEmpty()) {
			// Empty list if no filename
			list = new PlayerList();
			System.out.println("New list created");
		} else {
			list = TeamReader.loadPlayerList(new File(filename));
			if(list.isEmpty())
				System.out.println("File not loaded");
			else
				System.out.println("File loaded");
		}
		System.out.println("Time Keeper DB V3");
		runMenu(list);
		System.out.println("Save data to " + filename + "? (Y/N)");
		String yn = kb.nextLine();
		if (yn.equalsIgnoreCase("y")) {
			// Get filename if none was entered earlier to save to
			if (filename.isEmpty()) {
				System.out.println("Enter filename to save to:");
				filename = kb.nextLine();
			}
			if (TeamWriter.recordToFile(new File(filename), list)) {
				System.out.println("Saved output to file " + filename);
			} else {
				System.out.println("Not able to save file.");
			}
		}
		System.out.println("Exiting");
		kb.close();
	}

	/**
	 * Menu loop
	 * 
	 * @param list The PlayerList holding a roster of players
	 */
	private static void runMenu(PlayerList list) {
		boolean keepRunning = true;
		do {
			printMenu();
			keepRunning = doMenu(kb.nextLine(), list);
		} while (keepRunning);
	}

	/**
	 * Menu printer to System.out
	 */
	private static void printMenu() {
		System.out.println("1 - List Player Roster");
		System.out.println("2 - List Skater Stats");
		System.out.println("3 - List Goalie Stats");
		System.out.println("4 - List By Hometown");
		System.out.println("A - Add player");
		System.out.println("S # - record a shot for player");
		System.out.println("G # <#> <#> - record a goal for the first player, optionally assists for the second and third");
		System.out.println("P # <#> <#> - record a power play goal for the first player, optionally assists for the second and third");
		System.out.println("SA # - record a shot against a goalie");
		System.out.println("GA # - record a goal against a goalie");
		System.out.println("GP # MIN - record a game played by a goalie with given minutes");
		System.out.println("SO # MIN - record a game played with a shutout by a goalie with given minutes");
		System.out.println();
		System.out.println("Q - quit");
	}

	/**
	 * Menu option switch
	 * 
	 * @param input The input from menu options
	 * @param list  The PlayerList of roster
	 * @return True if option was selected, False for quit
	 */
	private static boolean doMenu(String input, PlayerList list) {
		ArrayList<String> parsed = new ArrayList<>(Arrays.asList(input.split(" ")));
		switch (parsed.get(0).toUpperCase()) {
		case "1":
			listRoster(list);
			break;
		case "2":
			listSkaterStats(list);
			break;
		case "3":
			listGoalieStats(list);
			break;
		case "4":
			listByHomeTown(list);
			break;
		case "A":
			addPlayer(list);
			break;
		case "S":
			recordShot(list, parsed.get(1));
			break;
		case "G":
			recordGoal(list, input);
			break;
		case "P":
			recordPowerPlayGoal(list, input);
			break;
		case "SA":
			recordShotAgainst(list, parsed.get(1));
			break;
		case "GA":
			recordGoalAgainst(list, parsed.get(1));
			break;
		case "GP":
			recordGameResult(list, input);
			break;
		case "SO":
			recordShutout(list, input);
			break;
		case "Q":
			return false;
		}
		return true;
	}

	private static void listByHomeTown(PlayerList playerList) {
		System.out.println(TableFactory.listPlayersByHometown(playerList));
		
	}

	/**
	 * List player roster
	 * 
	 * @param list The PlayerList of skaters/goalies
	 */
	private static void listRoster(PlayerList playerList) {
		System.out.println(TableFactory.listAllPlayersRoster(playerList));
	}

	/**
	 * List skaters stats
	 * 
	 * @param list The PlayerList of skaters/goalies
	 */
	private static void listSkaterStats(PlayerList playerList) {
		System.out.println(TableFactory.listAllSkaterStats(playerList));
	}

	/**
	 * List goalie stats
	 * 
	 * @param list The PlayerList of skaters/goalies
	 */
	private static void listGoalieStats(PlayerList playerList) {
		System.out.println(TableFactory.listAllGoalieStats(playerList));
	}

	/**
	 * Add a player to roster
	 * 
	 * @param list The PlayerList of roster
	 */
	private static void addPlayer(PlayerList list) {
		System.out.println("Enter Player information");
		System.out.print("Name: ");
		String name = kb.nextLine();
		System.out.print("Number: ");
		String number = kb.nextLine();
		System.out.print("Position: ");
		Position pos = Position.valueOf(kb.nextLine());
		System.out.print("Date of Birth: ");
		String dob = kb.nextLine();
		System.out.print("HomeTown: ");
		String hometown = kb.nextLine();
		System.out.print("Weight: ");
		String weight = kb.nextLine();
		System.out.print("Height: ");
		String height = kb.nextLine();
		Player player;
		if (pos.isGoalie()) {
			player = new Goalie(name, pos, number, dob, hometown, weight, height);
		} else {
			player = new Skater(name, pos, number, dob, hometown, weight, height);
		}
		list.addPlayer(player);
	}

	/**
	 * Record a shot by a player
	 * 
	 * @param list         The PlayerList of roster
	 * @param playerNumber The String number of a player
	 */
	private static void recordShot(PlayerList list, String number) {
		System.out.println("Recorded shot for " + number);
		list.recordShot(number);
	}

	/**
	 * Record a goal for a player with one or two assists
	 * 
	 * @param list  The PlayerList of roster
	 * @param input The input list including G/P to start, ex G 1 ex. P 42 23 1
	 */

	private static void recordGoal(PlayerList list, String input) {
		ArrayList<String> parsed = new ArrayList<>(Arrays.asList(input.split(" ")));
		if (parsed.size() == 2) {
			String g = parsed.get(1);
			System.out.println("Recorded goal for " + g);
			list.recordGoal(g);
		} else if (parsed.size() == 3) {
			String g = parsed.get(1);
			String a1 = parsed.get(2);
			System.out.println("Recorded assist for " + a1);
			list.recordGoal(g, a1);
		} else if (parsed.size() == 4) {
			String g = parsed.get(1);
			String a1 = parsed.get(2);
			String a2 = parsed.get(3);
			System.out.println("Recorded assist for " + a2);
			list.recordGoal(g, a1, a2);
		}
	}

	/**
	 * Record a power play goal for a player with one or two assists
	 * 
	 * @param list  The PlayerList of roster
	 * @param input The input list including G/P to start, ex G 1 ex. P 42 23 1
	 */
	private static void recordPowerPlayGoal(PlayerList list, String input) {
		ArrayList<String> parsed = new ArrayList<>(Arrays.asList(input.split(" ")));
		if (parsed.size() == 2) {
			String g = parsed.get(1);
			System.out.println("Recorded PP goal for " + g);
			list.recordPowerPlayGoal(g);
		} else if (parsed.size() == 3) {
			String g = parsed.get(1);
			String a1 = parsed.get(2);
			System.out.println("Recorded PP assist for " + a1);
			list.recordPowerPlayGoal(g, a1);
		} else if (parsed.size() == 4) {
			String g = parsed.get(1);
			String a1 = parsed.get(2);
			String a2 = parsed.get(3);
			System.out.println("Recorded PP assist for " + a2);
			list.recordPowerPlayGoal(g, a1, a2);
		}
	}

	/**
	 * Record a shot against a goalie
	 * 
	 * @param list   The PlayerList of roster
	 * @param number The String number of a goalie with shot against
	 */
	private static void recordShotAgainst(PlayerList list, String number) {
		System.out.println("Recorded shot against " + number);
		list.recordShotAgainst(number);
	}

	/**
	 * Record a goal against a goalie
	 * 
	 * @param list   The PlayerList of roster
	 * @param number The String number of a goalie scored against
	 */
	private static void recordGoalAgainst(PlayerList list, String number) {
		System.out.println("Recorded goal against " + number);
		list.recordGoalAgainst(number);
	}

	/**
	 * Record a game played by a goalie (non-shutout)
	 * 
	 * @param list  The PlayerList of roster
	 * @param input The input list including GP to start, ex GP 1 60
	 */
	private static void recordGameResult(PlayerList list, String input) {
		ArrayList<String> parsed = new ArrayList<>(Arrays.asList(input.split(" ")));
		if (parsed.size() >= 3) {
			String number = parsed.get(1);
			int minutesPlayed = Integer.parseInt(parsed.get(2));
			System.out.println("Recorded " + minutesPlayed + " minutes played for goalie " + number);
			list.recordGamePlayed(number, minutesPlayed);
		}
	}

	/**
	 * Record a game played by a goalie (non-shutout)
	 * 
	 * @param list  The PlayerList of roster
	 * @param input The input list including GP to start, ex GP 1 60
	 */
	private static void recordShutout(PlayerList list, String input) {
		ArrayList<String> parsed = new ArrayList<>(Arrays.asList(input.split(" ")));
		if (parsed.size() >= 3) {
			String number = parsed.get(1);
			int minutesPlayed = Integer.parseInt(parsed.get(2));
			System.out.println("Recorded shutout with " + minutesPlayed + " minutes played for goalie " + number);
			list.recordShutout(number, minutesPlayed);
		}
	}

}
