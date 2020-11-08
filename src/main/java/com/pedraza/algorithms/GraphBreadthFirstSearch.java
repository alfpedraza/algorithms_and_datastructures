package com.pedraza.algorithms;

import com.pedraza.datastructures.Graph;
import com.pedraza.datastructures.GraphEdge;
import com.pedraza.datastructures.GraphVertex;
import com.pedraza.datastructures.HashTable;
import com.pedraza.datastructures.Queue;

public class GraphBreadthFirstSearch<T, W> {
    
    private Graph<T, W> graph;

    public GraphBreadthFirstSearch(Graph<T, W> graph) {
        this.graph = graph;
    }

    public GraphVertex<T, W> search(T start, T end) {
        GraphVertex<T, W> startVertex = graph.get(start);
        if (startVertex == null) return null;
        
        HashTable<T, Boolean> visited = new HashTable<>();
        Queue<GraphVertex<T, W>> queue = new Queue<>();
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            GraphVertex<T, W> vertex = queue.poll();
            if (visited.get(vertex.getValue()) != null) continue;
            
            if (vertex.getValue() == end) return vertex;
            visited.put(vertex.getValue(), true);
            for (GraphEdge<T, W> edge : vertex.getEdges()) {
                queue.add(edge.getVertex());
            }
        }
        
        return null;
    }

}
