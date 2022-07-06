class Solution {
    public int kSimilarity(String s1, String s2){
        Queue<String> q = new ArrayDeque<>();
        q.add(s1);
        int lvl = 0;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                String rem  =   q.remove();
                if(rem.equals(s2))return lvl;
                int i = 0;
                while(rem.charAt(i) == s2.charAt(i))i++;
                int j = i;
                while(j < rem.length()){
                    if(rem.charAt(j) == s2.charAt(i) && s2.charAt(j) != rem.charAt(j)){
                        StringBuilder sb = new StringBuilder(rem);
                        sb.setCharAt(i, rem.charAt(j));
                        sb.setCharAt(j, rem.charAt(i));
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