package com.pedraza.datastructures;

public class Graph<T, W> {

    protected HashTable<T, GraphVertex<T, W>> vertices;

    public Graph() {
        vertices = new HashTable<>();
    }

    public GraphVertex<T, W> get(T value) { return vertices.get(value); }
    public int size() { return vertices.size(); }

    public void addVertex(T value) {
        GraphVertex<T, W> vertex = new GraphVertex<T, W>(value);
        vertices.set(value, vertex);
    }

    public void addEdge(T source, T destination) {
        addEdge(source, destination, null);
    }

    public void addEdge(T source, T destination, W weight) {
        GraphVertex<T, W> sourceVertex = vertices.get(source);
        GraphVertex<T, W> destinationVertex = vertices.get(destination);
        if (sourceVertex == null) throw new RuntimeException();
        if (destinationVertex == null) throw new RuntimeException();
        sourceVertex.addEdge(destinationVertex, weight);
    }

    public void removeVertex(T value) {
        GraphVertex<T,W> toRemove = vertices.get(value);
        for (GraphVertex<T,W> vertex : vertices) {
            for (GraphEdge<T,W> edge : vertex.edges) {
                if (edge.vertex.value == value) {
                    vertex.removeEdge(toRemove);
                    break;
                }
            }
        }
        vertices.remove(value);
    }

    public void removeEdge(T source, T destination) {
        GraphVertex<T, W> sourceVertex = vertices.get(source);
        GraphVertex<T, W> destinationVertex = vertices.get(destination);
        if (sourceVertex == null) throw new RuntimeException();
        if (destinationVertex == null) throw new RuntimeException();
        sourceVertex.removeEdge(destinationVertex);
    }
}
