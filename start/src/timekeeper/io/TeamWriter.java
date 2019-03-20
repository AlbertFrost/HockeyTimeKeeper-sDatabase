package timekeeper.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import timekeeper.data.*;

/**
 * <h1>W19 - COMP 1502 - Assignment 2 TeamWriter Class</h1> Write a player to a
 * file <br>
 * Format Skater: $,name,pos,number,date of
 * birth,hometown,height,weight,goals,assists,power play goals, power play
 * shots, shots <br>
 * Format Goalie: @,name,pos,number,date of birth,hometown,height,weight,shots
 * against,goals against,shutouts,minutes
 * <br> pos is one of G,C,D,LW,RW
 * 
 * @author Tyson Kendon, Jonathan Hudson
 * @version 2.0
 *
 */
public class TeamWriter {

	/**
	 * Write player roster out to a file
	 * 
	 * @param file       The file handle to write to
	 * @param playerList The PlayerList to write out
	 * @return True if success, false if failed to write to file
	 * @throws FileNotFoundException
	 */
	public static boolean recordToFile(File file, PlayerList playerList) throws FileNotFoundException {
		PrintWriter printWriter = new PrintWriter(file);
		for (Player player : playerList.getPlayers()) {
			if (player.isGoalie()) {
				printWriter.println(getFileFormatString((Goalie) player));
			} else {
				printWriter.println(getFileFormatString((Skater) player));
			}
		}
		printWriter.close();
		return true;
	}

	/**
	 * Helper function to create shared Player part of output
	 * 
	 * @param player The Player object to output
	 * @return The String version of player
	 */
	private static String getFileFormatString(Player player) {
		StringBuilder builder = new StringBuilder();
		builder.append(player.getName()).append(",");
		builder.append(player.getPosition()).append(",");
		builder.append(player.getNumber()).append(",");
		builder.append(player.getDateOfBirth()).append(",");
		builder.append(player.getHomeTown()).append(",");
		builder.append(player.getWeight()).append(",");
		builder.append(player.getHeight()).append(",");
		return builder.toString();
	}

	/**
	 * Helper function to create Skater part of output
	 * 
	 * @param player The Skater object to output
	 * @return The String version of skater
	 */
	private static String getFileFormatString(Skater skater) {
		StringBuilder builder = new StringBuilder();
		builder.append(getFileFormatString((Player) skater));
		builder.append(skater.getGoals()).append(",");
		builder.append(skater.getAssists()).append(",");
		builder.append(skater.getPowerPlayGoals()).append(",");
		builder.append(skater.getPowerPlayAssists()).append(",");
		builder.append(skater.getShots()).append(",");
		return builder.toString();
	}

	/**
	 * Helper function to create Goalie part of output
	 * 
	 * @param player The Goalie object to output
	 * @return The String version of goalie
	 */
	private static String getFileFormatString(Goalie goalie) {
		StringBuilder builder = new StringBuilder();
		builder.append(getFileFormatString((Player) goalie));
		builder.append(goalie.getShotsAgainst()).append(",");
		builder.append(goalie.getGoalsAgainst()).append(",");
		builder.append(goalie.getShutouts()).append(",");
		builder.append(goalie.getMinutes()).append(",");
		return builder.toString();
	}

}
