class Solution {
    
    private int solve(int s,int idx ,int n){
        if(n==0){
            return 1;
        }
        int ans = 0;
        for(int i=idx;i<s;i++){
            ans +=solve(s,i,n-1);
        }
        return ans;
    }
    
    public int countVowelStrings(int n) {
        String s = "aeiou";
        return solve(s.length(),0,n);
    }
}