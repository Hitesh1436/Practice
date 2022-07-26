class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSofar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for(int i=0;i<n;i++){
            maxEndingHere = maxEndingHere + nums[i];
            if(maxSofar < maxEndingHere){
                maxSofar = maxEndingHere;
            }
            if(maxEndingHere <0){
                maxEndingHere =0;
            }
        }
        return maxSofar;
    }
}