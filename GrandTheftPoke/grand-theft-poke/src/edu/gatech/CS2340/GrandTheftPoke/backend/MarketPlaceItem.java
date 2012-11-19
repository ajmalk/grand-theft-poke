package edu.gatech.CS2340.GrandTheftPoke.backend;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Represents the price and stock properties of an item in the marketplace
 * 
 * @author Team Rocket
 * 
 */
@XStreamAlias("Stock")
public class MarketPlaceItem {

	private float price, stock;
	@XStreamOmitField
	private final float EQIL_PRICE, EQIL_STOCK, CONS_ELASTICITY,
			PROD_ELASTICITY, STOCK_RATIO;

	/**
	 * Creates a MarketPlaceItem
	 * 
	 * @param price
	 *            the equilibrium price of the item in this marketplace
	 * @param stock
	 */
	public MarketPlaceItem(Float price, Float stock) {
		EQIL_PRICE = this.price = price * 100;
		EQIL_STOCK = this.stock = stock + 500;
		CONS_ELASTICITY = -1f;
		PROD_ELASTICITY = 2f;
		STOCK_RATIO = 0.1f;
	}

	/**
	 * returns the current retail price
	 * 
	 * @return the price truncated to 2 decimal places
	 */
	public Float getPrice() {
		return ((int) (price * 100)) / 10000f; // probably a better way to do
												// this
	}

	/**
	 * returns the total price if buying a certain amount of the item
	 * 
	 * @param amount
	 * @return the price truncated to 2 decimal places
	 */
	public Float getBuyingPrice(int amount) {
		if (amount < 0) {
			return 0f;
		}
		float price = 0;
		for (int i = 0; i < amount; i++) {
			price += getNewPrice(-1);
		}
		return ((int) (price * 100)) / 10000f; // probably a better way to do
												// this
	}

	/**
	 * returns the total price if selling a certain amount of the item
	 * 
	 * @param amount
	 * @return the price truncated to 2 decimal places
	 */
	public Float getSellingPrice(int amount) {
		if (amount < 0) {
			return 0f;
		}
		float price = 0;
		for (int i = 0; i < amount; i++) {
			price += getNewPrice(-1);
		}
		return ((int) (price * 100)) / 10000f; // probably a better way to do
												// this
	}

	/**
	 * The current stock level
	 * 
	 * @return the stock
	 */
	public Integer getStock() {
		return (int) stock - 500;
	}

	/**
	 * checks consumption
	 * 
	 * @param price
	 *            the price
	 * @return float
	 */
	public float consumption(float price) {
		return (float) Math.pow((price / EQIL_PRICE), CONS_ELASTICITY)
				* EQIL_STOCK;
	}

	/**
	 * checks production
	 * 
	 * @param price
	 *            the price
	 * @return float
	 */
	public float production(float price) {
		return (float) Math.pow((price / EQIL_PRICE), PROD_ELASTICITY)
				* EQIL_STOCK;
	}

	/**
	 * checks consumption
	 * 
	 * @return float
	 */
	private float consumption() {
		return consumption(price);
	}

	/**
	 * checks production
	 * 
	 * @return float
	 */
	private float production() {
		return production(price);
	}

	/**
	 * checks to see if two items are equal
	 * 
	 * @param item
	 *            item to be checked
	 * @return boolean
	 */
	public boolean equals(MarketPlaceItem item) {
		if (item.CONS_ELASTICITY == CONS_ELASTICITY
				&& item.EQIL_PRICE == EQIL_PRICE
				&& item.EQIL_STOCK == EQIL_STOCK && item.price == price
				&& item.PROD_ELASTICITY == PROD_ELASTICITY
				&& item.stock == stock)
			return true;
		return false;
	}

	/**
	 * gets new price of item
	 * 
	 * @param amount
	 *            price of item
	 * @return float
	 */
	private float getNewPrice(float amount) {
		float temp, price = this.price;
		amount += stock - EQIL_STOCK;
		do {
			temp = consumption(price) - production(price) - amount;
			temp /= -CONS_ELASTICITY * Math.pow(EQIL_PRICE, PROD_ELASTICITY)
					* Math.pow(price, CONS_ELASTICITY - 1) + PROD_ELASTICITY
					* Math.pow(EQIL_PRICE, CONS_ELASTICITY)
					* Math.pow(price, PROD_ELASTICITY - 1);
			temp += price;
			if (Math.abs(price - temp) < 0.00001) {
				break;
			}
			price = temp;
		} while (true);
		return price;
	}

	/**
	 * updates the stock and price level to the next iteration (turn). Should be
	 * called once every turn.
	 * 
	 * @return true if successful
	 */
	public boolean update() {
		if (Math.abs(price - EQIL_PRICE) < 0.001) {
			return true;
		}
		float change = (production(price) - consumption(price)) * STOCK_RATIO;
		price = getNewPrice(change);
		stock += change;
		return true;
	}

	/**
	 * buys "amount" items from the market
	 * 
	 * @param amount
	 * @return the total price of the transaction
	 */
	public Float buy(int amount) {
		if (amount < 0 || amount > stock - 500) {
			return 0f;
		}
		float price = getBuyingPrice(amount);
		stock -= amount;
		this.price = getNewPrice(-amount);
		return price;
	}

	/**
	 * sells "amount" items to the market
	 * 
	 * @param amount
	 * @return the total price of the transaction
	 */
	public Float sell(int amount) {
		if (amount < 0) {
			return 0f;
		}
		float price = getSellingPrice(amount);
		stock += amount;
		this.price = getNewPrice(amount);
		return price;
	}
}