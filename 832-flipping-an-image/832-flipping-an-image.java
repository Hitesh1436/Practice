class Solution {
    public int[][] flipAndInvertImage(int[][] arr) {
        int n = arr.length;
        
        int [][]dp = new int[n][n];
        // flip kia h
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=arr[i][n-j-1];
            }
        }
        // invert kro 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]= dp[i][j] ==1 ? 0:1;
            }
        }
        return dp;
        
    }
}