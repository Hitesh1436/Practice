// O(n)
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int start = 0;
        int i = 0, c = 0;
		//filling values less than pivot from start
        while(start < nums.length) {
            if(nums[start] < pivot) {
                ans[i++] = nums[start];
            } else if(nums[start] ==  pivot) c++;
            start++;
        }
        start = 0;
		//putting pivot values in centre (c -> count of number of pivot in array)
		for(int j = 0; j < c;  j++) {
			ans[i++] = pivot;
		}
		
		//filling values greater than pivot from start
        while(start < nums.length) {
            if(nums[start] > pivot) {
                ans[i++]= nums[start];
            }
            start++;
        }
        return ans;
    }
}