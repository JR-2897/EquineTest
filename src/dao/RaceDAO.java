package dao;

import models.Data;
import models.Race;

public class RaceDAO {

	Data data = Data.init();
	
	public Race createRace(String raceName) {
		if(raceName == null || raceName.isEmpty())
			return null;
		return new Race(raceName);
	}
}
