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
	 */
	public RosterTable(PlayerList playerList) {
		this.playerList = playerList;
		this.players = playerList.getMap();
	}

	@Override
	public String createTableString() {
		StringBuilder sb = new StringBuilder();
		sb.append(ROSTER_HEADER).append("\n");
		
		ArrayList<Player> rosterPlayers = (ArrayList<Player>) players;
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

}
