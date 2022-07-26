class Solution {
    public void sortColors(int[] nums) {
       int n = nums.length;
        if(n<2){
            return;
        }
        int left =0;
        int right = n-1;
        int curr =0;
        while(curr <= right){
            if(nums[curr]==0){
                swap(nums,left,curr);
                left++;
                curr++;
            }else if(nums[curr]==1){
                curr++;
            }else{
                swap(nums,right,curr);
                right--;
            }
        }
    }
    void swap(int []nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}