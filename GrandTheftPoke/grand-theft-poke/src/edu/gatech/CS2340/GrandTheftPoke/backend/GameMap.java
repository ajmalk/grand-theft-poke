package edu.gatech.CS2340.GrandTheftPoke.backend;

import edu.gatech.CS2340.GrandTheftPoke.backend.Towns.Town;
import java.util.*;

/**
 *
 * @author Ben Nuttle
 */
public class GameMap {

    private Town current; //test
    private Set townSet;

    public GameMap() {
        townSet = new HashSet<Town>();
    }

    public GameMap(Town startTown) {
        townSet = new HashSet<Town>();
        current = startTown;
        townSet.add(current);
    }

    public void addTown(Town toBeAdded) {
        townSet.add(toBeAdded);
    }

    public void setCurrent(Town current) {
        this.current = current;
    }

    public Town getCurrent() {
        return current;
    }

    public Set<Town> getTownSet() {
        return townSet;
    }

    public static void computePaths(Town source) {
        source.setMinimumDistance(0);
        PriorityQueue<Town> vertexQueue = new PriorityQueue<Town>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Town u = vertexQueue.poll();

            for (Path e : (Set<Path>) u.getAdjacencies()) {
                Town v = e.getTarget();
                int weight = e.getWeight();
                int distanceThroughU = u.getMinimumDistance() + weight;
                if (distanceThroughU < v.getMinimumDistance()) {
                    vertexQueue.remove(v);
                    v.setMinimumDistance(distanceThroughU);
                    v.setPrevious(u);
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static List<Town> getShortestPathTo(Town target) {
        List<Town> path = new ArrayList<Town>();
        for (Town vertex = target; vertex != null; vertex = vertex.getPrevious()) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }

    public void Dijkstras() {
        computePaths(current);
        for (Town x : (Set<Town>) townSet) {
            System.out.println("Distance to " + x + ": " + x.getMinimumDistance());
            //List<Town> path = getShortestPathTo(x);
            //System.out.println("Path: " + path);
        }
    }

    public int Dijkstras(String townName) {
        computePaths(current);
        int toBeReturned = Integer.MAX_VALUE;
        for (Town x : (Set<Town>) townSet) {
            if (x.toString().equals(townName)) {
                toBeReturned = x.getMinimumDistance();
                //resetMinimumDistance(current);
                //List<Town> path = getShortestPathTo(x);
                //System.out.println("Path: " + path);
            }
            resetMinimumDistance(x);
        }
        return toBeReturned;
    }

    private void resetMinimumDistance(Town toBeReset) {
        toBeReset.setMinimumDistance(Integer.MAX_VALUE);
    }
}
