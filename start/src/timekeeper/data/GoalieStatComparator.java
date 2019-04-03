package timekeeper.data;

import java.util.Comparator;

public class GoalieStatComparator implements Comparator<Goalie>{
	
	@Override
	public int compare (Goalie a, Goalie b)
	{
		if(a.getSavePercentage() < b.getSavePercentage())
			return 1;
		else if(a.getSavePercentage() > b.getSavePercentage())
			return -1;
		else
		{
			PlayerNumberComparator comp = new PlayerNumberComparator();
			return comp.compare(a, b);
		}
	}

}
