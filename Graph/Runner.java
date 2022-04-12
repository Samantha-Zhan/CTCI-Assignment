public class Runner {
    public static void main(String[] args) {
        Graph g = new Graph();
        System.out.println(g.adjacencyList);
        g.addNode('A');
        g.addNode('B');
        g.addEdge('A', 'B');
        System.out.println(g.adjacencyList);
        g.addNode('C');
        g.addEdge('C', 'A');
        System.out.println(g.adjacencyList);
        g.removeEdge('A', 'B');
        System.out.println(g.adjacencyList);
        g.addEdge('B', 'C');
        g.addEdge('A', 'B');
        System.out.println(g.adjacencyList);
        g.removeNode('A');
        System.out.println(g.adjacencyList);
    }
}
