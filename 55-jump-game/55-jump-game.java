class Solution {
    public boolean canJump(int[] nums) {
        int tar = nums.length -1;
        for(int i=nums.length -1 ;i>=0;i--){
            if(nums[i]>= tar - i){
                tar = i;
            }
        }
        if(tar == 0){
            return true;
        }
        return false;
    }
}