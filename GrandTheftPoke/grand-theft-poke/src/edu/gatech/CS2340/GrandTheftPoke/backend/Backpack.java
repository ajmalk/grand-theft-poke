package edu.gatech.CS2340.GrandTheftPoke.backend;

//import com.badlogic.gdx.utils.ObjectMap;

//import com.badlogic.gdx.utils.ObjectMap.Entries;

import edu.gatech.CS2340.GrandTheftPoke.backend.Items.Item;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Holds and operates on a person's supply of items.
 * @author Team Rocket
 */
public class Backpack {
    private int capacity;
    private int maxRange;
    private HashMap<Item, Integer> contents;

    /**
     * Creates a backpack with specified maximum range and capacity
     * @param range
     * @param capacity
     */
    public Backpack(int range, int capacity) {
        this.capacity = capacity;
        contents = new HashMap<Item, Integer>();
        maxRange = range;
    }

    /**
     * Places a given number of a specified item in the backpack
     * WARNING: Doesn't check for legality of placement. Use checkCapacity
     * @param placedItem
     * @param quantity
     */
    public void place(Item placedItem, int quantity) {
        if (!(contents.containsKey(placedItem))) {
            contents.put(placedItem, quantity);
        } else {
            int currentItems = contents.get(placedItem);
            contents.put(placedItem, currentItems + quantity);
        }
    }

    /**
     * Checks the capacity of the backpack to ensure there is sufficient space
     * @param placedItem, the item to be placed
     * @param quantity, the number of items to be placed
     * @return whether or not there is sufficient space
     */
    public boolean checkCapacity(Item placedItem, int quantity) {
        if (!(contents.containsKey(placedItem))) {
            return capacity - (placedItem.getWeight() * quantity) >= 0;
        } else {
            return capacity - (contents.get(placedItem) + placedItem.getWeight() * quantity) >= 0;
        }
    }

    /**
     * Removes a given number of a specified item from the backpack
     * WARNING: Doesn't check for legality of the removal. Use checkContents
     * @param retrievedItem
     * @param quantity
     */
    public void remove(Item retrievedItem, int quantity) {
        int weightDiff = retrievedItem.getWeight() * quantity;
        capacity += weightDiff;
        int netWeight = contents.get(retrievedItem) - weightDiff;
        contents.put(retrievedItem, netWeight);
        if(contents.get(retrievedItem) == 0) {
            contents.remove(retrievedItem);
        }

    }

    /**
     * Checks the contents of the backpack to ensure removal is legal
     * @param retrievedItem
     * @param quantity
     * @return whether the backpack has the specified number of the given item
     */
    public boolean checkContents(Item retrievedItem, int quantity) {
        if (!(contents.containsKey(retrievedItem))) {
            return false;
        }
        else {
            return contents.get(retrievedItem) >= quantity;
        }
    }

    /**
     * 
     * @return the maximum range
     */
    public int getMaxRange() {
        return maxRange;
    }

    /**
     * Sets the maximum range. Call when changing backpack type.
     * @param maxRange
     */
    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }
    /**
     * Sets the capacity of the backpack. Call when changing backpack type.
     * @param capacity 
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public HashMap<Item, Integer> getContents() {
    	return contents;
    }
    @Override
    public String toString() {
        String toBeReturned = "Backpack Contents: \n";
        Set keys = contents.entrySet();
        for (Iterator it = keys.iterator(); it.hasNext();) {
            toBeReturned += it.next() + "\n";
        }
       return toBeReturned;
    }

}
