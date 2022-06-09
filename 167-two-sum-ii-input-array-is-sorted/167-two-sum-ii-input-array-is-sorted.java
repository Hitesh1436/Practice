class Solution {
    public int[] twoSum(int[] arr, int target) {
        int i = 0 , j = arr.length-1;
        while(arr[i] + arr[j]!= target){
            if(arr[i] + arr[j] > target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{i+1,j+1};
    }
}