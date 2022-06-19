package model;

import java.util.ArrayList;
import java.util.Random;

public class RoomSet {
	private ArrayList<Room> rooms;
	private Random gen;
	
	public RoomSet() {
		rooms = new ArrayList<Room>();
		gen = new Random();
	}

	public void addroom(Room room) {
		rooms.add(room);
	}
	
	public Room findRandomRoom() {
		int index = gen.nextInt(rooms.size());
		return rooms;
	}
	
}
