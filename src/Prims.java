public class Prims {
    public int n;
    public int cost[][];
    int min_cost = Integer.MAX_VALUE;
    int k = -1, l = -1; // neighbors
    int t[][]; // MST
    int near[]; //nearest node

    public Prims() {
        n = 6;
        k = -1;
        l = -1;
        t = new int[n][2];
        near = new int[n];
        cost = new int[][]{
                {Integer.MAX_VALUE, 28, Integer.MAX_VALUE, Integer.MAX_VALUE, 10, Integer.MAX_VALUE},
                {28, Integer.MAX_VALUE, 16, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 16, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 12, Integer.MAX_VALUE, 22, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 22, Integer.MAX_VALUE, 24},
                {10, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 67, Integer.MAX_VALUE}
        };

        for (int i = 0; i < n; i++) {
            near[i] = -1;
        }
    }

    public void primsMST(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cost[i][j] < min_cost) {
                    min_cost = cost[i][j];
                    k = i;
                    l = j;
                }
            }
        }
        min_cost = cost[k][l];
        t[l][0] = k;
        t[k][1] = l;
//        for (int i)
    }
}
