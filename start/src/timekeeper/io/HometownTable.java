package timekeeper.io;

import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;

import timekeeper.data.*;

public class HometownTable implements Table{

	PlayerList playerList;
	
	Map<String, Player> players;
	
	/**
	 * Format for hometown table
	 */
	private static final String HOMETOWN_FORMAT = "%-20s %5s %30s";
	/**
	 * Header for hometown table
	 */
	private static final String HOMETOWN_HEADER = String.format(HOMETOWN_FORMAT, "HOMETOWN", "COUNT", "PLAYERS");
	
	public HometownTable(PlayerList playerList)
	{
		this.playerList = playerList;
		this.players = playerList.getMap();
	}

	@Override
	public String createTableString() {
		StringBuilder sb = new StringBuilder();
		sb.append(STATS_HEADER_SKATER).append("\n");
		
		SkaterStatComparator comp = new SkaterStatComparator();
		Collections.sort(skaters, comp);
		
		for (Skater skater: skaters) {
				sb.append(getFormattedStats(skater)).append("\n");
		}
		return sb.toString();
	}
	
//	private static String getFormattedStats(Player player) {
//		return String.format(HOMETOWN_FORMAT, player.getHomeTown(), );
//	}
}
