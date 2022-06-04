class Solution {
    public List<List<String>> solveNQueens(int n) {
        return queens(new boolean[n][n],0);
    }
 public   List<List<String>>  queens(boolean[][] board,int row){
        if (row == board.length) {
            List<List<String>> list = new ArrayList<>();
          list.add(display(board));
          return list;
        }

            List<List<String>> ans = new ArrayList<>();

            for (int col = 0; col < board.length; col++) {
                if(ifSafe(board,row,col)){
                    board[row][col] = true;
                    ans.addAll(queens(board,row+1));
                    board[row][col]= false;
                }
            }
        return ans;
    }
    public  boolean ifSafe(boolean[][] board,int row,int col){
        //chek for vertically
        for (int i = 0; i < row; i++) {
            if (board[i][col]){
                return false;
            }
        }

        //check for diagonal left

        int maxleft = Math.min(row,col);
        for (int i = 1 ; i <=maxleft ; i++) {
            if (board[row-i][col-i]){
                return false;
            }
        }
        // diagonal right check
        int maxright = Math.min(row, board.length-1-col);
        for (int i = 1; i <=maxright ; i++) {
            if (board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
    public  List<String> display(boolean[][] board){
        List<String> list = new ArrayList<>();
                String p ="";
        for(boolean[] arr:board){
            for (boolean element:arr){
                if (element == true){
                   p =p+"Q";
                }else {
                    p+=".";
                }
            }
            list.add(p);
            p="";
        }
        return list;
    }
}