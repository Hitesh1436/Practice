class Solution {
      boolean flag = true;
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    dfs(grid,i,j);
                    if(flag == true){
                        ans++;
                    }
                    flag = true;
                }
            }
        }
        return ans;
    }
    public void dfs(int[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length|| grid[i][j] ==1){
              return; 
        }
      if(( i==0 || j==0 || i==grid.length-1 | j==grid[0].length-1) && grid[i][j]==0){
          flag = false;
      }
        grid[i][j] =1;
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}