package daoTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import dao.HorseDAO;
import models.Data;
import models.Horse;
import models.Race;

public class HorseDAOTests {

	HorseDAO hDao = new HorseDAO();
	
	Data data = Data.init();
	
	// createHorse tests
	@Test
	public void createHorseTestOk() {
		assertNotNull(hDao.createHorse("Tonerre", 5));
	}
	
	@Test
	public void createHorseTestWithHorseNameNull() {
		assertNull(hDao.createHorse(null, 5));
	}
	
	@Test
	public void createHorseTestWithHorseNameEmpty() {
		assertNull(hDao.createHorse("", 5));
	}
	
	@Test
	public void createHorseTestWithZeroAge() {
		assertNull(hDao.createHorse("Tonerre", 0));
	}
	
	@Test
	public void createHorseTestWithNegativeAge() {
		assertNull(hDao.createHorse("Tonerre", -20));
	}
	
	// getAllHorses tests
	@Test
	public void getAllHorsesTestOk() {
		assertNotNull(hDao.getAllHorses());
	}
	
	// deleteHorse tests
	@Test
	public void deleteHorseTestOk() {
		Horse h = new Horse("Joker",5);
		data.getAllHorse().add(h);
		assertTrue(hDao.deleteHorse(h));
	}
	
	@Test
	public void deleteHorseTestWithHorseDontExist() {
		Horse h = new Horse("Joker",5);
		assertFalse(hDao.deleteHorse(h));
	}
	
	// increaseVictoryNb tests
	@Test
	public void increaseVictoryNbTestOk() {
		Horse h = new Horse("Joker",5);
		assertTrue(hDao.increaseVictoryNb(h));
	}
	
	@Test
	public void increaseVictoryNbTestWithHorseNull() {
		assertFalse(hDao.increaseVictoryNb(null));
	}
	
	
	// getHorseByName tests
	@Test
	public void getHorseByNameTestOk() {
		String name = "Junior";
		Horse horse = new Horse(name, 5);
		data.getAllHorse().add(horse);
		assertNotNull(hDao.getHorseByName(name));
	}
	
	@Test
	public void getHorseByNameTestWithHorseNameDontExist() {
		String name = "Junior";
		assertNull(hDao.getHorseByName(name));
	}
	
	@Test
	public void getHorseByNameTestWithHorseNameEmpty() {
		String name = "";
		assertNull(hDao.getHorseByName(name));
	}
	
	@Test
	public void getHorseByNameTestWithHorseNameNull() {
		assertNull(hDao.getHorseByName(null));
	}
	
	// horseExist tests
	@Test
	public void horseExistTestWithHorseExist() {
		String name = "Flash";
		Horse h = new Horse(name,6);
		data.getAllHorse().add(h);
		assertTrue(hDao.horseExist(name));
	}
	
	@Test
	public void horseExistTestWithHorseNotExist() {
		String name = "Flash";
		Horse h = new Horse("Gargouille",6);
		data.getAllHorse().add(h);
		assertFalse(hDao.horseExist(name));
	}
	
	@Test
	public void horseExistTestWithNameNull() {
		assertFalse(hDao.horseExist(null));
	}
	
	@Test
	public void horseExistTestWithNameEmpty() {
		String name = "";
		Horse h = new Horse("",6);
		data.getAllHorse().add(h);
		assertFalse(hDao.horseExist(name));
	}
	
	// horseExistInRace test
	
	@Test
	public void horseExistInRaceTestOk() {
		String horseName = "Pegase";
		Horse h = new Horse(horseName,9);
		Race r = new Race("Course olympique");
		r.getHorseList().add(h);
		data.getAllRace().add(r);
		assertTrue(hDao.horseExistInRace(horseName));
	}
	
	@Test
	public void horseExistInRaceTestWithHorseNotExistInRace() {
		String horseName = "Pegase 3";
		Horse h = new Horse("Pegase 2",9);
		Race r = new Race("Course olympique");
		r.getHorseList().add(h);
		data.getAllRace().add(r);
		assertFalse(hDao.horseExistInRace(horseName));
	}
	
	@Test
	public void horseExistInRaceTestWithHorseNameIsNull() {
		String horseName = null;
		Race r = new Race("Course olympique 2");
		data.getAllRace().add(r);
		assertFalse(hDao.horseExistInRace(horseName));
	}
	
	@Test
	public void horseExistInRaceTestWithHorseNameIsEmpty() {
		String horseName = "";
		Race r = new Race("Course olympique 3");
		data.getAllRace().add(r);
		assertFalse(hDao.horseExistInRace(horseName));
	}
}
