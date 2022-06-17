class Solution {
    class Pair{
        int i;
        int j;
        boolean border;
        Pair(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean [][]vis = new boolean[grid.length][grid[0].length];
        ArrayDeque<Pair> qu = new ArrayDeque<>();
          int ogc = grid[row][col];  // ogc = original color jispr jana h hume bas  
        Pair p = new Pair(row,col);
        p.border = isBorder(grid,row,col);
        qu.add(p);
        
        ArrayList<Pair> res = new ArrayList<>();   // to store border one's here tki bdmn unhe color kre bas
        while(qu.size()>0){
            Pair rem = qu.remove();
            if(vis[rem.i][rem.j] == true){
                continue;
            }
            vis[rem.i][rem.j] = true;
            
            res.add(rem);
            
            addN(rem.i-1,rem.j,grid,vis,qu,ogc);
            addN(rem.i+1,rem.j,grid,vis,qu,ogc);
            addN(rem.i,rem.j-1,grid,vis,qu,ogc);
            addN(rem.i,rem.j+1,grid,vis,qu,ogc);
        }
        for(Pair ans : res){   // isme humne AL bnai usme dkha agr border h toh jo color kha h usse mark krdia
            if(ans.border == true){
                grid[ans.i][ans.j] = color;
            }
        }
        return grid;
    }
    private void addN(int i,int j,int[][]grid,boolean[][]vis,ArrayDeque<Pair>qu,int ogc){
        if(i<0 || j<0 || i>=grid.length || j>= grid[0].length || vis[i][j] == true || grid[i][j] != ogc){
            return;
        }
        Pair p = new Pair(i,j);
        p.border = isBorder(grid,i,j);
        qu.add(p);
    }
    private boolean isBorder(int[][]grid,int i,int j){
        if(i == 0){
            return true;
        }else if(i == grid.length-1){
            return true;
        }else if(j == 0){
            return true;
        }else if(j == grid[0].length -1){
            return true;
        }else{
            // iss else ka mtlb border pr toh ni h lkin check kro kya uske 4 direction mn same color h ya ni
            int clr = grid[i][j];
            if(grid[i-1][j] != clr){
                return true;
            }else if(grid[i][j+1] != clr){
                return true;
            }else if(grid[i+1][j] != clr){
                return true;
            }else if(grid[i][j-1] != clr){
                return true;
            }
            return false;
        }
    }
}