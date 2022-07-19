class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a,b) -> a[0] > b[0]? 1:-1); // sort in ascending order
        int first = points[0][0];
        int max = 0;
        for(int i=1; i<points.length;i++){
            max = Math.max(max, points[i][0] - first); // update max if necessary
            first = points[i][0];
        }
		return max; 
    }
}