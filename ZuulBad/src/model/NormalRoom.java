/**
 * 
 */
package model;

/**
 * @author Daniele
 *
 */
public class NormalRoom extends Room {
	
	public NormalRoom(String description) {
		super(description);
	}

	@Override
	public Room getExit(String direction) {
		
		return null;
	}

}
