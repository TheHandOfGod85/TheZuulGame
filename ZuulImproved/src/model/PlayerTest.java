package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void test() {
		Player player1 = new Player();
		Item drink = new Item("drink");
		player1.addtoInventory(drink);
		assertEquals(1, player1.getItemsNumbers());
	}

}
