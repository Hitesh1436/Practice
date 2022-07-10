class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
       int []dp = new int[n];
        for(int i=0;i<n;i++){
            if(i ==0 || i==1){
                dp[i] = cost[i];
            }else{
                dp[i]= Math.min(dp[i-1],dp[i-2]) + cost[i];
            }
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}