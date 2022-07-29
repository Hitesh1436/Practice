class Solution {
    List<String>ans;
    HashMap<Character,Character>map;
    char []arr;
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        arr = pattern.toCharArray();
        for (int i = 0; i < pattern.length(); i++){
            arr[i] = translate(arr[i]);
        }
        for (String word : words){
             compare(word);
        }
        return ans;
    }
    private char translate(char c) {
        if (!map.containsKey(c)){
            map.put(c, (char)(97 + map.size()));
        }
        return map.get(c);
    }
    private void compare(String word) {
        map.clear();
        for (int i = 0; i < word.length(); i++){
            if (translate(word.charAt(i)) != arr[i]){
              return;  
            } 
        }
        ans.add(word);
    }
}