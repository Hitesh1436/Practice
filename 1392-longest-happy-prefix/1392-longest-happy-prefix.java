class Solution {
    public String longestPrefix(String s) {
        if (s.length() <= 1)
            return "";
        int[] lps = new int[s.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else if(len ==0){
                lps[i] =0;
                i++;
            }else{
                 len = lps[len - 1];
                }
            }
        return s.substring(0, lps[lps.length-1]);
    }
}