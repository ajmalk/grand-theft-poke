package edu.gatech.CS2340.GrandTheftPoke.backend.persons;

import java.util.HashMap;
import java.util.Map;

import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

/**
 * Represents a Trader
 * 
 * @author Team Rocket
 * @version 1.0
 * 
 */
public class Trader extends Person {

	/**
	 * Field personalMarket.
	 */
	private MarketPlace personalMarket;
	
	/**
	 * Field itemsInstance.
	 */
	private final GlobalItemReference itemsInstance;

	/**
	 * @param name
	 * @param strength
	 * @param agility
	 * @param trade
	 * @param stamina
	 * @param health
	 * @param range
	 * @param capacity
	 * @param money
	 * @param theMap
	 * @param itemsInstance
	 */
	public Trader(String name, int strength, int agility, int trade,
			int stamina, int health, int range, int capacity, Float money,
			GameMap theMap, GlobalItemReference itemsInstance) {
		super(name, strength, agility, trade, stamina, health, range, capacity,
				money, theMap);

		super.setCurrent(theMap.getRandomTown());
		this.itemsInstance = itemsInstance;
	}

	/**
	 * initializes market
	 */
	public void initializeMarket() {
	
		final Map<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
		myStock.put(
				itemsInstance.getHealthPotion(),
				new MarketPlaceItem(10f, (float) (getBackpack()
						.getAmount(itemsInstance.getHealthPotion()))));
		myStock.put(
				itemsInstance.getHealthVitamin(),
				new MarketPlaceItem(750f, (float) (getBackpack()
						.getAmount(itemsInstance.getHealthVitamin()))));
		myStock.put(
				itemsInstance.getAgilityVitamin(),
				new MarketPlaceItem(850f, (float) (getBackpack()
						.getAmount(itemsInstance.getAgilityVitamin()))));
		myStock.put(
				itemsInstance.getStrengthVitamin(),
				new MarketPlaceItem(1000f, (float) (getBackpack()
						.getAmount(itemsInstance.getStrengthVitamin()))));
		myStock.put(
				itemsInstance.getStaminaVitamin(),
				new MarketPlaceItem(500f, (float) (getBackpack()
						.getAmount(itemsInstance.getStaminaVitamin()))));
		myStock.put(
				itemsInstance.getTradeVitamin(),
				new MarketPlaceItem(600f, (float) (getBackpack()
						.getAmount(itemsInstance.getTradeVitamin()))));
		myStock.put(itemsInstance.getRepel(), new MarketPlaceItem(250f,
				(float) (getBackpack().getAmount(itemsInstance.getRepel()))));
		myStock.put(itemsInstance.getSquirtle(), new MarketPlaceItem(2500f,
				(float) (getBackpack().getAmount(itemsInstance.getSquirtle()))));
		myStock.put(
				itemsInstance.getCharizard(),
				new MarketPlaceItem(3000f, (float) (getBackpack()
						.getAmount(itemsInstance.getCharizard()))));
		myStock.put(itemsInstance.getPikachu(), new MarketPlaceItem(4500f,
				(float) (getBackpack().getAmount(itemsInstance.getPikachu()))));
		myStock.put(
				itemsInstance.getJigglyPuff(),
				new MarketPlaceItem(500f, (float) (getBackpack()
						.getAmount(itemsInstance.getJigglyPuff()))));
		myStock.put(itemsInstance.getArcanine(), new MarketPlaceItem(2000f,
				(float) (getBackpack().getAmount(itemsInstance.getArcanine()))));
		myStock.put(
				itemsInstance.getHealthRoid(),
				new MarketPlaceItem(2750f, (float) (getBackpack()
						.getAmount(itemsInstance.getHealthRoid()))));
		myStock.put(
				itemsInstance.getAgilityRoid(),
				new MarketPlaceItem(2500f, (float) (getBackpack()
						.getAmount(itemsInstance.getAgilityRoid()))));
		myStock.put(
				itemsInstance.getStrengthRoid(),
				new MarketPlaceItem(3000f, (float) (getBackpack()
						.getAmount(itemsInstance.getStrengthRoid()))));
		myStock.put(
				itemsInstance.getTradeRoid(),
				new MarketPlaceItem(2000f, (float) (getBackpack()
						.getAmount(itemsInstance.getTradeRoid()))));
		final MarketPlace myMarket = new MarketPlace(myStock);

		personalMarket = myMarket;
	}

	/**
	
	 * @return personalMarket */
	public MarketPlace getMarket() {
		return personalMarket;
	}
}
