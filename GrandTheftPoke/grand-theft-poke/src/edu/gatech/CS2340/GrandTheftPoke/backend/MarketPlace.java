package edu.gatech.CS2340.GrandTheftPoke.backend;

import java.util.HashMap;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

/**
 * 
 * @author Team Rocket
 */
@XStreamAlias("Market")
public class MarketPlace {
	//@XStreamImplicit(itemFieldName="Item")
	HashMap<Item, MarketPlaceItem> stock;

	/**
	 * Constructor that creates the market place for each town
	 * 
	 * @param stock
	 *            , a hashmap of Items to their MarketPlaceItem economic models
	 */
	public MarketPlace(HashMap<Item, MarketPlaceItem> stock) {
		this.stock = stock;
	}


	/**
	 * 
	 * @param good
	 * @param quantity
	 * @return
	 */
	public float buy(Item good, int quantity) {
		if (stock.containsKey(good)) {
			MarketPlaceItem model = (MarketPlaceItem) stock.get(good);
			return model.buy(quantity);
		}
		return 0;
	}

	/**
	 * 
	 * @param good
	 * @param quantity
	 * @return
	 */
	public float sell(Item good, int quantity) {
		if (stock.containsKey(good)) {
			MarketPlaceItem model = (MarketPlaceItem) stock.get(good);
			return model.sell(quantity);
		}
		return 0;

	}

	/**
	 * 
	 * @return
	 */
	public HashMap getStock() {
		return stock;
	}
}
