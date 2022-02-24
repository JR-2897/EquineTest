package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Race {
	
	String raceName;
	Date raceDate;
	List<Horse> horseList;
	Horse winner;

	public Race(String raceName) {
		this.raceName = raceName;
		horseList = new ArrayList<Horse>();
	}
	
	public String getRaceName() {
		return raceName;
	}
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	public Date getRaceDate() {
		return raceDate;
	}
	public void setRaceDate(Date raceDate) {
		this.raceDate = raceDate;
	}
	public List<Horse> getHorseList() {
		return horseList;
	}
	public void setHorseList(List<Horse> horseList) {
		this.horseList = horseList;
	}
	public Horse getWinner() {
		return winner;
	}
	public void setWinner(Horse winner) {
		this.winner = winner;
	}

}
