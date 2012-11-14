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
 * 
 * @author Team Rocket
 */
@XStreamAlias("Map")
public class GameMap {
	
	@XStreamImplicit(itemFieldName="Town")
	private Set<Town> townSet;
	
	@XStreamOmitField
	private Town startTown;

	public GameMap() {
		townSet = new HashSet<Town>();
	}

	public GameMap(GlobalItemReference theReference) {
		townSet = new HashSet<Town>();

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

	public void addTown(Town toBeAdded) {
		townSet.add(toBeAdded);
	}

	public Set<Town> getTownSet() {
		return townSet;
	}

	public static void computePaths(Town source) {
		source.setMinimumDistance(0);
		PriorityQueue<Town> vertexQueue = new PriorityQueue<Town>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Town u = vertexQueue.poll();

			for (Path e : (Set<Path>) u.getAdjacencies()) {
				Town v = e.getTarget();
				int weight = e.getWeight();
				int distanceThroughU = u.getMinimumDistance() + weight;
				if (distanceThroughU < v.getMinimumDistance()) {
					vertexQueue.remove(v);
					v.setMinimumDistance(distanceThroughU);
					v.setPrevious(u);
					vertexQueue.add(v);
				}
			}
		}
	}

	public static List<Town> getShortestPathTo(Town target) {
		List<Town> path = new ArrayList<Town>();
		for (Town vertex = target; vertex != null; vertex = vertex
				.getPrevious()) {
			path.add(vertex);
		}
		Collections.reverse(path);
		return path;
	}

	public void Dijkstras(Town source) {
		computePaths(source);
		for (Town x : (Set<Town>) townSet) {
			//System.out.println("Distance to " + x + ": "
				//	+ x.getMinimumDistance());
			// List<Town> path = getShortestPathTo(x);
			// System.out.println("Path: " + path);
		}
	}

	public Town getStartTown() {
		return startTown;
	}

	public Town getRandomTown() {
		Random rand = new Random();
		return (Town) townSet.toArray()[rand.nextInt(townSet.size())];

	}

	public int Dijkstras(Town source, String townName) {
		computePaths(source);
		int toBeReturned = Integer.MAX_VALUE;
		for (Town x : (Set<Town>) townSet) {
			if (x.toString().equals(townName)) {
				toBeReturned = x.getMinimumDistance();
			}
			resetMinimumDistance(x);
		}
		return toBeReturned;
	}

	private void resetMinimumDistance(Town toBeReset) {
		toBeReset.setMinimumDistance(Integer.MAX_VALUE);
	}
}
