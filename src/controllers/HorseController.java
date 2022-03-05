package controllers;

import java.util.ArrayList;
import java.util.List;

import dao.HorseDAO;
import models.Data;
import models.Horse;

public class HorseController {
	
	HorseDAO hDAO = new HorseDAO();
	
	public String getAllHorses() {
		List<Horse> horseList = hDAO.getAllHorses();
		if (horseList == null)
			return "KO";
		for(Horse horseToPrint : horseList)
		{
			System.out.println("- " + horseToPrint.getNameHorse());
		}
		return "OK";
	}
	
	public String createHorse(String name, int age) {
		if(hDAO.horseExist(name))
			return "Le nom du cheval existe déjà";
		Horse horseToCreate = hDAO.createHorse(name, age);
		if(horseToCreate != null)
			return "ok";
		return "La création du cheval n'a pas pu être faite";
	}
	
	public String showInfoHorse(String name) {
		Horse horseFind = hDAO.getHorseByName(name);
		if(horseFind == null)
			return "Ce cheval n'existe pas";
		System.out.println("Nom du cheval : " + horseFind.getNameHorse());
		System.out.println("Age du cheval : " + horseFind.getAge());
		System.out.println("Nombre de victoire du cheval : " + horseFind.getVictoryNb());
		return "OK";
	}
	
	public String deleteHorse(String horseName) {
		Horse h = hDAO.getHorseByName(horseName);
		if(h == null)
			return "Ce cheval n'existe pas";
		if(hDAO.horseExistInRace(horseName))
			return "Ce cheval existe dans une course, donc elle ne peut pas être supprimé";
		hDAO.deleteHorse(h);
		return "OK";
	}

}
