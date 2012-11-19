package edu.gatech.CS2340.GrandTheftPoke.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.GlobalItemReference;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;
import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.TownFactoryImplementation;

/**
 * Represents the game map
 * 
 * @author Team Rocket
 * 
 */
@XStreamAlias("Map")
public class GameMap {

	@Override
	public String toString() {
		return "GameMap [townSet=" + townSet + ", startTown=" + startTown + "]";
	}

	@XStreamImplicit(itemFieldName = "Town")
	private final Set<Town> townSet;

	@XStreamOmitField
	private Town startTown;

	/**
	 * constructor for the game map
	 */
	public GameMap() {
		townSet = new HashSet<Town>();
	}

	/**
	 * constructor
	 * 
	 * @param theReference
	 *            the global item reference
	 */
	public GameMap(GlobalItemReference theReference) {
		townSet = new HashSet<Town>();

		final TownFactoryImplementation townGenerator = new TownFactoryImplementation(
				theReference);

		final Town palletTown = townGenerator.makePalletTown();
		final Town viridianCity = townGenerator.makeViridianCity();
		final Town pewterCity = townGenerator.makePewterCity();
		final Town ceruleanCity = townGenerator.makeCeruleanCity();
		final Town vermillionCity = townGenerator.makeVermillionCity();
		final Town lavenderTown = townGenerator.makeLavenderTown();
		final Town celadonCity = townGenerator.makeCeladonCity();
		final Town fuchsiaCity = townGenerator.makeFuchsiaCity();
		final Town saffronCity = townGenerator.makeSaffronCity();
		final Town cinnabarIsland = townGenerator.makeCinnabarIsland();
		final Town powerPlant = townGenerator.makePowerPlant();

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

		// current = palletTown;
		townSet.add(palletTown);

		this.addTown(viridianCity);
		this.addTown(pewterCity);
		this.addTown(ceruleanCity);
		this.addTown(powerPlant);
		this.addTown(saffronCity);
		this.addTown(celadonCity);
		this.addTown(lavenderTown);
		this.addTown(vermillionCity);
		this.addTown(fuchsiaCity);
		this.addTown(cinnabarIsland);

		startTown = palletTown;

	}

	/**
	 * checks to see if two towns are equal
	 * 
	 * @param town
	 *            the current town
	 * @return boolean
	 */
	public boolean equals(Town town) {
		if (!startTown.equals(town))
			return false;
		for (Town t : townSet)
			if (!town.equals(t))
				return false;
		return true;
	}

	/**
	 * adds town
	 * 
	 * @param toBeAdded
	 *            town toBeAdded
	 */
	public void addTown(Town toBeAdded) {
		townSet.add(toBeAdded);
	}

	/**
	 * gets the set of towns
	 * 
	 * @return townSet the set of towns
	 */
	public Set<Town> getTownSet() {
		return townSet;
	}

	/**
	 * sets the starting town
	 * 
	 * @param startTown
	 *            the starting town
	 */
	public void setStartTown(Town startTown) {
		this.startTown = startTown;
	}

	/**
	 * computes the paths from one town to the others
	 * 
	 * @param source
	 *            the starting town
	 */
	public static void computePaths(Town source) {
		source.setMinimumDistance(0);
		final PriorityQueue<Town> vertexQueue = new PriorityQueue<Town>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Town town = vertexQueue.poll();

			for (Path e : (Set<Path>) town.getAdjacencies()) {
				Town v = e.getTarget();
				int weight = e.getWeight();
				int distanceThroughU = town.getMinimumDistance() + weight;
				if (distanceThroughU < v.getMinimumDistance()) {
					vertexQueue.remove(v);
					v.setMinimumDistance(distanceThroughU);
					v.setPrevious(town);
					vertexQueue.add(v);
				}
			}
		}
	}

	/**
	 * returns the shortest path to a town
	 * 
	 * @param target
	 *            the end town
	 * @return the shortest path
	 */
	public static List<Town> getShortestPathTo(Town target) {
		final List<Town> path = new ArrayList<Town>();
		for (Town vertex = target; vertex != null; vertex = vertex
				.getPrevious()) {
			path.add(vertex);
		}
		Collections.reverse(path);
		return path;
	}

	/**
	 * runs Dijkstra's algorithm on the towns
	 * 
	 * @param source
	 *            the starting town
	 */
	public void Dijkstras(Town source) {
		computePaths(source);
		for (Town x : townSet) {
			// System.out.println("Distance to " + x + ": "
			// + x.getMinimumDistance());
			// List<Town> path = getShortestPathTo(x);
			// System.out.println("Path: " + path);
		}
	}

	/**
	 * return the start town
	 * 
	 * @return startTown
	 */
	public Town getStartTown() {
		return startTown;
	}

	/**
	 * returns a random town
	 * 
	 * @return a random town
	 */
	public Town getRandomTown() {
		final Random rand = new Random();
		return (Town) townSet.toArray()[rand.nextInt(townSet.size())];

	}

	/**
	 * returns dijkstra's distances as ints
	 * 
	 * @param source
	 *            the starting town
	 * @param townName
	 *            the townName
	 * @return an int computing the distance
	 */
	public int Dijkstras(Town source, String townName) {
		computePaths(source);
		int toBeReturned = Integer.MAX_VALUE;
		for (Town x : townSet) {
			if (x.toString().equals(townName)) {
				toBeReturned = x.getMinimumDistance();
			}
			resetMinimumDistance(x);
		}
		return toBeReturned;
	}

	/**
	 * resets the minimum distance
	 * 
	 * @param toBeReset
	 *            town toBeReset
	 */
	private void resetMinimumDistance(Town toBeReset) {
		toBeReset.setMinimumDistance(Integer.MAX_VALUE);
	}
}
