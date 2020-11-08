package com.pedraza.algorithms;

import com.pedraza.datastructures.Graph;
import com.pedraza.datastructures.GraphEdge;
import com.pedraza.datastructures.GraphVertex;
import com.pedraza.datastructures.HashTable;
import com.pedraza.datastructures.Stack;

public class GraphDepthFirstSearch<T, W> {
    
    private Graph<T, W> graph;

    public GraphDepthFirstSearch(Graph<T, W> graph) {
        this.graph = graph;
    }

    public GraphVertex<T, W> search(T start, T end) {
        GraphVertex<T, W> startVertex = graph.get(start);
        if (startVertex == null) return null;

        HashTable<T, Boolean> visited = new HashTable<>();
        Stack<GraphVertex<T, W>> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            GraphVertex<T, W> vertex = stack.pop();
            if (visited.get(vertex.value) != null) continue;
        
            if (vertex.value == end) return vertex;
            visited.set(vertex.value, true);
            for (GraphEdge<T, W> edge : vertex.edges) {
                stack.push(edge.vertex);
            }
        }

        return null;
    }

}
