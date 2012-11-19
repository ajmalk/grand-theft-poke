package edu.gatech.CS2340.GrandTheftPoke.backend.Towns;

import java.util.HashSet;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.Path;

/**
 * The town
 * 
 * @author Team Rocket
 */
@XStreamAlias("Town")
public class Town implements Comparable {

	@XStreamOmitField
	private int minimumDistance = Integer.MAX_VALUE;

	@XStreamAsAttribute
	private String name;

	@XStreamOmitField
	private Town previous;

	protected MarketPlace myMarket;

	@XStreamOmitField
	private String filename;

	@XStreamOmitField
	private Set<Path> adjacencies;

	/**
	 * @param name
	 *            the name of the town
	 * @param myMarket
	 *            the market being used
	 */
	public Town(String name, MarketPlace myMarket) {
		this.name = name;
		this.myMarket = myMarket;
		adjacencies = new HashSet<Path>();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Town))
			return false;
		if (!toString().equals(((Town) o).toString()))
			return false;
		if (myMarket.equals(((Town) o).getMarket()))
			return false;
		return true;
	}

	/**
	 * @param toBeAdded
	 *            the connection to be added
	 */
	public void addConnection(Path toBeAdded) {
		if (toBeAdded != null && !adjacencies.contains(toBeAdded)) {
			adjacencies.add(toBeAdded);
		}
	}

	/**
	 * @return adjacencies
	 */
	public Set getAdjacencies() {
		return adjacencies;
	}

	/**
	 * @return minimumDistance
	 */
	public int getMinimumDistance() {
		return minimumDistance;
	}

	/**
	 * @param minimumDistance
	 *            the minimumDistance
	 */
	public void setMinimumDistance(int minimumDistance) {
		this.minimumDistance = minimumDistance;
	}

	/**
	 * @return previous
	 */
	public Town getPrevious() {
		return previous;
	}

	/**
	 * @param previous
	 *            the previous town
	 */
	public void setPrevious(Town previous) {
		this.previous = previous;
	}

	@Override
	public int compareTo(Object other) {
		return getMinimumDistance() - ((Town) other).getMinimumDistance();
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * @return myMarket
	 */
	public MarketPlace getMarket() {
		return myMarket;
	}

	/**
	 * @return filename
	 */
	public String getImage() {
		return filename;
	}

	/**
	 * @param str
	 *            the string to use to set image
	 */
	public void setImage(String str) {
		filename = str;
	}
}
