package timekeeper.data;
/**
 * <h1>W19 - COMP 1502 - Assignment 2 Goalie Class</h1> A Goalie is a player
 * with default 0 stats of shots against, goals against, minutes played and
 * shutouts. Every goal against is a shot against. All these values should be 0
 * or greater.
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public class Goalie extends Player {

	private int shotsAgainst;
	private int goalsAgainst;
	private int shutouts;
	private int minutes;

	/**
	 * Create all parts of a goalie
	 * 
	 * @param name        String name of goalie
	 * @param position    Enum Position of goalie
	 * @param number      String number of goalie
	 * @param dateOfBirth String date of birth of goalie
	 * @param homeTown    String hometown of goalie
	 * @param weight      String Weight of goalie
	 * @param height      String height of goalie
	 */
	public Goalie(String name, Position position, String number, String dateOfBirth, String homeTown, String weight, String height) {
		super(name, position, number, dateOfBirth, homeTown, weight, height);
	}

	/**
	 * Create all parts of a goalie
	 * 
	 * @param name         String name of goalie
	 * @param position     Enum Position of goalie
	 * @param number       String number of goalie
	 * @param dateOfBirth  String date of birth of goalie
	 * @param homeTown     String hometown of goalie
	 * @param weight       String Weight of goalie
	 * @param height       String height of goalie
	 * @param shotsAgainst Integer shots against a goalie (shotsAgainst >= 0)
	 * @param goalsAgainst Integer goals against a goalie (goalsAgainst >= 0)
	 * @param shutouts     Integer shutouts by goalie (shutouts >= 0)
	 * @param minutes      Integer minute played by goalie (minutes >= 0)
	 */
	public Goalie(String name, Position position, String number, String dateOfBirth, String homeTown, String weight, String height, int shotsAgainst, int goalsAgainst, int shutouts, int minutes) {
		super(name, position, number, dateOfBirth, homeTown, weight, height);
		this.shotsAgainst = shotsAgainst;
		this.goalsAgainst = goalsAgainst;
		this.shutouts = shutouts;
		this.minutes = minutes;
	}

	/**
	 * Copy the goalie entered
	 * 
	 * @param p Goalie to be copied
	 */
	public Goalie(Goalie g) {
		super(g);
		this.shotsAgainst = g.shotsAgainst;
		this.goalsAgainst = g.goalsAgainst;
		this.shutouts = g.shutouts;
		this.minutes = g.minutes;
	}

	/**
	 * Shots against the goalie
	 * 
	 * @return Shots against the goalie
	 */
	public int getShotsAgainst() {
		return shotsAgainst;
	}

	/**
	 * Goals against the goalie
	 * 
	 * @return Goals against the goalie
	 */
	public int getGoalsAgainst() {
		return goalsAgainst;
	}

	/**
	 * Shutouts by the goalie
	 * 
	 * @return Shutouts by the goalie
	 */
	public int getShutouts() {
		return shutouts;
	}

	/**
	 * Minutes played by the goalie
	 * 
	 * @return Minutes played by the goalie
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * Calculate goals against average for goalie (G per 60 mintues played)
	 * 
	 * @return Goals against average by the goalie
	 */
	public double getGoalsAgainstAverage() {
		if (minutes == 0) {
			return 0;
		}
		return ((double) goalsAgainst) * 60.0 / ((double) minutes);
	}

	/**
	 * Calculate goalie save percentage (0-1)
	 * 
	 * @return Calculate goalie save percentage (0-1)
	 */
	public double getSavePercentage() {
		if (shotsAgainst == 0) {
			return 0;
		}
		return 1.0 - ((double) goalsAgainst) / ((double) shotsAgainst);
	}

	/**
	 * Add a shot against
	 */
	public void recordShotAgainst() {
		this.shotsAgainst += 1;
	}

	/**
	 * Add a goal (and a shot) against
	 */
	public void recordGoalAgainst() {
		this.goalsAgainst += 1;
		this.shotsAgainst += 1;
	}

	/**
	 * Add a shutout
	 */
	public void recordShutout() {
		shutouts += 1;
	}

	/**
	 * Add minutes played
	 * 
	 * @param minutes The minutes played to add (minutes >=0)
	 */
	public void addMinutesPlayed(int minutes) {
		this.minutes += minutes;
	}

}
