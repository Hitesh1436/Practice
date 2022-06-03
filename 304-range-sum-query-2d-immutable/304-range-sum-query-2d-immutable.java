class NumMatrix {
    private int[][] mat;
    public NumMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        
        mat=new int[m][n];
        
        mat[0][0]=matrix[0][0];
        
        int j=0;
        for(int i=1;i<m;i++)
            mat[i][j]=matrix[i][j]+mat[i-1][j];
        
        int i=0;
        
        for(j=1;j<n;j++)
            mat[i][j]=matrix[i][j]+mat[i][j-1];
        
        for(i=1;i<m;i++)
        {
            for(j=1;j<n;j++)
            {
                mat[i][j]=mat[i][j-1]+mat[i-1][j]-mat[i-1][j-1]+matrix[i][j];       
            }
        }
    
                
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        
        if (row1==0 && col1==0)
            return mat[row2][col2];
        else if (row1==0)
            return mat[row2][col2]-mat[row2][col1-1];
        else if(col1==0)
            return mat[row2][col2]-mat[row1-1][col2];
        else
            return mat[row2][col2] +mat[row1-1][col1-1]-mat[row2][col1-1]-mat[row1-1][col2];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */