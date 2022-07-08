// Top-down approach with memoization:
class Solution {
    
    private int houses[], cost[][], m, n, target, memo[][][];
    private static final int MAX = Integer.MAX_VALUE;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.target = target;
        this.memo = new int[m][n + 1][target + 1];
        return dp(0, 0, 0);
    }
    
    private int dp(int i, int color, int neighborhood) {
        if (i == m)
            return neighborhood != target ? -1 : 0;
        
        if (neighborhood > target)
            return -1;
        
        if (memo[i][color][neighborhood] != 0)
            return memo[i][color][neighborhood];
        
        int min = MAX;
        if (houses[i] == 0) {
            for (int clr = 1; clr <= n; clr++) {
                int price = 0;
                if (clr == color)
                    price = dp(i + 1, clr, neighborhood);
                else
                    price = dp(i + 1, clr, neighborhood + 1);
                
                if (price >= 0)
                    min = Math.min(min, cost[i][clr - 1] + price);
            }    
        } else {
            if (houses[i] == color)
                min = dp(i + 1, houses[i], neighborhood);
            else
                min = dp(i + 1, houses[i], neighborhood + 1);
        }
        
        memo[i][color][neighborhood] = min == MAX ? -1 : min;
        return memo[i][color][neighborhood];
    }
}