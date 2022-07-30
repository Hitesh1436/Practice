class Solution {
    public List<String> wordSubsets(String[] w1, String[] w2) {
        int []word2Map = new int[26];
        List<String> ans = new ArrayList<>();
        for(String word : w2){
            int n = word.length();
            int []map = new int[26];
            
            for(int i=0;i<n;i++){
                char ch = word.charAt(i);
                map[ch - 'a']++;
                word2Map[ch -'a'] = Math.max(word2Map[ch-'a'],map[ch-'a']);
            }
        }
        for(String wd : w1){
            int []map = new int[26];
            int m = wd.length();
            boolean isValid = true;
            for(int i=0;i<m;i++){
                char ch = wd.charAt(i);
                map[ch -'a']++;
            }
            for(int j=0 ;j<26;j++){
                if(map[j]<word2Map[j]){
                    isValid = false;
                    break;
                }
            }
            if(isValid == true){
                ans.add(wd);
            } 
        }
        return ans;
    }
}