class Solution {
    public int missingNumber(int[] nums) {
        // sort krdii
     Arrays.sort(nums);
     int n = nums.length;
            if(nums[n-1]==0){
                return 1;
            }
        for(int i=0;i<n-1;i++){
            if(nums[i]+1 != nums[i+1]){
                return nums[i]+1;
            }
            if(nums[n-1]+1 == n){
                return n;
            }
        }
        return 0;
    }
}