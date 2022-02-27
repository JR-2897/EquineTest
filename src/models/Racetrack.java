package models;

import java.util.ArrayList;
import java.util.List;

public class Racetrack {
	
	String nameRacetrack;

	private static Racetrack racetrack;
	
	private Racetrack() {
		nameRacetrack = "ParisLongchamp";
	}
	
	public static Racetrack initRacetrack() {
		if (racetrack == null)
		{
			racetrack = new Racetrack();
		}
		return racetrack;
	}

	public String getNameRacetrack() {
		return nameRacetrack;
	}
}
