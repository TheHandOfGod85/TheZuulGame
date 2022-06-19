package model;

import java.util.Random;

public class Edible {
	public static final double P_CREATE = 0.6;
	public static final double P_HEALTHY = 0.5;

	private boolean isHealthy;
	private static final Random rnd = new Random();

	private Edible() {
		isHealthy = (rnd.nextDouble() <= P_HEALTHY);
	}
	
	public static Edible buildEdible() {
		if(rnd.nextDouble() <= P_CREATE) {
			return new Edible();
		}else {
			return null;
		}
	}

	/**
	 * @return the isHealthy
	 */
	public boolean isHealthy() {
		return isHealthy;
	}

	public int effectOnHealth() {
		// generate the random number between 0-4
		int value = rnd.nextInt(5);
		if (isHealthy()) {
			return value;
		} else {
			return value * - 1;
		}

	}

}
