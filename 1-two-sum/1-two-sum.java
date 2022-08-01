class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int []ans = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(target - nums[i])){
                ans[1] = i;
                ans[0] = map.get(target - nums[i]);
                return ans;
            }else{
                map.put(nums[i],i);
            }
        }
        return ans;
    }
}