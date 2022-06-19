package model;

import java.util.ArrayList;

public class Player {
	private int score;
	private int health;
	private Room currentLocation;
	private ArrayList<Item> inventory;

	public Player() {
		score = 0;
		health = 10;
		currentLocation = null;
		inventory = new ArrayList<Item>();
	}

	/**
	 * adding items to the inventory
	 * 
	 * @param newItem
	 */
	public void addtoInventory(Item newItem) {
		inventory.add(newItem);
	}

	/**
	 * print the items in the inventory
	 */
	public void printInventory() {
		if (inventory.isEmpty()) {
			System.out.println("There are no items in the inventory!");
		}
			for (Item items : inventory) {
				System.out.println("You have these items in the inventory:\n" + items.toString());
			}
	}

	/**
	 * return how many items in the inventory
	 * 
	 * @return
	 */
	public int getItemsNumbers() {
		int num = inventory.size();
		return num;
	}

	/**
	 * @return the currentLocation
	 */
	public Room getCurrentLocation() {
		return currentLocation;
	}

	public void eat() {
		// if there is food in the current room
		Edible food = this.currentLocation.getFood();
		if (food != null) {
			// get the food`s effect on health
			int dh = food.effectOnHealth();
			health = health + dh;
			this.currentLocation.eatFood();
		}
	}

	/**
	 * @param currentLocation the currentLocation to set
	 */
	public void setCurrentLocation(Room currentLocation) {
		this.currentLocation = currentLocation;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	public void move() {
		score = score + 1;
		health = health - 2;
	}

	public String toString() {
		String description = "";
		description = description + "Score is " + score + "\n";
		description = description + "Health is " + health + "\n";
		return description;
	}

	public boolean isAlive() {
		return health > 0;
	}

}
