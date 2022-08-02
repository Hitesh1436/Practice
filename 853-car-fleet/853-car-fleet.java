class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0;i<position.length;i++){
            map.put(position[i],speed[i]);
        }
        double time =0;
        int groups =0;
        for(Map.Entry<Integer,Integer>car : map.entrySet()){
            int pos = car.getKey();  // pos -> position
            int sp = car.getValue(); // sp -> speed
            int dist = target - pos;
            double currTime = dist * 1.0 / sp;
            if(currTime > time){
                time = currTime;
                groups++;
            }
        }
        return groups;
    }
}