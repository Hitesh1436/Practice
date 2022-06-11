class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int num : nums){
            total += num;
        }
        int n = nums.length;
        int max = -1;
        int lt = 0;
        int curr = 0;
        for(int rt=0;rt<n;rt++){
            curr +=nums[rt];
            while(curr > total-x && lt <= rt){
                curr -=nums[lt];
                lt ++;
            }
            if(curr == total -x){
                max = Math.max(max,rt-lt +1);
            }
        }
        return max != -1 ? n - max : -1;
    }
}