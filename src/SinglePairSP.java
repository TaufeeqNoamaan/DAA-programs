public class SinglePairSP {

    // Method to compute the shortest path from a single source vertex to all other vertices
    public static void shortestpath(int v, double cost[][], double dist[], int n) {
        boolean s[] = new boolean[n];  // Array to keep track of visited vertices

        // Initialize distances and the visited array
        for (int i = 0; i < n; i++) {
            dist[i] = Double.MAX_VALUE;  // Set initial distance to infinity for all vertices
            s[i] = false;  // Mark all vertices as unvisited
        }

        dist[v] = 0.0;  // Distance to the source vertex is 0

        // Main loop to find the shortest path to each vertex
        for (int count = 0; count < n - 1; count++) {
            int u = -1;  // Vertex with the minimum distance that hasn't been processed
            double minDist = Double.MAX_VALUE;  // Minimum distance found so far

            // Find the unvisited vertex with the smallest known distance
            for (int i = 0; i < n; i++) {
                if (!s[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    u = i;
                }
            }

            s[u] = true;  // Mark the selected vertex as visited

            // Update distances for adjacent vertices of the selected vertex
            for (int w = 0; w < n; w++) {
                // Update distance if a shorter path is found
                if (!s[w] && cost[u][w] != 0 && dist[u] != Double.MAX_VALUE && dist[u] + cost[u][w] < dist[w]) {
                    dist[w] = dist[u] + cost[u][w];
                }
            }
        }
    }

    public static void main(String args[]) {
        int n = 6;  // Number of vertices in the graph
        double cost[][] = {
                {0, 50, 45, 10, 0, 0},  // Cost matrix representing the graph
                {0, 0, 10, 15, 0, 0},
                {0, 0, 0, 0, 30, 0},
                {20, 0, 0, 0, 15, 0},
                {0, 20, 35, 0, 0, 0},
                {0, 0, 0, 0, 3, 0}
        };

        int source = 0;  // The source vertex from which to calculate shortest paths
        double distance[] = new double[n];  // Array to store the shortest distances from the source vertex

        shortestpath(source, cost, distance, n);  // Compute shortest paths using Dijkstra's algorithm

        // Print the shortest distances from the source vertex to each vertex
        System.out.println("Shortest distance from vertex : " + source);
        for (int i = 0; i < n; i++)
            System.out.println("To vertex " + i + " " + distance[i]);
    }
}
