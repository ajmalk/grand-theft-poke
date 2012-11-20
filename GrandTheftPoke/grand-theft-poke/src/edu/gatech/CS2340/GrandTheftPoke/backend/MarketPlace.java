package edu.gatech.CS2340.GrandTheftPoke.backend;

import java.util.Iterator;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

/**
 * represents a marketPlace
 * 
 * @author Team Rocket
 * @version 1.0
 */
@XStreamAlias("Market")
public class MarketPlace {
	/**
	 * Method hashCode.
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		return result;
	}

	/**
	 * Method equals.
	 * @param obj Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MarketPlace)) {
			return false;
		}
		final MarketPlace other = (MarketPlace) obj;
		if (stock == null) {
			if (other.stock != null) {
				return false;
			}
		} else if (!stock.equals(other.stock)) {
			return false;
		}
		return true;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "MarketPlace [stock=" + stock + "]";
	}

	// @XStreamImplicit(itemFieldName="Item")
	/**
	 * Field stock.
	 */
	private final Map<Item, MarketPlaceItem> stock;

	/**
	 * Constructor that creates the market place for each town
	 * 
	 * @param stock
	 *            a hash map of Items to their MarketPlaceItem economic models
	 */
	public MarketPlace(Map<Item, MarketPlaceItem> stock) {
		this.stock = stock;
	}

	/**
	 * buys an item
	 * 
	 * @param good
	 *            the good to be bought
	 * @param quantity
	 *            quantity to be bought
	
	 * @return float */
	public float buy(Item good, int quantity) {
		if (stock.containsKey(good)) {
			final MarketPlaceItem model = stock.get(good);
			return model.buy(quantity);
		}
		return 0;
	}

	/**
	 * sells an item
	 * 
	 * @param good
	 *            good to be sold
	 * @param quantity
	 *            quantity to be sold
	
	 * @return float */
	public float sell(Item good, int quantity) {
		if (stock.containsKey(good)) {
			final MarketPlaceItem model = stock.get(good);
			return model.sell(quantity);
		}
		return 0;

	}

	/**
	 * getsStock
	 * 
	
	 * @return stock the stock of the market */

	public Map getStock() {
		return stock;
	}

	/**
	 * marketPlace Iterator
	 * 
	
	 * @return Iterator iterator */
	public Iterator iterator() {
		return stock.entrySet().iterator();

	}
}
