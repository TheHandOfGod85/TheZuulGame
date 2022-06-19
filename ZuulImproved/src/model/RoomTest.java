package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
	void test() {
		Room office = new Room("ufficio");
		Room pub = new Room("il pub");
		Item printer = new Item("printer");
		Item drink = new Item("drink");
		office.setItem(printer);
		assertEquals(printer, office.getItem());
		pub.setItem(drink);
		assertEquals(drink, pub.getItem());
		assertEquals("drink", drink.getItemName());
		assertEquals("printer", printer.getItemName());
		}

}
