class Solution {
    int[] parents;
    int[] sizes;
    int m, n;
    
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        this.m = grid.length;
        this.n = grid[0].length;
        
        // Step 1). copy table and removing all stones being hit
        this.parents = new int[m * n + 1];
        for (int i = 0; i <= m * n; i++) parents[i] = i;
        this.sizes = new int[m * n + 1];
        //Arrays.fill(sizes, 1);
        
        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                mat[i][j] = grid[i][j];
            
        for (int[] hit : hits) 
            mat[hit[0]][hit[1]] = 0;
        
        
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (mat[i][j] == 1) sizes[i * n + j] = 1;
        
        
        
        // Step 2). initialization, union all remaining entries
        for (int j = 0; j < n; j++) 
            if (mat[0][j] == 1) union(j, m * n);
            
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;
                
                int id = i * n + j;
                if (mat[i-1][j] == 1) union(id, (i-1) * n + j);
                if (j != 0 && mat[i][j-1] == 1) union(id, i * n + (j-1));
            }
        }

        
        // Step 3). adding bricks being hit
        int[] res = new int[hits.length];
        for (int h = hits.length - 1; h >= 0; h--) {
            int x = hits[h][0];
            int y = hits[h][1];
            if (grid[x][y] == 0) continue;
            
            // hit on a brick, add that brick back
            int id = x * n + y;
            mat[x][y] = 1;
            sizes[id] = 1;
            
            int afterStable = sizes[m * n];
            
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX < 0) {
                    union(id, m * n);
                    continue;
                }
                
                if (newY < 0 || newX >= m || newY >= n) continue;
                if (mat[newX][newY] == 0) continue;
                
                int nId = newX * n + newY;
                union(id, nId);
            }
            int currStable = sizes[m * n];
            
            // hitting the brick actually causes some brick to fall
            if (currStable - afterStable > 0) {
                res[h] = currStable - afterStable - 1;
            }
        }
        return res; 
    }
    
    private int find(int x) {
        while (x != parents[x]) {
            parents[x] = parents[parents[x]];
            x = parents[x];
        }
        return x;
    }
    
    private void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);
      
        if (xParent == yParent) return;
        
        if (xParent == m * n) {
            parents[yParent] = xParent;
            sizes[xParent] += sizes[yParent];
        } else {
            parents[xParent] = yParent;
            sizes[yParent] += sizes[xParent];
        }

    }
}