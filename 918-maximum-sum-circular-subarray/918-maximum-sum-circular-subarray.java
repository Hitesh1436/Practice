class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];
        int sum = nums[0];
        int n = nums.length;
        
        for(int i=1; i < n; i++){
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMax);
            currMin = Math.min(currMin + nums[i], nums[i]);
            minSum = Math.min(minSum, currMin);
            sum += nums[i];
        }
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    } 
}