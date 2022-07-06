class Solution {
    public int kSimilarity(String s1, String s2){
        Queue<String> q = new ArrayDeque<>();
        q.add(s1);
        int lvl = 0;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                String s = q.remove();
                if(s.equals(s2))return lvl;
                int i = 0;
                while(s.charAt(i) == s2.charAt(i))i++;
                int j = i;
                while(j < s.length()){
                    if(s.charAt(j) == s2.charAt(i) && s2.charAt(j) != s.charAt(j)){
                        StringBuilder sb = new StringBuilder(s);
                        sb.setCharAt(i, s.charAt(j));
                        sb.setCharAt(j, s.charAt(i));
                        if(sb.toString().equals(s2))return lvl+1;
                        q.add(sb.toString());
                    }
                    j++;
                }
            }
            lvl++;
        }
        return lvl;
    }
}