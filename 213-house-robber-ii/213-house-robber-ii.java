class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int max1 = maxRob(nums,0,n-2);  //nums[0,n-2]
        int max2 = maxRob(nums,1,n-1);  //nums[1,n-1]
        return Math.max(max1,max2);
    }   
    //return the max money we can rob, include the house end
    private int maxRob(int[] nums, int start,int end){
        //base
        if(start == end) return nums[start];
  
        int first = nums[start];
        int second = Math.max(nums[start],nums[start+1]);
        for(int i = start + 2; i<=end; i++){
            int res = Math.max(first + nums[i], second);
            first = second;
            second = res;
        }
        return second;
    }
}