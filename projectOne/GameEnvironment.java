package projectOne;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

/**
 * GameEnvironment sets up a new game and stores values of objects to be used in gameplay
 */
public class GameEnvironment {
	
	private int goldAvailable, numPoints, numDays, currentDay, difficulty;
	private String characterName;
	private Monster vampire, banshee, goblin, werewolf, dragon, elf, tyrant, 
	gnome, zombie, alien, demon, cyclops, bigfoot, unicorn, basilisk;
	private Item bread, water, healthPotion, speedPotion, throwingStars, sword, flameThrower;
	private List<Item> itemInventory = new ArrayList<Item>();
	private List<Monster> monsterInventory = new ArrayList<Monster>();
	private List<Monster> monsterList = new ArrayList<Monster>();
	private List<Item> edibles = new ArrayList<Item>(); 
	private List<Item> itemList = new ArrayList<Item>();
	private List<Item> weapons = new ArrayList<Item>(); 
	private Item selectedWeapon; 
	private Item selectedEdible; 
	private List<Monster> enemies = new ArrayList<Monster>();
	private Battle battle;

	/**
	 * creates a GameEnvironment object
	 */
	public GameEnvironment() {
		vampire = new Monster("Vampire", 60, 20, 70, 1,50);
		banshee = new Monster("Banshee", 70, 10, 60, 1,50);
		goblin = new Monster("Goblin", 70, 15, 40, 1,50);
		werewolf = new Monster("Werewolf", 60, 15, 70, 1,70);
		dragon = new Monster("Dragon", 90, 45, 70, 2,80);
		elf = new Monster("Elf", 90, 55, 80, 3,100);
		tyrant = new Monster("Tyrant", 60, 10, 80, 1, 0);
		gnome = new Monster("Gnome", 50, 30, 70, 1, 0);
		zombie = new Monster("Zombie", 55, 40, 60, 1, 0);
		alien = new Monster("Alien", 60, 35, 70, 2, 0);
		demon = new Monster("Demon", 55, 40, 60, 2,0);
		cyclops = new Monster("Cyclops", 60, 60, 50, 2, 0);
		bigfoot = new Monster("Bigfoot", 70, 50, 80, 3, 0);
		unicorn = new Monster("Unicorn", 60, 50, 65, 3, 0);
		basilisk = new Monster("Basilisk", 90, 60,75,3,0);

		
		Collections.addAll(monsterList,vampire,banshee,goblin,werewolf,dragon,elf);
		Collections.addAll(enemies,vampire,banshee,goblin,werewolf,dragon,elf,tyrant, 
				gnome, zombie, alien, demon, cyclops, bigfoot, unicorn, basilisk);

		bread = new Item(20, "Bread", 10, "Food");
		water = new Item(10,"Water",5,"Food");
		healthPotion = new Item(20, "Health Potion",10, "Health Potion");
		speedPotion = new Item(20, "Speed Potion",10, "Speed Potion");
		throwingStars = new Item(20, "Throwing Stars", 5, "Weapon");
		sword = new Item(50, "Sword",10, "Weapon");
		flameThrower = new Item(70, "Flamethrower",20,"Weapon");
		
		Collections.addAll(itemList,bread,water,healthPotion,speedPotion,sword,flameThrower, throwingStars);
		
		battle = new Battle(this);
		
		currentDay = 1;
		numDays = 15;
		goldAvailable = 60;
		characterName = "";
		currentDay = 1;
		numPoints = 0;
		difficulty = 1;
	}
	
	/**
	 * increases monsters health over night
	 */
	public void sleepingMonsters() {
		for (Monster monster : monsterInventory) {
			monster.setCurrentHealth(monster.getMaxHealth());
		}
	}
	
	/**
	 * gets the number of points a player has
	 * @return the integer for the number of points
	 */
	public int getPoints() {
		return numPoints;
	}
	
	/**
	 * sets the number of points
	 * @param points sets the value 
	 */
	public void setPoints(int points) {
		numPoints += points; 
	}
	
