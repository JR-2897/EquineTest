package models;

import java.util.List;

public class Racetrack {
	
	String nameRacetrack;
	List<Race> listRace;

	private Racetrack racetrack;
	
	private Racetrack() {
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

	public void setNameRacetrack(String nameRacetrack) {
		this.nameRacetrack = nameRacetrack;
	}
	
	public List<Race> getListRace() {
		return listRace;
	}

	public void setListRace(List<Race> listRace) {
		this.listRace = listRace;
	}
}
