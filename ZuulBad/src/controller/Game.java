package controller;

import model.Command;
import model.Player;
import model.Room;
import util.Parser;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    //private Room currentRoom;
    private Player player;
    
    
    
    /**
     * The main method: this is what happens first when the program is run.
     * This just creates a new Game object, then plays the game.
     */
    public static void main(String[] args) {
    	Game theGame = new Game();
    	theGame.play();
    }
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
    	player = new Player();
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, cellar, tree, transporter;
      
        // create the rooms
        outside = new NormalRoom("outside the main entrance of the university");
        theater = new NormalRoom("in a lecture theater");
        pub = new NormalRoom("in the campus pub");
        lab = new NormalRoom("in a computing lab");
        office = new NormalRoom("in the computing admin office");
        cellar = new NormalRoom("in a dark musty cellar with lots of beer");
        tree = new NormalRoom("in a huge old oak tree");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        outside.setExit("up", tree);
        
        tree.setExit("down", outside);
        
        theater.setExit("west", outside);
        
        pub.setExit("east", outside);
        pub.setExit("down", cellar);
        
        cellar.setExit("up", pub);
        
        lab.setExit("north", outside);
        lab.setExit("east", office);
        
        office.setExit("west", lab);

        player.setCurrentRoom(outside); // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
            System.out.println(player.getStatus());
            finished = (player.getHealth() <= 0);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + player.getCurrentRoom().getDescription());
        System.out.print("Exits: ");
        System.out.println("You can go " + player.getCurrentRoom().getExitDescription());
        System.out.println();
    }
    

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("look")) {
        	System.out.println(player.getCurrentRoom().getLongDescription());
        } else if (commandWord.equals("eat")) {
        	player.eat();
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.getListOfCommands());
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = null;
        // move in that direction
        nextRoom = player.getCurrentRoom().getExit(direction);
        

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            player.setCurrentRoom(nextRoom);
            System.out.println("You are " + player.getCurrentRoom().getDescription());
            System.out.print("Exits: ");
            System.out.println("You can go " + player.getCurrentRoom().getExitDescription());
            System.out.println();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
