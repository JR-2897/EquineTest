package controllersTests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import controllers.RaceController;
import models.Data;
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
		assertTrue(rCrt.createRace(name).equals("Le nom de la course existe d�j�"));
	}
	
	@Test
	public void createRaceTestWithRaceNameEmpty() {
		String name = "";
		assertTrue(rCrt.createRace(name).equals("La cr�ation de la course n'a pas pu �tre faite"));
	}
	
	@Test
	public void createRaceTestWithRaceNameNull() {
		String name = null;
		assertTrue(rCrt.createRace(name).equals("La cr�ation de la course n'a pas pu �tre faite"));
	}
	
}
