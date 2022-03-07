import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import models.Data;
import models.Horse;

public class DataTest {

	Data data = Data.init();
	
	@Test
	public void generateDataForDemoTestOk() {
		data.generateDataForDemo();
		assertTrue(data.getAllHorse().size() != 0 && data.getAllRace().size() != 0);
	}
	
	@Test
	public void resetDataOk() {
		data.getAllHorse().add(new Horse("toto",8));
		data.resetData();
		assertTrue(data.getAllHorse().size() == 0 && data.getAllRace().size() == 0);
	}
}
