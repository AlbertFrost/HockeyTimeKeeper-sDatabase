package timekeeper;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

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
			File file = new File("FailLoadFile.txt");
			TeamReader.loadPlayerList(file);
			fail();
		}
		catch(Exception e)
		{}
		try 
		{
			File file = new File("WorkingLoadSaveFile.txt");
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
			File file = new File("FailSaveFile.txt");
			TeamWriter.recordToFile(file, playerList);
			fail();
		}
		catch(Exception e)
		{}
		try 
		{
			PlayerList playerList = new PlayerList();
			File file = new File("WorkingLoadSaveFile.txt");
			TeamWriter.recordToFile(file, playerList);
		}
		catch(Exception e)
		{
			fail();
		}
	}
	
	//Being handled internally
//	@Test
//	public void testLoadPlayerDataFromFile()
//	{
//		try {
//			File file = new File("brokenData.txt");
//			TeamReader.loadPlayerList(file);
//			fail();
//		}
//		catch(Exception e){
//		}
//		try {
//			File file = new File("data.txt");
//			TeamReader.loadPlayerList(file);
//		}
//		catch(Exception e){
//			fail();
//		}
//	}
	
	@Test
	public void testSortPlayerByNumber()
	{
		ArrayList<Player> players = new ArrayList<>();
		
		String name1 = "Albert Morozov";
		String dateOfBirth1 = "Aug 3 2000";
		String homeTown1 = "Calgary AB";
		String weight1 = "138";
		String height1 = "5\'8";
		String number1 = "1";
		
		String name2 = "Rachel Smith";
		String dateOfBirth2 = "Feb 14 1995";
		String homeTown2 = "Edmonton AB";
		String weight2 = "130";
		String height2 = "5\'6";
		String number2 = "5";
		
		String name3 = "Robert Rose";
		String dateOfBirth3 = "Nov 18 1999";
		String homeTown3 = "Red Deer AB";
		String weight3 = "150";
		String height3 = "5\'9";
		String number3 = "37";
		
		players.add(new Skater(name3, Position.C, number3, dateOfBirth3, homeTown3, weight3, height3));	
		players.add(new Skater(name1, Position.C, number1, dateOfBirth1, homeTown1, weight1, height1));	
		players.add(new Skater(name2, Position.C, number2, dateOfBirth2, homeTown2, weight2, height2));	
	
		PlayerNumberComparator comp = new PlayerNumberComparator();
		Collections.sort(players, comp);
		
		System.out.println(players);
		
		assertEquals(players.get(0).getNumber(), number1);
		assertEquals(players.get(1).getNumber(), number2);
		assertEquals(players.get(2).getNumber(), number3);
	}
	
	@Test
	public void testSortPlayerByName()
	{
		ArrayList<Player> players = new ArrayList<>();
		
		String name1 = "Albert Morozov";
		String dateOfBirth1 = "Aug 3 2000";
		String homeTown1 = "Calgary AB";
		String weight1 = "138";
		String height1 = "5\'8";
		String number1 = "1";
		
		String name2 = "Beth Smith";
		String dateOfBirth2 = "Feb 14 1995";
		String homeTown2 = "Edmonton AB";
		String weight2 = "130";
		String height2 = "5\'6";
		String number2 = "2";
		
		String name3 = "Robert Rose";
		String dateOfBirth3 = "Nov 18 1999";
		String homeTown3 = "Red Deer AB";
		String weight3 = "150";
		String height3 = "5\'9";
		String number3 = "3";
		
		players.add(new Skater(name3, Position.C, number3, dateOfBirth3, homeTown3, weight3, height3));	
		players.add(new Skater(name1, Position.C, number1, dateOfBirth1, homeTown1, weight1, height1));	
		players.add(new Skater(name2, Position.C, number2, dateOfBirth2, homeTown2, weight2, height2));	
	
		PlayerNameComparator comp = new PlayerNameComparator();
		Collections.sort(players, comp);
		
		assertEquals(players.get(0).getName(), name1);
		assertEquals(players.get(1).getName(), name2);
		assertEquals(players.get(2).getName(), name3);
	}
	
	@Test
	public void testSortSkaterByStat()
	{
		ArrayList<Skater> players = new ArrayList<>();
		
		String name1 = "Ashly Matvely";
		String dateOfBirth1 = "Aug 3 2000";
		String homeTown1 = "Calgary AB";
		String weight1 = "138";
		String height1 = "5\'8";
		String number1 = "1";
		int goals1 = 8;
		int assists1 = 7;
		int powerPlayGoals1 = 6;
		int powerPlayAssists1 = 7;
		int shots1 = 20;
		
		String name2 = "Beth Smith";
		String dateOfBirth2 = "Feb 14 1995";
		String homeTown2 = "Edmonton AB";
		String weight2 = "130";
		String height2 = "5\'6";
		String number2 = "2";
		int goals2 = 7;
		int assists2 = 8;
		int powerPlayGoals2 = 7;
		int powerPlayAssists2 = 7;
		int shots2 = 14;
		
		String name3 = "Robert Rose";
		String dateOfBirth3 = "Nov 18 1999";
		String homeTown3 = "Red Deer AB";
		String weight3 = "150";
		String height3 = "5\'9";
		String number3 = "3";
		int goals3 = 3;
		int assists3 = 3;
		int powerPlayGoals3 = 3;
		int powerPlayAssists3 = 3;
		int shots3 = 6;
		
		String name4 = "Zelda LaFleche";
		String dateOfBirth4 = "May 8 2001";
		String homeTown4 = "Lethbridge AB";
		String weight4 = "145";
		String height4 = "5\'7";
		String number4 = "4";
		int goals4 = 3;
		int assists4 = 3;
		int powerPlayGoals4 = 3;
		int powerPlayAssists4 = 3;
		int shots4 = 6;

		String name5 = "Lima November";
		String dateOfBirth5 = "Jul 4 1978";
		String homeTown5 = "Medicine Hat AB";
		String weight5 = "143";
		String height5 = "5\'8";
		String number5 = "5";
		int goals5 = 8;
		int assists5 = 10;
		int powerPlayGoals5 = 6;
		int powerPlayAssists5 = 7;
		int shots5 = 20;
		
		players.add(new Skater(name3, Position.C, number3, dateOfBirth3, homeTown3, weight3, height3, goals3, assists3, powerPlayGoals3, powerPlayAssists3, shots3));	
		players.add(new Skater(name1, Position.C, number1, dateOfBirth1, homeTown1, weight1, height1, goals1, assists1, powerPlayGoals1, powerPlayAssists1, shots1));	
		players.add(new Skater(name4, Position.C, number4, dateOfBirth4, homeTown4, weight4, height4, goals4, assists4, powerPlayGoals4, powerPlayAssists4, shots4));	
		players.add(new Skater(name2, Position.C, number2, dateOfBirth2, homeTown2, weight2, height2, goals2, assists2, powerPlayGoals2, powerPlayAssists2, shots2));		
		players.add(new Skater(name5, Position.C, number5, dateOfBirth5, homeTown5, weight5, height5, goals5, assists5, powerPlayGoals5, powerPlayAssists5, shots5));	
	
		SkaterStatComparator comp = new SkaterStatComparator();
		Collections.sort(players, comp);

		assertEquals(players.get(0).getName(), name5);
		assertEquals(players.get(1).getName(), name1);
		assertEquals(players.get(2).getName(), name2);
		assertEquals(players.get(3).getName(), name3);
		assertEquals(players.get(4).getName(), name4);
	}
	
	@Test
	public void testSortGoalieByStat()
	{
		ArrayList<Goalie> players = new ArrayList<>();
		
		//85% SV
		String name1 = "Ashly Matvely";
		String dateOfBirth1 = "Aug 3 2000";
		String homeTown1 = "Calgary AB";
		String weight1 = "138";
		String height1 = "5\'8";
		String number1 = "1";
		int shotsAgainst1 = 20;
		int goalsAgainst1 = 3;
		int shutouts1 = 2;
		int minutes1 = 300;

		//70% SV
		String name2 = "Beth Smith";
		String dateOfBirth2 = "Feb 14 1995";
		String homeTown2 = "Edmonton AB";
		String weight2 = "130";
		String height2 = "5\'6";
		String number2 = "2";
		int shotsAgainst2 = 10;
		int goalsAgainst2 = 3;
		int shutouts2 = 2;
		int minutes2 = 300;

		//20% SV
		String name3 = "Robert Rose";
		String dateOfBirth3 = "Nov 18 1999";
		String homeTown3 = "Red Deer AB";
		String weight3 = "150";
		String height3 = "5\'9";
		String number3 = "3";
		int shotsAgainst3 = 5;
		int goalsAgainst3 = 3;
		int shutouts3 = 2;
		int minutes3 = 300;
		
		players.add(new Goalie(name3, Position.C, number3, dateOfBirth3, homeTown3, weight3, height3, shotsAgainst3, goalsAgainst3, shutouts3, minutes3));	
		players.add(new Goalie(name1, Position.C, number1, dateOfBirth1, homeTown1, weight1, height1, shotsAgainst1, goalsAgainst1, shutouts1, minutes1));	
		players.add(new Goalie(name2, Position.C, number2, dateOfBirth2, homeTown2, weight2, height2, shotsAgainst2, goalsAgainst2, shutouts2, minutes2));	
	
		GoalieStatComparator comp = new GoalieStatComparator();
		Collections.sort(players, comp);
		
		assertEquals(players.get(0).getName(), name1);
		assertEquals(players.get(1).getName(), name2);
		assertEquals(players.get(2).getName(), name3);
	}

