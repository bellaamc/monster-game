package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import projectOne.GameEnvironment;
import projectOne.Item;
import projectOne.Monster;

/**
 * 
 * MonsterTest tests the monster class
 *
 */
@TestInstance(Lifecycle.PER_CLASS)
public class MonsterTest {
	
	/**
	 * MonsterTest constructs Monster Test
	 */
	public MonsterTest() {
	}

	GameEnvironment newGame = new GameEnvironment();
	
	/**
	 * testSetPointsGreater50 tests when a monster should level up
	 */
	@Test
	public void testSetPointsGreater50() {
		Monster vampire = newGame.getVampire();
		newGame.setPoints(60);
		vampire.setLevel(1);
		assertEquals(2,vampire.getLevel());
	}
	
	/**
	 * testSetPointsLess50 tests when a monster should not level up
	 */
	@Test
	public void testSetPointsLess50() {
		Monster vampire = newGame.getVampire();
		vampire.setPoints(40);
		assertEquals(1,vampire.getLevel());
		assertEquals(40,vampire.getPoints());
	}
	
	/**
	 * testRarityNotRare tests non rare object
	 */
	@Test
	public void testRarityNotRare() {
		Monster vampire = newGame.getVampire();
		assertEquals("not rare",vampire.getRarity());
	}
	
	/**
	 * testRarityNotRare tests somewhat rare object
	 */
	@Test
	public void testRaritySomewhatRare() {
		Monster dragon = newGame.getDragon();
		assertEquals("somewhat rare",dragon.getRarity());
	}
	
	/**
	 * testRarityNotRare tests rare object
	 */
	@Test
	public void testRarityRare() {
		Monster elf = newGame.getElf();
		assertEquals("rare",elf.getRarity());
	}
	
	/**
	 * testRarityNotRare tests object with no rarity
	 */
	@Test
	public void testRarityHasNoRarity() {
		Monster newMonster = new Monster("monster",10,10,10,4,0);
		assertEquals("This has no rarity",newMonster.getRarity());
	}
	
	/**
	 * testGetWeaponNoWeapon tests get weapon when there is no weapon
	 */
	@Test
	public void testGetWeaponNoWeapon() {
		Monster vampire = newGame.getVampire();
		assertEquals(null,vampire.getWeapon());
	}
	
	/**
	 * testGetWeapon tests get weapon when there is one
	 */
	@Test
	public void testGetWeapon() {
		Monster vampire = newGame.getVampire();
		Item sword = newGame.getSword();
		newGame.buyItem(sword);
		newGame.changeProperty(vampire, sword);
		assertEquals(sword,vampire.getWeapon());
	}
	
	/**
	 * testGetWeaponNoWeaponName tests get weapon name when there is no weapon
	 */
	@Test
	public void testGetWeaponNameNoWeapon() {
		Monster vampire = newGame.getVampire();
		assertEquals("No weapon",vampire.getWeaponName());
	}
	
	/**
	 * testGetWeaponName tests get weapon name when there is one
	 */
	@Test
	public void testGetWeaponName() {
		Monster vampire = newGame.getVampire();
		Item sword = newGame.getSword();
		newGame.buyItem(sword);
		newGame.changeProperty(vampire, sword);
		assertEquals("Sword",vampire.getWeaponName());
	}
	
}
