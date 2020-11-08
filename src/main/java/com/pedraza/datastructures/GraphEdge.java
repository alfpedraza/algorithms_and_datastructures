package com.pedraza.datastructures;

public class GraphEdge<T, W> {

    private W weight;
    private GraphVertex<T, W> vertex;

    public W getWeight() { return weight; }
    public GraphVertex<T, W> getVertex() { return vertex; }

    public GraphEdge(GraphVertex<T, W> vertex) {
        this(vertex, null);
    }

    public GraphEdge(GraphVertex<T, W> vertex, W weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

}
