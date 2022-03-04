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
		return "echec";
	}

}
