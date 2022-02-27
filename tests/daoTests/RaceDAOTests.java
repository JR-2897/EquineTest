package daoTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import dao.RaceDAO;
import models.Data;
import models.Race;

public class RaceDAOTests {

	RaceDAO rDao= new RaceDAO();
	
	Data data = Data.init();
	
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
	
	@Test
	public void getAllRacesTestOk() {
		assertNotNull(rDao.getAllRaces());
	}
	
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
}
