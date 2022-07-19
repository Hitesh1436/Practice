class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int []arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = points[i][0];
        }
        Arrays.sort(arr);
        int diff = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(arr[i] - arr[i-1]>diff){
                diff = arr[i] - arr[i-1];
            }
        }
        return diff;
    }
}