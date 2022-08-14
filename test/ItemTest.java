package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import projectOne.GameEnvironment;
import projectOne.Item;

/**
 * 
 * ItemTest tests the item class
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class ItemTest {

	/**
	 * ItemTest constructs an item test
	 */
	public ItemTest() {
	}
	
	GameEnvironment newGame = new GameEnvironment();
	
	/**
	 * propertyAdjustmentHealth tests how properties adjust with health potion
	 */
	@Test
	public void propertyAdjustmentHealth() {
		Item healthPotion = newGame.getHealthPotion();
		String message = healthPotion.propertyAdjustment();
		assertEquals("Health Boost: 10", message);
	}
	
	/**
	 * propertyAdjustmentHealth tests how properties adjust with food
	 */
	@Test
	public void propertyAdjustmentFood() {
		Item bread = newGame.getBread();
		String message = bread.propertyAdjustment();
		assertEquals("Health Boost: 10", message);
	}
	
	/**
	 * propertyAdjustmentHealth tests how properties adjust with weapons
	 */
	@Test
	public void propertyAdjustmentWeapon() {
		Item sword = newGame.getSword();
		String message = sword.propertyAdjustment();
		assertEquals("Damage Boost: 10", message);
	}
	
	/**
	 * propertyAdjustmentHealth tests how properties adjust with speed potion
	 */
	@Test
	public void propertyAdjustmentSpeed() {
		Item speedPotion = newGame.getSpeedPotion();
		String message = speedPotion.propertyAdjustment();
		assertEquals("Speed Boost: 10", message);
	}
	
	/**
	 * propertyAdjustmentHealth tests how properties adjust with nothing
	 */
	@Test
	public void propertyAdjustmentNothing() {
		Item otherItem = new Item(10,"item",10,"nothing");
		String message = otherItem.propertyAdjustment();
		assertEquals("", message);
	}
	
	/**
	 * testGetDescriptionFood tests get description of food
	 */
	@Test
	public void testGetDescriptionFood() {
		Item bread = newGame.getBread();
		String message = bread.getDescription();
		assertEquals("Bread\nPrice: 20g\nThis item increases health by 10",message);
	}
	
	/**
	 * testGetDescriptionHealth tests get description of health potion
	 */
	@Test
	public void testGetDescriptionHealth() {
		Item health = newGame.getHealthPotion();
		String message = health.getDescription();
		assertEquals("Health Potion\nPrice: 20g\nThis item increases health by 10",message);
	}
	
	/**
	 * testGetDescriptionFood tests get description of weapon
	 */
	@Test
	public void testGetDescriptionWeapon() {
		Item sword = newGame.getSword();
		String message = sword.getDescription();
		assertEquals("Sword\nPrice: 50g\nThis item increases damage by 10",message);
	}
	
	/**
	 * testGetDescriptionFood tests get description of speed potion
	 */
	@Test
	public void testGetDescriptionSpeed() {
		Item speedPotion = newGame.getSpeedPotion();
		String message = speedPotion.getDescription();
		assertEquals("Speed Potion\nPrice: 20g\nThis item increases speed by 10",message);
	}
	
}
