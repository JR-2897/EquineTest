package controllers;

import java.util.List;

import dao.HorseDAO;
import dao.RaceDAO;
import models.Horse;
import models.Race;

public class RaceController {

	RaceDAO rDao = new RaceDAO();
	HorseDAO hDao = new HorseDAO();
	
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
	
	public String deleteHorseInRace(String raceName, String horseName) {
		if(!hDao.horseExist(horseName))
			return "Le cheval n'existe pas";
		if(!rDao.raceExist(raceName))
			return "La course n'existe pas";
		Race r = rDao.getRaceByName(raceName);
		Horse h = rDao.getHorseInRaceByHorseName(r, horseName);
		if(h == null)
			return "Le cheval n'existe pas dans cette course";
		rDao.deleteHorseInRace(r,h);
		return "OK";
	}
	
	public String printHorseListInRace(String raceName) {
		return "KO";
	}
}
