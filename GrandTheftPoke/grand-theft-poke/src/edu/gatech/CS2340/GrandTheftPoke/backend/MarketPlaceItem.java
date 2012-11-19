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
	
	private final float EQIL_PRICE, EQIL_STOCK, CONS_ELASTICITY,
						PROD_ELASTICITY, STOCK_RATIO;
	
	private float price, stock;
	
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
		EQIL_PRICE = price * 100;
		this.price = EQIL_PRICE;
		EQIL_STOCK = stock + 500;
		this.stock = EQIL_STOCK;
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
		return price / 100f; // probably a better way to do
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
		return price / 100f; 
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
		return price / 100f; 
	}

	/**
	 * The current stock level
	 * 
	 * @return the stock
	 */
	public Integer getStock() {
		return (int) Math.floor(stock - 500);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(CONS_ELASTICITY);
		result = prime * result + Float.floatToIntBits(EQIL_PRICE);
		result = prime * result + Float.floatToIntBits(EQIL_STOCK);
		result = prime * result + Float.floatToIntBits(PROD_ELASTICITY);
		result = prime * result + Float.floatToIntBits(STOCK_RATIO);
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + Float.floatToIntBits(stock);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MarketPlaceItem)) {
			return false;
		}
		MarketPlaceItem other = (MarketPlaceItem) obj;
		if (Float.floatToIntBits(CONS_ELASTICITY) != Float
				.floatToIntBits(other.CONS_ELASTICITY)) {
			return false;
		}
		if (Float.floatToIntBits(EQIL_PRICE) != Float
				.floatToIntBits(other.EQIL_PRICE)) {
			return false;
		}
		if (Float.floatToIntBits(EQIL_STOCK) != Float
				.floatToIntBits(other.EQIL_STOCK)) {
			return false;
		}
		if (Float.floatToIntBits(PROD_ELASTICITY) != Float
				.floatToIntBits(other.PROD_ELASTICITY)) {
			return false;
		}
		if (Float.floatToIntBits(STOCK_RATIO) != Float
				.floatToIntBits(other.STOCK_RATIO)) {
			return false;
		}
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price)) {
			return false;
		}
		if (Float.floatToIntBits(stock) != Float.floatToIntBits(other.stock)) {
			return false;
		}
		return true;
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
	 * @return the total price of the transaction
	 */
	public Float buy(int amount) {
		if (amount < 0 || amount > stock - 500) {
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