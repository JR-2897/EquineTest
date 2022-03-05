package dao;

import java.util.List;

import models.Data;
import models.Horse;
import models.Race;

public class HorseDAO {
	
	Data data = Data.init();

	public Horse createHorse(String horseName, int age) {
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
	
	public Horse getHorseByName(String name) {
		if(name == null || name.isEmpty())
			return null;
		for(Horse h : data.getAllHorse()) {
			if(h.getNameHorse().equals(name))
				return h;
		}
		return null;
	}
	
	public boolean horseExist(String name) {
		if(name == null || name.isEmpty())
			return false;
		for(Horse h : data.getAllHorse()) {
			if(h.getNameHorse().equals(name))
				return true;
		}
		return false;
	}
	
	public boolean horseExistInRace(String nameHorse) {
		if(nameHorse == null || nameHorse.equals(""))
			return false;
		for(Race r : data.getAllRace()) {
			for(Horse h : r.getHorseList()) {
				if(h.getNameHorse().equals(nameHorse))
					return true;
			}
		}
		return false;
	}
}
