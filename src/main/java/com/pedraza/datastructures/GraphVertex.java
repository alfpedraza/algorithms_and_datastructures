package com.pedraza.datastructures;

public class GraphVertex<T, W> {
    
    public T value;
    public LinkedList<GraphEdge<T, W>> edges;

    public GraphVertex(T value) {
        this.value = value;
        this.edges = new LinkedList<>();
    }

    public void addEdge(GraphVertex<T, W> vertex, W weight) {
        GraphEdge<T, W> edge = new GraphEdge<T, W>(vertex, weight);
        edges.add(edge);
    }

    public void removeEdge(GraphVertex<T, W> vertex) {
        int index = 0;
        for (GraphEdge<T,W> graphEdge : edges) {
            if (graphEdge.vertex.value ==  vertex.value) {
                edges.remove(index);
                return;
            }
            index++;
        }
    }

}
