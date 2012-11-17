package edu.gatech.CS2340.GrandTheftPoke.backend.persons;

import java.util.HashMap;

import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

public class Trader extends Person {

	private MarketPlace personalMarket;
	HashMap<Item, MarketPlaceItem> stock;
	float tradeMultiplier;
	private GlobalItemReference itemsInstance;

	public Trader(String name, int strength, int agility, int trade,
			int stamina, int health, int range, int capacity, Float money,
			GameMap theMap, GlobalItemReference itemsInstance) {
		super(name, strength, agility, trade, stamina, health, range, capacity,
				money, theMap);

		super.setCurrent(theMap.getRandomTown());
		tradeMultiplier = 1;
		this.itemsInstance = itemsInstance;
	}

	public void compareTrade(Person other) {
		int theirTrade = other.getTrade();
		tradeMultiplier = (float) (getTrade()) / theirTrade;
	}

	public void initializeMarket() {
		/*
		 * Set<Item> marketStock = getBackpack().getContents().keySet();
		 * if(marketStock.isEmpty()) { personalMarket = new MarketPlace(new
		 * HashMap<Item, MarketPlaceItem>()); return; } for(Item i :
		 * marketStock) { MarketPlaceItem townModel =
		 * (MarketPlaceItem)getCurrent().getMarket().getStock().get(i);
		 * if(townModel != null) { stock.put(i, new
		 * MarketPlaceItem((townModel.getPrice()),
		 * (float)getBackpack().getContents().get(i))); } else { stock.put(i,
		 * new MarketPlaceItem(100f,
		 * (float)getBackpack().getContents().get(i))); } }
		 */

		HashMap<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
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
		MarketPlace myMarket = new MarketPlace(myStock);

		personalMarket = myMarket;
	}

	public MarketPlace getMarket() {
		return personalMarket;
	}

	public boolean buy(Person other, Item desiredGood, int quantity) {
		float price;
		if ((personalMarket.getStock().containsKey(desiredGood))
				&& other.getBackpack().getContents().containsKey(desiredGood)) {
			price = (1 / tradeMultiplier)
					* ((MarketPlaceItem) (personalMarket.getStock()
							.get(desiredGood))).getBuyingPrice(quantity);
		} else if (other.getBackpack().getContents().containsKey(desiredGood)) {
			price = (1 / tradeMultiplier) * 100f;
		} else {
			price = 0f;
		}

		if (price != 0) {
			if (getWallet().checkAmount(price)) {
				if (getBackpack().checkCapacity(desiredGood, quantity)) {
					personalMarket.buy(desiredGood, quantity);
					getWallet().updateMoney(-price);
					getBackpack().place(desiredGood, quantity);
					other.getBackpack().remove(desiredGood, quantity);
					return true;
				}
			}
		}

		return false;

	}

	public boolean sell(Person other, Item desiredGood, int quantity) {
		if (getBackpack().checkContents(desiredGood, quantity)) {
			float price = (tradeMultiplier)
					* personalMarket.sell(desiredGood, quantity);
			getWallet().updateMoney(price);
			getBackpack().remove(desiredGood, quantity);
			other.getBackpack().place(desiredGood, quantity);
			return true;
		}
		return false;
	}

}
