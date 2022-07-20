class Solution {
    public int minPairSum(int[] nums) {
        // Arrays.sort(nums);
        // int max = 0;
        // int n = nums.length;
        // int temp = n / 2;
        // for(int i = 0, j = n - 1; i < temp; i++, j--) {
        //     max = Math.max(nums[i] + nums[j], max);
        // }
        return solution2(nums);
    }
    
    public int solution2(int[] nums) {
        int[] arr = new int[100001];
        int max = 0;
        int min = 100001;
        for(int i : nums) {
            arr[i]++;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int start = min; 
        int end = max;
        max = 0;
        while(start < end) {
            if(arr[start] == 0) start++; 
            else if(arr[end] == 0) end--;
            else {
                max = Math.max(start + end, max);
                int temp = Math.min(arr[start], arr[end]);
                arr[start] -= temp;
                arr[end] -= temp;
            }
        }
        if(arr[start] > 1) {
            max = Math.max(max, 2 * start);
        }
        else if(arr[end] > 1) {
            max = Math.max(max, 2 * end);
        }
        return max;
    }
}