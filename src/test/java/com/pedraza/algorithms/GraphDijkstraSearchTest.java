package com.pedraza.algorithms;

import static org.junit.Assert.*;

import com.pedraza.datastructures.GraphDijkstra;

import org.junit.jupiter.api.Test;

public class GraphDijkstraSearchTest {

    GraphDijkstra<String> graph;
    GraphDijkstraSearch<String> search;

    @Test
    public void searchShouldReturnIndexWhenFound() {
        graph = buildGraph();
        search = new GraphDijkstraSearch<>(graph);
        Object[] actual = search.search("SFO", "JFK").toArray();
        Object[] expected = new String[] { "JFK", "DCA", "ATL", "DFW", "LAS", "SFO" };
        assertArrayEquals(expected, actual);
    }

    private GraphDijkstra<String> buildGraph() {
        GraphDijkstra<String> graph = new GraphDijkstra<>();

        // Vertices
        graph.addVertex("DFW"); // Dallas
        graph.addVertex("LAS"); // Las Vegas 
        graph.addVertex("LAX"); // Los Angeles
        graph.addVertex("SFO"); // San Francisco 
        graph.addVertex("ORD"); // Chicago
        graph.addVertex("JFK"); // New York
        graph.addVertex("DCA"); // Washington, DC
        graph.addVertex("ATL"); // Atlanta
        graph.addVertex("MIA"); // Miami

        // Outbound
        graph.addEdge("SFO", "LAS", 1);
        graph.addEdge("SFO", "LAX", 2);
        graph.addEdge("LAX", "LAS", 1);
        graph.addEdge("LAS", "DFW", 4);
        graph.addEdge("DFW", "ORD", 7);
        graph.addEdge("DFW", "ATL", 3);
        graph.addEdge("ORD", "JFK", 1);
        graph.addEdge("JFK", "DCA", 1);
        graph.addEdge("DCA", "JFK", 1);
        graph.addEdge("ATL", "DCA", 2);
        graph.addEdge("ATL", "MIA", 2);

        // Inbound
        graph.addEdge("LAS", "SFO", 1);
        graph.addEdge("LAX", "SFO", 2);
        graph.addEdge("LAS", "LAX", 1);
        graph.addEdge("DFW", "LAS", 4);
        graph.addEdge("ORD", "DFW", 7);
        graph.addEdge("ATL", "DFW", 3);
        graph.addEdge("JFK", "ORD", 1);
        graph.addEdge("DCA", "JFK", 1);
        graph.addEdge("JFK", "DCA", 1);
        graph.addEdge("DCA", "ATL", 2);
        graph.addEdge("MIA", "ATL", 2);

        return graph;
    }

}