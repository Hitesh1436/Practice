class Solution {
    public String sortSentence(String s) {
        char [] ch = s.toCharArray();
        HashMap<Character,String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<ch.length-1;i++){
            if(ch[i] != ' '){
                sb.append(ch[i]);
            }
            if((i+2) == ch.length || ch[i+2] == ' '){
                map.put(ch[i+1],sb.toString());
                sb = new StringBuilder();
                i++;
            }
        }
       sb = new StringBuilder();
        for (char i = '1'; i <= '9'; i++) {
            if (map.containsKey(i)) {
                sb.append(map.get(i));
                sb.append(" ");
            }
        }

        return sb.toString().trim();
    }
}