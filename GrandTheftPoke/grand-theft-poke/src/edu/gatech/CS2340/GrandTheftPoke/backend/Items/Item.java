package edu.gatech.CS2340.GrandTheftPoke.backend.Items;

/**
 *
 * @author Team Rocket
 */
public abstract class Item {
    private int weight = 1;
    @Override
	public abstract String toString();
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
    
    public int getWeight() {
        return weight;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
}