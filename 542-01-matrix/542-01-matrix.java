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
    public int[][] updateMatrix(int[][] mat) {
        boolean [][]vis = new boolean[mat.length][mat[0].length];
        ArrayDeque<Pair> qu = new ArrayDeque<>();
        
        int [][]ans = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    qu.add(new Pair(i,j,0));
                }
            }
        }
        while(qu.size()>0){
            Pair rem = qu.remove();
            
            if(vis[rem.i][rem.j] == true){
                continue;
            }
            vis[rem.i][rem.j] = true;
            
            ans[rem.i][rem.j] = rem.level;
            
            addNeighbours(rem.i-1,rem.j,rem.level+1,mat,vis,qu);
            addNeighbours(rem.i+1,rem.j,rem.level+1,mat,vis,qu);
            addNeighbours(rem.i,rem.j-1,rem.level+1,mat,vis,qu);
            addNeighbours(rem.i,rem.j+1,rem.level+1,mat,vis,qu);
            
        }
        return ans;
    }
    private void addNeighbours( int i,int j,int level,int[][]mat,boolean[][]vis,ArrayDeque<Pair>qu){
        if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || vis[i][j] == true || mat[i][j] == 0){
            return;
        }
        qu.add(new Pair(i,j,level));
    }
}