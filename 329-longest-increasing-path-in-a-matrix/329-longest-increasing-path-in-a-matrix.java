class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
		//Base condition
        if(matrix.length==0)
            return 0;
        
		
        int dp[][] = new int[matrix.length][matrix[0].length];
        int max = 0;
        
        for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                //result is not stored
                if(dp[i][j]==0){
                   dfs(matrix,i,j,Integer.MIN_VALUE,dp);
                   max = Math.max(dp[i][j],max); 
                }
            }
        }
        
        return max;
    }
    
    private int dfs(int[][] matrix,int i,int j,int pre,int[][] dp){
        //Dont fo beyond boundaries and next element should be greater for increasing path
        if(i<0 || j<0 ||i>=matrix.length || j>=matrix[0].length || pre>=matrix[i][j])
            return 0;
			
		//already explored
        else if(dp[i][j]!=0) return dp[i][j];
        
		//exploring all direction
        int pathOne = dfs(matrix,i+1,j,matrix[i][j],dp);
        int pathTwo = dfs(matrix,i-1,j,matrix[i][j],dp);
        int pathThree = dfs(matrix,i,j-1,matrix[i][j],dp);
        int pathFour = dfs(matrix,i,j+1,matrix[i][j],dp);
        
		//finding the max path
        int maxOne = Math.max(pathOne,pathTwo);
        int maxTwo = Math.max(pathThree,pathFour);
        
		//store maximum path on that index
        dp[i][j] = 1+Math.max(maxOne,maxTwo);
        
        return dp[i][j];
        
    }
}