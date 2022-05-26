class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);      // 0,1,3
        
        int n = nums.length;   // 3
        int i=0;
        for(int j=0;j<n;j++){
            if(i != nums[j]){
                return i;
            }
            i++;
        }
        return i;
    }
}