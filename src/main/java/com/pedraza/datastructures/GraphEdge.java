package com.pedraza.datastructures;

public class GraphEdge<T, W> {

    public W weight;
    public GraphVertex<T, W> vertex;

    public GraphEdge(GraphVertex<T, W> vertex) {
        this(vertex, null);
    }

    public GraphEdge(GraphVertex<T, W> vertex, W weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

}
