class Solution {
    public boolean isAnagram(String s, String t) {
        int []alpha = new int[26];
        for(int i=0;i<s.length();i++){
            alpha[s.charAt(i)-'a']++;
        }
        for(int j=0;j<t.length();j++){
            alpha[t.charAt(j)-'a']--;
        }
        for(int a : alpha){
            if(a != 0){
                return false;
            }
        }
        return true;
    }
}