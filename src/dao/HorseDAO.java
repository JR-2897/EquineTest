package dao;

import java.util.List;

import models.Data;
import models.Horse;

public class HorseDAO {

	public Horse CreateHorse(String horseName, int age) {
		if(horseName == null || horseName.isEmpty() || age<= 0)
			return null;
		return new Horse(horseName,age);
	}
	
	public List<Horse> getAllHorses(){
		return Data.init().getAllHorse();
	}
	
	public boolean deleteHorse(Horse horse) {
		return false;
	}
}
