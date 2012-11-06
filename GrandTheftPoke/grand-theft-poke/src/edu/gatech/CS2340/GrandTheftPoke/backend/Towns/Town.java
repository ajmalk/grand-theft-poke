package edu.gatech.CS2340.GrandTheftPoke.backend.Towns;
import edu.gatech.CS2340.GrandTheftPoke.backend.MarketPlace;
import edu.gatech.CS2340.GrandTheftPoke.backend.Path;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author Ben Nuttle
 */
public class Town implements Comparable {
    
    private int minimumDistance = Integer.MAX_VALUE;
    private String name;
    private Set<Path> adjacencies;
    private Town previous;
    protected MarketPlace myMarket;
    

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
}
