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
	
	public String createRace(String name) {
		if(rDao.raceExist(name))
			return "Le nom de la course existe déjà";
		if(rDao.createRace(name) == null)
			return "La création de la course n'a pas pu être faite";
		return "OK";
	}
	
	public String deleteHorse(String raceName, String horseName) {
		return "KO";
	}
}
