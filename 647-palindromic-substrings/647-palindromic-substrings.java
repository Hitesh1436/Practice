class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            //count odd length palindrome, 
            //only one center character
            count += countPalindromesAroundCenter(s, i, i);
            
            //count even length palindrome, 
            //two center character
            count += countPalindromesAroundCenter(s, i, i + 1);
        } 
        
        return count;
    }
    
    
    private int  countPalindromesAroundCenter(String s, int l, int r){
        int count = 0;
        while(l >= 0 && r < s.length()){
            //just return count, as we found first mismatch
            if(s.charAt(l--) != s.charAt(r++))  return count;
            
            count++;
        }
        return count;
    }
}