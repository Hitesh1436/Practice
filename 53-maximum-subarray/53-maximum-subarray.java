// T(C) -> O(N) , S(C) -> O(N)
class Solution {
    public int maxSubArray(int[] nums) {
	int[] dp = new int[nums.length];
	dp[0] = nums[0];
	int maxsum = nums[0];
	for (int i = 1; i < nums.length; i++) {
		dp[i] = Math.max(nums[i], nums[i] + dp[i-1]);
		maxsum = Math.max(maxsum, dp[i]);
	}
	return maxsum;
   }   
}