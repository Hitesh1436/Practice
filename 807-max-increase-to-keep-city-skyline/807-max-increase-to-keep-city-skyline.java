class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // the highest each point can be is min(rowmax, colmax).
        
        int[] rowmaxes = new int[grid.length];
        int[] colmaxes = new int[grid[0].length];
        
        // get row and col maxima
        for (int i = 0; i < grid.length; i++) {
            rowmaxes[i] = grid[i][0];
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) colmaxes[j] = grid[0][j];
                if (grid[i][j] > rowmaxes[i]) rowmaxes[i] = grid[i][j];
                if (grid[i][j] > colmaxes[j]) colmaxes[j] = grid[i][j];           
            }
        }  
        // Sum the differences
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                total += Math.min(rowmaxes[i], colmaxes[j]) - grid[i][j];
            }
        }
        
        return total;
    }
}