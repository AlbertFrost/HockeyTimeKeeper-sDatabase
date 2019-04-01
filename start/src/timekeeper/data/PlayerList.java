package timekeeper.data;
import java.util.HashMap;
import java.util.Map;

/**
 * <h1>W19 - COMP 1502 - Assignment 2 PlayerList Class</h1> Holds a list of
 * Player and allows for Players to be added, found by jersey number, and for
 * shots, goals, pp goals to be recorded. Player's are stored in an internal
 * ArrayList of Player.
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public class PlayerList {

	/**
	 * The Players in the list
	 */
	private Map<String, Player> players;

	/**
	 * Construct a new empty PlayerList
	 */
	public PlayerList() {
		players = new HashMap<>();
	}

	/**
	 * The list of player stored
	 * 
	 * @return The ArrayList of Players stored
	 */
	public Map<String, Player> getMap() {
		return players;
	}

	/**
	 * Get a player with a given String jersey number
	 * 
	 * @param number String jersey number to search for
	 * @return The player found with jersey number, if no player found then null
	 */
	public Player getPlayerByNumber(String number) {
		Player foundPlayer = null;
		
		if(players.containsKey(number))
			foundPlayer = players.get(number);
		
		return foundPlayer;
	}

	/**
	 * Get a skater with a given String jersey number
	 * 
	 * @param number String jersey number to search for
	 * @return The skater found with jersey number, if no skater found then null
	 */
	public Skater getSkaterByNumber(String playerNumber) {
		if(players.containsKey(playerNumber)) {
			if (players.get(playerNumber).isSkater()) {
				return (Skater) players.get(playerNumber);
			}
		}
		return null;
	}

	/**
	 * Get a goalie with a given String jersey number
	 * 
	 * @param number String jersey number to search for
	 * @return The goalie found with jersey number, if no goalie found then null
	 */
	public Goalie getGoalieByNumber(String playerNumber) {
		if(players.containsKey(playerNumber)) {
			if (players.get(playerNumber).isGoalie()) {
				return (Goalie) players.get(playerNumber);
			}
		}
		return null;
	}

	/**
	 * Add a player to the PlayerList
	 * 
	 * @param p The Player to add
	 */
	public void addPlayer(Player p) {
		if(!players.containsKey(p.getNumber()))
			players.put(p.getNumber(), p);
	}

	/**
	 * Record a shot for a player
	 * 
	 * @param number String jersey number of player who had the shot
	 */
	public void recordShot(String number) {
		getSkaterByNumber(number).recordShot();
	}

	/**
	 * Record a goal for a given scorer
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 */
	public void recordGoal(String scorer) {
		getSkaterByNumber(scorer).recordGoal();
	}

	/**
	 * Record a goal for a given scorer and optional player a1 assisting the goal
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 * @param a1     String jersey number of player who assisted the goal (null if
	 *               no player)
	 */
	public void recordGoal(String scorer, String a1) {
		getSkaterByNumber(scorer).recordGoal();
		getSkaterByNumber(a1).recordAssist();
	}

	/**
	 * Record a goal for a given scorer and optional players a1/a2 assisting the
	 * goal
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 * @param a1     String jersey number of player who assisted the goal (null if
	 *               no player)
	 * @param a2     String jersey number of player who assisted the goal (null if
	 *               no player)
	 */
	public void recordGoal(String scorer, String a1, String a2) {
		getSkaterByNumber(scorer).recordGoal();
		getSkaterByNumber(a1).recordAssist();
		getSkaterByNumber(a2).recordAssist();
	}

	/**
	 * Record a PP goal for a given scorer
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 */
	public void recordPowerPlayGoal(String scorer) {
		getSkaterByNumber(scorer).recordPowerPlayGoal();
	}

	/**
	 * Record a PP goal for a given scorer and optional player a1 assisting the PP
	 * goal
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 * @param a1     String jersey number of player who assisted the goal (null if
	 *               no player)
	 */
	public void recordPowerPlayGoal(String scorer, String a1) {
		getSkaterByNumber(scorer).recordPowerPlayGoal();
		getSkaterByNumber(a1).recordPowerPlayAssist();
	}

	/**
	 * Record a PP goal for a given scorer and optional players a1/a2 assisting the
	 * PP goal
	 * 
	 * @param scorer String jersey number of player who scored (should not be null)
	 * @param a1     String jersey number of player who assisted the goal (null if
	 *               no player)
	 * @param a2     String jersey number of player who assisted the goal (null if
	 *               no player)
	 */
	public void recordPowerPlayGoal(String scorer, String a1, String a2) {
		getSkaterByNumber(scorer).recordPowerPlayGoal();
		getSkaterByNumber(a1).recordPowerPlayAssist();
		getSkaterByNumber(a2).recordPowerPlayAssist();
	}

	/**
	 * Record a shot against goalie
	 * 
	 * @param number String jersey number of goalie who had the shot against
	 */
	public void recordShotAgainst(String number) {
		getGoalieByNumber(number).recordShotAgainst();
	}

	/**
	 * Record a goal against goalie
	 * 
	 * @param number String jersey number of goalie who had the goal against
	 */
	public void recordGoalAgainst(String number) {
		getGoalieByNumber(number).recordGoalAgainst();
	}

	/**
	 * Record game played by goalie
	 * 
	 * @param number        The number of goalie
	 * @param minutesPlayed The minutes played by the goalie
	 */
	public void recordGamePlayed(String number, int minutesPlayed) {
		getGoalieByNumber(number).addMinutesPlayed(minutesPlayed);
	}

	/**
	 * Record shutout by goalie
	 * 
	 * @param number        The number of goalie
	 * @param minutesPlayed The minutes played by the goalie
	 */
	public void recordShutout(String number, int minutesPlayed) {
		getGoalieByNumber(number).recordShutout();
		getGoalieByNumber(number).addMinutesPlayed(minutesPlayed);
	}

}
