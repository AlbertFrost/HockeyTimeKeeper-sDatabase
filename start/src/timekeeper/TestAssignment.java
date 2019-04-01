package timekeeper;

import static org.junit.Assert.*;


import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import timekeeper.data.*;
import timekeeper.io.*;

public class TestAssignment {

	@Test
	public void testAddPlayer()
	{
		String name = "Rebecca Johnston";
		String dateOfBirth = "Sep 24 1989";
		String homeTown = "Sudbury ON";
		String weight = "161";
		String height = "5\'9";
		String number = "6";
		int shotsAgainst = 12;
		int goalsAgainst = 1;
		int shutouts = 1;
		int minutesPlayed = 140;
		
		Goalie goalie = new Goalie(name, Position.G, number, dateOfBirth, homeTown, weight, height, 
				shotsAgainst, goalsAgainst, shutouts, minutesPlayed);
		
		PlayerList playerList = new PlayerList();
		
		playerList.addPlayer(goalie);
		
		String nameS = "Albert Morozov";
		String dateOfBirthS = "Aug 3 2000";
		String homeTownS = "Calgary AB";
		String weightS = "138";
		String heightS = "5\'8";
		String numberS = "6";
		
		Skater skater = new Skater(nameS, Position.C, number, dateOfBirthS, homeTownS, weightS, heightS);
	
		playerList.addPlayer(skater);
		
		assertEquals(playerList.getPlayerByNumber(number) instanceof Goalie, true);
	}
	
	@Test
	public void testFindFileForLoading()
	{
		try 
		{
			File file = new File("FailFile.txt");
			TeamReader.loadPlayerList(file);
			fail();
		}
		catch(Exception e)
		{}
		try 
		{
			File file = new File("TestLoadSaveFile.txt");
			TeamReader.loadPlayerList(file);
		}
		catch(Exception e)
		{
			fail();
		}
	}

	@Test
	public void testFindFileForSaving()
	{
		try 
		{
			PlayerList playerList = new PlayerList();
			File file = new File("FailFile.txt");
			TeamWriter.recordToFile(file, playerList);
			fail();
		}
		catch(Exception e)
		{}
		try 
		{
			PlayerList playerList = new PlayerList();
			File file = new File("TestLoadSaveFile.txt");
			TeamWriter.recordToFile(file, playerList);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	@Test
	public void testLoadPlayerDataFromFile()
	{
		try {
			File file = new File("brokenData.txt");
			TeamReader.loadPlayerList(file);
			fail();
		}
		catch(Exception e){
		}
		try {
			File file = new File("data.txt");
			TeamReader.loadPlayerList(file);
		}
		catch(Exception e){
			fail();
		}
	}
	
	@Test
	public void testSortPlayerByNumber()
	{
		PlayerList playerList = new PlayerList();
		int counter = 1;
		
		String name = "Albert Morozov";
		String dateOfBirth = "Aug 3 2000";
		String homeTown = "Calgary AB";
		String weight = "138";
		String height = "5\'8";
		String number1 = "1";
		String number2 = "2";
		String number3 = "3";
		
		playerList.addPlayer(new Skater(name, Position.C, number3, dateOfBirth, homeTown, weight, height));	
		playerList.addPlayer(new Skater(name, Position.C, number1, dateOfBirth, homeTown, weight, height));	
		playerList.addPlayer(new Skater(name, Position.C, number2, dateOfBirth, homeTown, weight, height));	
	
		String table = TableFactory.listAllPlayersRoster(playerList).createTableString();
	
		ArrayList<String> lines = new ArrayList<>(Arrays.asList(table.split("\n")));
		
		for(String line : lines)
		{
			ArrayList<String> data = new ArrayList<>(Arrays.asList(table.split(" ")));
			
			if(data.get(1).equals("#"))
				continue;
			else {
				switch(counter)
				{
					case 1: assertEquals(data.get(1), number1); break;
					case 2: assertEquals(data.get(1), number2); break;
					case 3: assertEquals(data.get(1), number3); break;
				}
			}
			
		}
	}

}
