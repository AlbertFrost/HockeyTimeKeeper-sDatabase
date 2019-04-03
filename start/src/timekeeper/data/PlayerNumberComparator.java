package timekeeper.data;

import java.util.Comparator;

public class PlayerNumberComparator implements Comparator<Player> {

	@Override
	public int compare(Player a, Player b)
	{
		if(a.getNumber().compareTo(b.getNumber()) > 1)
			return 1;
		else if(a.getNumber().compareTo(b.getNumber()) < 1)
			return -1;
		else
			return 0;
	}
	
}
