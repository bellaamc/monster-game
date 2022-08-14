package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import projectOne.GameEnvironment;
import projectOne.Item;
import projectOne.Monster;

/**
 * 
 * GameEnvironmentTest tests the game environment
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class GameEnvironmentTest {

	/**
	 * GameEnvironmentTest constructs a game environment test
	 */
	public GameEnvironmentTest() {
	}
	
	GameEnvironment newGame = new GameEnvironment();
	
	/**
	 * setCharacterNameShort tests name that is too short
	 */
	@Test
	public void setCharacterNameShort() {
		String characterString = newGame.setCharacterName("aa");
		assertEquals("Your name is too short.\nTry a longer name.",characterString);
	}
	
	/**
	 * setCharacterNameLong tests a name that is too long
	 */
	@Test
	public void setCharacterNameLong() {
		String characterString = newGame.setCharacterName("fdlancknsgrenfdcner");
		assertEquals("Your name is too long.\nTry a shorter name.",characterString);
	}

	/**
	 * setCharacterNameSpecial tests a name with special characters
	 */
	@Test
	public void setCharacterNameSpecial() {
		String characterString = newGame.setCharacterName("hi*");
		assertEquals("Your name cannot contain special characters.",characterString);
	}
	
	/**
	 * setCharacterNameNormal tests a correct name
	 */
	@Test
	public void setCharacterNameNormal() {
		String characterString = newGame.setCharacterName("person");
		assertEquals("Your player is called person",characterString);
	}
	
	/**
	 * testDifficultyIncreaseMaxHealth tests if enemies' max health increases
	 */
	@Test
	public void testDifficultyIncreaseMaxHealth() {
		List<Integer> originalHealths = new ArrayList<Integer>();
		Collections.addAll(originalHealths, 60,70,70,60,90,90,60,50,55,60,55,60,70,60,90);
		
		newGame.increaseDifficulty();
		List<Monster> enemies = newGame.getEnemies();
		for (Monster enemy : enemies) {
			int i = enemies.indexOf(enemy);
			assertEquals(originalHealths.get(i)+10, enemy.getMaxHealth());

		}
	}
	
	/**
	 * testDifficultyIncreaseCurrentHealth tests if enemies' current health increases
	 */
	@Test
	public void testDifficultyIncreaseCurrentHealth() {
		List<Integer> originalHealths = new ArrayList<Integer>();
		Collections.addAll(originalHealths, 60,70,70,60,90,90,60,50,55,60,55,60,70,60,90);
		
		newGame.increaseDifficulty();
		List<Monster> enemies = newGame.getEnemies();
		for (Monster enemy : enemies) {
			int i = enemies.indexOf(enemy);
			assertEquals(originalHealths.get(i)+10, enemy.getCurrentHealth());

		}
	}
	
	/**
	 * testDifficultyIncreaseDamage tests if the enemies' damage increases
	 */
	@Test
	public void testDifficultyIncreaseDamage() {
		List<Integer> damages = new ArrayList<Integer>();
		Collections.addAll(damages, 20,10,15,15,45,55,10,15,20,35,40,45,50,50,60);
		
		newGame.increaseDifficulty();
		List<Monster> enemies = newGame.getEnemies();
		for (Monster enemy : enemies) {
			int i = enemies.indexOf(enemy);
			assertEquals(damages.get(i)+10, enemy.getDamage());

		}
	}
	
	/**
	 * testBuyItemEnoughGold tests a purchase when you have enough gold
	 */
	@Test
	public void testBuyItemEnoughGold() {
		Item bread = newGame.getBread();
		String outputString = newGame.buyItem(bread);
		assertEquals(40,newGame.getGold());
		assertEquals(true,newGame.getItemInventory().contains(bread));
		assertEquals("You have purchased Bread", outputString);
	}
	
	/**
	 * testBuyItemNotEnoughGold tests a purchase when you do not have enough gold
	 */
	@Test
	public void testBuyItemNotEnoughGold() {
		Item bread = newGame.getBread();
		newGame.buyItem(bread);
		newGame.buyItem(bread);
		newGame.buyItem(bread);
		String outputString = newGame.buyItem(bread);
		assertEquals("You do not have enough gold to purchase Bread",outputString);
	}
	
	/**
	 * testBuyMonsterEnoughGold tests a purchase when you do have enough gold
	 */
	@Test
	public void testBuyMonsterEnoughGold() {
		Monster vampire = newGame.getVampire();
		String outputString = newGame.buyMonster(vampire);
		assertEquals(10,newGame.getGold());
		assertEquals(true,newGame.getMonsterInventory().contains(vampire));
		assertEquals("You have purchased Vampire",outputString);
	}
	
	/**
	 * testBuyMonsterNotEnoughGold tests a purchase when you do not have enough gold
	 */
	@Test
	public void testBuyMonsterNotEnoughGold() {
		Monster elf = newGame.getElf();
		String outputString = newGame.buyMonster(elf);
		assertEquals("You do not have enough gold to purchase Elf",outputString);
	}
	
	/**
	 * testBuyMonsterFullInventory tests trying to buy a monster with a full inventory
	 */
	@Test
	public void testBuyMonsterFullInventory() {
		Monster vampire = newGame.getVampire();
		newGame.earnGold(500);
		newGame.buyMonster(vampire);
		newGame.buyMonster(newGame.getBanshee());
		newGame.buyMonster(newGame.getGoblin());
		newGame.buyMonster(newGame.getWerewolf());
		String outputString = newGame.buyMonster(newGame.getElf());
		assertEquals("Your monster inventory is full",outputString);
	}
	
	/**
	 * testBuyMonsterAlready tests buying a monster when the same monster has already been purchased
	 */
	@Test
	public void testBuyMonsterAlready() {
		Monster vampire = newGame.getVampire();
		newGame.buyMonster(vampire);
		String outputString = newGame.buyMonster(vampire);
		assertEquals("You have already purchased this monster",outputString);
	}
	
	/**
	 * testSellItem tests selling an item
	 */
	@Test
	public void testSellItem() {
		newGame.earnGold(100);
		int originalGold = newGame.getGold();
		Item sword = newGame.getSword();
		List<Item> inventory = newGame.getItemInventory();
		newGame.buyItem(sword);
		newGame.sellItem(sword);
		assertEquals(0,sword.getItemCount());
		assertEquals(false,inventory.contains(sword));
		assertEquals(originalGold-10,newGame.getGold());
	}
	
	/**
	 * testSellMonster tests selling a monster
	 */
	@Test
	public void testSellMonster() {
		int originalGold = newGame.getGold();
		Monster vampire = newGame.getVampire();
		List<Monster> inventory = newGame.getMonsterInventory();
		inventory.add(vampire);
		newGame.sellMonster(vampire);
		assertEquals(false,inventory.contains(vampire));
		assertEquals(originalGold+40,newGame.getGold());
	}
	
	/**
	 * testChangePropertyHealthPotion tests health potion
	 */
	@Test
	public void testChangePropertyHealthPotion() {
		Monster vampire = newGame.getVampire();
		vampire.setCurrentHealth(-10);
		int originalHealth = vampire.getCurrentHealth();
		newGame.changeProperty(vampire,newGame.getHealthPotion());
		assertEquals(originalHealth+10,vampire.getCurrentHealth());
	}
	
	/**
	 * testChangePropertySpeedPotion test speed potion
	 */
	@Test
	public void testChangePropertySpeedPotion() {
		Monster vampire = newGame.getVampire();
		int originalSpeed = vampire.getSpeed();
		newGame.changeProperty(vampire,newGame.getSpeedPotion());
		assertEquals(originalSpeed+10,vampire.getSpeed());
	}
	
	/**
	 * testChangePropertyWeapon tests weapons
	 */
	@Test
	public void testChangePropertyWeapon() {
		Monster vampire = newGame.getVampire();
		newGame.earnGold(100);
		newGame.buyItem(newGame.getSword());
		newGame.changeProperty(vampire,newGame.getSword());
		assertEquals(30, vampire.getDamage());
		assertEquals(0,newGame.getSword().getItemCount());
	}
	
	/**
	 * testChangePropertyFood tests food
	 */
	@Test
	public void testChangePropertyFood() {
		Monster vampire = newGame.getVampire();
		vampire.increaseHealth(-10);
		newGame.changeProperty(vampire,newGame.getBread());
		assertEquals(60, vampire.getCurrentHealth());
	}
	
	/**
	 * testUseItem tests using an item
	 */
	@Test
	public void testUseItem() {
		Monster goblin = newGame.getVampire();
		goblin.setCurrentHealth(60);
		Item bread = newGame.getBread();
		newGame.earnGold(100);
		newGame.buyItem(bread);
		goblin.increaseHealth(-10);
		newGame.useItem(bread,goblin);
		assertEquals(60,goblin.getCurrentHealth());
		assertEquals(0, bread.getItemCount());
		assertEquals(false, newGame.getItemInventory().contains(bread));
	}
	
	/**
	 * testUseItemNotInInventory tests using an item thats not in the inventory
	 */
	@Test
	public void testUseItemNotInInventory() {
		Monster vampire = newGame.getVampire();
		Item bread = newGame.getBread();
		int health = vampire.getCurrentHealth();
		newGame.useItem(bread,vampire);
		assertEquals(health,vampire.getCurrentHealth());
	}
	
	/**
	 * testIncrementCurrentDay tests incrementing day
	 */
	@Test
	public void testIncrementCurrentDay() {
		int currentDay = newGame.getCurrentDay();
		int newDay = newGame.incrementCurrentDay();
		assertEquals(currentDay+1,newDay);
	}
	
	/**
	 * testGetWeaponListNoWeapons tests adding to weapon list with no weapons
	 */
	@Test
	public void testGetWeaponListNoWeapons() {
		List<Item> inventory = newGame.getItemInventory();
		Item bread = newGame.getBread();
		inventory.add(bread);
		List<Item> weapons = newGame.getWeaponList();
		assertEquals(0,weapons.size());
	}
	
	/**
	 * testGetWeaponListOnlyWeapons tests adding to weapon list with only weapons
	 */
	@Test
	public void testGetWeaponListOnlyWeapons() {
		List<Item> inventory = newGame.getItemInventory();
		Item sword = newGame.getSword();
		inventory.add(sword);
		List<Item> weapons = newGame.getWeaponList();
		assertEquals(1,weapons.size());
		assertEquals(true,weapons.contains(sword));
	}
	
	/**
	 * testGetWeaponListWeaponsAndMore tests adding to weapon list with weapons and edibles
	 */
	@Test
	public void testGetWeaponListWeaponsAndMore() {
		List<Item> inventory = newGame.getItemInventory();
		Item sword = newGame.getSword();
		Item bread = newGame.getBread();
		inventory.add(bread);
		inventory.add(sword);
		List<Item> weapons = newGame.getWeaponList();
		assertEquals(1,weapons.size());
		assertEquals(true,weapons.contains(sword));
		assertEquals(false,weapons.contains(bread));
	}
	
	/**
	 * testGetEdiblesListNoEdibles tests adding to edible list with no edibles
	 */
	@Test
	public void testGetEdiblesListNoEdibles() {
		List<Item> inventory = newGame.getItemInventory();
		Item sword = newGame.getSword();
		inventory.add(sword);
		List<Item> edibles = newGame.getEdiblesList();
		assertEquals(0,edibles.size());
	}
	
	/**
	 * testGetEdiblesListOnlyEdibles tests adding to edible list with only edibles
	 */
	@Test
	public void testGetEdiblesListOnlyEdibles() {
		List<Item> inventory = newGame.getItemInventory();
		Item bread = newGame.getBread();
		inventory.add(bread);
		List<Item> edibles = newGame.getEdiblesList();
		assertEquals(1,edibles.size());
		assertEquals(true,edibles.contains(bread));
	}
	
	/**
	 * testGetEdiblesListBothEdiblesAndMore tests adding to edible list with edibles and weapons
	 */
	@Test
	public void testGetEdiblesListBothEdiblesAndMore() {
		List<Item> inventory = newGame.getItemInventory();
		Item sword = newGame.getSword();
		Item bread = newGame.getBread();
		inventory.add(bread);
		inventory.add(sword);
		List<Item> edibles = newGame.getEdiblesList();
		assertEquals(1,edibles.size());
		assertEquals(true,edibles.contains(bread));
		assertEquals(false,edibles.contains(sword));
	}
	
	/**
	 * testUnassignWeaponHasWeapon tests unassign weapon
	 */
	@Test
	public void testUnassignWeaponHasWeapon() {
		Monster vampire = newGame.getVampire();
		int vampireDamage = vampire.getDamage();
		Item sword = newGame.getSword();
		newGame.changeProperty(vampire,sword);
		assertEquals(sword,vampire.getWeapon());
		newGame.unassignWeapon(vampire);
		assertEquals(null,vampire.getWeapon());
		assertEquals(vampireDamage,vampire.getDamage());
		
	}
	
	/**
	 * testUnassignWeaponHasNoWeapon tests unassign weapon
	 */
	@Test
	public void testUnassignWeaponHasNoWeapon() {
		Monster vampire = newGame.getVampire();
		int vampireDamage = vampire.getDamage();
		newGame.unassignWeapon(vampire);
		assertEquals(null,vampire.getWeapon());
		assertEquals(vampireDamage,vampire.getDamage());
	}
	
	/**
	 * testSleepingMonsters tests the health restoring after sleep
	 */
	@Test 
	public void testSleepingMonsters() {
		newGame.addMonsterInventory(newGame.getVampire());
		Monster itemInInventory = newGame.getMonsterInventory().get(0);
		itemInInventory.setCurrentHealth(0);
		newGame.sleepingMonsters();
		assertEquals(itemInInventory.getMaxHealth(),itemInInventory.getCurrentHealth());
	}
	
	/**
	 * testCheckPointsEnough tests if when there is enough points the game levels up
	 */
	@Test
	public void testCheckPointsEnough() {
		newGame.setPoints(60);
		String message = newGame.checkPoints();
		assertEquals("Level up", message);
	}
	
	/**
	 * testCheckPointsNotMany tests if when there are not enough points it does not level up
	 */
	@Test
	public void testCheckPointsNotMany() {
		newGame.setPoints(10);
		String message = newGame.checkPoints();
		assertEquals(message,"No level up");
	}
}
