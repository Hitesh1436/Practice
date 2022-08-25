class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int r = ransomNote.length();
        int m = magazine.length();
        if(r > m)
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(char ch : ransomNote.toCharArray()) {
            if(!map.containsKey(ch))
                return false;
            map.put(ch, map.get(ch) - 1);
            if(map.get(ch) == 0)
                map.remove(ch);
        }
        return true;
    }
}