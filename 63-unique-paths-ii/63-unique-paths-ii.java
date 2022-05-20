class Solution {
    
    public boolean inRange(int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m){
            return false;
        }
        return true;
    }
    
    public int travelHelper(int sr,int sc,int dr,int dc,int[][]dir,int [][]dp,int [][]grid){
        if(sr == dr && sc == dc){
            return dp[sr][sc]=1;
        }
        
        if(dp[sr][sc]!=0){
            return dp[sr][sc];
        }
        int count = 0;
        for(int d=0;d<dir.length;d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(inRange(r,c,dr+1,dc+1) && grid[r][c]==0){
                count += travelHelper(r,c,dr,dc,dir,dp,grid);
            }
        }
        return dp[sr][sc] = count;
    }
    
    public int travel(int n,int m,int [][]grid){
        int [][]dir = {{0,1},{1,0}};
        int [][]dp = new int[n][m];
        
        int ans = travelHelper(0,0,n-1,m-1,dir,dp,grid);
        return ans;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        if(n==0 || m==0){
            return 0;
        }
        if(obstacleGrid[0][0]==1  || obstacleGrid[n-1][m-1]==1){
            return 0;
        }
        
        return travel(n,m,obstacleGrid);
    }
}