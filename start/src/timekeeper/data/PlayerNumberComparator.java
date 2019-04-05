package timekeeper.data;

import java.util.Comparator;

public class PlayerNumberComparator implements Comparator<Player> {

	@Override
	public int compare(Player a, Player b)
	{
		if(Integer.parseInt(a.getNumber()) > Integer.parseInt(b.getNumber()))
			return 1;
		else if(Integer.parseInt(a.getNumber()) < Integer.parseInt(b.getNumber()))
			return -1;
		else{

			PlayerNameComparator comp = new PlayerNameComparator();
			return comp.compare(a, b);
		}
	}
	
}
