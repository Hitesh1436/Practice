class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        double sum = (double)(len+1)/2 *len;
        int actualSum = 0;
        for(int i=0; i<len; i++)
            actualSum += nums[i];
        return (int)sum-actualSum;
    }
}