package models;

import java.util.List;

public class Racetrack {
	
	String nameRacetrack;
	List<Race> listRace;

	private Racetrack racetrack;
	
	private Racetrack() {
		nameRacetrack = "Le super Hippodrome";
	}
	
	public Racetrack initRacetrack() {
		if (racetrack == null)
		{
			racetrack = new Racetrack();
		}
		return racetrack;
	}

	public String getNameRacetrack() {
		return nameRacetrack;
	}

	public List<Race> getListRace() {
		return listRace;
	}

	public void setListRace(List<Race> listRace) {
		this.listRace = listRace;
	}
}
