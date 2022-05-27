class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);
        graph.addEdge("2", "1", 1);
        graph.addEdge("2", "2", 8);
        graph.addEdge("3", "3", 4);
        graph.addEdge("4", "1", 4);
        graph.addEdge("4", "3", 5);
        graph.addEdge("4", "4", 6);

        System.out.print("Dijkstra: ");
        Search<String> dijkstraSearch = new DijkstraSearch<>(graph, "1");
        System.out.println(dijkstraSearch.output("6"));

        System.out.print("Breadth: ");
        Search<String> breadthFirstSearch = new BreadthFirstSearch<>(graph, "1");
        System.out.println(breadthFirstSearch.output("6"));
    }
}