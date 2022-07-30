class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans =new ArrayList<>();
        int target[] = new int[26];
        for(String w:words2){
            int temp[] = new int[26];
            for(char c:w.toCharArray()){
                temp[c-'a']++;
                target[c-'a'] = Math.max(target[c-'a'] , temp[c-'a']);
            }
        }
        for(String w:words1){
            int temp[] = new int[26];
            for(char c:w.toCharArray()){
                temp[c-'a']++;
                
            }
            if(subset(temp,target))ans.add(w);
        }              
        return ans;
    }
    private boolean subset(int[] source , int[] dest){
        for(int i = 0 ; i<26 ; i++){
            if(dest[i]>source[i]){
                return false;
            }
        }
        return true;
    }
}