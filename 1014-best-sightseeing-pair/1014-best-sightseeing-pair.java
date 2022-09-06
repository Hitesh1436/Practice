class Solution {
    public int maxScoreSightseeingPair(int[] values) {
     int ans =0,curr =0;
        for(int i=0;i<values.length;i++){
            int val = values[i];
            ans = Math.max(ans,curr+val);
            curr = Math.max(curr,val)-1;
        }
        return ans;
    }
}