package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Represents an item
 * 
 * @author Team Rocket
 * @version 1.0
 */
public abstract class Item {
	/**
	 * Field weight.
	 */
	@XStreamOmitField
	private int weight = 1;

	/**
	 * returns a string to use to find the corresponding image
	 * 
	
	 * @return String imageName */
	public abstract String getFileName();

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "";
	}

	/**
	 * returns a description of the item
	 * 
	
	 * @return a description */
	public abstract String getDescription();

	/**
	 * Method equals.
	 * @param obj Object
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(getClass().equals(obj.getClass()))) {
			return false;
		}
		return true;
	}

	/**
	 * Method clone.
	 * @return Object
	 * @throws CloneNotSupportedException
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * Method hashCode.
	 * @return int
	 */
	@Override
	public int hashCode() {
		return getFileName().hashCode();
	}

	/**
	 * returns the weight
	 * 
	
	 * @return the weight */
	public int getWeight() {
		return weight;
	}

	/**
	 * sets the weight
	 * 
	 * @param weight
	 *            the weight to be set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
}