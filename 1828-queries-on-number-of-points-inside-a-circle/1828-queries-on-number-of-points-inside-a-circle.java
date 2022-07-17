class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int [] ans = new int[queries.length];
        int i = 0, count;
        for(int [] query : queries){
            count = 0;
            int x = query[0], y = query[1], rad = query[2]*query[2];
            for(int [] point : points){
                if((y-point[1])*(y-point[1])+(x-point[0])*(x-point[0]) <= rad){
                   count++; 
                }      
            }
            ans[i++] = count;
        }
        return ans;
    }
}