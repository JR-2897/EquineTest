package utilTests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import utils.Util;

public class UtilTest {

	@Test
	public void randomIntTestWithPositiveValues() {
		int min = 3;
		int max = 8;
		for(int i = 0; i<50;i++) {
			int randomValue = Util.randomInt(min, max);
			assertTrue(randomValue >= min && randomValue<= max);
		}
	}
	
	@Test 
	public void randomIntTestWithNegativeValues() {
		int min = -9;
		int max = -4;
		for(int i = 0; i<50;i++) {
			int randomValue = Util.randomInt(min, max);
			assertTrue(randomValue >= min && randomValue<= max);
		}
	}
	
	@Test 
	public void randomIntTestWithOneNegativeValueAndPositiveValue() {
		int min = -9;
		int max = 8;
		for(int i = 0; i<50;i++) {
			int randomValue = Util.randomInt(min, max);
			assertTrue(randomValue >= min && randomValue<= max);
		}
	}
}
