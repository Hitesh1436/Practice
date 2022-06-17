class Solution {
    class Pair{
        int i;
        int j;
        int level;
        Pair(int i,int j,int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    public int shortestBridge(int[][] grid) {
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        boolean [][] vis1 = new boolean[grid.length][grid[0].length];
        boolean found = false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    dfs(grid,vis1,qu,i,j);
                    found = true;
                    break;
                }
            }
            if(found == true){
                break;
            }
        }
        
        boolean [][]vis2 = new boolean[grid.length][grid[0].length];
        while(qu.size()>0){
            Pair rem = qu.remove();
            if(vis2[rem.i][rem.j] == true){
                continue;
            }
            vis2[rem.i][rem.j] = true;
            
            if(grid[rem.i][rem.j] == 1){
                return rem.level -1;
            }
            addN(grid,vis2,qu,rem.i-1,rem.j,rem.level +1);
            addN(grid,vis2,qu,rem.i,rem.j+1,rem.level +1);
            addN(grid,vis2,qu,rem.i+1,rem.j,rem.level +1);
            addN(grid,vis2,qu,rem.i,rem.j-1,rem.level +1);
        }
        return -1;
    }
    private void addN(int [][]grid,boolean[][]vis2,ArrayDeque<Pair>qu,int i,int j,int level){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return;
        }else if(vis2[i][j] == true){
            return;
        }else if(grid[i][j] == 2){
            return;
        }
        qu.add(new Pair(i,j,level));
    }
    private void dfs(int[][]grid,boolean[][]vis, ArrayDeque<Pair> qu,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || vis[i][j] == true|| grid[i][j] == 0){
            return;
        }
        vis[i][j] = true;
        qu.add(new Pair(i,j,0));  // phla component ko qu mn bhrlao nd sbka level 0 hoga
        dfs(grid,vis,qu,i-1,j);
        dfs(grid,vis,qu,i,j+1);
        dfs(grid,vis,qu,i+1,j);
        dfs(grid,vis,qu,i,j-1);
        grid[i][j] = 2;  // sbko 2 bndia phle component ke 
    }
}