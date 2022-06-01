class Solution {
    public int[] runningSum(int[] arr) {
        int n = arr.length;
        int []dp = new int[n];
        dp[0] = arr[0];   // 1 dalgya
        for(int i=1;i<n;i++){
            dp[i] = dp[i-1]+ arr[i];
        }
        return dp;
    }
}