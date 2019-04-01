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
public interface Table {


	/**
	 * Turns stored PlayerList into a String, used by toString
	 * 
	 * @return String version of PlayerList
	 */
	public String createTableString();

	public String toString();
}
