class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        char ch = s.charAt(0);
        String ans = "";
        ans += ch;
        int max =1;
        for(int i=1;i<s.length();i++){
            ch = s.charAt(i);
            int idx = ans.indexOf(ch);
            if(idx == -1){
                ans += ch;
                max = Math.max(max,ans.length());
            }else{
                ans = ans.substring(idx+1)+ ch;
            }
        }
        return max;
    }
}