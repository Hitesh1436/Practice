class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][]vis = new boolean[n][m];
        
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == false && grid[i][j]=='1'){
                    count ++;
                    traverse(grid,vis,i,j);
                }
            }
        }
        return count;
    }
    private void traverse(char [][]grid,boolean[][]vis,int i,int j){
         int n = grid.length;
        int m = grid[0].length;
        if(i<0 || j<0 || i>=n || j>=m){
            return;
        }else if(grid[i][j]=='0'){
            return ;
        }else if(vis[i][j]==true){
            return;
        }
        vis[i][j] = true;
        traverse(grid,vis,i-1,j);
        traverse(grid,vis,i+1,j);
        traverse(grid,vis,i,j-1);
        traverse(grid,vis,i,j+1);
    }
}