//	@Test
//	public void testSortPlayerByHometown()
//	{
//		ArrayList<Player> players = new ArrayList<>();
//		
//		String name1 = "Albert Morozov";
//		String dateOfBirth1 = "Aug 3 2000";
//		String homeTown1 = "Calgary AB";
//		String weight1 = "138";
//		String height1 = "5\'8";
//		String number1 = "1";
//		
//		String name2 = "Rachel Smith";
//		String dateOfBirth2 = "Feb 14 1995";
//		String homeTown2 = "Edmonton AB";
//		String weight2 = "130";
//		String height2 = "5\'6";
//		String number2 = "2";
//		
//		String name3 = "Robert Rose";
//		String dateOfBirth3 = "Nov 18 1999";
//		String homeTown3 = "Red Deer AB";
//		String weight3 = "150";
//		String height3 = "5\'9";
//		String number3 = "3";
//		
//		players.add(new Skater(name3, Position.C, number3, dateOfBirth3, homeTown3, weight3, height3));	
//		players.add(new Skater(name1, Position.C, number1, dateOfBirth1, homeTown1, weight1, height1));	
//		players.add(new Skater(name2, Position.C, number2, dateOfBirth2, homeTown2, weight2, height2));	
//	
//		HometownComparator comp = new HometownComparator();
//		Collections.sort(players, comp);
//		
//		assertEquals(players.get(0).getHomeTown(), homeTown1);
//		assertEquals(players.get(1).getHomeTown(), homeTown2);
//		assertEquals(players.get(2).getHomeTown(), homeTown3);
//	}

}
