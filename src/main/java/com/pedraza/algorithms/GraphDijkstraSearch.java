package com.pedraza.algorithms;

import com.pedraza.datastructures.ArrayList;
import com.pedraza.datastructures.GraphDijkstra;
import com.pedraza.datastructures.GraphDijkstraVertex;
import com.pedraza.datastructures.GraphEdge;
import com.pedraza.datastructures.MinPriorityQueue;

public class GraphDijkstraSearch<T> {
    
    private GraphDijkstra<T> graph;

    public GraphDijkstraSearch(GraphDijkstra<T> graph) {
        this.graph = graph;
    }

    public ArrayList<T> search(T start, T end) {

        // Initialization
        GraphDijkstraVertex<T> startVertex = graph.get(start);
        if (startVertex == null) return null;
        MinPriorityQueue<GraphDijkstraVertex<T>> queue = new MinPriorityQueue<>();
        startVertex.distance = 0;
        queue.add(startVertex);

        // Evaluation
        while (!queue.isEmpty()) {
            GraphDijkstraVertex<T> vertex = queue.poll();
            if (vertex.visited) continue;
        
            if (vertex.value == end) break;
            vertex.visited = true;

            for (GraphEdge<T, Integer> edge : vertex.edges) {
                int newDistance = vertex.distance + edge.weight;
                GraphDijkstraVertex<T> edgeVertex = (GraphDijkstraVertex<T>)edge.vertex;
                Integer nextDistance = edgeVertex.distance;
                if (newDistance < nextDistance) {
                    edgeVertex.distance = newDistance;
                    edgeVertex.previous = vertex;
                    queue.add(edgeVertex);
                }
            }
        }

        // Result
        ArrayList<T> path = new ArrayList<>();
        GraphDijkstraVertex<T> endVertex = graph.get(end);
        while (endVertex != null) {
            path.add(endVertex.value);
            endVertex = endVertex.previous;
        }
        return path;
    }

}
