package timekeeper.io;

import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;

import timekeeper.data.*;

public class HometownTable implements Table{

	private PlayerList playerList;
	private ArrayList<String> hometownList;
	private static Map<String, Player> players;
	private static Map<String, Integer> hometownMap;
	
	/**
	 * Format for hometown table
	 */
	private static final String HOMETOWN_FORMAT = "%-20s %5s %-30s";
	/**
	 * Header for hometown table
	 */
	private static final String HOMETOWN_HEADER = String.format(HOMETOWN_FORMAT, "HOMETOWN", "COUNT", "PLAYERS");
	
	public HometownTable(PlayerList playerList)
	{
		System.out.println("Calling HometownTable class");
		this.playerList = playerList;
		this.players = playerList.getMap();
		hometownList = new ArrayList<>();
		createMapOfHometown();
	}

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
	
	@Override
	public String toString()
	{
		return createTableString();
	}
	
	private static String getFormattedStats(String hometown) {
		return String.format(HOMETOWN_FORMAT, hometown, hometownMap.get(hometown), getPlayersColumnString(hometown));
	}
	
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
