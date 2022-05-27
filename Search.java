import java.util.*;

public class Search<Vertex> {
    protected int count;
    protected Set<Vertex> marked;
    protected Map<Vertex, Vertex> edgeTo;
    protected final Vertex source;

    public Search(Vertex source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex v) {
        return marked.contains(v);
    }

    public String output(Vertex v) {
        String value = "";

        if (!hasPathTo(v)) return null;
        LinkedList<Vertex> ls = new LinkedList<>();
        for (Vertex i = v; i != source; i = edgeTo.get(i)) {
            ls.push(i);
        }
        ls.push(source);

        for (int i = 0; i < ls.size(); i++) {
            value += ls.get(i);
            if (i != ls.size() - 1) value += " -> ";
        }
        return value;
    }
}