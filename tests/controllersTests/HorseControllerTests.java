package controllersTests;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import controllers.HorseController;
import models.Data;
import models.Horse;

public class HorseControllerTests {
	
	HorseController hCtontroller = new HorseController();
	
	Data data = Data.init();
	
	@Test
	public void getAllHorsesOk() {
		assertNotNull(hCtontroller.getAllHorses());
	}
	
	@Test
	public void createHorseTestOk() {
		String name = "Toto";
		int age = 5;
		assertTrue(hCtontroller.createHorse(name, age).equals("ok"));
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
		String name = "Toto";
		int age = 0;
		assertTrue(hCtontroller.createHorse(name, age).equals("La création du cheval n'a pas pu être faite"));
	}

}
