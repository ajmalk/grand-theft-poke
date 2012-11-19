package edu.gatech.CS2340.GrandTheftPoke.backend.Towns;

import java.util.HashMap;
import java.util.Map;

import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlaceItem;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

/**
 * Implementation of Town Factory
 * 
 * @author Team Rocket
 * 
 */
public class TownFactoryImplementation implements TownFactory {

	private GlobalItemReference itemsInstance;

	/**
	 * @param theReference
	 *            globalItemReference for use
	 */
	public TownFactoryImplementation(GlobalItemReference theReference) {
		itemsInstance = theReference;
	}

	@Override
	public Town makePalletTown() {
		Map<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
		myStock.put(itemsInstance.getHealthPotion(), new MarketPlaceItem(10f,
				10f));
		myStock.put(itemsInstance.getHealthVitamin(), new MarketPlaceItem(750f,
				0f));
		myStock.put(itemsInstance.getAgilityVitamin(), new MarketPlaceItem(
				850f, 0f));
		myStock.put(itemsInstance.getStrengthVitamin(), new MarketPlaceItem(
				1000f, 0f));
		myStock.put(itemsInstance.getStaminaVitamin(), new MarketPlaceItem(
				500f, 0f));
		myStock.put(itemsInstance.getTradeVitamin(), new MarketPlaceItem(600f,
				0f));
		myStock.put(itemsInstance.getRepel(), new MarketPlaceItem(250f, 5f));
		myStock.put(itemsInstance.getSquirtle(), new MarketPlaceItem(2500f, 0f));
		myStock.put(itemsInstance.getCharizard(),
				new MarketPlaceItem(3000f, 5f));
		myStock.put(itemsInstance.getPikachu(), new MarketPlaceItem(4500f, 0f));
		myStock.put(itemsInstance.getJigglyPuff(),
				new MarketPlaceItem(500f, 0f));
		myStock.put(itemsInstance.getArcanine(), new MarketPlaceItem(2000f, 0f));
		myStock.put(itemsInstance.getHealthRoid(), new MarketPlaceItem(2750f,
				0f));
		myStock.put(itemsInstance.getAgilityRoid(), new MarketPlaceItem(2500f,
				0f));
		myStock.put(itemsInstance.getStrengthRoid(), new MarketPlaceItem(3000f,
				0f));
		myStock.put(itemsInstance.getTradeRoid(),
				new MarketPlaceItem(2000f, 0f));
		MarketPlace myMarket = new MarketPlace(myStock);
		Town myTown = new Town("Pallet Town", myMarket);
		myTown.setImage("pallet-town");

		return myTown;
	}

	@Override
	public Town makeViridianCity() {
		Map<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
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
		MarketPlace myMarket = new MarketPlace(myStock);
		Town myTown = new Town("Viridian City", myMarket);
		myTown.setImage("viridian-city");

		return myTown;

	}

	@Override
	public Town makePewterCity() {
		Map<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
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
		MarketPlace myMarket = new MarketPlace(myStock);
		Town myTown = new Town("Pewter City", myMarket);
		myTown.setImage("pewter-city");

		return myTown;
	}

	@Override
	public Town makeCeruleanCity() {
		Map<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
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
		MarketPlace myMarket = new MarketPlace(myStock);
		Town myTown = new Town("Cerulean City", myMarket);
		myTown.setImage("cerulean-city");

		return myTown;
	}

