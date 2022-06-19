package model;

import java.util.Random;

public class Edible {
	private final double PROBABLILITY_IS_POISON = 0.5;
	private boolean isHealthy;
	
	public Edible() {
		Random gen  = new Random();
		double pPoison = gen.nextDouble();
		isHealthy = (pPoison <= this.PROBABLILITY_IS_POISON);
	}
	
	
	public boolean isHealthy() {
		return isHealthy;
	}


	@Override
	public String toString() {
		String text = "An edible that is ";
		if (this.isHealthy) {
			text = text + "healthy to eat";
		} else {
			text = text + "poisonous";
		}
		return text;
	}
	
	

	
}
