// Using Sliding Window Concept
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string is null");
        }

        int len = s.length();
        if (len <= 1) {
            return len;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < len; end++) {
            char eChar = s.charAt(end);
            if (map.containsKey(eChar)) {
                start = Math.max(start, map.get(eChar) + 1);
            }
            map.put(eChar, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}

//  Using Basic String Functions

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s.length()==0) return 0;
//         char ch = s.charAt(0);
//         String ans = "";
//         ans += ch;
//         int max =1;
//         for(int i=1;i<s.length();i++){
//             ch = s.charAt(i);
//             int idx = ans.indexOf(ch);
//             if(idx == -1){
//                 ans += ch;
//                 max = Math.max(max,ans.length());
//             }else{
//                 ans = ans.substring(idx+1)+ ch;
//             }
//         }
//         return max;
//     }
// }