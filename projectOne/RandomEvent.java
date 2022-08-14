package projectOne; 

import java.util.Collections;
import java.util.Random;

/**
 * 
 * RandomEvent generates a random event that occurs overnight after a battle 
 * @author Amber Waymouth and Arabella Cryer
 *
 *
 */
public class RandomEvent {
	/**
	 * @param random initialises a random integer 
	 * @param upperbound is the maximum value of the random variable 
	 * @param maxMonsterNumber is the maximum value of the the random number generated to get the monster to be added 
	 * 
	 */
	private int upperbound = 9; 
	private int maxMonsterNumber = 5; 
	private Random random = new Random(); 
	private int intRandom; 
	
	/**
	 * constructor which creates a random integer 
	 */
	public RandomEvent() {
		intRandom = random.nextInt(upperbound);
		
	}
	
	/**
	 * generateRandom generates a random event
	 * @param gameEnvironment keeps the same gameEnvironment throughout the codes
	 * @return String describing the random event that occurred 
	 */
	public String generateRandom(GameEnvironment gameEnvironment) {
		if (gameEnvironment.getMonsterList().size() > 0) { 
			if (intRandom == 7 && gameEnvironment.getMonsterInventory().size() < 4) {
				int newRandom = random.nextInt(maxMonsterNumber);
				gameEnvironment.addMonsterInventory(gameEnvironment.getMonsterList().get(newRandom));
				return "You have a new " + gameEnvironment.getMonsterList().get(newRandom).getItemName();
			}
			else if (intRandom == 2) {
				if (gameEnvironment.getMonsterInventory().size() > 1) {
					gameEnvironment.removeMonsterInventory(gameEnvironment.getMonsterInventory().get(0)); 
					return "You have lost a " + gameEnvironment.getMonsterInventory().get(0).getItemName() ;

				}
				else { 
					return ""; 
					
				}
				
			}
			
			else if (intRandom == 5) {
				Collections.shuffle(gameEnvironment.getMonsterInventory());
				Monster levelUpMonster = gameEnvironment.getMonsterInventory().get(0); 
				levelUpMonster.setLevel(1); 
				return levelUpMonster.getItemName() + " has leveled up!"; 
				
			}
			
		}
		
		
		return ""; 
	}
	
	/** 
	 * getter for the random integer 
	 * @return the value of the random integer
	 */
	public int getIntRandom() {
		return intRandom; 
		
	}
	
	/**
	 * sets the random integer to a certain value
	 * @param number sets the random integer
	 */
	public void setIntRandom(int number) {
		intRandom = number; 
	}
	
	
}




