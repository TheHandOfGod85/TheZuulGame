package model;

import java.util.HashMap;
import java.util.Random;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */
public abstract class Room 
{
    protected String description;
    // create a collection of exits with each exit associated with a direction.
    // for example down -> cellar
    
    protected HashMap<String, Room> exitMap;
    
    protected Edible edible;
    private final double PROBABLILITY_HAVING_EDIBLE = 0.6;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public  Room(String description) 
    {
        this.description = description;
        exitMap = new HashMap<String, Room>();
        Random gen = new Random();
        if (gen.nextDouble() <= this.PROBABLILITY_HAVING_EDIBLE) {
        	this.edible = new Edible();
        }
    }

    /**
     * Define an exit from this room.  Every direction leads
     * to another room.
     * @param direction The direction in which the exit lies.
     * @param room The room in the given direction.
     */
    public void setExit(String direction, Room room) 
    {
    	exitMap.put(direction, room);
    }
    
    /**
     * Get the exit in a given direction
     * @param direction where we want to go
     * @return the room in that direction or null if there is no exit in that direction
     */
    public abstract Room getExit(String direction) ;
    
    /**
     * Get a description of all the directions we can go from here.
     * @return a text direction of all the directions we can go.
     */
    public String getExitDescription() {
    	String exitText = "";
    	for (String exitDirection : exitMap.keySet()) {
    		exitText = exitText + exitDirection + " ";
    	}
        return exitText;
    }


    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getEdibleStatus() {
		String text = "";
		if (this.edible == null) {
			text = "There is nothing edible here";
		} else {
			text = edible.toString();
		}
		return text;
	}

	public String getLongDescription() {
		String text = getDescription();
		text = text + "\n";
		text = text + this.getExitDescription();
		text = text + "\n";
		text = text + this.getEdibleStatus();
		return text;
	}

	public Edible getEdible() {
		return this.edible;
		
	}

	public void removeEdible() {
		this.edible = null;
	}
	

	

}
