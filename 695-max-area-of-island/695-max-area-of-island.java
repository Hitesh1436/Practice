class Solution {
    public int garea;
    public void getarea(int[][] grid,int row,int col,int count){
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]!=1 ){
            return;
        }
        grid[row][col]=0;
        garea+=1;
        getarea(grid,row+1,col,count+1);
        getarea(grid,row-1,col,count+1);
        getarea(grid,row,col-1,count+1);
        getarea(grid,row,col+1,count+1);

    }
    public int maxAreaOfIsland(int[][] grid) {
       int area=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int val=grid[i][j];
                if(val==1){
                    int count=0;
                    garea=0;
                    getarea(grid,i,j,count);
                    area=Math.max(area,garea);
                }
            }
        }
        return area;
    }
}