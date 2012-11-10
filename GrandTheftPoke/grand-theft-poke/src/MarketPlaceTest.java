import edu.gatech.CS2340.GrandTheftPoke.backend.*;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.*;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.*;
import edu.gatech.CS2340.*;
import java.util.HashMap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MarketPlaceTest {
	MarketPlace myMarket;
	Person p;
	@Before
	public void setUp() throws Exception {
		GlobalItemReference itemsInstance = new GlobalItemReference();
		
		HashMap<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
        myStock.put(itemsInstance.getHealthPotion(), new MarketPlaceItem(20,20));
        myStock.put(itemsInstance.getHealthVitamin(), new MarketPlaceItem(750, 20));
        myStock.put(itemsInstance.getAgilityVitamin(), new MarketPlaceItem(850, 20));
        myStock.put(itemsInstance.getStrengthVitamin(), new MarketPlaceItem(1000, 20));
        myStock.put(itemsInstance.getStaminaVitamin(), new MarketPlaceItem(500, 20));
        myStock.put(itemsInstance.getTradeVitamin(), new MarketPlaceItem(600, 20));
        myStock.put(itemsInstance.getRepel(), new MarketPlaceItem(350, 10));
        //myStock.put(new Pokeball(), new MarketPlaceItem());
        myStock.put(itemsInstance.getSquirtle(), new MarketPlaceItem(2500, 10));
        myStock.put(itemsInstance.getCharizard(), new MarketPlaceItem(3000, 10));
        myStock.put(itemsInstance.getPikachu(), new MarketPlaceItem(4500, 10));
        myStock.put(itemsInstance.getJigglyPuff(), new MarketPlaceItem(500, 10));
        myStock.put(itemsInstance.getArcanine(), new MarketPlaceItem(2000, 10));
        myStock.put(itemsInstance.getHealthRoid(), new MarketPlaceItem(2750, 10));
        myStock.put(itemsInstance.getAgilityRoid(), new MarketPlaceItem(2500, 10));
        myStock.put(itemsInstance.getStrengthRoid(), new MarketPlaceItem(3000, 10));
        myStock.put(itemsInstance.getTradeRoid(), new MarketPlaceItem(2000, 10));
        //System.out.println(myStock.containsKey(itemsInstance.getHealthPotion()));
        myMarket = new MarketPlace(myStock);
        p = new Player("Sagar", 4, 4, 4, 4, 100, 100, 10, Main.makeMap(new GlobalItemReference()));

 
	}

	@Test
	public void testBasicBuy() {
		   System.out.println("price is now: "+((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getPrice());
	       myMarket.buy(new HealthPotion(), 5);
	       System.out.println("price is now: "+((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getPrice());
	       assertTrue(((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getStock().equals(15));
	       System.out.println("/////////////////////////");
	}
	
	@Test
	public void testBasicSell() {
		 System.out.println("price is now: "+((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getPrice());
	     myMarket.sell(new HealthPotion(), 5);
	     System.out.println("price is now: "+((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getPrice());
	     assertTrue(((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getStock().equals(25));
	       System.out.println("/////////////////////////");
	}

	@Test
	public void testBuyAndSell() {
		 System.out.println("price is now: "+((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getPrice());
	       myMarket.buy(new HealthPotion(), 5);
	       System.out.println("price is now: "+((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getPrice());
	       assertTrue(((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getStock().equals(15));
	       
	       System.out.println("-----------------------------------");
	       
	       
	  		 System.out.println("price is now: "+((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getPrice());
	  	     myMarket.sell(new HealthPotion(), 5);
	  	     System.out.println("price is now: "+((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getPrice());
	  	     assertTrue(((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getStock().equals(20));
	       
	}
	
	@Test
	public void testBuyAndSellBackpack() {

		//test buying 
		assertTrue(p.getBackpack().getContents().isEmpty());
		p.buy(myMarket, new Charizard(), 1);
		p.buy(myMarket, new HealthPotion(), 6);
		assertTrue(((MarketPlaceItem) myMarket.getStock().get(new Charizard())).getStock().equals(9));
		assertTrue(((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getStock().equals(14));
		assertTrue(p.getBackpack().checkContents(new Charizard(), 1));
		assertTrue(p.getBackpack().checkContents(new HealthPotion(), 6));
		p.buy(myMarket, new Pikachu(), 1);
		assertTrue(((MarketPlaceItem) myMarket.getStock().get(new Pikachu())).getStock().equals(10));
		assertFalse(p.getBackpack().checkContents(new Pikachu(), 1));
		assertTrue(p.getBackpack().checkContents(new Charizard(), 1));
		//System.out.println(p.getWallet().getMoney());
		//assertEquals((int)p.getWallet().getMoney(), 2000);
		
		//test selling
		
		p.sell(myMarket, new Charizard(), 1);
		//code does not allow one to sell more than one has
		assertTrue(((MarketPlaceItem) myMarket.getStock().get(new Charizard())).getStock().equals(10));
		assertFalse(p.getBackpack().checkContents(new Charizard(), 1));
		
		p.sell(myMarket, new HealthPotion(), 6);

		assertTrue(((MarketPlaceItem) myMarket.getStock().get(new HealthPotion())).getStock().equals(20));
		assertFalse(p.getBackpack().checkContents(new HealthPotion(), 6));
		
	}
	
	
}
