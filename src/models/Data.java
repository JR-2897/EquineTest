package models;

import java.util.ArrayList;
import java.util.List;

public class Data {

	List<Horse> allHorse;
	Racetrack racetrack;
	
	static Data data;
	
	private Data() {
		allHorse = new ArrayList<Horse>();
		racetrack = Racetrack.initRacetrack();
	}
	
	public static Data init() {
		if(data == null)
			data = new Data();
		return data;
	}

	public List<Horse> getAllHorse() {
		return allHorse;
	}

	public Racetrack getRacetrack() {
		return racetrack;
	}
	
}
