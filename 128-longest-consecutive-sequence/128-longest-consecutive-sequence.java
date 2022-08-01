class Solution {
    public int longestConsecutive(int[] nums) {
        int ans =0;
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<n;i++){
            int count =1;
            
            int val = nums[i];
            // left dekha
            while(set.contains(--val)){
                count++;
                set.remove(val);
            }
            // right dekha
            val = nums[i];
            while(set.contains(++val)){
                count++;
                set.remove(val);
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}