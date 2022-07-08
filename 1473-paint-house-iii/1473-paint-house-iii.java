// Bottom-up approach:
class Solution {    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int MAX = Integer.MAX_VALUE;
        int[][][] dp = new int[m + 1][n + 1][target + 2];
        
        for (int i = m; i >= 0; i--) {
            for (int color = n; color >= 0; color --) {
                for (int neighborhood = target + 1; neighborhood >= 0; neighborhood--) {
                    if (i == m) {
                        dp[i][color][neighborhood] = neighborhood != target ? -1 : 0;
                        continue;
                    }
                    
                    if (neighborhood > target) {
                        dp[i][color][neighborhood] = -1;
                        continue;
                    }
                    
                    int min = MAX;
                    if (houses[i] == 0) {
                        for (int clr = 1; clr <= n; clr++) {
                            int price = 0;
                            if (clr == color)
                                price = dp[i + 1][clr][neighborhood];
                            else
                                price = dp[i + 1][clr][neighborhood + 1];
                            
                            if (price >= 0)
                                min = Math.min(min, cost[i][clr - 1] + price);
                        }
                    } else {
                        if (houses[i] == color)
                            min = dp[i + 1][houses[i]][neighborhood];
                        else
                            min = dp[i + 1][houses[i]][neighborhood + 1];
                    }
                    dp[i][color][neighborhood] = min == MAX ? -1 : min;
                }
            }
        }
        return dp[0][0][0];
    }
}