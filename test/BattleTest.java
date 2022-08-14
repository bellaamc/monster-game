package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import projectOne.Battle;
import projectOne.GameEnvironment;
import projectOne.Monster;


/**
 * 
 * BattleTest tests battle class
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class BattleTest {
	
	/**
	 * BattleTest constructor creates BattleTest
	 */
	public BattleTest() {
	}
	
	/**
	 * newGame new game environment
	 */
	GameEnvironment newGame = new GameEnvironment();
	/**
	 * newBattle new battle to fight
	 * 
	 */
	Battle newBattle;
	
	/**
	 * init creates a new battle for every test
	 */
	 @BeforeEach
	    public void init() {
	        newBattle = new Battle(newGame);
	    }
	
	 /**
	  * testGetOutcomeWin tests the string output when a battle is won
	  */
	@Test
	public void testGetOutcomeWin() {
		newBattle.setCurrentEnemy(newGame.getVampire());
		Monster currentEnemy = newBattle.getCurrentEnemy();
		currentEnemy.setCurrentHealth(0);
		String message = newBattle.getOutcome();
		assertEquals("You won!",message);
	}

	/**
	 * testGetOutcomeLoss tests the string output when a battle is lost
	 */
	@Test 
	public void testGetOutcomeLoss() {
		newGame.getMonsterInventory().clear();
		newBattle.setCurrentEnemy(newGame.getVampire());
		newBattle.getCurrentEnemy().setCurrentHealth(50);
		newBattle.getOutcome();
		String message = newBattle.getOutcome();
		assertEquals("You lost",message);
	}
	
	/**
	 * testGetOutcomeKeepFighting tests the string output when a battle is tied
	 */
	@Test
	public void testGetOutcomeKeepFighting() {
		newBattle.setCurrentEnemy(newGame.getElf());
		newGame.buyMonster(newGame.getVampire());
		newGame.buyMonster(newGame.getBanshee());
		newBattle.setCurrentFighter();
		String message = newBattle.getOutcome();
		assertEquals("Keep fighting",message);
	}
	
	/**
	 * testRoundWinnerSameMonsterFight when two of the same monsters fight
	 */
	@Test
	public void testRoundWinnerSameMonsterFight() {
		Monster vampire = newGame.getVampire();
		newBattle.setCurrentEnemy(vampire);
		newGame.buyMonster(vampire);
		newBattle.setCurrentFighter();
		newBattle.roundWinner(newBattle.getCurrentFighter(),newBattle.getCurrentEnemy());
		assertEquals(0,newBattle.getCurrentEnemy().getCurrentHealth());
		int fighterHealth = newBattle.getCurrentFighter().getCurrentHealth();
		assertEquals(true,fighterHealth<newBattle.getCurrentFighter().getMaxHealth());
	}
	
	/**
	 * testRoundWinnerStrongFighter tests a strong fighter
	 */
	@Test
	public void testRoundWinnerStrongFighter() {
		newGame.earnGold(100);
		Monster elf = newGame.getElf();
		newBattle.setCurrentEnemy(newGame.getBanshee());
		newGame.buyMonster(elf);
		newBattle.setCurrentFighter();
		newBattle.roundWinner(newBattle.getCurrentFighter(),newBattle.getCurrentEnemy());
		assertEquals(0,newBattle.getCurrentEnemy().getCurrentHealth());
		int fighterHealth = newBattle.getCurrentFighter().getCurrentHealth();
		boolean correctHealth = false;
		if (fighterHealth < elf.getMaxHealth()) {
			correctHealth = true;
		}
		assertEquals(true,correctHealth);
	}
	
	/**
	 * testRoundWinnerStrongEnemy tests a strong opponent
	 */
	@Test
	public void testRoundWinnerStrongEnemy() {
		newBattle.setCurrentEnemy(newGame.getElf());
		newGame.buyMonster(newGame.getBanshee());
		newBattle.setCurrentFighter();
		newBattle.roundWinner(newBattle.getCurrentFighter(),newBattle.getCurrentEnemy());
		assertEquals(false,newGame.getMonsterInventory().contains(newBattle.getCurrentFighter()));
		int enemyHealth = newBattle.getCurrentEnemy().getCurrentHealth();
		assertEquals(true,enemyHealth<newBattle.getCurrentEnemy().getMaxHealth());
	}
	
	/**
	 * testRoundWinnerMultipleFighters tests when there are multiple fighters
	 */
	@Test
	public void testRoundWinnerMultipleFighters() {
		newGame.earnGold(200);
		newGame.buyMonster(newGame.getVampire());
		newGame.buyMonster(newGame.getBanshee());
		newBattle.setCurrentEnemy(newGame.getVampire());
		newBattle.setCurrentFighter();
		newBattle.roundWinner(newBattle.getCurrentFighter(),newBattle.getCurrentEnemy());
		int fighterHealth = newBattle.getCurrentFighter().getCurrentHealth();
		assertEquals(true,fighterHealth<newBattle.getCurrentFighter().getMaxHealth());
		assertEquals(0,newBattle.getCurrentEnemy().getCurrentHealth());
	}
	
	/**
	 * testChooseEnemyEmptyEnemies tests when there are no enemies
	 */
	@Test
	public void testChooseEnemyEmptyEnemies() {
		List<Monster> enemies = newGame.getEnemies();
		enemies.clear();
		newBattle.chooseEnemy(newGame.getVampire());
		assertEquals(null,newBattle.getCurrentEnemy());
	}
	
	/**
	 * testBattleSuccessEasy tests the easy difficulty reward for a successful battle
	 */
	@Test
	public void testBattleSuccessEasy() {
		int initialGold = newGame.getGold();
		int initialPoints = newGame.getPoints();
		newGame.battleSuccess();
		assertEquals(initialGold+40,newGame.getGold());
		assertEquals(initialPoints+10,newGame.getPoints());
	}
	
	/**
	 * testBattleSuccessHard tests the hard difficulty reward for a successful battle
	 */
	@Test
	public void testBattleSuccessHard() {
		newGame.increaseDifficulty();
		int initialGold = newGame.getGold();
		int initialPoints = newGame.getPoints();
		newGame.battleSuccess();
		assertEquals(initialGold+60,newGame.getGold());
		assertEquals(initialPoints+20,newGame.getPoints());
	}

}