	/**
	 * checks is a monster can be leveled up 
	 * @return string for whether the monster levels up
	 */
	public String checkPoints() {
		if (getPoints() >= 50 ) {
			setPoints(getPoints() - 50);
			return "Level up"; 
		}
		else {
			return "No level up"; 
		}
		
	}
	
	/**
	 * gets a vampire object	
	 * @return the vampire object of monster class
	 */
	public Monster getVampire() {
		return vampire;
	}
	
	
	/**
	 * gets a banshee object	
	 * @return the banshee object of monster class
	 */
	public Monster getBanshee() {
		return banshee;
	}
	
	/**
	 * gets a goblin object	
	 * @return the goblin object of monster class
	 */
	public Monster getGoblin() {
		return goblin;
	}
	
	/**
	 * getter method for werewolf object
	 * @return werewolf object
	 */
	public Monster getWerewolf() {
		return werewolf;
	}
	
	/**
	 * gets a dragon object	
	 * @return the dragon object of monster class
	 */
	public Monster getDragon() {
		return dragon;
	}
	
	/**
	 * gets a elf object	
	 * @return the elf object of monster class
	 */
	public Monster getElf() {
		return elf;
	}
	
	/**
	 * gets a bread object	
	 * @return the bread object of item class
	 */
	public Item getBread() {
		return bread;
	}
	
	/**
	 * gets a water object	
	 * @return the water object of item class
	 */
	public Item getWater() {
		return water;
	}
	
	/**
	 * gets a health potion object	
	 * @return the health potion object of item class
	 */
	public Item getHealthPotion() {
		return healthPotion;
	}
	
	/**
	 * gets a speed potion object
	 * @return the speed potion object of item class
	 */
	public Item getSpeedPotion() {
		return speedPotion;
	}
	
	/**
	 * gets a throwing stars object	
	 * @return the throwing stars object of item class
	 */
	public Item getThrowingStars() {
		return throwingStars;
	}
	
	/**
	 * gets a sword object	
	 * @return the sword object of item class
	 */
	public Item getSword() {
		return sword;
	}
	
	/**
	 * gets a value for the amount of gold
	 * @return the value of the amount of gold in game environment
	 */
	public int getGold() {
		return goldAvailable;
	}
	
	/**
	 * increases the amount of gold a player has
	 * @param gold sets the value for the amount it increases by
	 */
	public void earnGold(int gold) {
		goldAvailable += gold;
	}

	/**
	 * gets a flame thrower object	
	 * @return the flame thrower object of item class
	 */
	public Item getFlameThrower() {
		return flameThrower;
	}
	
	/**
	 * getter method for the game length
	 * @return the number of days the game will last
	 */
	public int getGameLength() {
		return numDays;
	}

	/**
	 * sets the player name
	 * @param playerName sets the name of the player
	 * @return the string with the player name
	 */
	public String setCharacterName(String playerName) {
		Pattern p = Pattern.compile("[^A-Za-z0-9 ]");
        Matcher m = p.matcher(playerName);
        if(m.find())
            {return "Your name cannot contain special characters.";}
	else if (playerName.length()<3) { return "Your name is too short.\nTry a longer name.";}
	else if (playerName.length()>15) { return "Your name is too long.\nTry a shorter name.";}
	else {
		characterName = playerName;
		return "Your player is called " +playerName;
	}
		
	}
	
	/**
	 * getter method for character name
	 * @return the value of the character name
	 */
	public String getCharacterName() {
		return characterName;
	}
	

	/**
	 * increases the difficulty of the game
	 */
	public void increaseDifficulty() {
		difficulty +=1;
		enemies = monsterList;
		for (Monster enemy : enemies) {
			enemy.increaseHealth(10);
			enemy.increaseMaxHealth(10);
			enemy.increaseDamage(10);
			}
	}
	
	/**
	 * increases the values of gold and points when a battle is one
	 */
	public void battleSuccess() {
		if (getDifficulty() ==1) {
			earnGold(40);
			setPoints(10);
		} else {
			earnGold(60);
			setPoints(20);
		}
	}

	/**
	 * getter method for the difficulty
	 * @return the value of the difficulty
	 */
	public int getDifficulty() {
		return difficulty; 
	}
		
