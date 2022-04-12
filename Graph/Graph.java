import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
    HashMap<Character, ArrayList<Character>> adjacencyList = new HashMap<Character, ArrayList<Character>>();
    Graph() {
        
    }

    void addNode(char value) {
        if(adjacencyList.get((Character)value) == null) {
            adjacencyList.put((Character)value, new ArrayList<Character>());
        }   
    }

    void addEdge(char node1, char node2) {
        if(adjacencyList.get(node1)==null || adjacencyList.get(node2)==null){
            return;
        }
        adjacencyList.get(node1).add(node2);
        adjacencyList.get(node2).add(node1);
    }

    void removeEdge(char node1, char node2) {
        if(adjacencyList.get(node1)==null || adjacencyList.get(node2)==null){
            return;
        }
        adjacencyList.get(node1).removeIf(value -> value == node2);
        adjacencyList.get(node2).removeIf(value -> value == node1);
    }

    void removeNode(char node) {
        adjacencyList.remove(node);
        for(ArrayList<Character> value : adjacencyList.values()) {
            value.remove((Character)node);
        }
    }
}

    /**
     * Vertex: a node
     * Nodes: 
     * Edges: connection between nodes
     * Weighted/unweighted: values assigned to the edges
     * Directed/undirected
     * - Close graph
     * - Open graph
     * 
     * Storing matrix
     * - Adjacency matrix
     *      A   B   C
     * A    1   1   0
     * B    0   1   1   
     * C    0   0   0
     * 
     * - Adjacency list
     * {
     *  "A":["B","D"],
     *  "B":["B","D"],
     *  "C":["B","D"],
     * }
     */
