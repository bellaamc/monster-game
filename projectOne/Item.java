package projectOne;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * creates a class of item objects that can be used
 * 
 *
 */
public class Item implements Purchaseable{
	
	private int itemPrice, propertyAdjustment;
	private String itemName, itemType;
	private ArrayList<Item> itemList = new ArrayList<Item>();
	private int itemCount = 0; 
	
	/**
	 * Item constructs an object of type item
	 * @param itemPrice determines the price of the item
	 * @param itemName determines the name of the item
	 * @param propertyAdjustment determines how much the item changes a property
	 * @param itemType determines what category the item belongs to
	 */
	public Item(int itemPrice, String itemName, int propertyAdjustment, String itemType) {
		this.itemPrice = itemPrice;
		this.itemName = itemName;
		this.itemType = itemType;
		this.propertyAdjustment = propertyAdjustment;
		itemList.add(this);
	}
	
	/**
	 * getter method for the number of this item in your inventory
	 * @return the counter of the items
	 */
	public int getItemCount() {
		return itemCount; 
	}
	
	/**
	 * determines the value of the item counter
	 * @param number sets the value of this counter
	 */
	public void setItemCount(int number) {
		itemCount += number; 
	}
	
	/**
	 * getter method for the price of the item
	 * @return the price of the item
	 */
	public int getItemPrice() {
		return itemPrice;
	}

	/**
	 * getter method for the name of the item
	 * @return the name of the item
	 */
	public String getItemName() {
		return itemName;
	}
	
	/** 
	 * getter method for the sell back price of the item
	 * @return sell back price
	 */
	public int getSellBackPrice() {
		return itemPrice -10;
	}
	/**
	 * getter method for the type of the item 
	 * @return item price 
	 */
	public String getItemType() {
		return itemType; 
	}
	/**
	 * determines the property adjustment an item gives a monster depending on its type 
	 * @return string showing the boost of the item and the property it boosts 
	 */
	public String propertyAdjustment() {
		if (itemType == "Health Potion" || itemType == "Food" && itemName!= "Speed Potion") {
			return "Health Boost: " + getPropertyAdjustment(); 
		}
		else if (itemType == "Weapon") {
			return "Damage Boost: " + getPropertyAdjustment(); 

		}
		
		else if (itemName == "Speed Potion") {
			return "Speed Boost: " + getPropertyAdjustment(); 

		}
		return ""; 
	}
	/**
	 * getter method for property adjustment
	 * @return property adjustment of item
	 */
	public int getPropertyAdjustment() {
		return propertyAdjustment; 
	}

	@Override
	/**
	 * getter method for the string description of an item
	 * @return string representation of item attributes 
	 */
	public String getDescription() {
		String descriptionString = "";
		if (getItemType() == "Food" || getItemType() =="Health Potion") {
			descriptionString = "This item increases health by ";
		} else if (getItemType() == "Weapon") {
			descriptionString = "This item increases damage by ";
		} else {
			descriptionString = "This item increases speed by ";
		}
		return getItemName()+"\nPrice: "+getItemPrice()+"g\n"+descriptionString+getPropertyAdjustment();
	}
}

