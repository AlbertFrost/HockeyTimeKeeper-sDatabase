package timekeeper.data;

import java.util.Comparator;

public class PlayerHometownComparator implements Comparator<Player>  {
	@Override
	public int compare(Player a, Player b)
	{
		if(a.getHomeTown().compareTo(b.getHomeTown()) > 1)
			return 1;
		else if(a.getHomeTown().compareTo(b.getHomeTown()) < 1)
			return -1;
		else 
		{
			PlayerNameComparator comp = new PlayerNameComparator();
			return comp.compare(a, b);
		}
	}
}
