class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] buckets = new int[limit+1];
        for(int p: people){
             buckets[p]++;
        }
        int start = 0;
        int end = buckets.length - 1;
        int boats = 0;
        while(start <= end){
			//make sure the start always point to a valid number
            while(start <= end && buckets[start] <= 0){
                 start++;
            }
			//make sure end always point to valid number
            while(start <= end && buckets[end] <= 0){
                 end--;
            }
			//no one else left on the ship, hence break.
            if(buckets[start] <= 0 && buckets[end] <= 0){
                break;
            } 
            boats++;
            if(start + end <= limit){// both start and end can carry on the boat
              buckets[start]--;    
            } 
            buckets[end]--;
        }
        return boats;
    }
}