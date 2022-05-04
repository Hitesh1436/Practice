class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
    int a = 0, b = nums.length - 1;
    int count = 0;
    while(a < b){
        if(nums[a]+nums[b] == k){
            count++;
            a++;
            b--;
        }
        else if(nums[a]+nums[b] > k){
            b--;
        }
        else{
            a++;
        }
    }
    return count;
    }
}
