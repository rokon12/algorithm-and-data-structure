package com.bazlur.datastructure.graph;

import java.util.*;

/**
 * @author Bazlur Rahman Rokon
 * @date 3/9/15.
 */
public class Graph {
    private Map<String, List<String>> edges = new HashMap<>();

    public void addEdge(String src, String dest) {
        List<String> srcNeighbours = this.edges.get(src);
        if (srcNeighbours == null) {
            srcNeighbours = new ArrayList<>();
            this.edges.put(src, srcNeighbours);
        }
        srcNeighbours.add(dest);
    }

    public Iterable<String> getNeighbours(String vertex) {
        List<String> neighbours = this.edges.get(vertex);

        if (neighbours == null) {

            return Collections.emptyList();
        } else {

            return Collections.unmodifiableList(neighbours);
        }
    }

}
