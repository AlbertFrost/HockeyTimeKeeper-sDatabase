package timekeeper.data;
/**
 * <h1>W19 - COMP 1502 - Assignment 2 Skater Class</h1> A Skater is a player
 * with default 0 stats of goals, assists, power play goals, power play assists,
 * and shots. Power play goals and power play assists are a subset of goals and
 * assists respectively. Every goal is a shot but players generally have more
 * shots than goals. All these values should be 0 or greater. The class allows
 * for a shot to be added, and for a goal and power play goal to be added with
 * the proper addition of shots at the same time.
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public class Skater extends Player {

	/**
	 * Integer goals of player (goals >= 0)
	 */
	private int goals = 0;
	/**
	 * Integer assists of player (assists >= 0)
	 */
	private int assists = 0;
	/**
	 * Integer Power play goals of player (should be subset of goals)
	 * (powerPlayGoals >= 0)
	 */
	private int powerPlayGoals = 0;
	/**
	 * Integer power play assists of player (should be subset of assists)
	 * (powerPlayAssists >= 0)
	 */
	private int powerPlayAssists = 0;
	/**
	 * Integer shots on goal of player (should be at least as large as goals) (shots
	 * >= 0)
	 */
	private int shots = 0;

	/**
	 * Create all parts of a skater
	 * 
	 * @param name        String name of skater
	 * @param position    Enum Position of skater
	 * @param number      String number of skater
	 * @param dateOfBirth String date of birth of skater
	 * @param homeTown    String hometown of skater
	 * @param weight      String Weight of skater
	 * @param height      String height of skater
	 */
	public Skater(String name, Position position, String number, String dateOfBirth, String homeTown, String weight, String height) {
		super(name, position, number, dateOfBirth, homeTown, weight, height);
	}

	/**
	 * Create all parts of a skater
	 * 
	 * @param name             String name of skater
	 * @param position         Enum Position of skater
	 * @param number           String number of skater
	 * @param dateOfBirth      String date of birth of skater
	 * @param homeTown         String hometown of skater
	 * @param weight           String Weight of skater
	 * @param height           String height of skater
	 * @param goals            Integer goals of skater (goals >= 0)
	 * @param assists          Integer assists of skater (assists >= 0)
	 * @param powerPlayGoals   Integer Power play goals of skater (should be subset
	 *                         of goals) (powerPlayGoals >= 0)
	 * @param powerPlayAssists Integer power play assists of skater (should be
	 *                         subset of assists) (powerPlayAssists >= 0)
	 * @param shots            Integer shots on goal of skater (should be at least
	 *                         as large as goals) (shots >= 0)
	 */
	public Skater(String name, Position position, String number, String dateOfBirth, String homeTown, String weight, String height, int goals, int assists, int powerPlayGoals, int powerPlayAssists, int shots) {
		super(name, position, number, dateOfBirth, homeTown, weight, height);
		this.goals = goals;
		this.assists = assists;
		this.powerPlayGoals = powerPlayGoals;
		this.powerPlayAssists = powerPlayAssists;
		this.shots = shots;
	}

	/**
	 * Copy the skater entered
	 * 
	 * @param p Skater to be copied
	 */
	public Skater(Skater p) {
		super(p);
		this.goals = p.goals;
		this.assists = p.assists;
		this.powerPlayGoals = p.powerPlayGoals;
		this.powerPlayAssists = p.powerPlayAssists;
		this.shots = p.shots;
	}

	/**
	 * Player's goals
	 * 
	 * @return Integer of goals
	 */
	public int getGoals() {
		return goals;
	}

	/**
	 * Player's assists
	 * 
	 * @return Integer of player assists
	 */
	public int getAssists() {
		return assists;
	}

	/**
	 * Player's power play goals
	 * 
	 * @return Integer of poewr play goals
	 */
	public int getPowerPlayGoals() {
		return powerPlayGoals;
	}

	/**
	 * Player's power play assists
	 * 
	 * @return Integer of power play assists
	 */
	public int getPowerPlayAssists() {
		return powerPlayAssists;
	}

	/**
	 * Player's shots on goal
	 * 
	 * @return Integer of player shots on goal
	 */
	public int getShots() {
		return shots;
	}

	/**
	 * Return points (note this is sum of power play goals and power play assists)
	 * 
	 * @return Integer points of the player
	 */
	public int getPoints() {
		return goals + assists;
	}

	/**
	 * Return power play points (note this is sum of power play goals and power play
	 * assists)
	 * 
	 * @return Integer power play points of the player
	 */
	public int getPowerPlayPoints() {
		return powerPlayGoals + powerPlayAssists;
	}

	/**
	 * Calculate and return a shooting percentage (0-100)
	 * 
	 * @return Double of shooting percentage (0.0-100.0), 0 is returned if player
	 *         has no shots
	 */
	public double getShootingPercentage() {
		if (shots == 0) {
			return 0;
		}
		return ((double) goals) / ((double) shots) * 100;
	}

	/**
	 * Record a shot
	 */
	public void recordShot() {
		this.shots += 1;
	}

	/**
	 * Record a goal (note this adds both a goal and a shot on goal)
	 */
	public void recordGoal() {
		this.goals += 1;
		this.shots += 1;
	}

	/**
	 * Record an assist
	 */
	public void recordAssist() {
		assists += 1;
	}

	/**
	 * Add a power play goal (note this adds both regular goal, power play goal, and
	 * shot on goal)
	 */
	public void recordPowerPlayGoal() {
		this.goals += 1;
		this.powerPlayGoals += 1;
		this.shots += 1;
	}

	/**
	 * Add a power play assist (note this adds both a regular assist and power play
	 * assist
	 */
	public void recordPowerPlayAssist() {
		this.assists += 1;
		this.powerPlayAssists += 1;
	}
}
