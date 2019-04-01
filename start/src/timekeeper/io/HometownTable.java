package timekeeper.io;

import timekeeper.data.PlayerList;

public class HometownTable implements Table{

	PlayerList playerList;
	
	public HometownTable(PlayerList playerList)
	{
		this.playerList = playerList;
	}

	@Override
	public String createTableString() {
		// TODO Auto-generated method stub
		return null;
	}
}
