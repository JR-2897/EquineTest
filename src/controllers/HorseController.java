package controllers;

import java.util.ArrayList;
import java.util.List;

import dao.HorseDAO;
import models.Data;
import models.Horse;

public class HorseController {
	
	HorseDAO hDAO = new HorseDAO();
	
	public String getAllHorses() {
		if (hDAO.getAllHorses() != null)
			return "OK";
		return "KO";
	}
	
	public String createHorse(String name, int age) {
		if(hDAO.horseExist(name))
			return "Le nom du cheval existe d�j�";
		Horse horseToCreate = hDAO.createHorse(name, age);
		if(horseToCreate != null)
			return "ok";
		return "La cr�ation du cheval n'a pas pu �tre faite";
	}

}
