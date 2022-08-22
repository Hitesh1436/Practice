class Solution {
    public int search(int[] nums, int tar) {
        int lo = 0;
        int hi = nums.length -1;
        while(lo <= hi){
            int mid = lo+(hi - lo)/2;
            if(nums[mid] < tar){
                lo = mid +1;
            }else if(nums[mid] > tar){
                hi = mid -1;
            }else{  // nums[mid] == tar 
                return mid;
            }
        }
        return -1;
    }
}