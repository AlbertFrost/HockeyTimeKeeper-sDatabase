package timekeeper.data;
/**
 * <h1>W19 - COMP 1502 - Assignment 2 Player Class</h1> A Player has roster
 * info. Name, position, number, date of birth, hometown, weight, height. These
 * are stored as String with only position being stored as an enum.
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public abstract class Player implements Comparable<Player> {

	/**
	 * String name of player
	 */
	private String name;
	/**
	 * Enum Position of player
	 */
	private Position position;
	/**
	 * String number of player
	 */
	private String number;
	/**
	 * String date of birth of player
	 */
	private String dateOfBirth;
	/**
	 * String hometown of player
	 */
	private String homeTown;
	/**
	 * String Weight of player
	 */
	private String weight;
	/**
	 * String height of player
	 */
	private String height;

	/**
	 * Create all parts of a player
	 * 
	 * @param name        String name of player
	 * @param position    Enum Position of player
	 * @param number      String number of player
	 * @param dateOfBirth String date of birth of player
	 * @param homeTown    String hometown of player
	 * @param weight      String Weight of player
	 * @param height      String height of player
	 */
	public Player(String name, Position position, String number, String dateOfBirth, String homeTown, String weight, String height) {
		this.name = name;
		this.position = position;
		this.number = number;
		this.dateOfBirth = dateOfBirth;
		this.homeTown = homeTown;
		this.weight = weight;
		this.height = height;
	}

	/**
	 * Copy the player entered
	 * 
	 * @param p Player to be copied
	 */
	public Player(Player p) {
		this(p.name, p.position, p.number, p.dateOfBirth, p.homeTown, p.weight, p.height);
	}

	/**
	 * Player's name
	 * 
	 * @return String of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Player's position
	 * 
	 * @return Enum Position of position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Player's jersey number
	 * 
	 * @return String of jersey number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Player's date of birth
	 * 
	 * @return String of date of birth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Player's hometown
	 * 
	 * @return String of hometown
	 */
	public String getHomeTown() {
		return homeTown;
	}

	/**
	 * Player's height
	 * 
	 * @return String of height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Player's weight
	 * 
	 * @return String of weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * Return &gt;name&lt;-&gt;#&lt; String of player
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + " - " + number;
	}

	/**
	 * Is this player a goalie
	 * 
	 * @return True if player is a goalie, false otherwise
	 */
	public boolean isGoalie() {
		return position.isGoalie();
	}

	/**
	 * Is this player a skater (not a goalie)
	 * 
	 * @return True if player is a skate (not a goalie), false otherwise
	 */
	public boolean isSkater() {
		return position.isSkater();
	}
	
	@Override
	public int compareTo(Player player)
	{
		int numberDifference = -number.compareTo(player.getNumber());
		if(numberDifference != 0)
			return numberDifference;
		
		return name.compareTo(player.getName());
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(o != null)
			if(o instanceof Player)
			{
				Player p = (Player) o;
				if(name.equals(p.getName()) && number.equals(p.getNumber()) && position.equals(p.getPosition()) && dateOfBirth.equals(p.getDateOfBirth())
						&& homeTown.equals(p.getHomeTown()) && weight.equals(p.getWeight()) && height.equals(p.getHeight()))
					return true;
			}
			
		return false;
	}
	
	@Override
	public int hashCode()
	{
		return name.hashCode();
	}

}
