package projectOne;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * Battle creates a battle between monsters and enemies
 *
 */
public class Battle {
	
	/**
	 * 
	 * @param enemies the list of monsters on the opposing team
	 * @param goldWon the amount of gold won from winning a battle 
	 * @param pointsAwarded the number of points awarded from winning a battle 
	 * @param damageDoneFighter the damage an individual monster on my team does in a battle 
	 * @param damageDoneEnemy the damage an individual monster on the enemy team does in a battle 
	 * @param battleDay the day the battle occurs on 
	 * @param fightingTeam list of fighters on player's side 
	 * @param currentEnemy the current monster fighting on the enemy side
	 * @param currentFighter the current monster fighting on the player's side 
	 */
	
	private Monster currentEnemy;
	private Monster currentFighter; 
	private GameEnvironment newGame;

	/**
	 * creates a battle using a constructor
	 * @param newGame continues the same game throughout the classes
	 */
	public Battle(GameEnvironment newGame) {
		this.newGame = newGame;
	}
	
	/**
	 * gets the outcome of a battle
	 * @return string with the outcome
	 */
	public String getOutcome() {
		if (currentEnemy.getCurrentHealth() == 0) {
			// Need to increase their gold when they win but not sure how you did gold hehe so will talk to u when i see u 
			return "You won!"; 
		}
		
		else if (newGame.getMonsterInventory().size() == 0) {
			return "You lost"; 
		}
		
		else {
			return "Keep fighting"; 
		}
	}
	
	

	/**
	 * calculates the winner of a battle
	 * @param currentFighter sets the fighting monster in the battle
	 * @param currentEnemy sets the enemy being fought in battle
	 */
	public void roundWinner(Monster currentFighter, Monster currentEnemy) {
		int damagePlayer = (int) ((currentFighter.getDamage() + currentFighter.getSpeed()) * 0.5);
		int damageEnemy = (int) ((currentEnemy.getDamage() + currentEnemy.getSpeed()) * 0.5); 
		double fighterNumHits = currentEnemy.getMaxHealth() / damagePlayer;
		double enemyNumHits = currentFighter.getMaxHealth() / damageEnemy;
		if (enemyNumHits >= fighterNumHits) {
			int playerDamage = (int) (Math.ceil(fighterNumHits) * Math.floor(damageEnemy));
			int newHealth = currentFighter.getCurrentHealth() - playerDamage;
			currentFighter.setCurrentHealth(newHealth);
			currentEnemy.setCurrentHealth(0);
		}else {
			int enemyDamage = (int) (Math.ceil(enemyNumHits) * Math.floor(damagePlayer));
			int newHealth = currentEnemy.getCurrentHealth() - enemyDamage;
			currentEnemy.setCurrentHealth(newHealth);
			newGame.getMonsterInventory().remove(currentFighter);
			if (newGame.getMonsterInventory().size() > 0) {
				currentFighter = newGame.getMonsterInventory().get(0); 
				roundWinner(currentFighter, currentEnemy); 
			}
		}
				
	}
	
	/**
	 * chooseEnemy chooses an enemy from the enemy list
	 * @param enemyChoice sets the enemy choice
	 */
	public void chooseEnemy(Monster enemyChoice) {
		if (newGame.getEnemies().size() > 0) {
			currentEnemy = enemyChoice;
			newGame.getEnemies().remove(currentEnemy);
			
		} else {
			currentEnemy = null; 
		}
		
		
	}
	
	/**
	 * getter for the current fighter
	 * @return the monster fighting
	 */
	public Monster getCurrentFighter() { 
		return currentFighter;
	}
	
	/**
	 * setter for the current fighter
	 */
	public void setCurrentFighter() {
		currentFighter = newGame.getMonsterInventory().get(0); 
	}
	
	/**
	 * getter for the current enemy fighting
	 * @return the enemy being fought
	 */
	public Monster getCurrentEnemy() {
		return currentEnemy;
	}
	
	/**
	 * setter for the current enemy
	 * @param newMonster the enemy to be fought
	 */
	public void setCurrentEnemy(Monster newMonster) {
		currentEnemy = newMonster; 
		
	}
}
