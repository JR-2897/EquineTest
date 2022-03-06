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

	public String addHorseInRace(Race r, String nameHorse) {
		if (r == null)
			return "La course n'est pas bonne";
		Horse h = hDao.getHorseByName(nameHorse);
		if (h == null)
			return "Ce cheval n'existe pas";
		if (rDao.getHorseInRaceByHorseName(r, nameHorse) != null)
			return "Ce cheval existe déjà dans la course";
		if (r.getHorseList().size() >= 6)
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
		return "KO";
	}
}
