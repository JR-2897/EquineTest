package dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import models.Data;
import models.Horse;
import models.Race;

public class RaceDAO {

	Data data = Data.init();

	public Race createRace(String raceName) {
		if (raceName == null || raceName.isEmpty())
			return null;
		Race race = new Race(raceName);
		data.getAllRace().add(race);
		return race;
	}

	public List<Race> getAllRaces() {
		return data.getAllRace();
	}

	public boolean deleteRace(Race race) {
		if (!data.getAllRace().contains(race))
			return false;
		return data.getAllRace().remove(race);
	}

	public boolean addHorseInRace(Race race, Horse horse) {
		try {
			if (horse == null)
				throw new NullPointerException();
			return race.getHorseList().add(horse);
		} catch (NullPointerException e) {
			return false;
		}
	}

	public List<Horse> getAllHorsesFromRace(Race race) {
		try {
			return race.getHorseList();
		} catch (NullPointerException e) {
			return null;
		}
	}

	public Race getRaceByName(String name) {
		if (name == null || name.isEmpty())
			return null;
		for (Race r : data.getAllRace()) {
			if (r.getRaceName().equals(name))
				return r;
		}
		return null;
	}

	public Horse getHorseInRaceByHorseName(Race r, String nameHorse) {
		if (nameHorse == null || nameHorse.isEmpty())
			return null;
		try {
			for (Horse h : r.getHorseList()) {
				if (h.getNameHorse().equals(nameHorse))
					return h;
			}
		} catch (NullPointerException ex) {
		}
		return null;
	}

	public boolean raceExist(String name) {
		if (name == null || name.isEmpty())
			return false;
		for (Race r : data.getAllRace()) {
			if (r.getRaceName().equals(name))
				return true;
		}
		return false;
	}

	public boolean deleteHorseInRace(Race r, Horse h) {
		try {
			if (h == null)
				throw new NullPointerException();
			return r.getHorseList().remove(h);
		} catch (NullPointerException e) {
			return false;
		}
	}

	public boolean horseWinnerExist(Race r) {
		try {
			if (r.getWinner() == null)
				return false;
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	public boolean raceHasAchievedHorsesMaxCapacity(Race r) {
		if(r != null && r.getHorseList().size() == 6)
			return true;
		return false;
	}
	
	public List<Race> getAllRaceLaunched(){
		List<Race> selectionList = new ArrayList<Race>();
		for(Race r : data.getAllRace())
			if(r.getWinner()!=null)
				selectionList.add(r);
		if(selectionList.size() != 0) {
			selectionList.sort(new Comparator<Race>() {
				@Override
				public int compare(Race r1, Race r2) {
					return r2.getRaceDate().compareTo(r1.getRaceDate());
				}
			});
		}
		return selectionList;
	}
}
