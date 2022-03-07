package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Data {

	List<Horse> allHorse;
	List<Race> allRace;

	Racetrack racetrack;
	
	static Data data;
	
	private Data() {
		allHorse = new ArrayList<Horse>();
		racetrack = Racetrack.initRacetrack();
		allRace = new ArrayList<Race>();
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
	
	public List<Race> getAllRace() {
		return allRace;
	}
	
	public void resetData() {
		allHorse = new ArrayList<Horse>();
		allRace = new ArrayList<Race>();
	}
	
	public void generateDataForDemo() {
		resetData();
		Horse h1 = new Horse("Tonnerre",4);
		data.allHorse.add(h1);
		Horse h2 = new Horse("Pegasus",3);
		data.allHorse.add(h2);
		Horse h3 = new Horse("Joker",2);
		data.allHorse.add(h3);
		Horse h4 = new Horse("Flash",4);
		data.allHorse.add(h4);
		Horse h5 = new Horse("Lucky",9);
		data.allHorse.add(h5);
		Horse h6 = new Horse("Starlight",6);
		data.allHorse.add(h6);
		Horse h7 = new Horse("Tequila",4);
		data.allHorse.add(h7);
		Horse h8 = new Horse("Pepito",7);
		data.allHorse.add(h8);
		Horse h9 = new Horse("Phoenix",11);
		data.allHorse.add(h9);
		Horse h10 = new Horse("Zigzag",6);
		data.allHorse.add(h10);
		
		Race r1 = new Race("Course_du_lundi");
		data.allRace.add(r1);
		Race r2 = new Race("Course_du_mardi");
		data.getAllRace().add(r2);
		Race r3 = new Race("Course_du_mercredi");
		data.getAllRace().add(r3);
		Race r4 = new Race("Course_du_jeudi");
		data.getAllRace().add(r4);
		Race r5 = new Race("Course_du_vendredi");
		data.getAllRace().add(r5);
		Race r6 = new Race("Course_du_samedi");
		data.getAllRace().add(r6);
		Race r7 = new Race("Course_du_dimanche");
		data.getAllRace().add(r7);
		Race r8 = new Race("Course_mensuelle");
		data.getAllRace().add(r8);
		Race r9 = new Race("Course_annuelle");
		data.getAllRace().add(r9);
		Race r10 = new Race("Course_hebdomadaire");
		data.getAllRace().add(r10);
		
		r1.getHorseList().add(h1);
		r1.getHorseList().add(h2);
		r1.getHorseList().add(h3);
		r1.getHorseList().add(h4);
		r1.getHorseList().add(h5);
		r1.getHorseList().add(h6);
		r1.setWinner(h3);
		h3.setVictoryNb(h3.getVictoryNb()+1);
		r1.setRaceDate(LocalDate.of(2003, 4, 5));
		
		r2.getHorseList().add(h2);
		r2.getHorseList().add(h3);
		r2.getHorseList().add(h4);
		r2.getHorseList().add(h5);
		r2.getHorseList().add(h6);
		r2.getHorseList().add(h7);
		r2.setWinner(h3);
		h3.setVictoryNb(h3.getVictoryNb()+1);
		r2.setRaceDate(LocalDate.of(2008, 4, 5));
		
		r3.getHorseList().add(h10);
		r3.getHorseList().add(h6);
		r3.getHorseList().add(h5);
		r3.getHorseList().add(h8);
		r3.getHorseList().add(h9);
		r3.getHorseList().add(h4);
		r3.setWinner(h10);
		h10.setVictoryNb(h10.getVictoryNb()+1);
		r3.setRaceDate(LocalDate.of(2013, 9, 25));
		
		r4.getHorseList().add(h9);
		r4.getHorseList().add(h8);
		r4.getHorseList().add(h7);
		r4.getHorseList().add(h6);
		r4.getHorseList().add(h5);
		r4.getHorseList().add(h4);
		r4.setWinner(h7);
		h7.setVictoryNb(h7.getVictoryNb()+1);
		r4.setRaceDate(LocalDate.of(2013, 4, 17));
		
		r5.getHorseList().add(h4);
		r5.getHorseList().add(h5);
		r5.getHorseList().add(h7);
		r5.getHorseList().add(h9);
		r5.getHorseList().add(h1);
		r5.getHorseList().add(h3);
		r5.setWinner(h3);
		h3.setVictoryNb(h3.getVictoryNb()+1);
		r5.setRaceDate(LocalDate.of(2018, 2, 8));
		
		r6.getHorseList().add(h1);
		r6.getHorseList().add(h4);
		r6.getHorseList().add(h3);
		r6.getHorseList().add(h5);
		r6.getHorseList().add(h9);
		r6.getHorseList().add(h10);
		r6.setWinner(h9);
		h9.setVictoryNb(h9.getVictoryNb()+1);
		r6.setRaceDate(LocalDate.of(2020, 12, 19));
		
		r7.getHorseList().add(h1);
		r7.getHorseList().add(h2);
		r7.getHorseList().add(h9);
		r7.getHorseList().add(h7);
		r7.getHorseList().add(h3);
		r7.getHorseList().add(h6);
		r7.setWinner(h9);
		h9.setVictoryNb(h9.getVictoryNb()+1);
		r7.setRaceDate(LocalDate.of(2019, 4, 24));
		
		r8.getHorseList().add(h1);
		r8.getHorseList().add(h2);
		r8.getHorseList().add(h10);
		r8.getHorseList().add(h4);
		r8.getHorseList().add(h7);
		r8.getHorseList().add(h6);
		r8.setWinner(h3);
		h3.setVictoryNb(h3.getVictoryNb()+1);
		r8.setRaceDate(LocalDate.of(2020, 6, 12));
		
		r9.getHorseList().add(h10);
		r9.getHorseList().add(h2);
		r9.getHorseList().add(h3);
		r9.getHorseList().add(h9);
		r9.getHorseList().add(h7);
		r9.getHorseList().add(h6);
		r9.setWinner(h2);
		h2.setVictoryNb(h2.getVictoryNb()+1);
		r9.setRaceDate(LocalDate.of(2013, 11, 5));
		
		r10.getHorseList().add(h1);
		r10.getHorseList().add(h3);
		r10.getHorseList().add(h5);
		r10.getHorseList().add(h7);
		r10.getHorseList().add(h9);
		r10.getHorseList().add(h10);
		r10.setWinner(h7);
		h7.setVictoryNb(h7.getVictoryNb()+1);
		r10.setRaceDate(LocalDate.of(2022, 2, 14));
		System.out.println("Les donnees de demo ont ete generees");
	}
}
