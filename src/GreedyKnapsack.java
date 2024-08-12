public class GreedyKnapsack {

    public void greedyKS() {
        int m = 20, n =3;
        int i;
        float [] profit = {24,15,25};
        float [] x = {0,0,0};
        float [] wt = {15, 10, 8};
        float u = m;
        float total = 0;

        for (i = 0; i < n; i++) {
            if(wt[i] > u) {
                break;
            }
            x[i] = 1;
            u = u - wt[i];
            if (i <= n) {
                x[i] = u / wt[i];
            }
        }
        for (i = 0; i < n; i++) {
            total = total + (profit[i] * x[i]);
        }
        System.out.println(total);

    }

    public static void main(String[] args) {
        GreedyKnapsack G = new GreedyKnapsack();
        G.greedyKS();
    }
}
