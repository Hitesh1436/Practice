class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int ogc = grid[row][col];  // ogc = original color
         dfsTravel(grid,row,col,ogc);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == -ogc){
                    grid[i][j] = color; 
                }
            }
        }
        return grid;
    }
    private void dfsTravel(int [][]grid,int r,int c,int ogc){
        if(r<0 || c<0 || r>=grid.length || c>= grid[0].length || grid[r][c]!=ogc){
            return;
        }
        grid[r][c] = -ogc;    // ek trke se mrk krdia humne 
        
         dfsTravel(grid,r-1,c,ogc);
         dfsTravel(grid,r+1,c,ogc);
         dfsTravel(grid,r,c-1,ogc);
         dfsTravel(grid,r,c+1,ogc);
        
        if(r>0 && c>0 && r<grid.length-1 && c<grid[0].length-1 && Math.abs(grid[r-1][c]) == ogc && Math.abs(grid[r][c+1]) == ogc && Math.abs(grid[r+1][c]) == ogc && Math.abs(grid[r][c-1]) == ogc){
            grid[r][c] = ogc;
        }
    }
}