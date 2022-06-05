class Solution {
    int count =0;
    // Approach 
    // 1. -> Ek function likha jo check krega place safe hai ya ni
    // 2. -> El function jo count btyga hume
    // 3. -> Recursion totalNQueens lgkr count return dega
    public int totalNQueens(int n) {
        int [][] chess = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chess[i][j]= 0;
            }
        }
        queenPlace(n,chess,0);
        return count;
    }
    private void queenPlace(int n,int [][]board,int row){
        if(row == n){
            count++;
            return;
        }
        for(int col=0;col<n;col++){
            // check kiya ki col jisme place krenge safe h ya ni
            if(isSafe(row,col,board)){
                board[row][col] = 1;  // us jgh Queen aygii
                queenPlace(n,board,row + 1);  
                board[row][col] =0;  // isse place krakr next row mn bdhgye hum
            } 
        }
    }
    private boolean isSafe(int row,int col,int [][]board){
        // right upward diagonal check
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]==1){
                return false;
            }
        }
        // upward directon ke liye
        for(int i=row-1,j=col;i>=0;i--){
            if(board[i][j]==1){
                return false;
            }
        }
        // left upward diagonal ke liye
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        // upr vale cases ke alwa mtlb safe h so we can place our queen
        return true;
    }
}