class Solution {
    public int[] singleNumber(int[] nums) {
            HashSet<Integer> set= new HashSet<>();
        int[] ans=new int[2];
            for(int i=0; i<nums.length; i++){
                    if(set.contains(nums[i]))
                            set.remove(nums[i]);
                    else
                            set.add(nums[i]);
            }
            int j=0;
            for(int n:set)
                    ans[j++]=n;
            return ans;
    }
}