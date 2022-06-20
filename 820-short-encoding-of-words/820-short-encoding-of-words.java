class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> ansSet = new HashSet<>(Arrays.asList(words));
        
        for(String word : words){
            if(ansSet.contains(word)){
                for(int i=1;i<word.length();i++){
                    ansSet.remove(word.substring(i));  
                }
            }
        }
        int finalAns = ansSet.size();
            
        for(String word : ansSet)
            finalAns+= word.length();
            
        return finalAns;
        
    }
}