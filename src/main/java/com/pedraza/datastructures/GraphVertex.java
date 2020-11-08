package com.pedraza.datastructures;

public class GraphVertex<T, W> {
    
    private T value;
    private LinkedList<GraphEdge<T, W>> edges;

    public T getValue() { return value; }
    public LinkedList<GraphEdge<T, W>> getEdges() { return edges; }

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
            if (graphEdge.getVertex().value ==  vertex.value) {
                edges.remove(index);
                return;
            }
            index++;
        }
    }

}
