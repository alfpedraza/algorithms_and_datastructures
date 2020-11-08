package com.pedraza.algorithms;

import static org.junit.Assert.*;

import com.pedraza.datastructures.Graph;
import com.pedraza.datastructures.GraphVertex;

import org.junit.jupiter.api.Test;

public class GraphDepthFirstSearchTest {

    Graph<String, Integer> graph;
    GraphDepthFirstSearch<String, Integer> search;

    @Test
    public void searchShouldReturnIndexWhenFound() {
        graph = buildGraph();
        search = new GraphDepthFirstSearch<>(graph);
        GraphVertex<String, Integer> actual = search.search("SFO", "JFK");
        GraphVertex<String, Integer> expected = graph.get("JFK");
        assertEquals(expected, actual);
    }

    @Test
    public void searchShouldReturnNullWhenNotFound() {
        graph = buildGraph();
        graph.addVertex("SEA");
        graph.addEdge("SEA", "DFW", 0);
        search = new GraphDepthFirstSearch<>(graph);
        GraphVertex<String, Integer> actual = search.search("SFO", "SEA");
        GraphVertex<String, Integer> expected = null;
        assertEquals(expected, actual);
    }

    private Graph<String, Integer> buildGraph() {
        Graph<String, Integer> graph = new Graph<>();

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
        graph.addEdge("SFO", "LAS", 0);
        graph.addEdge("SFO", "LAX", 0);
        graph.addEdge("LAX", "LAS", 0);
        graph.addEdge("LAS", "DFW", 0);
        graph.addEdge("DFW", "ORD", 0);
        graph.addEdge("DFW", "ATL", 0);
        graph.addEdge("ORD", "JFK", 0);
        graph.addEdge("JFK", "DCA", 0);
        graph.addEdge("ATL", "DCA", 0);
        graph.addEdge("ATL", "MIA", 0);

        // Inbound
        graph.addEdge("LAS", "SFO", 0);
        graph.addEdge("LAX", "SFO", 0);
        graph.addEdge("LAS", "LAX", 0);
        graph.addEdge("DFW", "LAS", 0);
        graph.addEdge("ORD", "DFW", 0);
        graph.addEdge("ATL", "DFW", 0);
        graph.addEdge("JFK", "ORD", 0);
        graph.addEdge("DCA", "JFK", 0);
        graph.addEdge("DCA", "ATL", 0);
        graph.addEdge("MIA", "ATL", 0);

        return graph;
    }

}