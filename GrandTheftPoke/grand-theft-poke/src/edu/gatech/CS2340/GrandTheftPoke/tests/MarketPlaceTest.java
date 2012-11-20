package edu.gatech.CS2340.GrandTheftPoke.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import edu.gatech.CS2340.GrandTheftPoke.backend.Main;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Player;

/**
 * This class tests the marketplace
 * 
 * @author Sagar Laud
 * @version 1.0
 * 
 */
public class MarketPlaceTest {
	private MarketPlace myMarket;

	private Person person;

	private GlobalItemReference itemsInstance;

	@Before
	public void setUp() {
		itemsInstance = new GlobalItemReference();

		final HashMap<Item, MarketPlaceItem> myStock = 
				new HashMap<Item, MarketPlaceItem>();
		myStock.put(itemsInstance.getHealthPotion(), new MarketPlaceItem(20f,
				20f));
		myStock.put(itemsInstance.getHealthVitamin(), new MarketPlaceItem(750f,
				20f));
		myStock.put(itemsInstance.getAgilityVitamin(), new MarketPlaceItem(
				850f, 20f));
		myStock.put(itemsInstance.getStrengthVitamin(), new MarketPlaceItem(
				1000f, 20f));
		myStock.put(itemsInstance.getStaminaVitamin(), new MarketPlaceItem(
				500f, 20f));
		myStock.put(itemsInstance.getTradeVitamin(), new MarketPlaceItem(600f,
				20f));
		myStock.put(itemsInstance.getRepel(), new MarketPlaceItem(350f, 10f));
		// myStock.put(new Pokeball(), new MarketPlaceItem());
		myStock.put(itemsInstance.getSquirtle(),
				new MarketPlaceItem(2500f, 10f));
		myStock.put(itemsInstance.getCharizard(), new MarketPlaceItem(3000f,
				10f));
		myStock.put(itemsInstance.getPikachu(), new MarketPlaceItem(4500f, 10f));
		myStock.put(itemsInstance.getJigglyPuff(), new MarketPlaceItem(500f,
				10f));
		myStock.put(itemsInstance.getArcanine(),
				new MarketPlaceItem(2000f, 10f));
		myStock.put(itemsInstance.getHealthRoid(), new MarketPlaceItem(2750f,
				10f));
		myStock.put(itemsInstance.getAgilityRoid(), new MarketPlaceItem(2500f,
				10f));
		myStock.put(itemsInstance.getStrengthRoid(), new MarketPlaceItem(3000f,
				10f));
		myStock.put(itemsInstance.getTradeRoid(), new MarketPlaceItem(2000f,
				10f));
		// System.out.println(myStock.containsKey(itemsInstance.getHealthPotion()));
		myMarket = new MarketPlace(myStock);
		person = new Player("Sagar", 4, 4, 4, 4, 100, 100, 10,
				Main.makeMap(new GlobalItemReference()));

	}

	@Test
	/**
	 * tests basic buy
	 */
	public void testBasicBuy() {
		System.out.println("price is now: "
				+ ((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getPrice());
		myMarket.buy(itemsInstance.getHealthPotion(), 5);
		System.out.println("price is now: "
				+ ((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getPrice());
		assertTrue(
				"You've made a mistake",
				(((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getStock().equals(new Integer(15))));
		System.out.println("/////////////////////////");
	}

	@Test
	/**
	 * tests basic sell
	 */
	public void testBasicSell() {
		System.out.println("price is now: "
				+ ((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getPrice());
		myMarket.sell(itemsInstance.getHealthPotion(), 5);
		System.out.println("price is now: "
				+ ((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getPrice());
		assertTrue(
				"You've made a mistake",
				(((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getStock().equals(new Integer(25))));
		System.out.println("/////////////////////////");
	}

	@Test
	/**
	 * tests buying and selling
	 */
	public void testBuyAndSell() {
		System.out.println("price is now: "
				+ ((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getPrice());
		final float bought = myMarket.buy(itemsInstance.getHealthPotion(), 5);
		System.out.println("price is now: "
				+ ((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getPrice());
		assertTrue(
				"You've made a mistake",
				(((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getStock().equals(new Integer(15))));

		System.out.println("-----------------------------------");

		System.out.println("price is now: "
				+ ((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getPrice());
		final float value = myMarket.sell(itemsInstance.getHealthPotion(), 5);
		System.out.println("price is now: "
				+ ((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getPrice());
		assertTrue("You've made a mistake", ((MarketPlaceItem) myMarket
				.getStock().get(itemsInstance.getHealthPotion())).getStock()
				.equals(new Integer(20)));

	}

	/**
	 * tests buying and selling with backpack
	 */
	@Test
	public void testBuyAndSellBackpack() {

		// test buying
		// assertTrue(p.getBackpack().getContents().isEmpty());
		final boolean buy1 = person.buy(myMarket, itemsInstance.getCharizard(),
				1);
		final boolean buy2 = person.buy(myMarket,
				itemsInstance.getHealthPotion(), 6);
		assertTrue(
				"You've made a mistake",
				(((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getCharizard())).getStock().equals(new Integer(9))));
		assertTrue(
				"You've made a mistake",
				(((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getStock().equals(new Integer(14))));
		assertTrue(
				"You've made a mistake",
				(person.getBackpack().checkContents(
						itemsInstance.getCharizard(), 1)));
		assertTrue(
				"You've made a mistake",
				(person.getBackpack().checkContents(
						itemsInstance.getHealthPotion(), 6)));
		final boolean buy3 = person
				.buy(myMarket, itemsInstance.getPikachu(), 1);
		assertTrue(
				"You've made a mistake",
				(((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getPikachu())).getStock().equals(new Integer(10))));
		assertFalse("You've made a mistake",
				(person.getBackpack().checkContents(itemsInstance.getPikachu(),
						1)));
		assertTrue(
				"You've made a mistake",
				(person.getBackpack().checkContents(
						itemsInstance.getCharizard(), 1)));
		// System.out.println(p.getWallet().getMoney());
		// assertEquals((int)p.getWallet().getMoney(), 2000);

		// test selling

		final boolean sell1 = person.sell(myMarket,
				itemsInstance.getCharizard(), 1);
		// code does not allow one to sell more than one has
		assertTrue(
				"You've made a mistake",
				(((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getCharizard())).getStock().equals(new Integer(10))));
		assertFalse(person.getBackpack().checkContents(
				itemsInstance.getCharizard(), 1));

		final boolean sell2 = person.sell(myMarket,
				itemsInstance.getHealthPotion(), 6);

		assertTrue(
				"You've made a mistake",
				(((MarketPlaceItem) myMarket.getStock().get(
						itemsInstance.getHealthPotion())).getStock().equals(new Integer(20))));
		assertFalse(
				"You've made a mistake",
				(person.getBackpack().checkContents(
						itemsInstance.getHealthPotion(), 6)));

	}

	@Override
	public String toString() {
		return "MarketPlaceTest";
	}

}
