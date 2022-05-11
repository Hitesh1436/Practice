class Solution {
    public int uniquePaths(int n, int m) {
        // int [][]ans = new int[n][m];
        int [][]dp = new int[n][m];
        
        for(int x=0;x<n;x++){
            for(int y=0;y<m;y++){
                if(x==0 || y==0){
                    dp[x][y]=1; 
                }else{
                    dp[x][y]= dp[x-1][y]+dp[x][y-1];   
                }
            }
           
        }
         return dp[n-1][m-1];
    }
}