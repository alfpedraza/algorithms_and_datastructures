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
        startVertex.setDistance(0);
        queue.add(startVertex);

        // Evaluation
        while (!queue.isEmpty()) {
            GraphDijkstraVertex<T> vertex = queue.poll();
            if (vertex.getVisited()) continue;
        
            if (vertex.getValue() == end) break;
            vertex.setVisited(true);

            for (GraphEdge<T, Integer> edge : vertex.getEdges()) {
                int newDistance = vertex.getDistance() + edge.getWeight();
                GraphDijkstraVertex<T> edgeVertex =
                    (GraphDijkstraVertex<T>)edge.getVertex();
                Integer nextDistance = edgeVertex.getDistance();
                if (newDistance < nextDistance) {
                    edgeVertex.setDistance(newDistance);
                    edgeVertex.setPrevious(vertex);
                    queue.add(edgeVertex);
                }
            }
        }

        // Result
        ArrayList<T> path = new ArrayList<>();
        GraphDijkstraVertex<T> endVertex = graph.get(end);
        while (endVertex != null) {
            path.add(endVertex.getValue());
            endVertex = endVertex.getPrevious();
        }
        return path;
    }

}
