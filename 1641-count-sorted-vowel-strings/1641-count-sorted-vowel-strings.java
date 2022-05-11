class Solution {
    
    public int helper(int len , char first){
        if(len ==0){
            return 1;
        }
        int ans =0;
        for(char c:ch){
            if(first>=c){
                ans+=helper(len-1,c);
            }
        }
        return ans;
    }
    
    char []ch = new char[]{'a','e','i','o','u'};
    public int countVowelStrings(int n) {
        int ans = 0;
        for(char c : ch){
            ans+= helper(n-1,c);
        }
        return ans;
    }
}