class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1){
            return 0;
        }
        int ans = 0;
        int curr =0;
        while(curr < nums.length){
            if(curr + nums[curr] >= nums.length -1){
                ans++;
                break;
            }
            int inter = curr;  // inter -> intermediate
            for(int j= curr+1;j<=curr + nums[curr] && j<nums.length ;j++){
                if(j + nums[j] > inter + nums[inter]){
                    inter = j;
                }
            }
            curr = inter;
            ans++;
        }
        return ans;
    }
}