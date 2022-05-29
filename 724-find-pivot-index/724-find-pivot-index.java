class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(n==1){
            return 0;
        }
        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum += nums[i];
        }
        int leftSum =0;
        for(int i=0;i<n;i++){
            totalSum = totalSum - nums[i];  // act as rightSum
            if(leftSum == totalSum){
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;  // agr esa koi index exist ni krega toh
    }
}