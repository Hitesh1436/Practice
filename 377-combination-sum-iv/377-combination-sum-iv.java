class Solution {
    public int combinationSum4(int[] nums, int target) {
        return permutations(nums,target,new Integer[target +1]);
    }
    int permutations(int []arr,int tar,Integer []dp){
        if(tar == 0){
            return 1;
        }
        if(tar <0){
            return 0;
        }
        if(dp[tar] != null){
            return dp[tar];
        }
        int count =0;
        for(int i=0;i<arr.length;i++){
            count += permutations(arr,tar - arr[i],dp);
        }
        return dp[tar]= count;
    }
}