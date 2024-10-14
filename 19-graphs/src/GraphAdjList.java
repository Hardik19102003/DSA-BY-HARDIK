import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphAdjList {
    private List<List<Integer>> adjList;
    private boolean[] visited;
    private int vertices;

    public GraphAdjList(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList<>();

        // Initialize adjacency lists for all vertices
        for (int i = 0; i < vertices; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    // Add an edge between vertex i and j
    public void addEdge(int i, int j) {
        adjList.get(i).add(j);
        adjList.get(j).add(i); // For undirected graph
    }

    // Print the adjacency list
    public void printAdjList() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer vertex : adjList.get(i)) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }

    // DFS traversal using the adjacency list
    public void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // Visit all adjacent vertices of the current vertex
        for (Integer adj : adjList.get(vertex)) {
            if (!visited[adj]) {
                dfs(adj);
            }
        }
    }

    // BFS traversal using the adjacency list
    public void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            // Visit all adjacent vertices of the current vertex
            for (Integer adj : adjList.get(vertex)) {
                if (!visited[adj]) {
                    queue.add(adj);
                    visited[adj] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphAdjList graph = new GraphAdjList(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printAdjList();
    }
}
