package timekeeper.data;

import java.util.Comparator;

public class HometownComparator implements Comparator<String>{
	
	@Override
	public int compare(String a, String b)
	{
		return a.compareTo(b);
	}

}
