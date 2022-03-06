package controllersTests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.HorseController;
import models.Data;
import models.Horse;
import models.Race;

public class HorseControllerTests {
	
	HorseController hCtontroller = new HorseController();
	
	Data data = Data.init();
	
	@BeforeEach
	public void initData() {
		data.resetData();
	}
	
	// getAllHorses tests
	@Test
	public void getAllHorsesOk() {
		assertTrue(hCtontroller.getAllHorses() == "OK");
	}
	
	// createHorse tests
	@Test
	public void createHorseTestOk() {
		String name = "Toto";
		int age = 5;
		assertTrue(hCtontroller.createHorse(name, age).equals("OK"));
	}
	
	@Test
	public void createHorseTestWithNameNull() {
		String name = null;
		int age = 5;
		assertTrue(hCtontroller.createHorse(name, age).equals("La création du cheval n'a pas pu être faite"));
	}
	
	@Test
	public void createHorseTestWithNameEmpty() {
		String name = "";
		int age = 5;
		assertTrue(hCtontroller.createHorse(name, age).equals("La création du cheval n'a pas pu être faite"));
	}
	
	@Test
	public void createHorseTestWithHorseNameExist() {
		String name = "Toto";
		int age = 5;
		data.getAllHorse().add(new Horse(name, age));
		assertTrue(hCtontroller.createHorse(name, age).equals("Le nom du cheval existe déjà"));
	}
	
	@Test
	public void createHorseTestWithAgeHasZero() {
		String name = "Toto2";
		int age = 0;
		assertTrue(hCtontroller.createHorse(name, age).equals("La création du cheval n'a pas pu être faite"));
	}

	// showInfoHorse tests
	@Test
	public void showInfoHorseOK() {
		String name = "Toto3";
		int age = 7;
		hCtontroller.createHorse(name, age);
		assertTrue(hCtontroller.showInfoHorse(name).equals("OK"));
	}
	
	@Test
	public void showInfoHorseKO() {
		String name = "Toto4";
		assertTrue(hCtontroller.showInfoHorse(name).equals("Ce cheval n'existe pas"));
	}
	
	// deleteHorse tests
	@Test 
	public void deleteHorseTestOk() {
		String horseName = "Babby";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		assertTrue(hCtontroller.deleteHorse(horseName).equals("OK"));
	}
	
	@Test 
	public void deleteHorseTestHorseNotExist() {
		String horseName = "Babby";
		Horse h = new Horse("Pegasus",7);
		data.getAllHorse().add(h);
		assertTrue(hCtontroller.deleteHorse(horseName).equals("Ce cheval n'existe pas"));
	}
	
	@Test 
	public void deleteHorseTestHorseExistInRace() {
		String horseName = "Babby";
		Horse h = new Horse(horseName,7);
		data.getAllHorse().add(h);
		Race r = new Race("Course lunaire");
		r.getHorseList().add(h);
		data.getAllRace().add(r);
		assertTrue(hCtontroller.deleteHorse(horseName).equals("Ce cheval existe dans une course, donc il ne peut pas être supprimé"));
	}
	
	@Test 
	public void deleteHorseTestHorseNameIsNull() {
		String horseName = null;
		assertTrue(hCtontroller.deleteHorse(horseName).equals("Ce cheval n'existe pas"));
	}
	
	@Test 
	public void deleteHorseTestHorseNameIsEmpty() {
		String horseName = "";
		assertTrue(hCtontroller.deleteHorse(horseName).equals("Ce cheval n'existe pas"));
	}
}
