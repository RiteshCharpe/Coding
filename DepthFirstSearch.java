import java.util.*;

public class DepthFirstSearch {

    // Function to perform DFS traversal
    public static void dfs(int vertex, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
        // Mark the current vertex as visited
        visited.add(vertex);
        System.out.print(vertex + " "); // Process the vertex (here, we simply print it)

        // Recur for all the vertices adjacent to this vertex
        for (int neighbor : graph.get(vertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    // Main method to test DFS
    public static void main(String[] args) {
        // Creating a sample graph using an adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 5));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1, 5));
        graph.put(5, Arrays.asList(2, 4));

        Set<Integer> visited = new HashSet<>();

        // Perform DFS starting from vertex 0
        System.out.println("DFS Traversal starting from vertex 0:");
        dfs(0, graph, visited);
    }
}
