// T(C) -> O(nlogn)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> m = new TreeMap<>();
        for (int[] v: trips){
            int num_passengers = v[0];
            int start = v[1];
            int end = v[2];
            m.put(start, m.getOrDefault(start, 0) + num_passengers); // baith rha h toh add kia pass
            m.put(end, m.getOrDefault(end, 0) - num_passengers);// utrega rha h toh minus kia pass
        }
        int count=0;
        for (int c: m.values()){
            count+=c;
            if(count>capacity) return false;
        }
        return true;
    }
}