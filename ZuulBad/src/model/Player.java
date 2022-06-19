package model;

public class Player {
	private int score;
	private int health;
	private Room currentRoom;
	
	public Player() {
		score = 0;
		health = 10;
	}

	public Room getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
		health--;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getStatus() {
		return "Score is " + score + " Health is " + health;
	}

	public void eat() {
		Edible e = currentRoom.getEdible();
		if (e.isHealthy()) {
			this.health = this.health + 4;
		} else {
			this.health = this.health - 10;
		}
		this.currentRoom.removeEdible();
		
	}

	
}
