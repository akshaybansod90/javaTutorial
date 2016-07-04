package dataStructure.graph.problems;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Created by Akshay on 6/14/2016.
 *
 * A planner wants to deign a city. A city having n points of interest and marked them from 0 - (n-1).  Need to write
 * two API:
 * public void buildRoad(int a, int b); // build road directly between a and b.
 * public boolean isRoadExist(int a, int b); // Check if there is any road connectivity exist  between a & b (either
 * directly or indirectly) then return TRUE else FALSE.The solution should be in O(log n).
 *
 */
public class CityPlanner {


    private int[] parents;
    private Set<Edge> edges = new HashSet<>();
    private int noOfVertex = 0;


    public CityPlanner(int noOfVertex) {
        this.noOfVertex = noOfVertex;
        parents = new int[noOfVertex];
        for (int i = 0; i < noOfVertex; i++) {
            parents[i] = -1;
        }
    }

    public void buildRoad(int a, int b){
        if (a == b) {
            throw new IllegalArgumentException("Source and destination is same");
        }
        Edge edge = new Edge(a, b);
        if (!edges.add(edge)) {
            throw new IllegalArgumentException("Road built already");
        }
        int aParent = getParent(a);
        int bParent = getParent(b);
        if (aParent != bParent) {
            parents[aParent] = bParent;
        }
    }

    public boolean isRoadExist(int a, int b){
        return getParent(a)==getParent(b);
    }

    private int getParent(int v) {
        while (parents[v]!=-1){
            v = parents[v];
        }
        return v;
    }

    private class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (src != edge.src || src !=edge.dest) return false;
            if (src != edge.src) {
                return dest==edge.src;
            }
            return dest == edge.dest;
        }

        @Override
        public int hashCode() {
            int result = src * dest;
            result = 31 * result + dest + src;
            return result;
        }
    }
}
