class Solution {
    public boolean searchMatrix(int[][] mat, int tar) {
        int r = mat.length;
        int c= mat[0].length;
        if(r<1 || c<1){
            return false;
        }
        int i=0;
        int j = c-1;
        while(i<=r-1 && j>=0){  // start kia h first row last column se humne
            if(mat[i][j] == tar){
                return true;
            }else if(mat[i][j]>tar){
                j--;
            }else if(mat[i][j]<tar){
                i++;
            }
        }
        return false;
    }
}