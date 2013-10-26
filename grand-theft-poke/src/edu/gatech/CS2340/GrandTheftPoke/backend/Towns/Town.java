/**
 * Town.java
 * @version 1.0
 */

package edu.gatech.CS2340.GrandTheftPoke.backend.Towns;

import java.util.HashSet;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.Path;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.GymLeader;
import edu.gatech.CS2340.GrandTheftPoke.backend.persons.Person;

/**
 * The town
 * 
 * @author Team Rocket
 * @version 1.0
 */
@XStreamAlias("Town")
public class Town implements Comparable {

	/**
	 * Field minimumDistance.
	 */
	@XStreamOmitField
	private int minimumDistance = Integer.MAX_VALUE;

	/**
	 * Field name.
	 */
	@XStreamAsAttribute
	final private String name;

	/**
	 * Field previous.
	 */
	@XStreamOmitField
	private Town previous;

	/**
	 * Field myMarket.
	 */
	protected MarketPlace myMarket;
	
	private GymLeader theGymLeader;

	/**
	 * Field filename.
	 */
	@XStreamOmitField
	private String filename;

	/**
	 * Field adjacencies.
	 */
	@XStreamOmitField
	final private Set<Path> adjacencies;

	/**
	 * @param name
	 *            the name of the town
	 * @param myMarket
	 *            the market being used
	 */
	public Town(String name, MarketPlace myMarket, GymLeader theLeader) {
		this.name = name;
		this.myMarket = myMarket;
		theGymLeader = theLeader;
		adjacencies = new HashSet<Path>();
	}

	/**
	 * Method equals.
	 * 
	 * @param obj
	 *            Object
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
		if (!(obj instanceof Town)) {
			return false;
		}
		final Town other = (Town) obj;
		if (adjacencies == null) {
			if (other.adjacencies != null) {
				return false;
			}
		} else if (!adjacencies.equals(other.adjacencies)) {
			return false;
		}
		if (filename == null) {
			if (other.filename != null) {
				return false;
			}
		} else if (!filename.equals(other.filename)) {
			return false;
		}
		if (minimumDistance != other.minimumDistance) {
			return false;
		}
		if (myMarket == null) {
			if (other.myMarket != null) {
				return false;
			}
		} else if (!myMarket.equals(other.myMarket)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (previous == null) {
			if (other.previous != null) {
				return false;
			}
		} else if (!previous.equals(other.previous)) {
			return false;
		}
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
	 * 
	 * @return adjacencies
	 */
	public Set getAdjacencies() {
		return adjacencies;
	}

	/**
	 * 
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
	 * 
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

	/**
	 * Method compareTo.
	 * 
	 * @param other
	 *            Object
	 * @return int
	 */
	@Override
	public int compareTo(Object other) {
		return getMinimumDistance() - ((Town) other).getMinimumDistance();
	}

	/**
	 * Method toString.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * 
	 * @return myMarket
	 */
	public MarketPlace getMarket() {
		return myMarket;
	}

	/**
	 * 
	 * @return filename
	 */
	public String getImage() {
		return filename;
	}
	
	public Person getGymLeader() {
		return theGymLeader;
	}

	/**
	 * @param str
	 *            the string to use to set image
	 */
	public void setImage(String str) {
		filename = str;
	}
}
