class Solution {
    public int longestConsecutive(int[] nums) {
       int n = nums.length;
        if (n <= 1) {
            return n;
        }
        Arrays.sort(nums);
        int res = 1;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1];
            } else if (nums[i] - 1 == nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}