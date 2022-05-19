class Solution {
   
    public int longestIncreasingPath(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        
		//We create a cache for saving the computed result
        int cache[][]=new int[n][m];
        int max=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                max=Math.max(max, recurse(matrix,i,j,cache));
        }
        return max;
    }
    
    public int recurse(int [][]mat, int r, int c, int [][]cache){
	//Check boundary condition
        if(r<0||r>=mat.length||c<0||c>=mat[0].length)
            return 0;
			//If result is pre-computed use the same result
        if(cache[r][c]!=0)
            return cache[r][c];
        
        int ans=0;

        //In each direction up,bottom,left and right, check if it is possible to move or not
        if(c-1>=0&&mat[r][c-1]>mat[r][c])
            ans=Math.max(ans,recurse(mat,r,c-1,cache));
        if(c+1<mat[0].length&&mat[r][c+1]>mat[r][c])
            ans=Math.max(ans,recurse(mat,r,c+1,cache));
        if(r-1>=0&&mat[r-1][c]>mat[r][c])
            ans=Math.max(ans,recurse(mat,r-1,c,cache));
        if(r+1<mat.length&&mat[r+1][c]>mat[r][c])
            ans=Math.max(ans,recurse(mat,r+1,c,cache));        
			
		//Finally, take the biggest possible answer and add 1 as this current element must be counted
		//Store that result in the cache
        cache[r][c]=1+ans;
        return 1+ans;
        
    }
}