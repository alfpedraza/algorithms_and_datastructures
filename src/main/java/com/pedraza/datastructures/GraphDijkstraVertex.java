package com.pedraza.datastructures;

public class GraphDijkstraVertex<T>
    extends GraphVertex<T, Integer>
    implements Comparable<GraphDijkstraVertex<T>>
{
    public Integer distance;
    public Boolean visited;
    public GraphDijkstraVertex<T> previous;

    public GraphDijkstraVertex(T value) {
        super(value);
        distance = Integer.MAX_VALUE;
        visited = false;
        previous = null;
    }

    @Override
    public int compareTo(GraphDijkstraVertex<T> other) {
        return distance.compareTo(other.distance);
    }
}
