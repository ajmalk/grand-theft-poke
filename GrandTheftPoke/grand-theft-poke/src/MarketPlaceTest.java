import edu.gatech.CS2340.GrandTheftPoke.*;
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
 
	}

	@Test
	public void test() {
	       myMarket.buy(new HealthPotion(), 5);
	       //will add some tests later...having some issues
	       

	}

}
