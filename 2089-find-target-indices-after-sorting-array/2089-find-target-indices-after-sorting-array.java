class Solution {
    public List<Integer> targetIndices(int[] nums, int tar) {
        Arrays.sort(nums);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i] == tar){
                ans.add(i);
            }
        }
        return ans;
    }
}