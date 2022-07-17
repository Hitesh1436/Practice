class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if(grid.length ==0) return 0;
        int n = grid.length;
        int []maxrow = new int[n];
         int []maxcol = new int[n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                maxrow[i] = Math.max(maxrow[i],grid[i][j]);
                maxcol[j] = Math.max(maxcol[j],grid[i][j]);
            }
         }   
            int count =0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    count +=(Math.min(maxrow[i],maxcol[j])-grid[i][j]);
                }
            }
        
        return count;
    }
}