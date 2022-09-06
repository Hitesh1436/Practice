class Solution {
    boolean flag = false;
    HashMap<String, Boolean> map = new HashMap<>();
    private boolean solve(String s, List<String> wordDict){
        if(s.length()==0){
            return true;
        }
        if(map.containsKey(s)){
            return map.get(s);
        } 
        for(String word : wordDict){
            if(s.startsWith(word)){
                flag = flag || solve(s.substring(word.length()), wordDict);
            }
        }
        map.put(s, flag);
        return map.get(s);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(s, wordDict);
    }
}