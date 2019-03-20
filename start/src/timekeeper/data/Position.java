package timekeeper.data;
/**
 * <h1>W19 - COMP 1502 - Assignment 2 Position Class</h1> Position class for a
 * Player <br>
 * F-Forward <br>
 * C-Centre <br>
 * LW-Left Wing <br>
 * RW-Right Wing <br>
 * D-Defenseman <br>
 * G-Goalie
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public enum Position {

	F, RW, LW, C, D, G;

	/**
	 * Is this position a goalie position
	 * 
	 * @return True if G, else False
	 */
	public boolean isGoalie() {
		return this == G;
	}

	/**
	 * Is this position a skater (non goalie) position
	 * 
	 * @return True if not G, False otherwise
	 */
	public boolean isSkater() {
		return !isGoalie();
	}

}
