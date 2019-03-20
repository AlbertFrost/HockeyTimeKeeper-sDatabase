package timekeeper.io;

import timekeeper.data.*;

/**
 * <h1>W19 - COMP 1502 - Assignment 2 Table Class</h1> A class that knows how to
 * turn a PlayerList into a formatted string of the correct type
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public abstract class Table {

	/**
	 * The PlayerList stored in table
	 */
	private PlayerList playerList;

	/**
	 * Constructor for table
	 * 
	 * @param playerList PlayerList to store
	 */
	public Table(PlayerList playerList) {
		this.playerList = playerList;
	}

	/**
	 * The stored player list
	 * 
	 * @return The stored PlayerList
	 */
	protected PlayerList getPlayerList() {
		return playerList;
	}

	/**
	 * Turns stored PlayerList into a String, used by toString
	 * 
	 * @return String version of PlayerList
	 */
	public abstract String createTableString();

	@Override
	public String toString() {
		return createTableString();
	}

}
