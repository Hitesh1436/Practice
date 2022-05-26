class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {  // if the array has only one element it will return the first element itself
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i = i+2) {
            if (i == nums.length-1) {  // if i is at the last index return the last index
                return nums[nums.length -1];
            }
            if(nums[i] != nums[i+1]) { 
                return nums[i];
            }
        }
        return 0;
    }
}