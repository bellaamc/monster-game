package projectOne;

/**
 * 
 * Purchaseable interface defines main methods that purchaseable classes must have.
 *
 */
public interface Purchaseable {
	
	/**
	 * getter method for item price
	 * @return the price of an item or monster in the shop
	 */
	public int getItemPrice() ;
	
	/**
	 * getter method for item name
	 * @return the name of the item or monster in the shop
	 */
	public String getItemName() ;
	
	/**
	 * getter method for the sell back price
	 * @return the amount the item can be sold for
	 */
	public int getSellBackPrice();
	
	/**
	 * getter method for a string description of purchaseable objects
	 * @return a string description of a purchaseable item
	 */
	public String getDescription();

}


