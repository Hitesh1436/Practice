// T(C) -> O(m+n)
class Solution {
    public boolean searchMatrix(int[][] matrix, int tar) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        if(matrix == null || m < 1 || n <1){
            return false;
        }
        int j = n-1;  // first row mn last col se start krrhe hn 
        int i = 0;
        while(j>=0 && i<=m-1){
            if(matrix[i][j] == tar){
                return true;
            }else if(matrix[i][j] > tar){
                j--;
            }else if(matrix[i][j] < tar){
                i++;
            }
        }
        return false;
    }
}