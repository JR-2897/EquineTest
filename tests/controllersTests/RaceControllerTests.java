package controllersTests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import controllers.RaceController;
import models.Data;
import models.Horse;
import models.Race;

public class RaceControllerTests {

	Data data = Data.init();
	
	RaceController rCrt = new RaceController();
	
	@Test
	public void printAllRaceTestOk() {
		assertTrue(rCrt.printAllRaces().equals("OK"));
	}
	
	@Test
	public void createRaceTestOk() {
		String name = "Course du mardi";
		assertTrue(rCrt.createRace(name).equals("OK"));
	}
	
	@Test
	public void createRaceTestWithRaceNameAlReadyExist() {
		String name = "Course du mercredi";
		data.getAllRace().add(new Race(name));
		assertTrue(rCrt.createRace(name).equals("Le nom de la course existe déjà"));
	}
	
	@Test
	public void createRaceTestWithRaceNameEmpty() {
		String name = "";
		assertTrue(rCrt.createRace(name).equals("La création de la course n'a pas pu être faite"));
	}
	
	@Test
	public void createRaceTestWithRaceNameNull() {
		String name = null;
		assertTrue(rCrt.createRace(name).equals("La création de la course n'a pas pu être faite"));
	}
	
	@Test
	public void deleteRaceTestOk() {
		String raceName = "Course de Mars v1";
		String horseName = "Bobby";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		Race r = new Race(raceName);
		r.getHorseList().add(h);
		data.getAllRace().add(r);
		assertTrue(rCrt.deleteHorse(raceName, horseName).equals("OK"));
	}
	
	@Test
	public void deleteRaceTestWithRaceNotExist() {
		String raceName = "Course de Mars v2";
		String horseName = "Babby";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		Race r = new Race(raceName);
		r.getHorseList().add(h);
		assertTrue(rCrt.deleteHorse(raceName, horseName).equals("La course n'existe pas"));
	}
	
	@Test
	public void deleteRaceTestWithHorseNotExist() {
		String raceName = "Course de Mars v3";
		String horseName = "Bibby";
		Horse h = new Horse(horseName,7);
		Race r = new Race(raceName);
		r.getHorseList().add(h);
		data.getAllRace().add(r);
		assertTrue(rCrt.deleteHorse(raceName, horseName).equals("Le cheval n'existe pas"));
	}
	
	@Test
	public void deleteRaceTestWithHorseNotExistInRace() {
		String raceName = "Course de Mars v4";
		String horseName = "Bubby";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		Race r = new Race(raceName);
		data.getAllRace().add(r);
		assertTrue(rCrt.deleteHorse(raceName, horseName).equals("Le cheval n'existe pas dans cette course"));
	}
	
	@Test
	public void deleteRaceTestWithHorseNameNull() {
		String raceName = "Course de Mars v4";
		String horseName = null;
		assertTrue(rCrt.deleteHorse(raceName, horseName).equals("Le cheval n'existe pas"));
	}
	
	@Test
	public void deleteRaceTestWithHorseNameEmpty() {
		String raceName = "Course de Mars v4";
		String horseName = "";
		assertTrue(rCrt.deleteHorse(raceName, horseName).equals("Le cheval n'existe pas"));
	}
	
	@Test
	public void deleteRaceTestWithRaceNameNull() {
		String raceName = null;
		String horseName = "Tenor 1";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		assertTrue(rCrt.deleteHorse(raceName, horseName).equals("La course n'existe pas"));
	}
	
	@Test
	public void deleteRaceTestWithRaceNameEmpty() {
		String raceName = "";
		String horseName = "Tenor 2";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		assertTrue(rCrt.deleteHorse(raceName, horseName).equals("La course n'existe pas"));
	}
	
	
}
