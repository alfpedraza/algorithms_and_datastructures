package com.pedraza.datastructures;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class GraphTest extends TestBase {

    Graph<String, Integer> graph;

    @Test
    public void graphShouldBeCreated() {
        graph = buildGraph();
        assertEquals(3, graph.size());
    }

    @Test
    public void sizeShouldBeDecreasedWhenRemoveVertex() {
        graph = buildGraph();
        graph.removeVertex("John");
        assertEquals(2, graph.size());
    }

    @Test
    public void sizeShouldBeKeptWhenAddAndRemoveVertex() {
        graph = buildGraph();
        graph.removeVertex("John");
        graph.addVertex("John");
        assertEquals(3, graph.size());
    }

    @Test
    public void edgesSizeShouldBeKeptWhen() {
        graph = buildGraph();
        int actual = graph.get("John").getEdges().size();
        assertEquals(2, actual);
    }

    @Test
    public void edgesShouldBeDecreasedWhenRemoveEdge() {
        graph = buildGraph();
        graph.removeEdge("John", "Peter");
        int actual = graph.get("John").getEdges().size();
        assertEquals(1, actual);
    }

    @Test
    public void edgesShouldBeUpdatedWhenAddingEdges() {
        graph = buildGraph();
        graph.removeEdge("John", "Peter");
        graph.addEdge("John", "Peter");
        int actual = graph.get("John").getEdges().size();
        assertEquals(2, actual);
    }

    @Test
    public void edgesShouldBeAddedToItself() {
        graph = buildGraph();
        graph.addEdge("John", "John");
        int actual = graph.get("John").getEdges().size();
        assertEquals(3, actual);
    }

    @Test
    public void edgesShouldBeRemovedToItself() {
        graph = buildGraph();
        graph.addEdge("John", "John");
        graph.removeEdge("John", "John");
        int actual = graph.get("John").getEdges().size();
        assertEquals(2, actual);
    }

    private Graph<String, Integer> buildGraph() {
        Graph<String, Integer> graph = new Graph<>();
        graph.addVertex("John");
        graph.addVertex("Frank");
        graph.addVertex("Peter");
        graph.addEdge("John", "Peter", 1);
        graph.addEdge("John", "Frank", 2);
        graph.addEdge("Frank", "Peter", 1);
        return graph;
    }

}