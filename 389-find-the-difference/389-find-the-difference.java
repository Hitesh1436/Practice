class Solution {
    public char findTheDifference(String s, String t) {
        char []ch1 = s.toCharArray();  // [a b c d]
        char []ch2 = t.toCharArray(); // [a b c d e]
        
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for(int i=0;i<ch1.length;i++){
            if(ch1[i] != ch2[i]) 
                return ch2[i];
        }
        return ch2[s.length()];
    }
}