class Solution {
    public int fib(int n) {
        
        // T(C) = O(n);
        // S(C) = O(n);
        if(n<=1){
            return n;
        }
        // dp se try kro
        int []dp = new int[n+1];
        dp[0]=0;
        dp[1] =1;
        for(int i=2;i<=n;i++){
            dp[i]= dp[i-1]+ dp[i-2];
            
        }

    return dp[n];
    }
}