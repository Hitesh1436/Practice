class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int []ans = new int[n];
        int left =1,right =1;
        
        for(int i=n-1;i>=0 ;i--){
            ans[i] = right;
            right *=nums[i];
        }
        for(int j=0;j<n;j++){
            ans[j] *= left;
            left *= nums[j];
        }
        return ans;
    }
}