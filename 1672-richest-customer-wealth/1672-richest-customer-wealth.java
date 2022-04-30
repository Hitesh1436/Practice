class Solution {
    int max = Integer.MIN_VALUE;
    public int maximumWealth(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        for(int i=0;i<n;i++){
            int sum =0;
            for(int j=0;j<m;j++){
                sum+=arr[i][j];
            }
            max = Math.max(max,sum);
             
        }
        return max;
    }
}