import java.util.*;
public class BFS
{
    public int v;
    public int adj[][];
    public BFS()
    {
        v = 8;
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
    public void bfs(int s)
    {
        Queue<Integer> q = new LinkedList<>();
        int visited[] = new int[v];
        q.add(s);
        visited[s] = 1;
        while(!q.isEmpty())
        {
            int i = q.remove();
            System.out.print(i + " ");
            for(int j = 0; j < v; j++)
            {
                if(adj[i][j] == 1 && visited[j] == 0)
                {
                    visited[j] = 1;
                    q.add(j);
                }
            }
        }
    }
    public static void main(String args[])
    {
        BFS b = new BFS();
        System.out.print("BFS :: ");
        b.bfs(2);
    }
}