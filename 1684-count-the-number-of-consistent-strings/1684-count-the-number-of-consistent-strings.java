class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans =0;
        HashSet<Character> set = new HashSet<>();
            for(char ch : allowed.toCharArray()){
                set.add(ch);
            }
        for(String wd : words){
            for(int i=0;i<wd.length();i++){
                if(!set.contains(wd.charAt(i))){
                    break;
                }
                if(i == wd.length()-1){
                    ans++;
                }
            }
        }
        return ans;
    }
}