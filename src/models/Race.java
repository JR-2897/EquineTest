package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Race {
	
	String raceName;
	LocalDate raceDate;
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
	public LocalDate getRaceDate() {
		return raceDate;
	}
	public void setRaceDate(LocalDate raceDate) {
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
