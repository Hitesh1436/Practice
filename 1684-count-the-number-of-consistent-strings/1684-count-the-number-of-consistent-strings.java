class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for(String word: words){
            boolean isvalid = true;
            for(int i =0; i<word.length(); i++){
                if(!allowed.contains(String.valueOf(word.charAt(i)))){
                   isvalid = false;
                    break;
                }
            }
            if(isvalid) 
                count++;
        }
        return count;
    }
}