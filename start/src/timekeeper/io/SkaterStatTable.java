package timekeeper.io;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

import timekeeper.data.*;

/**
 * <h1>W19 - COMP 1502 - Assignment 2 SkaterStatTable Class</h1> A class that
 * knows how to turn a PlayerList into a formatted string of the skater stat
 * table
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public class SkaterStatTable implements Table {

	PlayerList playerList;
	Map<String, Player> players;
	/**
	 * Format for skater stat table
	 */
	private static final String STATS_FORMAT_SKATER = "%-20s %2s %3s %3s %3s %3s %3s %3s %3s %3s";
	/**
	 * Header for skater stat table
	 */
	private static final String STATS_HEADER_SKATER = String.format(STATS_FORMAT_SKATER, "Name", "#", "P", "G", "A", "PPP", "PPG", "PPA", "S", "S%");

	/**
	 * Construct skater stat table
	 * 
	 * @param playerList The PlayerList to store
	 * Calls the getMap method of PlayerList to fill the SkaterStatTable instance of
	 * Map<String, Player>
	 */
	public SkaterStatTable(PlayerList playerList) {
		this.playerList = playerList;
		this.players = playerList.getMap();
	}

	/**
	 * Helper method that creates a formatted String to represent a table
	 * of all Skaters' Stats in the order of greatest points, goals, assists
	 * and then natural ordering (smallest jersey number, name).
	 */
	@Override
	public String createTableString() {
		StringBuilder sb = new StringBuilder();
		sb.append(STATS_HEADER_SKATER).append("\n");
		
		ArrayList<Skater> skaters = getSkatersFromMap();
		SkaterStatComparator comp = new SkaterStatComparator();
		Collections.sort(skaters, comp);
		
		for (Skater skater: skaters) {
				sb.append(getFormattedStats(skater)).append("\n");
		}
		return sb.toString();
	}

	/**
	 * Helper to string that turns a skater into a single row entry
	 * 
	 * @param goalie The Skater to convert
	 * @return String version of the goalie as a row
	 */
	private static String getFormattedStats(Skater skater) {
		return String.format(STATS_FORMAT_SKATER, skater.getName(), skater.getNumber(), skater.getPoints(), skater.getGoals(), skater.getAssists(), skater.getPowerPlayPoints(), skater.getPowerPlayGoals(), skater.getPowerPlayAssists(), skater.getShots(), String.format("%3.2f", skater.getShootingPercentage()));
	}
	
	/**
	 * Calls the createTableString method and returns the String
	 */
	@Override
	public String toString()
	{
		return createTableString();
	}
	
	/**
	 * 
	 * @return ArrayList<Skater>
	 * 
	 * Helper method that will go through the Map of String, Player and pick out every
	 * Skater object to be placed into an ArrayList to be sorted later. After iterating
	 * through the Map, method will return the ArrayList.
	 */
	private ArrayList<Skater> getSkatersFromMap()
	{
		ArrayList<Skater> skaters = new ArrayList<>();
		
		for (Map.Entry<String, Player> p: players.entrySet()) {
			Player player = p.getValue();
			if (player.isSkater()) {
				skaters.add((Skater) player);
			}
		}
		
		return skaters;
	}

}