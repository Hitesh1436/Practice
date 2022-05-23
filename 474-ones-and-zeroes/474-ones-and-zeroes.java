class Solution {
    public int findMaxForm(String[] s, int m, int n) {
        int [][]dp = new int[m+1][n+1];
        for(String str : s){
            int zeros = 0,ones = 0;
            for(char ch : str.toCharArray()){
                if(ch == '0'){
                    zeros++;
                }else{
                    ones++;
                }
            }
            for(int i=m;i>=zeros;i--){
                    for(int j=n;j>=ones;j--){
                        dp[i][j] = Math.max(dp[i][j],dp[i-zeros][j-ones]+1);
                    }
                }
            
        }
        return dp[m][n];
    } 
}

// class Solution {
//     public int findMaxForm(String[] S, int M, int N) {
//         int[][] dp = new int[M+1][N+1];
//         for (String str : S) {
//             int zeros = 0, ones = 0;
//             for (char c : str.toCharArray())
//                 if (c == '0') zeros++;
//                 else ones++;
//             for (int i = M; i >= zeros; i--)
//                 for (int j = N; j >= ones; j--)
//                     dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
//         }
//         return dp[M][N];
//     }
// }