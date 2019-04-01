package timekeeper.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import timekeeper.data.*;

/**
 * <h1>W19 - COMP 1502 - Assignment 2 TeamReader Class</h1> Read a player from a
 * file <br>
 * Format Skater: $,name,pos,number,date of
 * birth,hometown,height,weight,goals,assists,power play goals, power play
 * shots, shots <br>
 * Format Goalie: @,name,pos,number,date of birth,hometown,height,weight,shots
 * against,goals against,shutouts,minutes
 * <br> pos is one of G,C,D,LW,RW
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public class TeamReader {

	/**
	 * Read a roster of players from a file with their stats
	 * 
	 * @param file The file handle to read from
	 * @return A PlayerList with data from file
	 * @throws FileNotFoundException If file not found
	 */
	public static PlayerList loadPlayerList(File file) throws FileNotFoundException {
		PlayerList playerList = new PlayerList();
		if (!file.exists()) {
			return playerList;
		}
		Scanner playerScanner = new Scanner(file);
		while (playerScanner.hasNextLine()) {
			String playerString = playerScanner.nextLine();
			Player player;
			// @ if player is a goalie
			if (playerString.startsWith("@,")) {
				player = loadGoalie(playerString.substring(2));
			}
			// If player is a skater
			else if (playerString.startsWith("$,")) {
				player = loadSkater(playerString.substring(2));
			} else {
				playerScanner.close();
				return null;
			}
			//playerList.addPlayer(player);
		}
		playerScanner.close();
		return playerList;
	}

	/**
	 * Private helper that loads a skater
	 * 
	 * @param playerString The skater string from file
	 * @return Skater object with info parsed from string
	 */
	private static Player loadSkater(String playerString) {
		ArrayList<String> data = new ArrayList<>(Arrays.asList(playerString.split(",")));
		String name = data.get(0);
		Position position = Position.valueOf(data.get(1));
		String number = data.get(2);
		String dateOfBirth = data.get(3);
		String homeTown = data.get(4);
		String weight = data.get(5);
		String height = data.get(6);
		int goals = Integer.parseInt(data.get(7));
		int assists = Integer.parseInt(data.get(8));
		int powerPlayGoals = Integer.parseInt(data.get(9));
		int powerPlayAssists = Integer.parseInt(data.get(10));
		int shots = Integer.parseInt(data.get(11));
		return new Skater(name, position, number, dateOfBirth, homeTown, weight, height, goals, assists, powerPlayGoals, powerPlayAssists, shots);
	}

	/**
	 * Private helper that loads a goalie
	 * 
	 * @param playerString The goalie string from file
	 * @return Goalie object with info parsed from string
	 */
	private static Player loadGoalie(String playerString) {
		ArrayList<String> data = new ArrayList<>(Arrays.asList(playerString.split(",")));
		String name = data.get(0);
		Position position = Position.valueOf(data.get(1));
		String number = data.get(2);
		String dateOfBirth = data.get(3);
		String homeTown = data.get(4);
		String weight = data.get(5);
		String height = data.get(6);
		int shotsAgainst = Integer.parseInt(data.get(7));
		int goalsAgainst = Integer.parseInt(data.get(8));
		int shutouts = Integer.parseInt(data.get(9));
		int minutes = Integer.parseInt(data.get(10));
		return new Goalie(name, position, number, dateOfBirth, homeTown, weight, height, shotsAgainst, goalsAgainst, shutouts, minutes);
	}

}
