class Solution {
    public int coinChange(int[] coins, int amount) {
        int []dp = new int[amount+1];   // amount se jyda toh ni hoskta isliye itna bnya
        Arrays.fill(dp,amount+1);
            dp[0] = 0;   // 
        
        for(int i=1;i<dp.length;i++){
            for(int c : coins){
                if(i-c>=0){
                    dp[i]= Math.min(dp[i],dp[i-c]+1);
                }
            }
        }
        // jb amount ni bnpyii toh
        return dp[amount] == (amount+1) ? -1 : dp[amount];
    }
}