package edu.gatech.CS2340.GrandTheftPoke.tests;

import static org.junit.Assert.*;
import java.util.HashMap;
import org.junit.Test;

import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Wallet;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;


public class WalletTest extends junit.framework.TestCase {
	private final float AMOUNT = 100;
	private Wallet wallet= new Wallet(AMOUNT);;
	private GlobalItemReference items;
	private MarketPlace myMarket;
	private float price, newAmount;

	/**
	 * toString
	 * @return the name of the class
	 */
	@Override
	public String toString() {
		return "WalletTest";
	}
	
	
	@Test
	public void testGetMoney(){
		assertEquals(AMOUNT, wallet.getMoney());
	}
	public void setup(){
		items = new GlobalItemReference();
		
		HashMap<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>(); 
		//create some stock
		myStock.put(items.getStrengthRoid(), new MarketPlaceItem(1500f, 15f));
		myStock.put(items.getTradeRoid(), new MarketPlaceItem(5000f, 5f));
		
				myMarket = new MarketPlace(myStock);
		
	}
	@Test
	public void testUpdateMoney(){
		setup();
		MarketPlaceItem testitem = (MarketPlaceItem) myMarket.getStock().get(items.getStrengthRoid());
		price = testitem.getPrice();
		wallet.updateMoney(-price);
		newAmount = AMOUNT - price;
		assertEquals(wallet.getMoney(),newAmount);
	}
	@Test
	public void testCheckAmount(){
		setup();
		float money;
		boolean test;
		price = ((MarketPlaceItem) myMarket.getStock().get(items.getTradeRoid())).getPrice();
		money = wallet.getMoney();
		test = wallet.checkAmount(price);
		assertEquals((money>=price),test);
	}
}
