package timekeeper.data;

import java.util.Comparator;

public class SkaterStatComparator implements Comparator<Skater>{
	
	@Override
	public int compare(Skater a, Skater b)
	{
		if(a.getPoints() < b.getPoints())
			return 1;
		else if(a.getPoints() > b.getPoints())
			return -1;
		else
		{
			if(a.getGoals() < b.getGoals())
				return 1;
			else if(a.getGoals() > b.getGoals())
				return -1;
			else
			{
				PlayerNumberComparator comp = new PlayerNumberComparator();
				return comp.compare(a, b);
			}
				
		}
	}

}
