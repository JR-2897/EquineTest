package daoTests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import dao.HorseDAO;
import models.Data;
import models.Horse;

public class HorseDAOTests {

	HorseDAO hDao = new HorseDAO();
	
	Data data = Data.init();
	
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
	
	@Test
	public void GetAllHorsesTestOk() {
		assertNotNull(hDao.getAllHorses());
	}
	
	@Test
	public void DeleteHorseTestOk() {
		Horse h = new Horse("Joker",5);
		data.getAllHorse().add(h);
		assertTrue(hDao.deleteHorse(h));
	}
	
	@Test
	public void DeleteHorseTestWithHorseDontExist() {
		Horse h = new Horse("Joker",5);
		assertFalse(hDao.deleteHorse(h));
	}
	
}
