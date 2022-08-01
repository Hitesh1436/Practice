class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int count = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int currNum = num;
                int subCount = 1;
                
                while(set.contains(currNum+1)){
                    currNum++;
                    subCount++;
                }
                count = Math.max(count , subCount);
            }
        }
        return count;
    }
}