class Solution {
    public List<List<String>> solveNQueens(int n) {
        int chess[][] = new int[n][n];
		List<List<String>> result = new ArrayList<>();
		findWays(chess, new ArrayList<String>(), result, 0);
		return result;
	}
	public static void findWays(int[][] chess, List<String> temp, List<List<String>> result, int row) {
		if(row == chess.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		for(int col = 0 ; col < chess.length ; col++) {
			if(isQueenSafe(chess, row, col)) {
				chess[row][col] = 1;
				String str = "";
				for(int i = 0 ; i < chess.length ; i++) {
					if(i == col) {
						str+='Q';
					}else {
						str+='.';
					}
				}
				temp.add(str);
				findWays(chess, temp, result, row+1);
				temp.remove(str);
				chess[row][col] = 0;
			}
		}
	}
	public static boolean isQueenSafe(int[][] chess, int row, int col) {
		for(int i = row-1 , j = col ; i >= 0 ; i--) {
			if(chess[i][j] == 1)
				return false;
		}
		for(int i = row-1 , j = col-1 ; i>=0 && j>=0 ; i--, j--) {
			if(chess[i][j] == 1)
				return false;
		}
		for(int i = row-1 , j = col+1 ; i>=0 && j<chess.length ; i--, j++) {
			if(chess[i][j] == 1)
				return false;
		}
		return true;
	}
}