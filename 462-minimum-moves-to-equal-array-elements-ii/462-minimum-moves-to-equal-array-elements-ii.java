class Solution {
    public int minMoves2(int[] nums){
        int moves =0;
        Arrays.sort(nums);
        int median = nums[nums.length/2];
        for(int i=0;i<nums.length;i++){
            moves += Math.abs(median - nums[i]);
        }
        return moves;
    }
}