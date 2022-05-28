class Solution {
    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
            if (count[nums[i]] > 1) {
                return nums[i];
            }
        }

        return n;
    }
}