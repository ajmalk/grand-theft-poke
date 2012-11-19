package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Represents an item
 * 
 * @author Team Rocket
 */
public abstract class Item {
	@XStreamOmitField
	private int weight = 1;

	/**
	 * returns a string to use to find the corresponding image
	 * 
	 * @return String imageName
	 */
	public abstract String getFileName();

	@Override
	public abstract String toString();

	/**
	 * returns a description of the item
	 * 
	 * @return a description
	 */
	public abstract String getDescription();

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return true;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public int hashCode() {
		return getFileName().hashCode();
	}

	/**
	 * returns the weight
	 * 
	 * @return the weight
	 */
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