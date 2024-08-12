import java.util.*;

public class BFS {
    public int v;           // Number of vertices in the graph
    public int adj[][];     // Adjacency matrix representing the graph

    // Constructor to initialize the graph with 8 vertices and a given adjacency matrix
    public BFS() {
        v = 8; // Number of vertices
        adj = new int[][] {
                // Adjacency matrix representing the graph
                { 0, 1, 1, 0, 0, 0, 0, 0 },  // Vertex 0 is connected to 1, 2
                { 1, 0, 0, 1, 1, 0, 0, 0 },  // Vertex 1 is connected to 0, 3, 4
                { 1, 0, 0, 0, 0, 1, 1, 0 },  // Vertex 2 is connected to 0, 5, 6
                { 0, 1, 0, 0, 0, 0, 0, 1 },  // Vertex 3 is connected to 1, 7
                { 0, 1, 0, 0, 0, 0, 0, 1 },  // Vertex 4 is connected to 1, 7
                { 0, 0, 1, 0, 0, 0, 0, 1 },  // Vertex 5 is connected to 2, 7
                { 0, 0, 1, 0, 0, 0, 0, 1 },  // Vertex 6 is connected to 2, 7
                { 0, 0, 0, 1, 1, 1, 1, 0 }   // Vertex 7 is connected to 3, 4, 5, 6
        };
    }

    // BFS traversal starting from a given source vertex 's'
    public void bfs(int s) {
        Queue<Integer> q = new LinkedList<>(); // Queue for BFS
        int visited[] = new int[v];            // Array to track visited vertices

        q.add(s);          // Add the source vertex to the queue
        visited[s] = 1;    // Mark the source vertex as visited

        while (!q.isEmpty()) {  // Continue until the queue is empty
            int i = q.remove(); // Dequeue a vertex from the queue
            System.out.print(i + " "); // Print the visited vertex

            // Explore all adjacent vertices of the dequeued vertex
            for (int j = 0; j < v; j++) {
                // If there is an edge from 'i' to 'j' and 'j' is not visited
                if (adj[i][j] == 1 && visited[j] == 0) {
                    visited[j] = 1; // Mark vertex 'j' as visited
                    q.add(j);       // Enqueue vertex 'j'
                }
            }
        }
    }

    // Main method to run the BFS program
    public static void main(String args[]) {
        BFS b = new BFS(); // Create an instance of the BFS class
        System.out.print("BFS :: ");
        b.bfs(2); // Perform BFS starting from vertex 2
    }
}
