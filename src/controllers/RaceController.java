package controllers;

import java.util.List;

import dao.RaceDAO;
import models.Race;

public class RaceController {

	RaceDAO rDao = new RaceDAO();
	
	public String printAllRaces() {
		List<Race> raceList = rDao.getAllRaces();
		if( raceList == null)
			return "KO";
		for(Race r : raceList) {
			System.out.println("- " + r.getRaceName());
		}
		return "OK";
	}
}
