public class DFS
{
    public int v;
    public int adj[][];
    public int visited[];
    public DFS()
    {
        v = 8;
        visited = new int[v];
        adj = new int[][]
                {
                        { 0, 1, 1, 0, 0, 0, 0, 0 },
                        { 1, 0, 0, 1, 1, 0, 0, 0 },
                        { 1, 0, 0, 0, 0, 1, 1, 0 },
                        { 0, 1, 0, 0, 0, 0, 0, 1 },
                        { 0, 1, 0, 0, 0, 0, 0, 1 },
                        { 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 0, 0, 1, 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 1, 1, 1, 1, 0 }
                };
    }
    public void dfs(int s)
    {
        if(visited[s] == 0)
        {
            visited[s] = 1;
            System.out.print(s + " ");
            for(int j = 0; j < v; j++)
            {
                if(adj[s][j] == 1 && visited[j] == 0)
                    dfs(j);
            }
        }
    }
    public static void main(String args[])
    {
        DFS d = new DFS();
        System.out.print("DFS :: ");
        d.dfs(2);
    }
}