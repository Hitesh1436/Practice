class Solution {
    int count =0;
    public int totalNQueens(int n) {
        char [][]chess = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chess[i][j]= '.';
            }
        }
        fixQueenPlace(n,chess,0);
        return count;
    }
    private void fixQueenPlace(int n,char[][] chess,int r){
        if(r == n){
            count++;
            return;
        }
        for(int col=0;col<n;col++){
            if(isQueenSafe(chess,r,col)){
                chess[r][col]='Q';
                fixQueenPlace(n,chess,r+1);
                chess[r][col]='.';
            }
        }
    }
    private  boolean isQueenSafe(char[][] chess, int row, int col) {
		for(int i = row-1 , j = col ; i >= 0 ; i--) {
			if(chess[i][j] == 'Q')
				return false;
		}
		for(int i = row-1 , j = col-1 ; i>=0 && j>=0 ; i--, j--) {
			if(chess[i][j] == 'Q')
				return false;
		}
		for(int i = row-1 , j = col+1 ; i>=0 && j<chess.length ; i--, j++) {
			if(chess[i][j] == 'Q')
				return false;
		}
		return true;
	}
}