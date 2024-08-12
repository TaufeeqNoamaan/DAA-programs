public class DFS {
    public int v;           // Number of vertices in the graph
    public int adj[][];     // Adjacency matrix representing the graph
    public int visited[];   // Array to track visited vertices

    // Constructor to initialize the graph with 8 vertices and the adjacency matrix
    public DFS() {
        v = 8; // Number of vertices
        visited = new int[v]; // Initialize the visited array with all elements set to 0 (unvisited)

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

    // DFS traversal starting from a given source vertex 's'
    public void dfs(int s) {
        if (visited[s] == 0) {    // Check if the vertex 's' is not visited
            visited[s] = 1;       // Mark the vertex 's' as visited
            System.out.print(s + " ");  // Print the visited vertex

            // Explore all adjacent vertices of the current vertex 's'
            for (int j = 0; j < v; j++) {
                // If there is an edge from 's' to 'j' and 'j' is not visited, perform DFS on 'j'
                if (adj[s][j] == 1 && visited[j] == 0) {
                    dfs(j);  // Recursive call to DFS for vertex 'j'
                }
            }
        }
    }

    // Main method to run the DFS program
    public static void main(String args[]) {
        DFS d = new DFS(); // Create an instance of the DFS class
        System.out.print("DFS :: ");
        d.dfs(2); // Perform DFS starting from vertex 2
    }
}
