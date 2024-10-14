import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GraphMatrix {
    private int[][] adjMatrix;
    private boolean[] visited;
    private int vertices;

    public GraphMatrix(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }

    // Add an edge between vertex i and j
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1; // For undirected graph
    }

    // Print the adjacency matrix
    public void printMatrix() {
        for (int[] row : adjMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // DFS traversal using the adjacency matrix
    public void dfs(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        // Visit all adjacent vertices of the current vertex
        for (int i = 0; i < vertices; i++) {
            if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    // BFS traversal using the adjacency matrix
    public void bfs(int startVertex) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            // Visit all adjacent vertices of the current vertex
            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        GraphMatrix graph = new GraphMatrix(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printMatrix();
    }
}