	@Override
	public Town makeSaffronCity() {
		Map<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
		myStock.put(itemsInstance.getHealthPotion(), new MarketPlaceItem(30f,
				30f));
		myStock.put(itemsInstance.getHealthVitamin(), new MarketPlaceItem(
				1000f, 30f));
		myStock.put(itemsInstance.getAgilityVitamin(), new MarketPlaceItem(
				1100f, 30f));
		myStock.put(itemsInstance.getStrengthVitamin(), new MarketPlaceItem(
				1250f, 30f));
		myStock.put(itemsInstance.getStaminaVitamin(), new MarketPlaceItem(
				750f, 30f));
		myStock.put(itemsInstance.getTradeVitamin(), new MarketPlaceItem(850f,
				30f));
		myStock.put(itemsInstance.getRepel(), new MarketPlaceItem(450f, 15f));
		// myStock.put(new Pokeball(), new MarketPlaceItem());
		myStock.put(itemsInstance.getSquirtle(),
				new MarketPlaceItem(2750f, 15f));
		myStock.put(itemsInstance.getCharizard(), new MarketPlaceItem(3250f,
				15f));
		myStock.put(itemsInstance.getPikachu(), new MarketPlaceItem(4750f, 15f));
		myStock.put(itemsInstance.getJigglyPuff(), new MarketPlaceItem(750f,
				15f));
		myStock.put(itemsInstance.getArcanine(),
				new MarketPlaceItem(2250f, 15f));
		myStock.put(itemsInstance.getHealthRoid(), new MarketPlaceItem(3000f,
				15f));
		myStock.put(itemsInstance.getAgilityRoid(), new MarketPlaceItem(2750f,
				15f));
		myStock.put(itemsInstance.getStrengthRoid(), new MarketPlaceItem(3250f,
				15f));
		myStock.put(itemsInstance.getTradeRoid(), new MarketPlaceItem(2250f,
				15f));
		MarketPlace myMarket = new MarketPlace(myStock);
		Town myTown = new Town("Saffron City", myMarket);
		myTown.setImage("saffron-city");

		return myTown;
	}

	@Override
	public Town makeCeladonCity() {
		Map<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
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
		MarketPlace myMarket = new MarketPlace(myStock);
		Town myTown = new Town("Celadon City", myMarket);
		myTown.setImage("celadon-city");
		return myTown;
	}

	@Override
	public Town makeLavenderTown() {
		HashMap<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
		myStock.put(itemsInstance.getHealthPotion(), new MarketPlaceItem(10f,
				10f));
		myStock.put(itemsInstance.getHealthVitamin(), new MarketPlaceItem(750f,
				0f));
		myStock.put(itemsInstance.getAgilityVitamin(), new MarketPlaceItem(
				850f, 0f));
		myStock.put(itemsInstance.getStrengthVitamin(), new MarketPlaceItem(
				1000f, 0f));
		myStock.put(itemsInstance.getStaminaVitamin(), new MarketPlaceItem(
				500f, 0f));
		myStock.put(itemsInstance.getTradeVitamin(), new MarketPlaceItem(600f,
				0f));
		myStock.put(itemsInstance.getRepel(), new MarketPlaceItem(250f, 5f));
		myStock.put(itemsInstance.getSquirtle(), new MarketPlaceItem(2500f, 0f));
		myStock.put(itemsInstance.getCharizard(),
				new MarketPlaceItem(3000f, 0f));
		myStock.put(itemsInstance.getPikachu(), new MarketPlaceItem(4500f, 0f));
		myStock.put(itemsInstance.getJigglyPuff(),
				new MarketPlaceItem(500f, 0f));
		myStock.put(itemsInstance.getArcanine(), new MarketPlaceItem(2000f, 0f));
		myStock.put(itemsInstance.getHealthRoid(), new MarketPlaceItem(2750f,
				0f));
		myStock.put(itemsInstance.getAgilityRoid(), new MarketPlaceItem(2500f,
				0f));
		myStock.put(itemsInstance.getStrengthRoid(), new MarketPlaceItem(3000f,
				0f));
		myStock.put(itemsInstance.getTradeRoid(),
				new MarketPlaceItem(2000f, 0f));
		System.out
				.println(myStock.containsKey(itemsInstance.getHealthPotion()));
		MarketPlace myMarket = new MarketPlace(myStock);
		Town myTown = new Town("Lavender Town", myMarket);
		myTown.setImage("lavender-town");

		return myTown;
	}

	@Override
	public Town makeVermillionCity() {
		HashMap<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
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
		MarketPlace myMarket = new MarketPlace(myStock);
		Town myTown = new Town("Vermillion City", myMarket);
		myTown.setImage("vermillion-city");

		return myTown;
	}

	@Override
	public Town makeFuchsiaCity() {
		HashMap<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
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
		MarketPlace myMarket = new MarketPlace(myStock);
		Town myTown = new Town("Fuchsia City", myMarket);
		myTown.setImage("fuchsia-city");

		return myTown;
	}

