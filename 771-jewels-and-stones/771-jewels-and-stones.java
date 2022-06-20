class Solution {
    int count =0;
    public int numJewelsInStones(String jwl, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
            for(int i=0;i<jwl.length();i++){
                map.put(jwl.charAt(i),i);
            }
        for(int j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                count++;
            }
        }
        return count;
    }
}