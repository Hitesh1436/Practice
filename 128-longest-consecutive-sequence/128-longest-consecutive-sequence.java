class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longestLength = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int currNum = num;
                int currLength = 1;
                
                while(set.contains(currNum+1)){
                    currNum++;
                    currLength++;
                }
                longestLength = Math.max(longestLength , currLength);
            }
        }
        return longestLength;
    }
}