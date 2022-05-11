class Solution {
    
    public  boolean inRange(int i, int j, int n, int m){
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;
        return true;
    }
    
   public int uniquePathsWithObstacles_01(int sr, int sc, int dr, int dc, int [][] dir, int [][] dp, int [][] grid){
        if(sr == dr && sc == dc){
            // System.out.println(asf);
            return dp[sr][sc] = 1;
        }
        
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }
        
        int count  = 0;
        for(int d = 0; d < dir.length; d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(inRange(r,c,dr + 1, dc + 1) && grid[r][c] == 0){
                count += uniquePathsWithObstacles_01(r,c, dr, dc, dir, dp, grid);
            }
        }
        return dp[sr][sc] = count;

    }
    
    public int uniquePathsWithObstacles(int n, int m, int [][] grid){
        
       
        int [][] dir = {{0,1}, {1,0}};

        // int ans = mazePath_01(0,0,n-1,m-1,dir, dirN, "");
        int [][] dp = new int[n][m];
        int ans = uniquePathsWithObstacles_01(0,0,n-1,m-1,dir,dp, grid);
        return ans;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        if(n == 0 || m == 0)
            return 0;
        
        //agr start of end me block hai toh return 0
        
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)
            return 0;
            
        
        return uniquePathsWithObstacles(n,m,grid);
    }
    
}