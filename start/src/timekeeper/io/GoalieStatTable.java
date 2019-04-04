package timekeeper.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import timekeeper.data.*;

/**
 * <h1>W19 - COMP 1502 - Assignment 2 GoalieStatTable Class</h1> A class that
 * knows how to turn a PlayerList into a formatted string of the goalie stat
 * table
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public class GoalieStatTable implements Table {

	PlayerList playerList;
	Map<String, Player> players;
	
	/**
	 * Format for goalie stat table
	 */
	private static final String STATS_FORMAT_GOALIE = "%-20s %2s %3s %3s %4s %5s %3s %4s";
	/**
	 * Header for goalie stat table
	 */
	private static final String STATS_HEADER_GOALIE = String.format(STATS_FORMAT_GOALIE, "Name", "#", "SA", "GA", "GAA", "SV%", "SO", "MIN");

	/**
	 * Construct goalie stat table
	 * @param playerList The PlayerList to store
	 */
	public GoalieStatTable(PlayerList playerList) {
		this.playerList = playerList;
		this.players = playerList.getMap();
	}

	public String createTableString() {
		StringBuilder sb = new StringBuilder();
		sb.append(STATS_HEADER_GOALIE).append("\n");
		
		ArrayList<Goalie> goalies = getGoaliesFromMap();
		GoalieStatComparator comp = new GoalieStatComparator();
		
		Collections.sort(goalies, comp);
		
		for (Goalie goalie:goalies) {
				sb.append(getFormattedStats(goalie)).append("\n");
		}
		return sb.toString();
	}

	/**
	 * Helper to string that turns a goalie into a single row entry
	 * @param goalie The Goalie to convert
	 * @return String version of the goalie as a row
	 */
	private static String getFormattedStats(Goalie goalie) {
		return String.format(STATS_FORMAT_GOALIE, goalie.getName(), goalie.getNumber(), goalie.getShotsAgainst(), goalie.getGoalsAgainst(), String.format("%4.2f", goalie.getGoalsAgainstAverage()), String.format("%5.3f", goalie.getSavePercentage()), goalie.getShutouts(), goalie.getMinutes());
	}
	
	@Override
	public String toString()
	{
		return createTableString();
	}
	
	private ArrayList<Goalie> getGoaliesFromMap()
	{
		ArrayList<Goalie> goalies = new ArrayList<>();
		
		for (Map.Entry<String, Player> p: players.entrySet()) 
		{
			Player player = p.getValue();
			if (player.isGoalie()) {
				goalies.add((Goalie) player);
			}
		}
		
		return goalies;
	}

}