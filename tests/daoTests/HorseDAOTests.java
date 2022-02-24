package daoTests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import dao.HorseDAO;

public class HorseDAOTests {

	HorseDAO hDao = new HorseDAO();
	
	@Test
	public void CreateHorseTestOk() {
		assertNotNull(hDao.CreateHorse("Tonerre", 5));
	}
	
	@Test
	public void CreateHorseTestWithHorseNameNull() {
		assertNull(hDao.CreateHorse(null, 5));
	}
	
	@Test
	public void CreateHorseTestWithHorseNameEmpty() {
		assertNull(hDao.CreateHorse("", 5));
	}
	
	@Test
	public void CreateHorseTestWithZeroAge() {
		assertNull(hDao.CreateHorse("Tonerre", 0));
	}
	
	@Test
	public void CreateHorseTestWithNegativeAge() {
		assertNull(hDao.CreateHorse("Tonerre", -20));
	}
	
	
}
