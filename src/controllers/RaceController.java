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
			return "Le nom de la course existe d�j�";
		if(rDao.createRace(name) == null)
			return "La cr�ation de la course n'a pas pu �tre faite";
		return "OK";
	}
	
	public String deleteHorse(String raceName, String horseName) {
		return "KO";
	}
}
