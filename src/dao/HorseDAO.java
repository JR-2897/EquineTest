package dao;

import java.util.List;

import models.Data;
import models.Horse;

public class HorseDAO {
	
	Data data = Data.init();

	public Horse CreateHorse(String horseName, int age) {
		if(horseName == null || horseName.isEmpty() || age<= 0)
			return null;
		Horse horse = new Horse(horseName,age);
		data.getAllHorse().add(horse);
		return horse;
	}
	
	public List<Horse> getAllHorses(){
		return data.getAllHorse();
	}
	
	public boolean deleteHorse(Horse horse) {
		if(!data.getAllHorse().contains(horse))
			return false;
		return data.getAllHorse().remove(horse);
	}
	
	public boolean increaseVictoryNb(Horse horse) {
		if(horse == null)
			return false;
		horse.setVictoryNb(horse.getVictoryNb() + 1);
		return true;
	}
}
