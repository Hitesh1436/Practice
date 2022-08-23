class Solution {
    public int[] sortedSquares(int[] nums) {
        int []ans = new int[nums.length];
        int i = 0;
        int j = nums.length -1;
        for(int k = nums.length -1;k>=0;k--){
            if(Math.abs(nums[i])>= Math.abs(nums[j])){
                ans[k] = nums[i]*nums[i];
                i++;
            }else{
                ans[k] = nums[j]*nums[j];
                j--;
            }
        }
        return ans;
    }
}