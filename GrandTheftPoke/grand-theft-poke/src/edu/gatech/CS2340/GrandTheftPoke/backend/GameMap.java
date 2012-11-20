/**
 * GameMap.java
 * @version 1.0
 */

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
 * @version 1.0
 */
@XStreamAlias("Map")
public class GameMap {

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "GameMap [townSet=" + townSet + ", startTown=" + startTown + "]";
	}

	/**
	 * Field townSet.
	 */
	@XStreamImplicit(itemFieldName = "Town")
	private final Set<Town> townSet;

	/**
	 * Field startTown.
	 */
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

		palletTown.addConnection(new Path(cinnabarIsland, 100));//distance between island and town
		palletTown.addConnection(new Path(viridianCity, 10));// distance between town and city

		viridianCity.addConnection(new Path(palletTown, 10));//distance between city and town
		viridianCity.addConnection(new Path(pewterCity, 20));//distance between city and city

		pewterCity.addConnection(new Path(viridianCity, 20));//distance between city and city
		pewterCity.addConnection(new Path(ceruleanCity, 50));//distance between city and city

		ceruleanCity.addConnection(new Path(pewterCity, 50));//distance between city and city
		ceruleanCity.addConnection(new Path(powerPlant, 30));//distance between city and powerplant
		ceruleanCity.addConnection(new Path(saffronCity, 20));//distance between city and city

		powerPlant.addConnection(new Path(ceruleanCity, 30));//distance between powerplant and city

		saffronCity.addConnection(new Path(ceruleanCity, 20));//distance between city and city
		saffronCity.addConnection(new Path(celadonCity, 10));//distance between city and city
		saffronCity.addConnection(new Path(lavenderTown, 20));//distance between city and town
		saffronCity.addConnection(new Path(vermillionCity, 20));//distance between city and city

		celadonCity.addConnection(new Path(saffronCity, 10));//distance between city and city
		celadonCity.addConnection(new Path(fuchsiaCity, 50));//distance between city and city

		lavenderTown.addConnection(new Path(saffronCity, 20));//distance between city and town
		lavenderTown.addConnection(new Path(vermillionCity, 40));//distance between city and city
		lavenderTown.addConnection(new Path(fuchsiaCity, 120));//distance between city and city

		vermillionCity.addConnection(new Path(saffronCity, 20));//distance between city and city
		vermillionCity.addConnection(new Path(lavenderTown, 40));//distance between city and town
		vermillionCity.addConnection(new Path(fuchsiaCity, 80));//distance between city and city

		fuchsiaCity.addConnection(new Path(celadonCity, 50));//distance between city and city
		fuchsiaCity.addConnection(new Path(lavenderTown, 120));//distance between city and town
		fuchsiaCity.addConnection(new Path(vermillionCity, 80));//distance between city and city
		fuchsiaCity.addConnection(new Path(cinnabarIsland, 100));//distance between city and island

		cinnabarIsland.addConnection(new Path(fuchsiaCity, 100));//distance between city and city
		cinnabarIsland.addConnection(new Path(palletTown, 100));//distance between city and town

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
	 * Method hashCode.
	 * @return int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;//prime for hashcode generation
		int result = 1;
		result = prime * result
				+ ((startTown == null) ? 0 : startTown.hashCode());
		result = prime * result + ((townSet == null) ? 0 : townSet.hashCode());
		return result;
	}

	/**
	 * Method equals.
	 * @param obj Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof GameMap)) {
			return false;
		}
		final GameMap other = (GameMap) obj;
		if (startTown == null) {
			if (other.startTown != null) {
				return false;
			}
		} else if (!startTown.equals(other.startTown)) {
			return false;
		}
		if (townSet == null) {
			if (other.townSet != null) {
				return false;
			}
		} else if (!townSet.equals(other.townSet)) {
			return false;
		}
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
	
	 * @return townSet the set of towns */
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
		source.setMinimumDistance(0);//minimum distance for dijkstra's
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
	
	 * @return the shortest path */
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
	 * return the start town
	 * 
	
	 * @return startTown */
	public Town getStartTown() {
		return startTown;
	}

	/**
	 * returns a random town
	 * 
	
	 * @return a random town */
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
	
	 * @return an int computing the distance */
	public int dijkstras(Town source, String townName) {
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
