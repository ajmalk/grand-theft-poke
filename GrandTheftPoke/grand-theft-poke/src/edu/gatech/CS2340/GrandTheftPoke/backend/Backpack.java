package edu.gatech.CS2340.GrandTheftPoke.backend;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;

/**
 * Holds and operates on a person's supply of items.
 * 
 * @author Team Rocket
 */
public class Backpack {

	private Integer capacity, maxRange;

	// @XStreamImplicit(itemFieldName="item")
	@XStreamOmitField
	private Map<Item, Integer> contents;

	public Backpack() {
		contents = new HashMap<Item, Integer>();
	}

	public int getAmount(Item toBeRetrieved) {
		if (contents.containsKey(toBeRetrieved)) {
			return contents.get(toBeRetrieved);
		}

		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result
				+ ((contents == null) ? 0 : contents.hashCode());
		result = prime * result
				+ ((maxRange == null) ? 0 : maxRange.hashCode());
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
		final Backpack other = (Backpack) obj;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (maxRange == null) {
			if (other.maxRange != null)
				return false;
		} else if (!maxRange.equals(other.maxRange))
			return false;
		return true;
	}

	/**
	 * Creates a backpack with specified maximum range and capacity
	 * 
	 * @param range
	 * @param capacity
	 */
	public Backpack(int range, int capacity) {
		this.capacity = capacity;
		contents = new HashMap<Item, Integer>();
		maxRange = range;
	}

	public Backpack(int range, int capacity, Map<Item, Integer> contents) {
		this(range, capacity);
		this.contents = contents;
	}

	/**
	 * Places a given number of a specified item in the backpack WARNING:
	 * Doesn't check for legality of placement. Use checkCapacity
	 * 
	 * @param placedItem
	 * @param quantity
	 */
	public boolean place(Item placedItem, int quantity) {
		 final int weightDiff = placedItem.getWeight() * quantity;
		if (checkCapacity(placedItem, quantity)) {
			if (!(contents.containsKey(placedItem))) {
				contents.put(placedItem, quantity);
			} else {
				final int currentItems = contents.get(placedItem);
				contents.put(placedItem, currentItems + quantity);
			}
			capacity -= weightDiff;
			return true;
		}
		return false;

	}

	/**
	 * Checks the capacity of the backpack to ensure there is sufficient space
	 * 
	 * @param placedItem
	 *            , the item to be placed
	 * @param quantity
	 *            , the number of items to be placed
	 * @return whether or not there is sufficient space
	 */
	public boolean checkCapacity(Item placedItem, int quantity) {
		if (!(contents.containsKey(placedItem))) {
			return capacity - (placedItem.getWeight() * quantity) >= 0;
		} else {
			return capacity
					- (contents.get(placedItem) + placedItem.getWeight()
							* quantity) >= 0;
		}
	}

	/**
	 * Removes a given number of a specified item from the backpack WARNING:
	 * Doesn't check for legality of the removal. Use checkContents
	 * 
	 * @param retrievedItem
	 * @param quantity
	 */
	public void remove(Item retrievedItem, int quantity) {
		final int weightDiff = retrievedItem.getWeight() * quantity;
		capacity += weightDiff;
		final int netWeight = contents.get(retrievedItem) - weightDiff;
		contents.put(retrievedItem, netWeight);
		if (contents.get(retrievedItem) == 0) {
			contents.remove(retrievedItem);
		}

	}

	/**
	 * Checks the contents of the backpack to ensure removal is legal
	 * 
	 * @param retrievedItem
	 * @param quantity
	 * @return whether the backpack has the specified number of the given item
	 */
	public boolean checkContents(Item retrievedItem, int quantity) {
		if (!(contents.containsKey(retrievedItem))) {
			return false;
		} else {
			return contents.get(retrievedItem) >= quantity;
		}
	}

	/**
	 * 
	 * @return the maximum range
	 */
	public Integer getMaxRange() {
		return maxRange;
	}

	public Integer getCapacity() {
		return capacity;
	}

	/**
	 * Sets the maximum range. Call when changing backpack type.
	 * 
	 * @param maxRange
	 */
	public void setMaxRange(int maxRange) {
		this.maxRange = maxRange;
	}

	/**
	 * Sets the capacity of the backpack. Call when changing backpack type.
	 * 
	 * @param capacity
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Map<Item, Integer> getContents() {
		return contents;
	}

	@Override
	public String toString() {
		String toBeReturned = "Backpack Contents: \n";
		final Set<?> keys = contents.entrySet();
		for (final Iterator<?> it = keys.iterator(); it.hasNext();) {
			toBeReturned += it.next() + "\n";
		}
		return toBeReturned;
	}

}