	/**
	 * method to purchase an item in the store
	 * @param itemToPurchase sets the item to buy in store
	 * @return a string with the item that is purchased
	 */
	public String buyItem(Item itemToPurchase) {
		if (goldAvailable >= itemToPurchase.getItemPrice()) {
			goldAvailable -= itemToPurchase.getItemPrice();
			itemInventory.add(itemToPurchase);
			itemToPurchase.setItemCount(1); 
		
			return "You have purchased " +itemToPurchase.getItemName();
		} else {
			return "You do not have enough gold to purchase " +itemToPurchase.getItemName();
		}
	}
	
	/**
	 * setter method for the difficulty
	 * @param difficulty value to set the difficulty to
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty; 
	}
	
	/**
	 * method to buy monster in the shop
	 * @param monsterToPurchase sets the monster being purchased
	 * @return string showing what has been purchased
	 */
	public String buyMonster(Monster monsterToPurchase) {
		if (!(monsterInventory).contains(monsterToPurchase)) {
		if (goldAvailable >= monsterToPurchase.getItemPrice() && monsterInventory.size() < 4) {
			goldAvailable -= monsterToPurchase.getItemPrice();
			monsterInventory.add(monsterToPurchase);
			return "You have purchased " +monsterToPurchase.getItemName();
			
			
		} else if (monsterInventory.size() >= 4) {
			return "Your monster inventory is full"; 
		}
		
		else {
			return "You do not have enough gold to purchase " +monsterToPurchase.getItemName();
		}
		} else {
			return "You have already purchased this monster"; 
		}
	}
	
	/**
	 * getter method for the monster list
	 * @return the list of monsters
	 */
	public List<Monster> getMonsterList() {
		return monsterList;
	}
	
	/**
	 * getter method for the player's monster inventory
	 * @return the inventory of monsters
	 */
	public List<Monster> getMonsterInventory() {
		return monsterInventory;
	}
	
	/**
	 * removes a monster from the inventory
	 * @param newMonster sets the item to be removed from the inventory
	 */
	public void removeMonsterInventory(Monster newMonster) {
		monsterInventory.remove(newMonster);
	}
	
	/**
	 * adds a monster to the inventory
	 * @param newMonster sets the item to be added to the inventory
	 */
	public void addMonsterInventory(Monster newMonster) {
		monsterInventory.add(newMonster); 
	}
	
	/**
	 * getter method for the item inventory
	 * @return the values of the items in the inventory
	 */
	public List<Item> getItemInventory() {
		return itemInventory;
	}
	
	/**
	 * method for selling an item
	 * @param item the item that is being sold
	 */
	public void sellItem(Item item) {
		itemInventory.remove(item); 
		goldAvailable += item.getSellBackPrice();
		item.setItemCount(-1);
		if (item.getItemType() == "Weapon" && item.getItemCount() == 0) {
			weapons.remove(item); 
		}	
	}
	
	/**
	 * method for selling a monster
	 * @param monster the monster that is being sold
	 */
	public void sellMonster(Monster monster) {
		monsterInventory.remove(monster);
		goldAvailable += monster.getSellBackPrice();

	}
	
	/**
	 * method for using different items
	 * @param monster the monster which is getting the property adjustment
	 * @param item the item that is being used
	 */
	public void changeProperty(Monster monster, Item item) {
		switch(item.getItemType()) {
			case "Health Potion": 
				monster.increaseHealth(item.getPropertyAdjustment());
				break;
			case "Speed Potion":
				monster.increaseSpeed(item.getPropertyAdjustment());
				break;
			case "Weapon":
				if (monster.getWeapon() == null) {
					monster.increaseDamage(item.getPropertyAdjustment());
					monster.setWeapon(item);
					item.setItemCount(-1);
				}
				break;
			case "Food": 
				monster.increaseHealth(item.getPropertyAdjustment());
			
				}
				
		}
	
