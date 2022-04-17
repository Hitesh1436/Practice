class Solution {
    public int area;
    public void getArea(int [][]grid , int i,int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j] ==1){
            grid[i][j] = 0; // mark krdia humne 0 
                
                area++;
            getArea(grid,i+1,j);
            getArea(grid,i-1,j);
            getArea(grid,i,j+1);
            getArea(grid,i,j-1);
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    area=0;
                    getArea(grid,i,j);
                    ans = Math.max(ans,area);
                }
            }
        }
        return ans;
    }
}