class Solution {
     public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid,row,col,grid[row][col]);
          for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]<0){
                    grid[i][j]= color;
                }
            }
        }
        return grid;
      
    }
    
    int [][]dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(int [][]grid,int row,int col,int clr){
       grid[row][col]= -clr;    // mark krdia 
       int count = 0;
       
       for(int i=0;i<4;i++){
           int r = row + dir[i][0];
           int c = col + dir[i][1];
           
           if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || Math.abs(grid[r][c])!=clr){
               continue;
           }
           count++;   // mtlb shi jgh h toh count ko bdhaoo 
           
           if(grid[r][c] == clr){
               dfs(grid,r,c,clr);
           }
       }
       if(count ==4){
           grid[row][col] = clr;
       }
    }
}