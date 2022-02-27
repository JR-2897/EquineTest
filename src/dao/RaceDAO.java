package dao;

import java.util.List;

import models.Data;
import models.Race;

public class RaceDAO {

	Data data = Data.init();
	
	public Race createRace(String raceName) {
		if(raceName == null || raceName.isEmpty())
			return null;
		return new Race(raceName);
	}
	
	public List<Race> getAllRaces(){
		return data.getAllRace();
	}
	
	public boolean deleteRace(Race race) {
		if(!data.getAllRace().contains(race))
			return false;
		return data.getAllRace().remove(race);
	}
}
