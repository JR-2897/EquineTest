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
		return "KO";
	}

}
