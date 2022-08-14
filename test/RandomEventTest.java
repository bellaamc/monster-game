package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import projectOne.GameEnvironment;
import projectOne.Monster;
import projectOne.RandomEvent;

/**
 * 
 * RandomEventTest tests random event
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class RandomEventTest {

	/**
	 * RandomEventTest constructs tests for random events
	 */
	public RandomEventTest() {
	}
	
	GameEnvironment newGame = new GameEnvironment();
	RandomEvent newRandom = new RandomEvent();
	
	/**
	 * testGenerateRandomEmptyMonsterList tests when an empty list is passed in
	 */
	@Test
	public void testGenerateRandomEmptyMonsterList(){
		List<Monster> monsterList = newGame.getMonsterList();
		monsterList.clear();
		String message = newRandom.generateRandom(newGame);
		assertEquals("",message);
	}
	
	/**
	 * testGenerateRandomIntTwoEmptyInventory tests when an empty inventory is passed in and random int is 2
	 */
	@Test
	public void testGenerateRandomIntTwoEmptyInventory() {
		newRandom.setIntRandom(2);
		String message = newRandom.generateRandom(newGame);
		assertEquals("",message);
	}
	
}
