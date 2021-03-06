package timekeeper.io;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

import timekeeper.data.*;

/**
 * <h1>W19 - COMP 1502 - Assignment 2 RosterTable Class</h1> A class that knows
 * how to turn a PlayerList into a formatted string of roster info table
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public class RosterTable implements Table {


	PlayerList playerList;
	Map<String, Player> players;
	
	/**
	 * Format for roster table
	 */
	private static final String ROSTER_FORMAT = "%-20s %2s %3s %20s %-25s %8s %8s";
	/**
	 * Header for roster table
	 */
	private static final String ROSTER_HEADER = String.format(ROSTER_FORMAT, "Name", "#", "Pos", "Birthdate", "Home Town", "Weight", "Height");

	/**
	 * Construct roster table
	 * 
	 * @param playerList The PlayerList to store
	 * Calls the getMap method of PlayerList to fill the RosterTable instance of
	 * Map<String, Player>
	 */
	public RosterTable(PlayerList playerList) {
		this.playerList = playerList;
		this.players = playerList.getMap();
	}

	/**
	 * Helper method that creates a formatted String to represent a table
	 * of all Players' roster information. Players are ordered in natural
	 * ordering (smallest jersey number, name).
	 */
	@Override
	public String createTableString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ROSTER_HEADER).append("\n");
		
		ArrayList<Player> rosterPlayers = Table.mapToArrayList(players);
		PlayerNumberComparator comp = new PlayerNumberComparator();
		Collections.sort(rosterPlayers, comp);
		
		for (Player player: rosterPlayers) {
			sb.append(getFormattedRoster(player)).append("\n");
		}
		return sb.toString();
	}

	/**
	 * Helper to string that turns a player into a single row entry
	 * 
	 * @param goalie The Player to convert
	 * @return String version of the player as a row
	 */
	private static String getFormattedRoster(Player player) {
		return String.format(ROSTER_FORMAT, player.getName(), player.getNumber(), player.getPosition(), player.getDateOfBirth(), player.getHomeTown(), player.getWeight(), player.getHeight());
	}
	
	/**
	 * Calls the createTableString method and returns the String
	 */
	@Override
	public String toString()
	{
		return createTableString();
	}

}
