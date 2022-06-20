class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        String ans = "";
        Arrays.sort(words, (a,b)->b.length() - a.length());
        
        for(int i=0;i<words.length;i++){
            
            String temp = words[i] + "#";
            if(!ans.contains(temp)) ans = ans + temp;
        }
        
        return ans.length();
        
    }
}