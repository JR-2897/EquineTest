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
			return "Le nom de la course existe déjà";
		if(rDao.createRace(name) == null)
			return "La création de la course n'a pas pu être faite";
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
		Race r = rDao.getRaceByName(raceName);
		if(r == null)
			return "Cette course n'existe pas";
		for(Horse h : r.getHorseList()) {
			System.out.println("- "+ h.getNameHorse());
		}
		return "OK";
	}
	
	public String addHorseInRace(Race r, String nameHorse) {
		if(r == null)
			return "La course n'est pas bonne";
		Horse h = hDao.getHorseByName(nameHorse);
		if(h == null)
			return "Ce cheval n'existe pas";
		if(rDao.getHorseInRaceByHorseName(r, nameHorse)!=null)
			return "Ce cheval existe déjà dans la course";
		if(r.getHorseList().size() >= 6)
			return "La course a déjà atteint son nombre maximum de chevaux";
		rDao.addHorseInRace(r, h);
		return "OK";
	}
	
	public String deleteRace(String nameRace) {
		return "KO";
	}
}
