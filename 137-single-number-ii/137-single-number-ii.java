class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        for(int i=0;i<n;i+=3){
            if(i == n-1){
                return nums[n-1];
            }
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
}