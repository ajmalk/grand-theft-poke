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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((adjacencies == null) ? 0 : adjacencies.hashCode());
		result = prime * result
				+ ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + minimumDistance;
		result = prime * result
				+ ((myMarket == null) ? 0 : myMarket.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((previous == null) ? 0 : previous.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Town other = (Town) obj;
		if (adjacencies == null) {
			if (other.adjacencies != null)
				return false;
		} else if (!adjacencies.equals(other.adjacencies))
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (minimumDistance != other.minimumDistance)
			return false;
		if (myMarket == null) {
			if (other.myMarket != null)
				return false;
		} else if (!myMarket.equals(other.myMarket))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (previous == null) {
			if (other.previous != null)
				return false;
		} else if (!previous.equals(other.previous))
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
