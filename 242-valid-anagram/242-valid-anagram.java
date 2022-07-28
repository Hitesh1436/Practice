class Solution {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        int[] sCnt = new int[26];
        int[] tCnt = new int[26];
        for (int i = 0; i < len; i++) {
            sCnt[s.charAt(i) - 'a']++;
            tCnt[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCnt[i] != tCnt[i]) {
                return false;
            }
        }
        return true;
    }
}