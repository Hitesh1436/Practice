class Solution {
    public int deleteAndEarn(int[] nums) {
        int include = 0;
        int exclude = 0;
        int [] count = new int[10001];
        for(int val : nums){
            count[val]++;
        }
        for(int i=0;i<10001;i++){
            int newInclude = exclude + count[i] * i;
            int newExclude = Math.max(include,exclude);
            
            include = newInclude;
            exclude = newExclude;
        }
        return Math.max(include,exclude);
    }
}