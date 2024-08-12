public class Prims {
    // Number of vertices in the graph
    public int n;
    // Adjacency matrix to represent the graph
    public int cost[][];
    // To store the minimum cost of the MST
    int min_cost = Integer.MAX_VALUE;
    // To store the vertices of the minimum edge found initially
    int k = -1, l = -1;
    // Array to store the edges of the MST
    int t[][];
    // Array to store the nearest vertex to the MST for each vertex
    int near[];

    // Constructor to initialize the graph and variables
    public Prims() {
        n = 6; // Number of vertices in the graph
        t = new int[n-1][2]; // n-1 edges in a Minimum Spanning Tree
        near = new int[n]; // Array to track the nearest node for each vertex
        cost = new int[][]{ // Adjacency matrix representing the graph
                {Integer.MAX_VALUE, 28, Integer.MAX_VALUE, Integer.MAX_VALUE, 10, Integer.MAX_VALUE},
                {28, Integer.MAX_VALUE, 16, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 16, Integer.MAX_VALUE, 12, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 12, Integer.MAX_VALUE, 22, Integer.MAX_VALUE},
                {10, Integer.MAX_VALUE, Integer.MAX_VALUE, 22, Integer.MAX_VALUE, 24},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 24, Integer.MAX_VALUE}
        };

        // Initialize the near array to indicate no vertex is part of the MST initially
        for (int i = 0; i < n; i++) {
            near[i] = -1;
        }
    }

    // Method to find the Minimum Spanning Tree using Prim's Algorithm
    public void primsMST() {
        // Step 1: Find the minimum edge in the entire graph
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cost[i][j] < min_cost) {
                    min_cost = cost[i][j];
                    k = i;
                    l = j;
                }
            }
        }

        // Initialize the first edge in the MST
        t[0][0] = k;
        t[0][1] = l;

        // Set the near array to reflect the nearest node for each vertex
        for (int i = 0; i < n; i++) {
            if (cost[i][l] < cost[i][k]) {
                near[i] = l;
            } else {
                near[i] = k;
            }
        }
        near[k] = near[l] = -1; // Mark the first two vertices as part of the MST

        // Step 2: Build the rest of the MST
        for (int i = 1; i < n-1; i++) {
            // Find the nearest vertex not in the MST
            int j = nearMin();
            // Add the edge to the MST
            t[i][0] = j;
            t[i][1] = near[j];

            // Add the cost of the edge to the total minimum cost
            min_cost += cost[j][near[j]];
            near[j] = -1; // Mark the vertex as part of the MST

            // Update the near array to reflect the nearest node for the remaining vertices
            for (int k = 0; k < n; k++) {
                if (near[k] != -1 && cost[k][near[k]] > cost[k][j]) {
                    near[k] = j;
                }
            }
        }

        // Output the minimum cost of the MST
        System.out.println("Minimum cost of MST: " + min_cost);

        // Display the edges in the MST
        for (int i = 0; i < n-1; i++) {
            System.out.println("Edge: (" + t[i][0] + ", " + t[i][1] + ")");
        }
    }

    // Helper method to find the nearest vertex not in the MST
    public int nearMin() {
        int j_min = Integer.MAX_VALUE;
        int j_val = -1;
        for (int i = 0; i < n; i++) {
            if (near[i] != -1 && cost[i][near[i]] < j_min) {
                j_min = cost[i][near[i]];
                j_val = i;
            }
        }
        return j_val;
    }

    // Main method to execute the Prim's Algorithm
    public static void main(String[] args) {
        Prims p = new Prims(); // Create an instance of the Prims class
        p.primsMST(); // Call the method to find the MST
    }
}
