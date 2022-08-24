// Time Complexity :- BigO(N)
// Space Complexity :- BigO(1)
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k <0){
            k += nums.length;
        }
        reverse(nums,0,nums.length -k-1);  // k se phle tk reverse
        reverse(nums,nums.length -k,nums.length -1); // k se end tk reverse
        reverse(nums,0,nums.length -1); // pura jo aaya usse reverse
    }
    public void reverse(int []nums,int i,int j){
        int li = i;
        int ri = j;
        while(li < ri){
            int temp = nums[li];
            nums[li] = nums[ri];
            nums[ri] = temp;
            li++;
            ri--;
        }
    }
}