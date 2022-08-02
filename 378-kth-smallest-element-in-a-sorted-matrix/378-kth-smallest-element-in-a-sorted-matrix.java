class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int [] oneD = new int[n*n];
        int i,j,a=0;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                a = i * n + j;
                oneD[a] = matrix[i][j];
                a++;
            }
        }
        Arrays.sort(oneD); // 1,5,9,10,11,12,13,13,15
        return oneD[k-1];
    }
}