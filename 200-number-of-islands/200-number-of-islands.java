class Solution {
    static int[][]dir = {{-1,0},{0,1},{1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid,int i,int j){
        // mark krdoo
        grid[i][j] ='0';
        
        for(int []d : dir){
            int row = i + d[0];
            int col = j + d[1];
            
            if(row>=0 && col>=0 && row<grid.length && col<grid[0].length && grid[row][col]=='1'){
                dfs(grid,row,col);
            }
        }
    }
}