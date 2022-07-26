class Solution {
    public int idealArrays(int n, int m) {
        // step 1 ending number, length, unique plans
        int MOD = (int)1e9 + 7;
        long[][] dp = new long[m + 1][15];
        for(int i = 1; i <= m; i++){
            dp[i][1] = 1;
        }
        // based on current -> calculate next
        // length
        for(int j = 1; j < 14; j++){
            // current state ending
            for(int i = 1; i <= m; i++){
                // next state ending
                for(int k = 2; i * k <= m; k++){
                    dp[k * i][j + 1] = (dp[i][j] + dp[k * i][j + 1]) % MOD;
                }
            }
        }
        // step 2 combination
        long[][] C = new long[n][15];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 15 && j <= i; j++){
                if(j == 0) C[i][j] = 1;
                else C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
        // step 3 result 
        long res = 0L;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= 14 && j <= n; j++){
                res = (res + dp[i][j] * C[n - 1][j - 1]) % MOD;
            }
        }
        return (int)res;
    }
}