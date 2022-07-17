class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int answer = 0;
        for(int i: nums){
            if(map.containsKey(i)){ // if number has occurred before
                int temp = map.get(i);
                answer += temp; // add number of occurrences to the answer
                map.put(i,temp+1); // increment number of occurrences
            } else {
                map.put(i,1); // if it is the first time, add it to the map
            }
        }
        return answer;
    }
}