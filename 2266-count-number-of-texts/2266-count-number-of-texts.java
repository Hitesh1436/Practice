class Solution {
     int mod = (1000000007);
    
    public int helper(int idx , String s , int[] key,int []dp){
        // base case
        if(idx == s.length()){
            return 1;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int count = 0;
        int num = s.charAt(idx) - '0';      // ascii ka use kia h string to number change krne mn
        int press = key[num];
        for(int i=0;i<press && idx+i<s.length() && s.charAt(idx)==s.charAt(idx+i);i++){
            count += helper(idx+1+i,s,key,dp);
           count %= mod;
        }
        return dp[idx]=count;
    }
    
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int [] key = new int []{0,0,3,3,3,3,3,4,3,4};
        int []dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(0,pressedKeys,key,dp);
       
    }
}