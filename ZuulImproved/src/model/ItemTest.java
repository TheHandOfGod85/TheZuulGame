package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void test() {
		Item drink = new Item("drink");
		assertEquals("drink", drink.getItemName());
		}

}
