import java.util.LinkedList;

public class WeightedGraph<Vertex> {
    private final boolean direct;
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();
    public WeightedGraph(boolean direct){
        this.direct = direct;
    }

    public void addVertex(Vertex v){
        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex dest, Vertex source, double weight){
        if (hasVertex(source)){
            addVertex(source);
        }
        if (hasVertex(dest)) {
            addVertex(dest);
        }
        if (hasEdge(source, dest) || source.equals(dest))
            return;
        map.get(source).add(new Edge<>(source, dest, weight));
        if (direct)
            map.get(dest).add(new Edge<>(dest, source, weight));
    }

    public boolean hasVertex(Vertex v) {
        return !map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (hasVertex(source)) return false;
        return map.get(source).contains(new Edge<>(source, dest));
    }

    public Iterable<Edge<Vertex>> getEdges(Vertex v) {
        if (hasVertex(v)) return null;
        return map.get(v);
    }

    public Iterable<Vertex> adjacencyList(Vertex v) {
        if (hasVertex(v)) return null;
        List<Vertex> vertices = new LinkedList<>();
        for (Edge<Vertex> e : map.get(v)) {
            vertices.add(e.getDest());
        }
        return vertices;
    }
}

