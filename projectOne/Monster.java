package projectOne;

import java.util.ArrayList;

/**
 * 
 * Monster describes a monster object, which partakes in battles, and has different attributes, which affect these battles.
 *
 */

public class Monster implements Purchaseable{
	
	private int maxHealth, healAmount, rarity, price;
	private int level = 1; 
	private int points = 0; 
	private String monsterName;
	private int currentHealth, damage, speed;
	private Item weapon;
	
	/**
	 * constructs a Monster object and adds it to the list of monsters
	 * 
	 * @param monsterName sets the monsters name
	 * @param maxHealth sets the maximum health
	 * @param damageValue sets the damage value
	 * @param speedValue sets the speed of the monster
	 * @param rarity sets how rare a monster is
	 * @param price sets how much is sold for
	 */
	public Monster(String monsterName, int maxHealth, int damageValue, int speedValue, int rarity, int price){
		this.monsterName = monsterName;
		this.maxHealth = maxHealth;
		damage = damageValue;
		this.rarity = rarity;
		speed = speedValue;
		currentHealth = maxHealth;
		healAmount = 20;
		weapon = null;
		this.price = price;
		
	}
	
	/**
	 * setLevel sets the monster's level
	 * @param level
	 */
	public void setLevel(int level) {
		this.level += level; 
		maxHealth += 5; 
		damage += 5; 
	}
	
	/**
	 * getter method for level of monster
	 * @return the monster's level based on its points
	 */
	public int getLevel() {
		return level; 
	}
	
	/**
	 * sets the number of points a monster has
	 * @param points sets the number of points the monster has
	 */
	public void setPoints(int points) {
		this.points += points; 
	}
	
	/**
	 * getter method for number of points a monster has
	 * @return number of points a monster has
	 */
	public int getPoints() {
		return points; 
	}
			
		
	/**
	 * getter method for the maximum health value
	 * @return the monster's maximum health value
	 */
	public int getMaxHealth() {
		return maxHealth;
	}
	
	/**
	 * better method for the damage a monster does
	 * @return the maximum damager a monster can do
	 */
	public int getDamage() {
		return damage;
	}
	
	/**
	 * getter method for the monster's health
	 * @return the monster's health value
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	/**
	 * setter method for the monsters health
	 * @param value sets the health of the monster
	 */
	public void setCurrentHealth(int value) {
		currentHealth = value;
	}

	
	/**
	 * getter method for the rarity of a monster
	 * @return how rare a monster is
	 */
	public String getRarity() {
		if (this.rarity==1) {
			return "not rare";
		} else if (this.rarity==2) {
			return "somewhat rare";
		} else if (this.rarity==3) {
			
			return "rare";
		} else {
			return "This has no rarity";
		}
	}
	
	/**
	 * getter method for the value
	 * @return the monster's speed during attack
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * 
	 * @return the monster's name
	 */ 
	public String getItemName() {
		return monsterName;
	}
	
	/**
	 * getter method for the weapon a monster has
	 * @return the weapon name if a weapon is selected, else returns that no weapon is selected
	 */
	public Item getWeapon() {
		if (weapon != null) {
			return weapon;
		} else { 
			return null;
		}
	}
	
	/**
	 * getter method for the name of the weapon a monster has
	 * @return the name of the weapon
	 */
	public String getWeaponName() {
		if (weapon!= null) {
			return weapon.getItemName(); 
		}
		else {
			return "No weapon"; 
		}
	}
	
	/**
	 * sets the name of the monster
	 * @param monsterName sets a new name for the monster
	 */
	public void setName(String monsterName) {
		this.monsterName = monsterName;
	}
	
	/**
	 * increaseDamage increases the damage a monster can do
	 * @param itemDamage sets a new value for the amount of damage a monster can do in one hit
	 */
	public void increaseDamage(int itemDamage) {
		damage += itemDamage;
	}
	
	/**
	 * increases the speed a monster's attacks move at
	 * @param itemSpeed increase monster's speed
	 */
	public void increaseSpeed(int itemSpeed) {
		speed += itemSpeed;
	}

	/**
	 * increases the health of the monster
	 * @param healAmount set the amount a monster heals by every five seconds if a monster drinks a healing potion
	 */
	public void increaseHealth(int healAmount) {
		currentHealth += healAmount;
	}
	
	/**
	 * sets the weapon a monster has
	 * @param item sets the monster's weapon to a new value
	 */
	public void setWeapon(Item item) {
		weapon = item;
	}
	
	/**
	 * getter method for the price of the item
	 * @return the price the item sells for
	 */
	public int getItemPrice() {
		return price;
	}

	/** 
	 * getter method for the price an item can be resold for
	 * @return sellBack returns the value that a monster can be resold for 
	 */
	public int getSellBackPrice() {
		int sellBack = price-10;
		return sellBack;
	}

	/**
	 * returns a string description of the monster
	 * @return stringRepresentation gets the value of the string representation
	 */
	public String getDescription() {
		String stringRepresentation = "Max Health: "+getMaxHealth()+"\n"
				+"Damage: "+getDamage()+"\nSpeed: "+getSpeed()+"\n"
				+"Price: "+getItemPrice()+"g\n"+getItemName()+" is "
				+getRarity()+"\nCurrent health: "+getCurrentHealth();
		return stringRepresentation;
	}

	/**
	 * increases the maximum health amount
	 * @param amount gives the value of the amount the max health is changed by
	 */
	public void increaseMaxHealth(int amount) {
		this.maxHealth += amount;
	}

}
