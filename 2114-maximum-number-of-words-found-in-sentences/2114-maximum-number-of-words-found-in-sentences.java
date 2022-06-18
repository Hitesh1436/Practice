//  split method in java returns array of strings** 
class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(int i = 0; i < sentences.length; i++) { // traversing the sentences array
            String s = sentences[i]; // take out ith String
            String a[] = s.split(" "); // Split it into String array 
            max = Math.max(max,a.length); // find maximum length in all arrays
        }
        return max;
    }
}