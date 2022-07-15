class Solution {
    public int[] sortedSquares(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
        }
        int []arr = new int[nums.length];
            for(int i=0;i<arr.length;i++){
                int val = nums[i];
                arr[i] = val*val;
            }
        Arrays.sort(arr);
        return arr;
    }
}