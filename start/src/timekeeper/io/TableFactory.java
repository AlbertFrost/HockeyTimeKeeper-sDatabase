package timekeeper.io;

import timekeeper.data.*;

/**
 * <h1>W19 - COMP 1502 - Assignment 2 TableFactory Class</h1> Returns tables
 * which can be printed as a string - Roster Table, Skater Stats Table, and
 * Goalie Stats Table
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public class TableFactory {

	/**
	 * Return RosterTable from PlayerList
	 * 
	 * @param playerList The PlayerList to convert
	 * @return The RosterTable for roster
	 */
	public static Table listAllPlayersRoster(PlayerList playerList) {
		return new RosterTable(playerList);
	}

	/**
	 * Return SkaterStatTable from PlayerList
	 * 
	 * @param playerList The PlayerList to convert
	 * @return The SkaterStatTable for roster
	 */
	public static Table listAllSkaterStats(PlayerList playerList) {
		return new SkaterStatTable(playerList);
	}

	/**
	 * Return GoalieStatTable from PlayerList
	 * 
	 * @param playerList The PlayerList to convert
	 * @return The GoalieStatTable for roster
	 */
	public static Table listAllGoalieStats(PlayerList playerList) {
		return new GoalieStatTable(playerList);
	}

}
