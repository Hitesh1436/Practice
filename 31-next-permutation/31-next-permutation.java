class Solution {
    public void nextPermutation(int[] nums){
        int n = nums.length;
       int i = n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = n-1;
            while(nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }
   private void reverse(int []arr,int start){
       int end = arr.length -1;
        while(start<end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    private void swap(int []arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}