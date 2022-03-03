package daoTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import dao.RaceDAO;
import models.Data;
import models.Horse;
import models.Race;

public class RaceDAOTests {

	RaceDAO rDao= new RaceDAO();
	
	Data data = Data.init();
	
	// createRace tests
	@Test
	public void createRaceTestOk() {
		assertNotNull(rDao.createRace("Course du printemps"));
	}
	
	@Test
	public void createRaceTestWithRaceNameNull() {
		assertNull(rDao.createRace(null));
	}
	
	@Test
	public void createRaceTestWithRaceNameEmpty() {
		assertNull(rDao.createRace(""));
	}

	// getAllRaces tests
	@Test
	public void getAllRacesTestOk() {
		assertNotNull(rDao.getAllRaces());
	}
	
	// deleteRace tests
	@Test
	public void deleteRaceTestOk() {
		Race race = new Race("Course Semaine 1");
		data.getAllRace().add(race);
		assertTrue(rDao.deleteRace(race));
	}
	
	@Test
	public void deleteRaceTestWithRaceNull() {
		assertFalse(rDao.deleteRace(null));
	}
	
	@Test
	public void deleteRaceTestWithRaceDontExist() {
		Race race = new Race("Course Semaine 1");
		assertFalse(rDao.deleteRace(race));
	}
	
	// addHorseInRace tests
	@Test
	public void addHorseInRaceTestOk() {
		Horse h = new Horse("Tonnerre", 6);
		Race r = new Race("Course du mois");
		assertTrue(rDao.addHorseInRace(r, h));
	}
	
	@Test
	public void addHorseInRaceTestWithHorseNull() {
		Race r = new Race("Course du mois");
		assertFalse(rDao.addHorseInRace(r, null));
	}
	
	@Test
	public void addHorseInRaceTestWithRaceNull() {
		Horse h = new Horse("Tonnerre", 6);
		assertFalse(rDao.addHorseInRace(null, h));
	}
	
	// getAllHorsesFromRace tests
	@Test
	public void getAllHorsesFromRaceTestOk() {
		Horse h = new Horse("Tonnerre", 6);
		Race r = new Race("Course du mois");
		r.getHorseList().add(h);
		assertNotNull(rDao.getAllHorsesFromRace(r));
	}
	
	@Test
	public void getAllHorsesFromRaceTestWithRaceNull() {
		assertNull(rDao.getAllHorsesFromRace(null));
	}
	
	// getRaceByName tests
	@Test
	public void getRaceByNameTestOk() {
		String name = "Course du lundi";
		Race race = new Race(name);
		data.getAllRace().add(race);
		assertNotNull(rDao.getRaceByName(name));
	}
	
	@Test
	public void getRaceByNameTestWithRaceNameDontExist() {
		String name = "Course du lundi";
		assertNull(rDao.getRaceByName(name));
	}
	
	@Test
	public void getRaceByNameTestWithRaceNameEmpty() {
		String name = "";
		assertNull(rDao.getRaceByName(name));
	}
	
	@Test
	public void getRaceByNameTestWithRaceNameNull() {
		assertNull(rDao.getRaceByName(null));
	}
	
	// getHorseInRaceByHorseName tests
	@Test
	public void getHorseInRaceByHorseNameTestOk() {
		String name = "Jojo";
		Horse h = new Horse(name, 8);
		Race r = new Race("Course mensuelle");
		r.getHorseList().add(h);
		assertNotNull(rDao.getHorseInRaceByHorseName(r, name));
	}
	
	@Test
	public void getHorseInRaceByHorseNameTestWithHorseNameDontExist() {
		String name = "Jojo";
		Horse h = new Horse(name, 8);
		Race r = new Race("Course mensuelle");
		assertNull(rDao.getHorseInRaceByHorseName(r, name));
	}
	
	@Test
	public void getHorseInRaceByHorseNameTestWithHorseNameEmpty() {
		String name = "";
		Race r = new Race("Course mensuelle");
		assertNull(rDao.getHorseInRaceByHorseName(r, name));
	}
	
	@Test
	public void getHorseInRaceByHorseNameTestWithHorseNameNull() {
		Race r = new Race("Course mensuelle");
		assertNull(rDao.getHorseInRaceByHorseName(r, null));
	}
	
	@Test
	public void getHorseInRaceByHorseNameTestWithRaceNull() {
		String name = "Jojo";
		assertNull(rDao.getHorseInRaceByHorseName(null, name));
	}
	
	@Test
	public void raceNotExistTestWithRaceExist() {
		String name = "Course hebdo";
		Race r = new Race(name);
		data.getAllRace().add(r);
		assertTrue(rDao.raceExist(name));
	}
	
	@Test
	public void raceNotExistTestWithRaceNotExist() {
		String name = "Course 1";
		Race r = new Race("Course quotidienne");
		data.getAllRace().add(r);
		assertFalse(rDao.raceExist(name));
	}
	
	@Test
	public void horseNotExistTestWithNameNull() {
		assertFalse(rDao.raceExist(null));
	}
	
	@Test
	public void raceNotExistTestWithNameEmpty() {
		String name = "";
		Race r = new Race("");
		data.getAllRace().add(r);
		assertFalse(rDao.raceExist(name));
	}
}
