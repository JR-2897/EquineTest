package controllersTests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import controllers.HorseController;
import models.Data;

public class HorseControllerTests {
	
	HorseController hCtontroller = new HorseController();
	
	Data data = Data.init();
	
	@Test
	public void getAllHorsesOk() {
		assertTrue(hCtontroller.getAllHorses() == "OK");
	}

}
