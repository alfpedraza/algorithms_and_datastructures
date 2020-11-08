package com.pedraza.algorithms;

import com.pedraza.datastructures.ArrayList;
import com.pedraza.datastructures.Graph;
import com.pedraza.datastructures.GraphEdge;
import com.pedraza.datastructures.GraphVertex;
import com.pedraza.datastructures.HashTable;
import com.pedraza.datastructures.Stack;

public class GraphDijkstra<T> {
    
    private Graph<T, Integer> graph;

    public GraphDijkstra(Graph<T, Integer> graph) {
        this.graph = graph;
    }

    public ArrayList<T> search(T start, T end) {

        // Initialization
        GraphVertex<T, Integer> startVertex = graph.get(start);
        if (startVertex == null) return null;

        HashTable<T, Integer> distance = new HashTable<>();
        HashTable<T,T> previous = new HashTable<>();
        HashTable<T, Boolean> visited = new HashTable<>();
        Stack<GraphVertex<T, Integer>> stack = new Stack<>();

        distance.set(start, 0);
        previous.set(start, null);
        visited.set(start, null);
        stack.push(startVertex);

        // Evaluation
        while (!stack.isEmpty()) {
            GraphVertex<T, Integer> vertex = stack.pop();
            if (visited.get(vertex.value) != null) continue;
        
            if (vertex.value == end) break;
            visited.set(vertex.value, true);

            for (GraphEdge<T, Integer> edge : vertex.edges) {
                int newDistance = distance.get(vertex.value) + edge.weight;
                Integer nextDistance = distance.get(edge.vertex.value);
                if (nextDistance == null || newDistance < nextDistance) {
                    distance.set(edge.vertex.value, newDistance);
                    previous.set(edge.vertex.value, vertex.value);
                    stack.push(edge.vertex);
                }
            }
        }

        // Result
        ArrayList<T> path = new ArrayList<>();
        T prev = previous.get(end);
        if (prev != null) path.add(end);
        while (prev != null) {
            path.add(prev);
            prev = previous.get(prev);
        }
        return path;
    }

}
