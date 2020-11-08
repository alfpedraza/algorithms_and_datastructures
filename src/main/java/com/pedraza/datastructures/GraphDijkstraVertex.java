package com.pedraza.datastructures;

public class GraphDijkstraVertex<T>
    extends GraphVertex<T, Integer>
    implements Comparable<GraphDijkstraVertex<T>>
{
    private Integer distance;
    private Boolean visited;
    private GraphDijkstraVertex<T> previous;

    public Integer getDistance() { return distance; }
    public Boolean getVisited() { return visited; }
    public GraphDijkstraVertex<T> getPrevious() { return previous; }

    public void setDistance(Integer value) { distance =  value; }
    public void setVisited(Boolean value) { visited =  value; }
    public void setPrevious(GraphDijkstraVertex<T> value) { previous =  value; }

    public GraphDijkstraVertex(T value) {
        super(value);
        distance = Integer.MAX_VALUE;
        visited = false;
        previous = null;
    }

    @Override
    public int compareTo(GraphDijkstraVertex<T> other) {
        return distance.compareTo(other.getDistance());
    }
}
