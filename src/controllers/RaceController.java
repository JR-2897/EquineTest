package controllers;

import java.time.LocalDate;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;

import dao.HorseDAO;
import dao.RaceDAO;
import models.Horse;
import models.Race;
import utils.Util;

public class RaceController {

	RaceDAO rDao = new RaceDAO();
	HorseDAO hDao = new HorseDAO();

	public String printAllRaces() {
		List<Race> raceList = rDao.getAllRaces();
		if (raceList == null)
			return "KO";
		for (Race r : raceList) {
			System.out.println("- " + r.getRaceName());
		}
		return "OK";
	}

	public String createRace(String name) {
		if (rDao.raceExist(name))
			return "Le nom de la course existe déjà";
		if (rDao.createRace(name) == null)
			return "La création de la course n'a pas pu être faite";
		return "OK";
	}

	public String deleteHorseInRace(String raceName, String horseName) {
		if (!hDao.horseExist(horseName))
			return "Le cheval n'existe pas";
		if (!rDao.raceExist(raceName))
			return "La course n'existe pas";
		Race r = rDao.getRaceByName(raceName);
		Horse h = rDao.getHorseInRaceByHorseName(r, horseName);
		if (h == null)
			return "Le cheval n'existe pas dans cette course";
		rDao.deleteHorseInRace(r, h);
		return "OK";
	}

	public String printHorseListInRace(String raceName) {
		Race r = rDao.getRaceByName(raceName);
		if (r == null)
			return "Cette course n'existe pas";
		for (Horse h : r.getHorseList()) {
			System.out.println("- " + h.getNameHorse());
		}
		return "OK";
	}

	public String addHorseInRace(String nameRace, String nameHorse) {
		Race r = rDao.getRaceByName(nameRace);
		if (r == null)
			return "La course n existe pas";
		Horse h = hDao.getHorseByName(nameHorse);
		if (h == null)
			return "Ce cheval n'existe pas";
		if (rDao.getHorseInRaceByHorseName(r, nameHorse) != null)
			return "Ce cheval existe déjà dans la course";
		if(rDao.raceHasAchievedHorsesMaxCapacity(r))
			return "La course a déjà atteint son nombre maximum de chevaux";
		rDao.addHorseInRace(r, h);
		return "OK";
	}

	public String deleteRace(String nameRace) {
		if (nameRace == null || nameRace.isEmpty())
			return "Vous n avez pas donne le nom de la course";
		Race r = rDao.getRaceByName(nameRace);
		if (r == null)
			return "La course que vous avez donne n existe pas";
		if (rDao.horseWinnerExist(r))
			return "Suppresion impossible car la course a un gagnant";
		return "OK";
	}

	public String showInfoRace(String nameRace) {
		Race raceToFind = rDao.getRaceByName(nameRace);
		if (raceToFind == null)
			return "Cette course n existe pas";
		System.out.println("Nom de la course : " + raceToFind.getRaceName());
		System.out.println("Date de la course : " + raceToFind.getRaceDate());
		if (raceToFind.getHorseList().size() == 0) {
			System.out.println("Aucun cheval n est partant dans cette course");
			System.out.println("Veuillez en ajoute pour les voir apparaitre ici");
		} else {
			for (Horse horse : raceToFind.getHorseList()) {
				System.out.println("- " + horse.getNameHorse());
			}
		}
		Horse horseWinner = raceToFind.getWinner();
		if (horseWinner == null) {
			System.out.println("Cette course n a pas encore de gagnant");
			System.out.println("Veuillez la lance pour le connaitre");
		} else {
			System.out.println("Le gagnant de la course est : " + horseWinner.getNameHorse());
		}
		return "OK";
	}

	public String launchRaceAndPrintResult(String raceName) {
		Race r = rDao.getRaceByName(raceName);
		if(r == null)
			return "La course n'existe pas";
		if(!rDao.raceHasAchievedHorsesMaxCapacity(r))
			return "Il faut 6 chevaux pour lancer la course. Il y en a que "+ r.getHorseList().size();
		if(rDao.horseWinnerExist(r))
			return "La course a déjà été lancé, elle ne peut pas être relancé";
		Horse h = launchRace(r);
		if(h == null)
			return "Il y a eu un problème dans le lancement de la course";
		System.out.println("Le gagnant pour la course "+ r.getRaceName()+ " est : "+r.getWinner().getNameHorse());
		return "OK";
	}
	
	private Horse launchRace(Race r) {
		int winnerIndex = Util.randomInt(0, 5);
		Horse h = null;
		try {
			h = r.getHorseList().get(winnerIndex);
			r.setWinner(h);
			hDao.increaseVictoryNb(h);
			r.setRaceDate(LocalDate.now());
		}catch(Exception ex) {
		}
		return h;
	}
	
	public String printLast10RacesLaunched() {
		try {
		for(Race r : rDao.getAllRaceLaunched()) {
			System.out.println("Course : "+r.getRaceName()+" Date: "+r.getRaceDate()+" Cheval vainqueur: "+r.getWinner().getNameHorse());
		}
		}catch(Exception ex) {
			return "Il y a eu une exception";
		}
		return "OK";
	}
}
