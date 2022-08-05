// 3 Dp - Tabulation Approach
class Solution {
   public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int dp[] = new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            int comb=0;
            for(int j=0;j<nums.length;j++){
                if(nums[j]<=i){
                    comb+=dp[i-nums[j]];
                }
            }
            dp[i]=comb;
        }
        return dp[target];
    }
}