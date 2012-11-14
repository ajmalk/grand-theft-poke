package edu.gatech.CS2340.GrandTheftPoke.backend.persons;

import java.util.HashMap;
import java.util.Set;

import edu.gatech.CS2340.GrandTheftPoke.backend.GameMap;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

public class Trader extends Person {
	
	private MarketPlace personalMarket;
	HashMap<Item, MarketPlaceItem> stock;
	float tradeMultiplier;
	
	public Trader(String name, int strength, int agility, int trade, int stamina, int health, int range, int capacity, Float money, GameMap theMap) {
		super(name, strength, agility, trade,
				stamina, health, range, capacity, money,
				theMap);
		
		super.setCurrent(theMap.getRandomTown());
		tradeMultiplier = 1;
	}
	
	public void compareTrade(Person other) {
		int theirTrade = other.getTrade();
		tradeMultiplier = getTrade()/theirTrade;
	}
	
	public void initializeMarket() {
		Set<Item> marketStock = getBackpack().getContents().keySet();
		
		for(Item i : marketStock) {
			MarketPlaceItem townModel = (MarketPlaceItem)getCurrent().getMarket().getStock().get(i);
			if(townModel != null) {
				stock.put(i, new MarketPlaceItem((townModel.getPrice()), getBackpack().getContents().get(i)));
			} else {
				stock.put(i, new MarketPlaceItem(100f, getBackpack().getContents().get(i)));
			}
		}
		
		personalMarket = new MarketPlace(stock);
	}
	
	public MarketPlace getMarket() {
		return personalMarket;
	}
	
	public boolean buy(Person other, Item desiredGood, int quantity) {
		float price;
		if((personalMarket.getStock().containsKey(desiredGood)) && other.getBackpack().getContents().containsKey(desiredGood)) {
			price = (float)(1/tradeMultiplier) * ((MarketPlaceItem) (personalMarket.getStock().get(desiredGood)))
					.getBuyingPrice(quantity);
		} else if(other.getBackpack().getContents().containsKey(desiredGood)){
			price = (float)(1/tradeMultiplier) * 100f;
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
			float price = (float)(tradeMultiplier) * personalMarket.sell(desiredGood, quantity);
			getWallet().updateMoney(price);
			getBackpack().remove(desiredGood, quantity);
			other.getBackpack().place(desiredGood, quantity);
			return true;
		}
		return false;
	}

}
