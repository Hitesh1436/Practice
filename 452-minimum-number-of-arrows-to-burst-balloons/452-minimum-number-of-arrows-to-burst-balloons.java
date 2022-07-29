class Solution {
    public int findMinArrowShots(int[][] points) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        for(int[] point: points){
            if(list.size() == 0){
                list.add(point);
            }
            else{
                int[] ele = list.get(list.size()-1);
                if(point[0] <= ele[1]){
                    ele[1] = Math.min(ele[1], point[1]);
                }
                else{
                    list.add(point);
                }
            }
        }
        return list.size();
    }
}