	/**
	 * method to use the item
	 * @param itemToUse the item being used
	 * @param monster the monster the property is applied to
	 */
	public void useItem(Item itemToUse, Monster monster) {
		if (itemInventory.contains(itemToUse)) {
			changeProperty(monster, itemToUse);
			itemInventory.remove(itemToUse);
			itemToUse.setItemCount(-1); 
			if (itemToUse.getItemCount() == 0) {
				edibles.remove(itemToUse); 
			}
		}
	}
	
	/**
	 * sets how long the game lasts
	 * @param days the number of days the game will last
	 */
	public void chooseGameLength(int days) {
			this.numDays = days;
	}
	
	/**
	 * getter method for the value of the current day
	 * @return the current day
	 */
	public int getCurrentDay() {
		return currentDay;
	}
	
	/**
	 * changes the value of the current day
	 * @return the day number
	 */
	public int incrementCurrentDay() {
		if (currentDay < numDays) {
			currentDay +=1;
		}
		return currentDay;
	}
	
	/**
	 * getter method for the battle
	 * @return the battle object
	 */
	public Battle getBattle() { 
		return battle;
	}
	
	/**
	 * getter method for the enemies list
	 * @return the list of enemies
	 */
	public List<Monster> getEnemies() {
		return enemies;
	}

	/**
	 * gets the value of the monster fighting
	 * @return the monster fighting
	 */
	public Monster getCurrentFighter() {
		return monsterInventory.get(0);
	}
	
	/**
	 * gets the value of an item in the inventory
	 * @param index to index the inventory list
	 * @return the value of the item at this index
	 */
	public Item getItem(int index) {
		return itemInventory.get(index); 
		
	}
	
	/**
	 * gets the shuffled item list
	 * @return the item list shuffled
	 */
	public List<Item> getShuffledItemList() {
		Collections.shuffle(itemList);
		return itemList; 
	}
	
	/**
	 * allows a list of only the weapons
	 * @return the list of weapons
	 */
	public List<Item> getWeaponList() {
		if (itemInventory.size() > 0) {
			for (int i = 0; i <  itemInventory.size(); i += 1) {
				if (itemInventory.get(i).getItemType() == "Weapon" && weapons.contains(itemInventory.get(i)) == false) {
					weapons.add(itemInventory.get(i)); 
					
				}
			}
		}
		return weapons; 
	}
	
	/**
	 * the list of only the edibles
	 * @return a list of edibles
	 */
	public List<Item> getEdiblesList() {
		if (itemInventory.size() > 0) {
			for (int i = 0; i <  itemInventory.size(); i += 1) {
				if ((itemInventory.get(i).getItemType() == "Food" || itemInventory.get(i).getItemType() == "Health Potion" || itemInventory.get(i).getItemType() == "Speed Potion" ) && edibles.contains(itemInventory.get(i)) == false) {
					edibles.add(itemInventory.get(i)); 
					
				}
			
		}

		
		

	}
		return edibles; 
		
		

		
	

	
}
	
	/**
	 * getter method for the selected weapon
	 * @return the chosen weapon
	 */
	public Item getSelectedWeapon() {
		return selectedWeapon; 
	}
	
	/**
	 * setter method for the selected weapon
	 * @param item chooses the value of the selected weapon
	 * 
	 */
	public void setSelectedWeapon(Item item) {
		selectedWeapon = item; 
		
	}
	
	/**
	 * getter method for the selected edible
	 * @return item returns the value of the selected edible
	 * 
	 */
	public Item getSelectedEdible() {
		return selectedEdible; 
	}
	
	/**
	 * setter method for the selected edible
	 * @param item chooses the value of the selected edible
	 * 
	 */
	public void setSelectedEdible(Item item) {
		selectedEdible = item; 
		
	}
	
	/**
	 * removes a weapon from a monster
	 * @param monster determines which monster loses its weapon
	 */
	public void unassignWeapon(Monster monster) {
		if (monster.getWeapon() != null) {
			monster.getWeapon().setItemCount(1);
			itemList.add(monster.getWeapon()); 
			monster.increaseDamage(-(monster.getWeapon().getPropertyAdjustment())); 
			monster.setWeapon(null);
		}
	}

}


