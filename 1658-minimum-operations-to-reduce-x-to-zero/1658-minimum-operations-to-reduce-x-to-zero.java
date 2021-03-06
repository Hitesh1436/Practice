class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;   
        int sum = 0;
        for (int i = 0; i < n; i++) 
            sum += nums[i];
        int target = sum - x;
        
        if (target < 0)
            return -1;
        if (target == 0)
            return n;
        
        int left = 0, right = 0;
        int max = 0;
        while (right < n) {
            target -= nums[right++];
            
            while (target < 0){
                target += nums[left++];
            }
                
            if (target == 0)
                max = Math.max(max, right - left);
        }
        return max == 0 ? -1 : nums.length - max;
    }
}