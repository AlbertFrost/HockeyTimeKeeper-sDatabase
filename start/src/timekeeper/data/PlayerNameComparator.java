package timekeeper.data;

import java.util.Comparator;

public class PlayerNameComparator implements Comparator<Player> {
	@Override
	public int compare(Player a, Player b)
	{
		if(a.getName().compareTo(b.getName()) > 1)
			return 1;
		else if(a.getName().compareTo(b.getName()) < 1)
			return -1;
		else
			return 0;
	}
}
