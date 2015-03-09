package com.bazlur.datastructure.graph;


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @date 3/9/15.
 */
public class BreadthFirstIterator implements Iterator<String> {

    private Set<String> visited = new HashSet<>();
    private LinkedList<String> queue = new LinkedList<>();
    private Graph graph;

    public BreadthFirstIterator(Graph graph, String startVartex) {
        this.graph = graph;
        this.queue.add(startVartex);
        this.visited.add(startVartex);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        return !this.queue.isEmpty();
    }

    @Override
    public String next() {
        String next = queue.remove();

        for (String neighbour : this.graph.getNeighbours(next)) {
            if (!this.visited.contains(neighbour)) {
                this.queue.add(neighbour);
                this.visited.add(neighbour);
            }

        }
        return next;
    }
}
