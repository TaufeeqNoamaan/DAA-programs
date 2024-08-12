public class AllPairSP {
    static final int INF = 999999;
    public static int[][] All_pairs(int graph[][])
    {
        int v = graph.length;
        int dist[][] = new int[v][v];
        for(int i = 0; i < v; i++)
        {
            for(int j = 0; j < v; j++)
            {
                dist[i][j] = graph[i][j];
            }
        }
        for(int k = 0; k < v; k++)
        {
            for(int i = 0; i < v; i++)
            {
                for(int j = 0; j < v; j++)
                {
                    if(dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        return dist;
    }
    public static void printSolution(int dist[][])
    {
        int v = dist.length;
        for(int i = 0; i < v; i++)
        {
            for(int j = 0; j < v; j++)
            {
                if(dist[i][j] == INF)
                    System.out.print("INF");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
        int graph[][] = {
                {0, 3, INF, 7},
                {8, 0, 2, INF},
                {5, INF, 0, 1},
                {2, INF, INF, 0}
        };
        int shortestDistance[][] = All_pairs(graph);
        System.out.println("Shortest distance between every pair of vertices");
        printSolution(shortestDistance);
    }
}
