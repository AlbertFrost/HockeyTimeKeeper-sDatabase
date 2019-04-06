package timekeeper.io;

import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

import timekeeper.data.*;

public class HometownTable implements Table{

	private PlayerList playerList;
	
	/**
	 * Collections to organize data and information
	 */
	private ArrayList<String> hometownList; //To have a collection that can sort hometowns by alphabet
	private static Map<String, Player> players; //Collection to take in the data from PlayerList
	private static Map<String, Integer> hometownMap; //Collection to save hometown and the amount of players from that hometown
	
	/**
	 * Format for hometown table
	 */
	private static final String HOMETOWN_FORMAT = "%-20s %5s %-30s";
	/**
	 * Header for hometown table
	 */
	private static final String HOMETOWN_HEADER = String.format(HOMETOWN_FORMAT, "HOMETOWN", "COUNT", "PLAYERS");
	
	/**
	 * Construct hometown table
	 * 
	 * @param playerList The PlayerList to store
	 * Calls the getMap method of PlayerList to fill the HometownTable instance of
	 * Map<String, Player>
	 * Additionally fills other collection objects to have data ready to create the
	 * table string.
	 */
	public HometownTable(PlayerList playerList)
	{
		System.out.println("Calling HometownTable class");
		this.playerList = playerList;
		this.players = playerList.getMap();
		hometownList = new ArrayList<>();
		createMapOfHometown();
	}

	/**
	 * Using StringBuilder to create a formatted String that represents the hometowns
	 * of the Players. Table is organized by alphabetical order which each hometown
	 * will show how many Players are from it and all the Players' name and number.
	 */
	@Override
	public String createTableString() {
		StringBuilder sb = new StringBuilder();
		sb.append(HOMETOWN_HEADER).append("\n");
		
		HometownComparator comp = new HometownComparator();
		Collections.sort(hometownList, comp);
		
		for (String hometown: hometownList) {
				sb.append(getFormattedStats(hometown)).append("\n");
		}
		return sb.toString();
	}
	
	/**
	 * Calls the createTableString method and returns the formatted table String
	 */
	@Override
	public String toString()
	{
		return createTableString();
	}
	
	/**
	 * @param hometown
	 * @return String
	 * 
	 * Takes the hometown name and creates a formatted line which includes the
	 * amount of Players from it and the Players' name and number
	 */
	private static String getFormattedStats(String hometown) {
		return String.format(HOMETOWN_FORMAT, hometown, hometownMap.get(hometown), getPlayersColumnString(hometown));
	}
	
	/**
	 * @param hometown
	 * @return String
	 * 
	 * Takes the hometown name and goes through the Map of Player and String to
	 * find each Player from that hometown and create a formatted String to be
	 * placed into a line in the table. 
	 */
	private static String getPlayersColumnString(String hometown)
	{
		StringBuilder sb = new StringBuilder();
		
		boolean isMoreThanOnePlayer = false;
		
		sb.append("[");
		
		for(Player p: players.values())
		{
			if(p.getHomeTown().equals(hometown))
			{
				if(isMoreThanOnePlayer)
					sb.append(", ("+p.getName()+","+p.getNumber()+")");
				else {
					sb.append("("+p.getName()+","+p.getNumber()+")");
					isMoreThanOnePlayer = true;
				}
			}
		}

		sb.append("]");
		
		return sb.toString();
	}
	
	/**
	 * This method is called in the constructor to setup the Map with
	 * hometown and integer as well add every unique hometown to the
	 * hometown list.
	 */
	private void createMapOfHometown()
	{
		hometownMap = new HashMap<String, Integer>();
		for(Player p: players.values())
		{
			if(!hometownMap.containsKey(p.getHomeTown()))
			{
				hometownList.add(p.getHomeTown());
				hometownMap.put(p.getHomeTown(), 1);
			}
			else {
				hometownMap.put(p.getHomeTown(), hometownMap.get(p.getHomeTown())+1);
			}
		}
	}
}
