package com.pedraza.datastructures;

public class GraphDijkstra<T> extends Graph<T, Integer> {

    public GraphDijkstraVertex<T> get(T value) {
        GraphDijkstraVertex<T> vertex =
            (GraphDijkstraVertex<T>)getVertices().get(value);
        return vertex;
    }

    public void addVertex(T value) {
        GraphDijkstraVertex<T> vertex = new GraphDijkstraVertex<T>(value);
        getVertices().put(value, vertex);
    }
    
}
