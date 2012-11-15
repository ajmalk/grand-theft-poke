package edu.gatech.CS2340.GrandTheftPoke.backend.Towns;
import java.util.HashSet;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.Path;
/**
 *
 * @author Ben Nuttle
 */
@XStreamAlias("Town")
public class Town implements Comparable {
	
	@XStreamOmitField
    private int minimumDistance = Integer.MAX_VALUE;
	
	@XStreamAsAttribute
    private String name;
    
    @XStreamOmitField
    private Set<Path> adjacencies;
    
    @XStreamOmitField
    private Town previous;
    
    protected MarketPlace myMarket;
    
    @XStreamOmitField
    private String filepath;
    
    public Town(String name, MarketPlace myMarket) {
        this.name = name;
        this.myMarket = myMarket;
        adjacencies = new HashSet<Path>();
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Town) {
            return toString().equals(((Town) o).toString());
        } else {
            return false;
        }
    }

    public void addConnection(Path toBeAdded) {
        if (toBeAdded != null && !adjacencies.contains(toBeAdded)) {
            adjacencies.add(toBeAdded);
        }
    }

    public Set getAdjacencies() {
        return adjacencies;
    }

    public int getMinimumDistance() {
        return minimumDistance;
    }

    public void setMinimumDistance(int minimumDistance) {
        this.minimumDistance = minimumDistance;
    }

    public Town getPrevious() {
        return previous;
    }

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
    
    public MarketPlace getMarket() {
        return myMarket;
    }

	public String getImage() {
		
		return filepath;
	}
	
	public void setImage(String str){
		filepath = str;
	}
}
