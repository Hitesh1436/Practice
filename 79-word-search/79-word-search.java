class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean [][] vis = new boolean[m][n];
        char start = word.charAt(0);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==start){
                    // vis = new boolean[m][n];
                    if(dfs(board,word,0,i,j,vis)== true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char [][]board,String word,int idx,int i,int j,boolean[][]vis){
        if(idx >= word.length()){
            return true;    // mtlb sb milchuke the toh true dega
        }
        if(board[i][j] != word.charAt(idx)){
            return false;
        }
        vis[i][j] = true;  // mark krdia
        
        if(idx+1 >=word.length()){
            return true;
        }
        int [][]dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int d=0;d<4;d++){
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            if(x>=0 && y>=0 && x<board.length && y<board[0].length && vis[x][y]==false){
               boolean ans = dfs(board,word,idx+1,x,y,vis);
                if(ans == true){
                    return true;
                }
            }
        }
        vis[i][j] = false;
        return false;
    }
}