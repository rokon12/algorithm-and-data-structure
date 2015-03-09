package com.bazlur.datastructure.graph;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * @author Bazlur Rahman Rokon
 * @date 3/9/15.
 */
@RunWith(JUnit4.class)
public class GraphTest {
    public static Graph graph1;

    @BeforeClass
    public static void makeGraphs() {
        Graph g = graph1 = new Graph();
        g.addEdge("A", "B");
        g.addEdge("B", "C");
        g.addEdge("B", "D");
        g.addEdge("B", "A");
        g.addEdge("B", "E");
        g.addEdge("B", "F");
        g.addEdge("C", "A");
        g.addEdge("D", "C");
        g.addEdge("E", "B");
        g.addEdge("F", "B");
    }

    @Test
    public void BreadthFirstIterationOfIsolatedVertex() {
        expectIteration("Z", new BreadthFirstIterator(graph1, "Z"));
    }

    private void expectIteration(String answer, Iterator<String> it) {
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(' ').append(it.next());
        }
        System.out.println(sb.toString());
        assertEquals(answer, sb.substring(1));
    }
}
