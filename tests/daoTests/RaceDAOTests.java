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
}
