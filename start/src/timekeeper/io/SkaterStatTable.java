package timekeeper.io;

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
public class SkaterStatTable extends Table {

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
	 */
	public SkaterStatTable(PlayerList playerList) {
		super(playerList);
	}

	@Override
	public String createTableString() {
		StringBuilder sb = new StringBuilder();
		sb.append(STATS_HEADER_SKATER).append("\n");
		for (Player player : getPlayerList().getPlayers()) {
			if (player.isSkater()) {
				sb.append(getFormattedStats((Skater) player)).append("\n");
			}
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

}