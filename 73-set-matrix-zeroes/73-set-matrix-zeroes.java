// T(C) -> O(m*n) S(C) -> O(1)
class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j] == 0){
                    if(i==0){
                         row = true;
                    }
                    if(j==0){
                         col = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(matrix[i][0] ==0 || matrix[0][j]==0){
                    matrix[i][j] =0;
                }
            }
        }
        if(row == true){
            for(int j=0;j<c;j++){
                matrix[0][j] =0;
            }
        }
        if(col == true){
            for(int i=0;i<r;i++){
                matrix[i][0] =0;
            }
        }
    }
}