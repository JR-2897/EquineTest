package daoTests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import dao.RaceDAO;

public class RaceDAOTests {

	RaceDAO rDao= new RaceDAO();
	
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
}
