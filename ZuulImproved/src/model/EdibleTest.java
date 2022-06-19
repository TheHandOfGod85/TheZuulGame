package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EdibleTest {

	@Test
	void testHealth() {
		Edible edible = Edible.buildEdible();
		if(edible != null) {
		assertTrue(edible.effectOnHealth() >= -4 && edible.effectOnHealth() <= 4);
		if (edible.isHealthy()) {
			assertTrue(edible.effectOnHealth() >= 0 && edible.effectOnHealth() <= 4);
		} else {
			assertTrue(edible.effectOnHealth() >= -4 && edible.effectOnHealth() <= 0);
		}

	}

}
}