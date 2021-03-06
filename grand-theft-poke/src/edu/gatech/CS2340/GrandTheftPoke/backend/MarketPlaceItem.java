/**
 * MarketPlaceItem.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Represents the price and stock properties of an item in the marketplace
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
@XStreamAlias("Stock")
public class MarketPlaceItem {

	/**
	 * Field STOCK_RATIO.
	 */
	/**
	 * Field PROD_ELASTICITY.
	 */
	/**
	 * Field CONS_ELASTICITY.
	 */
	/**
	 * Field EQIL_STOCK.
	 */
	/**
	 * Field EQIL_PRICE.
	 */
	private final float EQIL_PRICE, EQIL_STOCK, CONS_ELASTICITY,
			PROD_ELASTICITY, STOCK_RATIO;

	/**
	 * Field stock.
	 */
	/**
	 * Field price.
	 */
	private float price, stock;

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "MarketPlaceItem [price=" + price + ", stock=" + stock
				+ ", EQIL_PRICE=" + EQIL_PRICE + ", EQIL_STOCK=" + EQIL_STOCK
				+ ", CONS_ELASTICITY=" + CONS_ELASTICITY + ", PROD_ELASTICITY="
				+ PROD_ELASTICITY + ", STOCK_RATIO=" + STOCK_RATIO + "]";
	}

	/**
	 * Creates a MarketPlaceItem
	 * 
	 * @param price
	 *            the equilibrium price of the item in this marketplace
	 * @param stock
	 */
	public MarketPlaceItem(Float price, Float stock) {
		EQIL_PRICE = price * 100;// scaling price
		this.price = EQIL_PRICE;
		EQIL_STOCK = stock + 500;// scaling stock
		this.stock = EQIL_STOCK;
		CONS_ELASTICITY = -1f;// scaling elasticity
		PROD_ELASTICITY = 2f;// scaling elasticity
		STOCK_RATIO = 0.1f;// scaling ratio
	}

	/**
	 * returns the current retail price
	 * 
	 * 
	 * @return the price truncated to 2 decimal places
	 */
	public Float getPrice() {
		return price / 100f; // probably a better way to do
								// this
	}

	/**
	 * returns the total price if buying a certain amount of the item
	 * 
	 * @param amount
	 * 
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
		return price / 100f; // scaling back to normal
	}

	/**
	 * returns the total price if selling a certain amount of the item
	 * 
	 * @param amount
	 * 
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
		return price / 100f; // scalingn back to normal
	}

	/**
	 * The current stock level
	 * 
	 * 
	 * @return the stock
	 */
	public Integer getStock() {
		return (int) (stock - 500);// scaling stock
	}

	/**
	 * checks consumption
	 * 
	 * @param price
	 *            the price
	 * 
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
	 * 
	 * @return float
	 */
	public float production(float price) {
		return (float) Math.pow((price / EQIL_PRICE), PROD_ELASTICITY)
				* EQIL_STOCK;
	}

	/**
	 * gets new price of item
	 * 
	 * @param amount
	 *            price of item
	 * 
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
			// if (Math.abs(price - temp) < 0.00001) {
			// break;
			// }
			price = temp;
		} while (Math.abs(price - temp) > 0.00001);// checking for virtually
													// zero
		return price;
	}

	/**
	 * updates the stock and price level to the next iteration (turn). Should be
	 * called once every turn.
	 * 
	 * 
	 * @return true if successful
	 */
	public boolean update() {
		if (Math.abs(price - EQIL_PRICE) < 0.001) {// checking for virtually
													// zero
			return true;
		}
		final float change = (production(price) - consumption(price))
				* STOCK_RATIO;
		price = getNewPrice(change);
		stock += change;
		return true;
	}

	/**
	 * buys "amount" items from the market
	 * 
	 * @param amount
	 * 
	 * @return the total price of the transaction
	 */
	public Float buy(int amount) {
		if (amount < 0 || amount > stock - 500) {// checking for buying stock
			return 0f;
		}
		final float price = getBuyingPrice(amount);
		stock -= amount;
		this.price = getNewPrice(-amount);
		return price;
	}

	/**
	 * sells "amount" items to the market
	 * 
	 * @param amount
	 * 
	 * @return the total price of the transaction
	 */
	public Float sell(int amount) {
		if (amount < 0) {
			return 0f;
		}
		final float price = getSellingPrice(amount);
		stock += amount;
		this.price = getNewPrice(amount);
		return price;
	}
}