	@Override
	public Town makeCinnabarIsland() {
		HashMap<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
		myStock.put(itemsInstance.getHealthPotion(), new MarketPlaceItem(10f,
				10f));
		myStock.put(itemsInstance.getHealthVitamin(), new MarketPlaceItem(750f,
				0f));
		myStock.put(itemsInstance.getAgilityVitamin(), new MarketPlaceItem(
				850f, 0f));
		myStock.put(itemsInstance.getStrengthVitamin(), new MarketPlaceItem(
				1000f, 0f));
		myStock.put(itemsInstance.getStaminaVitamin(), new MarketPlaceItem(
				500f, 0f));
		myStock.put(itemsInstance.getTradeVitamin(), new MarketPlaceItem(600f,
				0f));
		myStock.put(itemsInstance.getRepel(), new MarketPlaceItem(250f, 5f));
		// myStock.put(new Pokeball(), new MarketPlaceItem());
		myStock.put(itemsInstance.getSquirtle(), new MarketPlaceItem(2500f, 0f));
		myStock.put(itemsInstance.getCharizard(),
				new MarketPlaceItem(3000f, 0f));
		myStock.put(itemsInstance.getPikachu(), new MarketPlaceItem(4500f, 0f));
		myStock.put(itemsInstance.getJigglyPuff(),
				new MarketPlaceItem(500f, 0f));
		myStock.put(itemsInstance.getArcanine(), new MarketPlaceItem(2000f, 0f));
		myStock.put(itemsInstance.getHealthRoid(), new MarketPlaceItem(2750f,
				0f));
		myStock.put(itemsInstance.getAgilityRoid(), new MarketPlaceItem(2500f,
				0f));
		myStock.put(itemsInstance.getStrengthRoid(), new MarketPlaceItem(3000f,
				0f));
		myStock.put(itemsInstance.getTradeRoid(),
				new MarketPlaceItem(2000f, 0f));
		MarketPlace myMarket = new MarketPlace(myStock);
		Town myTown = new Town("Cinnabar Island", myMarket);
		myTown.setImage("cinnabar-island.png");

		return myTown;
	}

	@Override
	public Town makePowerPlant() {
		HashMap<Item, MarketPlaceItem> myStock = new HashMap<Item, MarketPlaceItem>();
		myStock.put(itemsInstance.getHealthPotion(), new MarketPlaceItem(10f,
				10f));
		myStock.put(itemsInstance.getHealthVitamin(), new MarketPlaceItem(750f,
				0f));
		myStock.put(itemsInstance.getAgilityVitamin(), new MarketPlaceItem(
				850f, 0f));
		myStock.put(itemsInstance.getStrengthVitamin(), new MarketPlaceItem(
				1000f, 0f));
		myStock.put(itemsInstance.getStaminaVitamin(), new MarketPlaceItem(
				500f, 0f));
		myStock.put(itemsInstance.getTradeVitamin(), new MarketPlaceItem(600f,
				0f));
		myStock.put(itemsInstance.getRepel(), new MarketPlaceItem(250f, 5f));
		// myStock.put(new Pokeball(), new MarketPlaceItem());
		myStock.put(itemsInstance.getSquirtle(), new MarketPlaceItem(2500f, 0f));
		myStock.put(itemsInstance.getCharizard(),
				new MarketPlaceItem(3000f, 0f));
		myStock.put(itemsInstance.getPikachu(), new MarketPlaceItem(4500f, 0f));
		myStock.put(itemsInstance.getJigglyPuff(),
				new MarketPlaceItem(500f, 0f));
		myStock.put(itemsInstance.getArcanine(), new MarketPlaceItem(2000f, 0f));
		myStock.put(itemsInstance.getHealthRoid(), new MarketPlaceItem(2750f,
				0f));
		myStock.put(itemsInstance.getAgilityRoid(), new MarketPlaceItem(2500f,
				0f));
		myStock.put(itemsInstance.getStrengthRoid(), new MarketPlaceItem(3000f,
				0f));
		myStock.put(itemsInstance.getTradeRoid(),
				new MarketPlaceItem(2000f, 0f));
		MarketPlace myMarket = new MarketPlace(myStock);
		Town myTown = new Town("Power Plant", myMarket);

		return myTown;
	}
}
