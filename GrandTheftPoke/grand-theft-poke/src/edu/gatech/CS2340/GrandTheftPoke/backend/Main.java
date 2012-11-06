package edu.gatech.CS2340.GrandTheftPoke.backend;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.TownFactoryImplementation;
import java.util.Iterator;
import java.util.Set;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		GlobalItemReference theReference = new GlobalItemReference();
		GameMap testMap = Main.makeMap(theReference);
		// testMap.Dijkstras(); ragequit
		testMarketPlace(testMap, theReference);
		testMovement(testMap);
	}

	public static GameMap makeMap(GlobalItemReference theReference) {
		theReference = new GlobalItemReference();
		TownFactoryImplementation townGenerator = new TownFactoryImplementation(
				theReference);

		Town palletTown = townGenerator.makePalletTown();
		Town viridianCity = townGenerator.makeViridianCity();
		Town pewterCity = townGenerator.makePewterCity();
		Town ceruleanCity = townGenerator.makeCeruleanCity();
		Town vermillionCity = townGenerator.makeVermillionCity();
		Town lavenderTown = townGenerator.makeLavenderTown();
		Town celadonCity = townGenerator.makeCeladonCity();
		Town fuchsiaCity = townGenerator.makeFuchsiaCity();
		Town saffronCity = townGenerator.makeSaffronCity();
		Town cinnabarIsland = townGenerator.makeCinnabarIsland();
		Town powerPlant = townGenerator.makePowerPlant();

		palletTown.addConnection(new Path(cinnabarIsland, 100));
		palletTown.addConnection(new Path(viridianCity, 10));

		viridianCity.addConnection(new Path(palletTown, 10));
		viridianCity.addConnection(new Path(pewterCity, 20));

		pewterCity.addConnection(new Path(viridianCity, 20));
		pewterCity.addConnection(new Path(ceruleanCity, 50));

		ceruleanCity.addConnection(new Path(pewterCity, 50));
		ceruleanCity.addConnection(new Path(powerPlant, 30));
		ceruleanCity.addConnection(new Path(saffronCity, 20));

		powerPlant.addConnection(new Path(ceruleanCity, 30));

		saffronCity.addConnection(new Path(ceruleanCity, 20));
		saffronCity.addConnection(new Path(celadonCity, 10));
		saffronCity.addConnection(new Path(lavenderTown, 20));
		saffronCity.addConnection(new Path(vermillionCity, 20));

		celadonCity.addConnection(new Path(saffronCity, 10));
		celadonCity.addConnection(new Path(fuchsiaCity, 50));

		lavenderTown.addConnection(new Path(saffronCity, 20));
		lavenderTown.addConnection(new Path(vermillionCity, 40));
		lavenderTown.addConnection(new Path(fuchsiaCity, 120));

		vermillionCity.addConnection(new Path(saffronCity, 20));
		vermillionCity.addConnection(new Path(lavenderTown, 40));
		vermillionCity.addConnection(new Path(fuchsiaCity, 80));

		fuchsiaCity.addConnection(new Path(celadonCity, 50));
		fuchsiaCity.addConnection(new Path(lavenderTown, 120));
		fuchsiaCity.addConnection(new Path(vermillionCity, 80));
		fuchsiaCity.addConnection(new Path(cinnabarIsland, 100));

		cinnabarIsland.addConnection(new Path(fuchsiaCity, 100));
		cinnabarIsland.addConnection(new Path(palletTown, 100));

		GameMap map = new GameMap(palletTown);
		map.addTown(viridianCity);
		map.addTown(pewterCity);
		map.addTown(ceruleanCity);
		map.addTown(powerPlant);
		map.addTown(saffronCity);
		map.addTown(celadonCity);
		map.addTown(lavenderTown);
		map.addTown(vermillionCity);
		map.addTown(fuchsiaCity);
		map.addTown(cinnabarIsland);

		return map;
	}

	public static void testMarketPlace(GameMap map,
			GlobalItemReference theReference) {
		MarketPlace theMarket = map.getCurrent().getMarket();
		Player testPlayer = new Player("Ben", 4, 4, 4, 4, 500, 100, 1000, map);
		System.out.println(testPlayer.getBackpack());
		System.out.println(testPlayer.getWallet());
		testPlayer.buy(theMarket, theReference.getHealthPotion(), 50);
		System.out.println(testPlayer.getBackpack());
		System.out.println(testPlayer.getWallet());
		testPlayer.sell(theMarket, theReference.getHealthPotion(), 2);
		System.out.println(testPlayer.getBackpack());
		System.out.println(testPlayer.getWallet());
		testPlayer.buy(theMarket, theReference.getRepel(), 1);
		System.out.println(testPlayer.getBackpack());
		System.out.println(testPlayer.getWallet());
	}

	public static void testMovement(GameMap map) {
		Player testPlayer = new Player("Ben", 4, 4, 4, 4, 500, 120, 10, map);
		Set<Town> townSet = map.getTownSet();
		for (Iterator<Town> it = townSet.iterator(); it.hasNext();) {
			testPlayer.move((Town) it.next());
			System.out.println(testPlayer.getCurrent());
			map.Dijkstras();
			System.out.println();
		}
	}
}
