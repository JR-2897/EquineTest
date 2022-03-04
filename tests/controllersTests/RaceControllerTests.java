package controllersTests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import controllers.RaceController;
import models.Data;

public class RaceControllerTests {

	Data data = Data.init();
	
	RaceController rCrt = new RaceController();
	
	@Test
	public void printAllRaceTestOk() {
		assertTrue(rCrt.printAllRaces().equals("ok"));
	}
}
